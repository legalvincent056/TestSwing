package dao;

import java.util.Collection;

import metier.Client;

public interface IDao {

	
	public void ajouterClient(Client c);
	public void modifierClient(int id, String nom, String prenom, String yeux);
	public void supprimerClient(int id);
	public Collection<Client> listerClients();
	public Collection<Client> chercherParMC(String mc); //recherche par Mot cl� du nom
	public Client retrouverClient(int id);
	public void ajouterYeux();
	
	
}
