package gm.inventarios.servicio;

import gm.inventarios.modelo.Cliente;

import java.util.List;

public interface IClienteServicio {

    List<Cliente> listarClientes();

    Cliente buscarClientePorId (Integer idCliente);

    Cliente guardarCliente (Cliente clienteGuardado);

    void eliminarCliente(Integer idCliente);
}
