package service;

import java.util.Collection;

import dao.Dao;
import dao.IDao;
import metier.Client;

public class ClientService implements IClientService,IClientServiceVip {

	private IDao idao = new Dao();
	
	
	@Override
	public void direBonjour() {
		// TODO Auto-generated method stub
		System.out.println("BONJOUR");

	}

	@Override
	public void direAurevoir() {
		// TODO Auto-generated method stub
		System.out.println("AU REVOIR");
	}

	@Override
	public void jesuisVip() {
		// TODO Auto-generated method stub
		System.out.println("JE SUIS VIP");
	}

	@Override
	public void ajouterClient(Client c) {
		idao.ajouterClient(c);
				
	}

	@Override
	public void modifierClient(int id, String nom, String prenom, String yeux) {
		// TODO Auto-generated method stub
		idao.modifierClient(id, nom, prenom, yeux);
	}

	@Override
	public void supprimerClient(int id) {
		// TODO Auto-generated method stub
		idao.supprimerClient(id);
	}

	@Override
	public Collection<Client> listerClients() {
		// TODO Auto-generated method stub
		return idao.listerClients();
	}

	@Override
	public Collection<Client> chercherParMC(String mc) {
		// TODO Auto-generated method stub
		return idao.chercherParMC(mc);
	}

	@Override
	public void modifierClient(Client c, String nom, String prenom) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client retrouverClient(int id) {
		// TODO Auto-generated method stub
		return idao.retrouverClient(id);
	}
		
	public void ajouterYeux(){
		
		idao.ajouterYeux();
	}
	
	
	
}
