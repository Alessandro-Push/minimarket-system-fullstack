package gm.inventarios.servicio;


import gm.inventarios.modelo.Cliente;
import gm.inventarios.repositorio.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio implements IClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> listarClientes() {
        return this.clienteRepositorio.findAll();
    }

    @Override
    public Cliente buscarClientePorId(Integer idCliente) {
        Cliente cliente = this.clienteRepositorio.findById(idCliente).orElse(null);
        return cliente;
    }

    @Override
    public Cliente guardarCliente(Cliente clienteGuardado) {
       Cliente cliente = this.clienteRepositorio.save(clienteGuardado);
       return cliente;
    }

    @Override
    public void eliminarCliente(Integer idCliente) {
      this.clienteRepositorio.deleteById(idCliente);
    }
}
