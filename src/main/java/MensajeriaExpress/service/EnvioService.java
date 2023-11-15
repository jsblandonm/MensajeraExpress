package MensajeriaExpress.service;

import MensajeriaExpress.Dto.EnvioCambiarEstadoDto;
import MensajeriaExpress.Dto.EnvioCreadoDto;
import MensajeriaExpress.Dto.EnvioDetalleDto;
import MensajeriaExpress.Dto.EnvioDto;
import MensajeriaExpress.entity.Cliente;
import MensajeriaExpress.entity.Empleado;
import MensajeriaExpress.entity.Envio;
import MensajeriaExpress.entity.Paquete;
import MensajeriaExpress.model.PaqueteModel;
import MensajeriaExpress.repository.ClienteRepository;
import MensajeriaExpress.repository.EmpleadoRepositry;
import MensajeriaExpress.repository.EnvioRepository;
import MensajeriaExpress.repository.PaqueteRepository;
import MensajeriaExpress.state.EnvioState;
import MensajeriaExpress.state.EstadoRecibido;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class EnvioService{

    private final EnvioRepository envioRepo;
    private final ClienteRepository clienteRepo;
    private final EmpleadoRepositry empleadoRepo;
    private final PaqueteRepository paqueteRepo;
    private EnvioState estadoActual;

    public EnvioService(EnvioRepository envioRepo,
                        ClienteRepository clienteRepo,
                        EmpleadoRepositry empleadoRepo,
                        PaqueteRepository paqueteRepo
                        ) {
        this.envioRepo = envioRepo;
        this.clienteRepo = clienteRepo;
        this.empleadoRepo = empleadoRepo;
        this.paqueteRepo = paqueteRepo;
        this.estadoActual = new EstadoRecibido();//Estado inicial
    }


    public EnvioCreadoDto create(EnvioDto envioDto){
        if (envioDto == null){
            throw new IllegalArgumentException("El envio no pude ser nulo");
        }

        if (envioDto.getPeso() == null || envioDto.getValorDeclarado() == null) {
            throw new IllegalArgumentException("El peso y el valor declarado no pueden ser nulos");
        }

        Cliente cliente = clienteRepo.findById(envioDto.getCedulaCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        //inancia del paqueteModel
        PaqueteModel paqueteModel = new PaqueteModel(envioDto.getPeso(),envioDto.getValorDeclarado());


        Paquete paqueteEntity = new Paquete(
                paqueteModel.getTipo(),
                envioDto.getPeso(),
                envioDto.getValorDeclarado()
        );

        paqueteRepo.save(paqueteEntity);

        Envio envio = new Envio(
                envioDto.getCiudadOrigen(),
                envioDto.getCiudadDestino(),
                envioDto.getDireccionDestino(),
                envioDto.getDestinatario(),
                envioDto.getCelularDestinatario(),
                calcularHoraEntrega(),
                EstadoEnvio.RECIBIDO.getEstado(),
                calcularValorEnvio(paqueteEntity.getTipo()),
                cliente,
                empleadoRepo.findById(envioDto.getCedulaEmpleado())
                        .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado"))

        );

        envioRepo.save(envio);

        //Transicion del estado
        estadoActual = estadoActual.next(envio);
        return new EnvioCreadoDto(envio.getNumeroGuia(), envio.getEstado());
    }

    //-------------------------------------------------------------------------

    public EnvioCreadoDto changeState(EnvioCambiarEstadoDto cambioEstadoDto) {
        Optional<Envio> envioOptional = envioRepo.findById(cambioEstadoDto.getNumeroGuia());
        Optional<Envio> empleadoOptional = envioRepo.findById(cambioEstadoDto.getCedulaEmpleado());

        if (empleadoOptional.isEmpty() || envioOptional.isEmpty()){
            throw new IllegalArgumentException("El empleado o el numero de guial del envio no son validos");
        }

        Empleado empleado = empleadoOptional.get().getEmpleado();
        if (!empleado.getTipo().equals("REPARTIDOR") && !empleado.getTipo().equals("COORDINAOR")){
            throw new IllegalArgumentException("El empleado no esta autorizado para cambiar el estado del envio ");
        }

        String estadoIncial = cambioEstadoDto.getEstado().toUpperCase();
        if (!estadoActual.equals("RECIBIDO") && !estadoActual.equals("EN_RUTA") && !estadoActual.equals("ENTREGADO")) {
            throw new IllegalArgumentException("El estado del envío no es válido");
        }

        Envio envio = envioOptional.get();
        envio.setEstado(EstadoEnvio.valueOf(estadoIncial).getEstado());
        envioRepo.save(envio);

        //Transicion de estado
        estadoActual = estadoActual.next(envio);
        return new EnvioCreadoDto(envio.getNumeroGuia(),envio.getEstado());

    }

    //-------------------------------------------------------------------------------------------

    public EnvioDetalleDto search(Integer numeroGuia){
        if (numeroGuia == null) {
            throw new IllegalArgumentException("El número de guía no puede ser nulo");
        }

        Optional<Envio> envioOptional = envioRepo.findById(numeroGuia);
        if (envioOptional.isEmpty()) {
            throw new IllegalArgumentException("No se encontró un envío con el número de guía proporcionado");
        }

        Envio envio = envioOptional.get();
        Paquete paquete = envio.getPaquetes().get(0);
        Cliente cliente = envio.getCliente();
        return new EnvioDetalleDto(
                envio.getNumeroGuia(),
                cliente.getCedulaCliente(),
                cliente.getNombre(),
                envio.getCiudadOrigen(),
                envio.getCiudadDestino(),
                envio.getDireccionDestino(),
                envio.getDestinatario(),
                envio.getCelularDestinatario(),
                paquete.getValorDeclarado(),
                paquete.getPeso(),
                envio.getValorEnvio()
        );

    }

    //------------------------------------------------------------------------------------------

    public List<Envio> filter(String estado){
        String estadoUpperCase = estado.toUpperCase();

        if (!estadoUpperCase.equals("RECIBIDO") && !estadoUpperCase.equals("EN_RUTA") && !estadoUpperCase.equals("ENTREGADO")) {
            throw new IllegalArgumentException("El estado que está consultando no existe, asegúrese de haber colocado el número de guía correctamente");
        }

        List<Envio> resultado = envioRepo.filtrarPorEstado(estadoUpperCase).stream().toList();

        if (resultado.isEmpty()) {
            throw new IllegalArgumentException("No se encontraron envíos con estado: " + estadoUpperCase);
        }
        return resultado;
    }

    //---------------------------------------------------------------------------------------------------

    private String calcularHoraEntrega(){
        LocalDateTime horaLocal = LocalDateTime.now();
        LocalDateTime horaEntrega = horaLocal.plusHours(72);
        DateTimeFormatter horaFormateada = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");
        return horaEntrega.format(horaFormateada);
    }

    //-----------------------------------------------------------------------------------------------------------

    private double calcularValorEnvio(String tipoPaquete){

        return switch (tipoPaquete) {
            case "LIVIANO" -> 30000;
            case "MEDIANO" -> 40000;
            case "GRANDE" -> 50000;
            default -> throw new IllegalArgumentException("El valor ingresad no pertenece a un tamaño de paquete");
        };

    }

    /*

    private final EnvioRepository envioRepository;
    private final ClienteRepository clienteRepository;
    private final EmployableRepository employableRepository;
    private final PaqueteRepository paqueteRepository;

    private final EnvioEstadoDto envioEstadoDto;
    //private EnvioState estadoIncial;
    @Autowired
    public EnvioService(EnvioEstadoDto envioEstadoDto,
                        EnvioRepository envioRepository,
                        ClienteRepository clienteRepository,
                        EmployableRepository employableRepository,
                        PaqueteRepository paqueteRepository) {
        this.envioEstadoDto = envioEstadoDto;
        this.envioRepository = envioRepository;
        this.clienteRepository = clienteRepository;
        this.employableRepository = employableRepository;
        this.paqueteRepository = paqueteRepository;
    }



    public EnvioCreadoDto create(EnvioDto envioDto){
        if (envioDto == null){
            throw new IllegalArgumentException("El envio no pude ser nulo");
        }


        //String estado = estadoIncial.();

        if (envioDto.getCedulaCliente() == null
                || envioDto.getCiudadOrigen() == null
                || envioDto.getCiudadDestino() == null
                || envioDto.getDestinatario() == null
                || envioDto.getDireccionDestino() == null
                || envioDto.getCelularDestinatario() == null
                || envioDto.getPeso() == 0
                || envioDto.getValorDeclarado() == 0
        ){
            throw new IllegalArgumentException("Todos los campos deben ser diligenciado y diferentes de nulo o 0");
        }

        Cliente cliente = clienteRepository.findById(envioDto.getCedulaCliente())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado"));

        //Optional<Cliente> cliente = this.clienteRepository.findById(envioDto.getCedulaCliente());

        if (cliente.isPresent()){
            throw new IllegalArgumentException("El cliente debe haberse creado anteriormente");
        }

        PaqueteModel paqueteModel = new PaqueteModel(
                envioDto.getPeso(),
                envioDto.getValorDeclarado()
        );

        Paquete paqueteEntity = new Paquete(
                paqueteModel.getTipo(),
                paqueteModel.getPeso(),
                paqueteModel.getValorDeclarado()
        );


        paqueteRepository.save(paqueteEntity);

        EnvioModel envioModel = new EnvioModel();
        double valor = envioModel.calcularValorEnvio(paqueteEntity.getTipo());

        List<Paquete> paquetes = new ArrayList<>();
        paquetes.add(paqueteEntity);


        Envio envio = new Envio(
                envioDto.getCiudadOrigen(),
                envioDto.getCiudadDestino(),
                envioDto.getDireccionDestino(),
                envioDto.getDestinatario(),
                envioDto.getCelularDestinatario(),
                calcularHoraEntrega(),
                estado,
                valor,
                cliente.get(),
                paquetes

        );

        envioRepository.save(envio);

        EnvioCreadoDto respuestaDto = new EnvioCreadoDto(
                envio.getNumeroGuia(),
                envio.getEstado()
        );

        return respuestaDto;
    }

    public String calcularHoraEntrega(){
        LocalDateTime horaLocal = LocalDateTime.now();
        LocalDateTime horaEntrega = horaLocal.plusHours(72);
        DateTimeFormatter horaFormateada = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

        String hora = horaFormateada.toString();
        return hora;
    }

    public EnvioCreadoDto changeState(EnvioCamibiarEstdoDto envioCamibiarEstdoDto){
        Optional<Envio> envioPorId = this.envioRepository.findById(envioCamibiarEstdoDto.getNumeroGuia());
        Optional<Empleado> empleadoPorId = this.employableRepository.findById(envioCamibiarEstdoDto.getCedulaEmpleado());

        if (empleadoPorId.isEmpty() || envioPorId.isPresent()) {
            throw new IllegalArgumentException("El empleado con cedula " + envioCamibiarEstdoDto.getCedulaEmpleado() + " o el numero de guia del envio " + envioCamibiarEstdoDto.getNumeroGuia() + " no son validos");
        }
        if (empleadoPorId.get().getTipo().equals("REPARTIDOR") || empleadoPorId.get().getTipo().equals("COORDINADOR")){
            String estadoActual = envioCamibiarEstdoDto.getEstado().toUpperCase();

            if (estadoActual.equals("RECIBIDO") || estadoActual.equals("EN_RUTA") ||estadoActual.equals("ENTREGADO")){

                Envio envio = envioPorId.get();

                envioPorId.get().setEstado(envioEstadoDto.cambiarEstado());
                envioRepository.save(envio);
                EnvioCreadoDto respuestaDto = new EnvioCreadoDto(
                        envioPorId.get().getNumeroGuia(),
                        envioPorId.get().getEstado()
                );

                return respuestaDto;
            }else {
                throw new IllegalArgumentException("El estado del envio no corresponde a una de las opciones habilitadas");
            }
        }else {
            throw new IllegalArgumentException("El empleado con cedula: " + empleadoPorId + "no esta autorizado para cambiar el estado del envio ");
        }
    }

    public EnvioDetalleDto search(Integer numeroGuia){
        if (numeroGuia == null){
            throw new IllegalArgumentException("El cliete debe haberse creado previamente");
        }

        Optional<Envio> envio = envioRepository.findById(numeroGuia);



        if (envio.isEmpty()){
            EnvioDetalleDto envioDetalleDto = new EnvioDetalleDto(
                    envio.get().getNumeroGuia(),
                    envio.get().getCiudadOrigen(),
                    envio.get().getCiudadDestino(),
                    envio.get().getDireccionDestino(),
                    envio.get().getDestinatario(),
                    envio.get().getCelularDestinatario(),
                    envio.get().getValorEnvio(),
                    envio.get().getPaquetes().get(0).getValorDeclarado(),
                    envio.get().getPaquetes().get(0).getPeso(),
                    envio.get().getCliente().getCedulaCliente(),
                    envio.get().getCliente().getNombre()
            );
            return envioDetalleDto;
        }else {
            throw new IllegalArgumentException("La guia con el ID: " + numeroGuia + "no es valido");
        }
    }

    public List<Envio> filter(String estado) {
        String estadoUpperCase = estado.toUpperCase();

        if (!estadoUpperCase.equals("RECIBIDO") && !estadoUpperCase.equals("EN_RUTA") && !estadoUpperCase.equals("ENTREGADO")){
            throw new IllegalArgumentException("El estado que esta consultando no existe, asegurese de haber colocado el numero de guia correctamente");
        }
        List<Envio> resultado = envioRepository.filtrarPorEstado(estadoUpperCase).stream().toList();

        if (resultado.isEmpty()){
            throw new IllegalArgumentException("No se encontraron envios con estado: " + estadoUpperCase);
        }
        return resultado;

    }

     */
}

