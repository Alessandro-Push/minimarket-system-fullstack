package gm.inventarios.controlador;

import gm.inventarios.exepcion.RecursoNoEncontradoExcepcion;
import gm.inventarios.modelo.Producto;
import gm.inventarios.servicio.IProductoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("inventario-app") //http://localhost:8080/inventario-app/productos
@CrossOrigin(value = "http://localhost:4200") //Puerto por default de Angular
public class ProductoControlador {
    private static final Logger logger = LoggerFactory.getLogger(ProductoControlador.class);

    @Autowired
    private IProductoServicio productoServicio;

    @GetMapping("/productos") //http://localhost:8080/inventario-app/productos
    public List<Producto> obtenerProducto(){
        List<Producto> productos = this.productoServicio.listarProductos();
        logger.info("Productos obtenidos: ");
        productos.forEach(producto -> logger.info(producto.toString()));
        return productos;
    }

    @PostMapping ("/productos")
    public Producto agregarProducto(@RequestBody Producto productoAgregado){
        logger.info("Producto a agrega: " + productoAgregado);
        return this.productoServicio.guardarProducto(productoAgregado);
    }

    @GetMapping("/productos/{id}")
    public ResponseEntity<Producto> obtenerProductoPorID(@PathVariable int id){
        Producto producto= this.productoServicio.buscarProductoPorId(id);
        if (producto !=null){
            return ResponseEntity.ok(producto);
        }else {
            throw new RecursoNoEncontradoExcepcion("No se encontró el id: " + id);
        }
    }

    @PutMapping("/productos/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable int id, @RequestBody Producto productoRecibido){
        Producto producto= this.productoServicio.buscarProductoPorId(id);
        producto.setDescripcion(productoRecibido.getDescripcion());
        producto.setPrecio(productoRecibido.getPrecio());
        producto.setExistencia(productoRecibido.getExistencia());

        //Guardamos la informacion
        this.productoServicio.guardarProducto(producto);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<Map<String,Boolean>> eliminarPorducto(@PathVariable int id){
        Producto producto= this.productoServicio.buscarProductoPorId(id);
            if (producto==null){
                throw new RecursoNoEncontradoExcepcion("No se encontró el id: " + id);
            }
            this.productoServicio.eliminarProducto(producto.getIdProducto());
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return ResponseEntity.ok(respuesta);
    }
}
