package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import metier.Client;

public class Dao implements IDao {

	@Override
	public void ajouterClient(Client c) {
		
		try {
			//1- Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
					
			//2- Créer la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root","");
			
			//3- Créer la requête
			//PreparedStatement ps = con.prepareStatement("INSERT INTO Client(nom,prenom) VALUES ('"+ c.getNom() + "','" + c.getPrenom() + "')");
			PreparedStatement ps = con.prepareStatement("INSERT INTO Client(nom,prenom,yeux) VALUES (?,?,?)");
			ps.setString(1, c.getNom());
			ps.setString(2, c.getPrenom());
			ps.setString(3, c.getYeux());
			
			
			//4- Executer la requête
			ps.executeUpdate();
			
			
			//5- Présenter les resultats
			
			//6- fermer la connexion
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//code qui est executé quelque soit les étapes précédentes 
		}
		

	}

	@Override
	public void modifierClient(int id, String nom, String prenom, String yeux) {
		try {
			//1- Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
					
			//2- Créer la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root","");
			
			//3- Créer la requête
			PreparedStatement ps = con.prepareStatement("Update Client set nom = ? , prenom = ?, yeux = ? where id = ?");
			ps.setString(1, nom);
			ps.setString(2,  prenom);
			ps.setString(3, yeux);
			ps.setInt(4, id);
			
			//4- Executer la requête
			ps.executeUpdate();
						
			//5- Présenter les resultats
			
			//6- fermer la connexion
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//code qui est executé quelque soit les étapes précédentes 
		}

	}

	@Override
	public void supprimerClient(int id) {
		try {
			//1- Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
					
			//2- Créer la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root","");
			
			//3- Créer la requête
			PreparedStatement ps = con.prepareStatement("Delete from Client where id=?;");
			ps.setInt(1, id);
			
			//4- Executer la requête
			ps.executeUpdate();
			
			//5- Présenter les resultats
			
			//6- fermer la connexion
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//code qui est executé quelque soit les étapes précédentes 
		}
		
	}

	@Override
	public Collection<Client> listerClients() {
		Collection<Client> c1 = new ArrayList<Client>();
		try {
			//1- Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
					
			//2- Créer la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root","");
			
			//3- Créer la requête
			PreparedStatement ps = con.prepareStatement("Select * from Client;");
					
			//4- Executer la requête
			ResultSet rs = ps.executeQuery();
			
			//5- Présenter les resultats
			
			while (rs.next()){
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setYeux(rs.getString("yeux"));
				c1.add(c);
			}
			
			//6- fermer la connexion
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//code qui est executé quelque soit les étapes précédentes 
		}
		
		
		return c1;
	}

	@Override
	public Collection<Client> chercherParMC(String mc) {
		// TODO Auto-generated method stub
		Collection<Client> c1 = new ArrayList<Client>();
		try {
			//1- Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
					
			//2- Créer la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root","");
			
			//3- Créer la requête
			PreparedStatement ps = con.prepareStatement("Select * from Client where nom like ?");
			ps.setString(1,"%"+mc+"%");
			
			//4- Executer la requête
			ResultSet rs = ps.executeQuery();
			
			//5- Présenter les resultats
			
			while (rs.next()){
				Client c = new Client();
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setYeux(rs.getString("yeux"));
				c1.add(c);
			}
			
			//6- fermer la connexion
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//code qui est executé quelque soit les étapes précédentes 
		}
		
		return c1;
	}

	
	
	@Override
	public Client retrouverClient(int id) {
		Client c = new Client();
		try {
			//1- Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
					
			//2- Créer la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root","");
			
			//3- Créer la requête
			PreparedStatement ps = con.prepareStatement("Select * from Client where id = ?;");
			ps.setInt(1,id);
			
			//4- Executer la requête
			ResultSet rs = ps.executeQuery();
			
			//5- Présenter les resultats
			
			 rs.next(); //recherche tant qu'il n'a pas trouvé l'ID
				c.setId(rs.getInt("id"));
				c.setNom(rs.getString("nom"));
				c.setPrenom(rs.getString("prenom"));
				c.setYeux(rs.getString("yeux"));
			
			
			//6- fermer la connexion
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c ;
	}

	@Override
	public void ajouterYeux() {
		try {
			//1- Charger le pilote
			Class.forName("com.mysql.jdbc.Driver");
					
			//2- Créer la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bddclients", "root","");
			
			//3- Créer la requête
		
			PreparedStatement ps = con.prepareStatement("ALTER table Client ADD yeux VarChar(20)");
			
			//4- Executer la requête
			ps.executeUpdate();
			
			
			//5- Présenter les resultats
			
			//6- fermer la connexion
			con.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
	
}
