package gm.inventarios.repositorio;

import gm.inventarios.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepositorio extends JpaRepository <Cliente, Integer> {
}
