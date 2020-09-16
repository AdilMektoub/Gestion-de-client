package com.mode;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mode.entities.Client;
import com.mode.entities.Commande;
import com.mode.repositories.ClientRepository;
import com.mode.repositories.CommandeRepository;

@SpringBootApplication
public class CLientCommandeSbApplication implements CommandLineRunner  {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private CommandeRepository commandeRepository;

	public static void main(String[] args) {
		SpringApplication.run(CLientCommandeSbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		 	Client Ronaldo = new Client("Ronaldo", "Christiano", 33, "0000");
	        clientRepository.save(Ronaldo);
	        Client Messi = new Client ("Messi", "Lionnel", 30, "0000");
	        clientRepository.save(Messi);
	        Client Zinedine = new Client ("Zinedine", "Zidane", 50, "0000");
	        clientRepository.save(Zinedine);
	        Client Charapova = new Client("Charapova", "Maria", 35, "0000");
	        clientRepository.save(Charapova);
	        Client Nadal = new Client("Nadal", "Rafael", 35, "0000");
	        clientRepository.save(Nadal);
	        
	        DateFormat format = new SimpleDateFormat("yyyy MM dd", Locale.ENGLISH);
	        Date d1= format.parse("2019 08 07");	        
	        

			Date d2 = format.parse("2019 12 18") ;
			Date d3 = format.parse("2019 04 01") ;
			Date d4 = format.parse("2019 09 25") ;
			Date d5 = format.parse("2019 10 21") ;
			Date d6 = format.parse("2019 06 29") ;
			Date d7 = format.parse("2019 12 03") ;
			Date d8 = format.parse("2019 05 31") ;

			
			Commande c1 = new Commande() ; Commande c2 = new Commande() ;
			Commande c3 = new Commande() ; Commande c4 = new Commande() ;
			Commande c5 = new Commande() ; Commande c6 = new Commande() ;
			Commande c7 = new Commande() ; Commande c8 = new Commande() ;
			
			c1.setDate(d1); c1.setClient(Ronaldo); c1.setNombre(20); c1.setPrix(1000); c1.setProduit("slip CR7");
			commandeRepository.save(c1) ;
			c2.setDate(d2); c2.setClient(Zinedine); c2.setNombre(10); c2.setPrix(50); c2.setProduit("Tacos");
			commandeRepository.save(c2) ;
			c3.setDate(d3); c3.setClient(Charapova); c3.setNombre(6); c3.setPrix(500); c3.setProduit("jupe mini");
			commandeRepository.save(c3) ;
			c4.setDate(d5); c4.setClient(Messi); c4.setNombre(1); c4.setPrix(300000); c4.setProduit("BMW");
			commandeRepository.save(c4) ;
			c5.setDate(d5); c5.setClient(Zinedine); c5.setNombre(500); c5.setPrix(3000); c5.setProduit("capsule de café");
			commandeRepository.save(c5) ;
			c6.setDate(d6); c6.setClient(Charapova); c6.setNombre(6); c6.setPrix(700); c6.setProduit("crème hydratante");
			commandeRepository.save(c6) ;
			c7.setDate(d7); c7.setClient(Messi); c7.setNombre(600); c7.setPrix(600); c7.setProduit("stylo rose");
			commandeRepository.save(c7) ;
			c8.setDate(d8); c8.setClient(Charapova); c8.setNombre(20); c8.setPrix(1000); c8.setProduit("rouge à  lèvres");
			commandeRepository.save(c8) ;
			
			String tabSpace="     ";
			for (Client elt : clientRepository.findAll()) {
				
				System.out.println(elt.getNom());
				System.out.println(tabSpace +"ses commandes:");			
				for (Commande	cmd : elt.getCommandes()) {
					System.out.println(tabSpace +cmd.getProduit());
				}
				System.out.println();
			}
			
			System.out.println("---------------------------------");
			System.out.println("Commandes");
			System.out.println("---------------------------------");
			for (Commande elt : commandeRepository.findAll()) 
				System.out.println(elt.getClient().getNom());
		
	}

}
