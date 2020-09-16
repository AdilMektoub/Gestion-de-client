package com.mode.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data @NoArgsConstructor @AllArgsConstructor @Setter @Getter
@Entity @Table(name="cmd")
public class Commande implements Serializable{
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_commande;
	private String produit;
	private int nombre;
	private int prix;
	private Date date;
	
	@ManyToOne
	private Client client;
	
	public Long getId_commande() {
		return id_commande;
	}

	public String getProduit() {
		return produit;
	}

	public int getNombre() {
		return nombre;
	}

	public int getPrix() {
		return prix;
	}

	public Date getDate() {
		return date;
	}

	public Client getClient() {
		return client;
	}

	public void setId_commande(Long id_commande) {
		this.id_commande = id_commande;
	}

	public void setProduit(String produit) {
		this.produit = produit;
	}

	public void setNombre(int nombre) {
		this.nombre = nombre;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	
	public Commande(String produit, int nombre, int prix, Date date) {
		this.produit = produit;
		this.nombre = nombre;
		this.prix = prix;
		this.date = date;
	}

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
