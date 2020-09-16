package com.mode.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.mode.entities.Commande;


@CrossOrigin("*")
@RepositoryRestResource
public interface CommandeRepository extends JpaRepository<Commande, Long> {
	
	@Query("select c from Commande c where c.client.id_client = :x")
	public List<Commande> findCommandeByIdClient(@Param("x")Long id_client);

}
