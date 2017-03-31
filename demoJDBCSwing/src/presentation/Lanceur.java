package presentation;

import java.util.ArrayList;
import java.util.Collection;

import metier.Client;
import service.ClientService;
import service.IClientService;
import service.IClientServiceVip;

public class Lanceur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// déclaration de l'interface
		IClientService s = new ClientService();
		IClientServiceVip sv = new ClientService();
		
		Client c = new Client();
		
		Collection<Client> col = new ArrayList<Client>();
		
		//declaration de la classe;
		ClientService cs = new ClientService();
		System.out.println("--------------CLIENT NORMAL-------------------------------");		
		// utilisation de l'interface
		s.direAurevoir();
		s.direBonjour();
		//s.jesuisVip();
		System.out.println("--------------CLIENT VIP---------------------------------");
		sv.direBonjour();
		sv.direAurevoir();
		sv.jesuisVip();
		
		//utilisation de la classe
		/*cs.direAurevoir();
		cs.direBonjour();
		cs.jesuisVip();*/
		
		System.out.println("--------------AJOUTER CLIENT---------------------------------");
		c.setNom("nom2");
		c.setPrenom("prepre");
		c.setYeux("vertFluo");
		s.ajouterClient(c);
		

		

		System.out.println("--------------MODIFIER CLIENT---------------------------------");

	//	s.modifierClient(7, "modi", "fication");
		
	/*	System.out.println("--------------LISTER CLIENT---------------------------------");
		col = s.listerClients();
		for(Client cli :col){
		System.out.println(cli);
	}*/
		
		System.out.println("--------------LISTER 1 CLIENT avec son ID---------------------");
		
	//	Client c1 = s.retrouverClient(5);
	//	System.out.println(c1);

		System.out.println("--------------SUPPRIMER CLIENT---------------------------------");
	//	s.supprimerClient(7);
		
		System.out.println("--------------RECHERCHER CLIENT---------------------------------");
		Collection<Client> col2 = s.chercherParMC("o");
		
		for(Client client : col2){
			System.out.println(client);
		}
		
		
		System.out.println("--------------AJOUT COLONNE---------------------------------");
		
	//	s.ajouterYeux();
		
		Fenetre f = new Fenetre("MA FENETRE"); //Il n'y a pas d'importation de la classe Fenetre car Lanceur et Fenetre sont dans le même package
		f.setVisible(true); // affichage de la fenêtre
		
	}
		
				
	

}
