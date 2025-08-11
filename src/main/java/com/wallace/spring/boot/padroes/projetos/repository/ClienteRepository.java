package com.wallace.spring.boot.padroes.projetos.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wallace.spring.boot.padroes.projetos.entities.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}