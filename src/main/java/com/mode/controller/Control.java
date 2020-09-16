package com.mode.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mode.entities.Client;
import com.mode.entities.Commande;
import com.mode.repositories.ClientRepository;
import com.mode.repositories.CommandeRepository;

@Controller
public class Control {
	
	@Autowired
	private ClientRepository clientRepo;
	
	@Autowired
	private CommandeRepository commandeRepo;
	
	@RequestMapping(value = "/login2" , method=RequestMethod.GET)
	public String login2() {
		return "login2";
	}
	
	@RequestMapping(value = "/")
	public String home() {
		return "redirect:/login2";
	}
	
	@RequestMapping(value = "/login22" , method=RequestMethod.POST)
	public String login22(Model model , 
			@RequestParam(name = "username", defaultValue="") String username,
			@RequestParam(name = "password", defaultValue="") String password) {

		System.out.println("--------------" +username);
		List<Client> clients = clientRepo.findAll();
		boolean clientExist = false;
		for (Client client : clients) {
			if (client.getNom().equals(username) && client.getPassword().equals(password)) {
				clientExist = true;
				model.addAttribute("username", username);
				model.addAttribute("password", password);
				
//				HttpSession session = request.getSession( true );
//				session.setAttribute( "connectedClient", connectedClient );
				
				List<Commande> touteCommandes = commandeRepo.findCommandeByIdClient(client.getId_client());
				model.addAttribute("touteCommandes", touteCommandes);	
			}
		}
		if (clientExist)
		return "login22";
		else return "error";
	}

}
