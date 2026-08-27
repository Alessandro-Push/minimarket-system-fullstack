package gm.inventarios.controlador;

import gm.inventarios.exepcion.RecursoNoEncontradoExcepcion;
import gm.inventarios.modelo.Cliente;
import gm.inventarios.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("inventario-app") //http://localhost:8080/inventario-app/clientes
@CrossOrigin(value = "http://localhost:4200") //Puerto por default de Angular
public class ClienteControlador {

    private static final Logger logger = LoggerFactory.getLogger(ClienteControlador.class);

    @Autowired
    private IClienteServicio clienteServicio;

    @GetMapping("/clientes")
    public List<Cliente> obtenerCliente(){
        List<Cliente> clientes = this.clienteServicio.listarClientes();
        logger.info("Clientes obtenidos: ");
        clientes.forEach( cliente -> logger.info(cliente.toString()));
        return clientes;
    }

    @PostMapping ("/clientes")
    public Cliente agregarCliente(@RequestBody Cliente clienteAgregado){
        logger.info("Cliente agregado: "+ clienteAgregado);
        return this.clienteServicio.guardarCliente(clienteAgregado);
    }

    //(GET) Cuando le das clic a "Editar" en la tabla, Angular navega al formulario pasándole el ID en la URL.
    // El formulario necesita hacer un GET para traer los datos actuales de ese cliente y rellenar las cajas de texto.
    @GetMapping ("/clientes/{id}")
    public ResponseEntity<Cliente> obtnerClientePorId(@PathVariable int id){
        Cliente cliente = this.clienteServicio.buscarClientePorId(id);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        }else{
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: " + id);
        }
    }

    //PUT por ID: Cuando modificas los campos y le das a "Guardar", se dispara el PUT para enviar los cambios
    // actualizados a MySQL
    @PutMapping ("/clientes/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable int id, @RequestBody Cliente clienteActualizado){
        Cliente cliente = this.clienteServicio.buscarClientePorId(id);
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setApellido(clienteActualizado.getApellido());
        cliente.setEmail(clienteActualizado.getEmail());

        this.clienteServicio.guardarCliente(cliente);
        return ResponseEntity.ok(cliente);

    }

    @DeleteMapping("/clientes/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCliente(@PathVariable int id){
        Cliente cliente= this.clienteServicio.buscarClientePorId(id);
        if (cliente == null){
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: " + id);
        }else {
            this.clienteServicio.eliminarCliente(cliente.getIdCliente());
            Map<String,Boolean> respuesta = new HashMap<>();
            respuesta.put("Eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
        }
    }



}
