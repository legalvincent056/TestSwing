package presentation;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import metier.Client;
import service.ClientService;
import service.IClientService;



class Fenetre extends JFrame {

	// liste des composants de ma fenêtre
	private JLabel jl = new JLabel("Nom :"); 
	private JTextField jtf1 = new JTextField(12);
	
	private JLabel jl1 = new JLabel("Prenom :"); 
	private JTextField jtf2 = new JTextField(12);
	
	private JLabel jl2 = new JLabel("Yeux :"); 
	private JTextField jtf3 = new JTextField(12);
	
	private JLabel jl3 = new JLabel("Id :");
	private JTextField jtf4 = new JTextField(12);
	
	private JButton jb1 = new JButton("Ajouter");
	private JButton jb2 = new JButton("Supprimer");
	
	
	//Liste des composants de l'onglet 3
	private JLabel jl4 = new JLabel("Nom :"); 
	private JTextField jtf5 = new JTextField(12);
	
	private JLabel jl5 = new JLabel("Prenom :"); 
	private JTextField jtf6 = new JTextField(12);
	
	private JLabel jl6 = new JLabel("Yeux :"); 
	private JTextField jtf7 = new JTextField(12);
	
	private JLabel jl7 = new JLabel("Id :");
	private JTextField jtf8 = new JTextField(12);
	
	private JButton jb3 = new JButton("Modifier");

	
	//Liste des composants de l'onglet 4 - Liste
	private JScrollPane jsp;
	private JLabel JLMC = new JLabel("Mot clé");
	private JTextField jtfMC = new JTextField(12);
	private JButton JBValider = new JButton("Valider");
	private JTable jTableClients;
	private JPanel jpN = new JPanel();
	private ClientModele model;
	
	
	
	private IClientService service = new ClientService();
	private Client c = new Client();
	
	public Fenetre(String nom){
		super(nom);
		setSize(800,600); //taille de la fenêtre
		
		//disposition de la fenêtre principale 
		this.setLayout(new BorderLayout()); //précise que ce je vais ajouter va se faire ligne par ligne
		
		
		
		
	//déclaration d'un "tableau" d'onglet
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
		
//déclaration un JPanel Ajouter
		
	JPanel onglet1 = new JPanel();
		
	
		//ajout de la première ligne
		JPanel jp1 = new JPanel(); //nouvelle ligne
		jp1.setLayout(new FlowLayout());
		jp1.add(jl);jp1.add(jtf1); //ajout du text et du label

		//ajout de la deuxième ligne
		JPanel jp2 = new JPanel(); //nouvelle ligne
		jp2.setLayout(new FlowLayout());
		jp2.add(jl1);jp2.add(jtf2); //ajout du text et du label
		
		
		//ajout de la troisième ligne
		JPanel jp3 = new JPanel(); //nouvelle ligne
		jp3.setLayout(new FlowLayout());
		jp3.add(jl2);jp3.add(jtf3);  //ajout du text et du label

		//ajout de la quatrième ligne
		JPanel jp4 = new JPanel(); //nouvelle ligne
		jp4.setLayout(new FlowLayout());
		jp4.add(jb1); //ajout des bouttons 
		
		
		
		
		JPanel jp5 = new JPanel();
		jp5.setLayout(new BoxLayout(jp5,BoxLayout.Y_AXIS));
		jp5.add(jp1);
		jp5.add(jp2);
		jp5.add(jp3);
		jp5.add(jp4);
		
		onglet1.add(jp5,BorderLayout.NORTH);
		
		
		
		
		//Rendre le bouton actif en lui donnant une action à réaliser
		jb1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// récupération des paramètres saisis par le client
				String nom = jtf1.getText();
				String prenom = jtf2.getText();
				String yeux = jtf3.getText();
				
				//appel de la couche service
				c.setNom(nom);
				c.setPrenom(prenom);
				c.setYeux(yeux);
				service.ajouterClient(c);
				
				
				//vider les champs après ajout en base
				jtf1.setText("");
				jtf2.setText("");
				jtf3.setText("");
			}
		});
		
		
		//déclaration un JPanel Supprimer
		
		JPanel onglet2 = new JPanel();
		
		
		
			//ajout de la première ligne
				JPanel jp6 = new JPanel(); //nouvelle ligne
				jp6.setLayout(new FlowLayout());
				jp6.add(jl3);
				jp6.add(jtf4); //ajout du text et du label
		
		
		
			//ajout du boutton
				JPanel jp7 = new JPanel(); //nouvelle ligne
				jp7.setLayout(new FlowLayout());
				jp7.add(jb2); //ajout des bouttons 
		
			
				//Association des text, saisie et boutton à un JPanel générale
				JPanel jp8 = new JPanel();
				jp8.setLayout(new BoxLayout(jp8,BoxLayout.Y_AXIS));
				jp8.add(jp6);
				jp8.add(jp7);
		
		
				onglet2.add(jp8,BorderLayout.NORTH);
		
		
				//Rendre le bouton actif en lui donnant une action à réaliser
				jb2.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						// récupération des paramètres saisis par le client
						int id =Integer.parseInt(jtf4.getText());
						
						
						//appel de la couche service
						c.setId(id);
						service.supprimerClient(id);
												
						//vider les champs après ajout en base
						jtf4.setText("");
						
					}
				
					
				});
				
				
			//déclaration un JPanel Modifier
				
			JPanel onglet3 = new JPanel();
				
				//ajout de la ligne avec Id
				JPanel jp9 = new JPanel();
				jp9.setLayout(new FlowLayout());
				jp9.add(jl7);
				jp9.add(jtf8);
				
				//ajout de la première ligne
				JPanel jp10 = new JPanel(); //nouvelle ligne
				jp10.setLayout(new FlowLayout());
				jp10.add(jl4);jp10.add(jtf5); //ajout du text et du label

				//ajout de la deuxième ligne
				JPanel jp11 = new JPanel(); //nouvelle ligne
				jp11.setLayout(new FlowLayout());
				jp11.add(jl5);jp11.add(jtf6); //ajout du text et du label
				
				//ajout de la troisième ligne
				JPanel jp12 = new JPanel(); //nouvelle ligne
				jp12.setLayout(new FlowLayout());
				jp12.add(jl6);
				jp12.add(jtf7);  //ajout du text et du label

								
				//ajout du boutton
				JPanel jp14 = new JPanel(); //nouvelle ligne
				jp14.setLayout(new FlowLayout());
				jp14.add(jb3); //ajout des bouttons
				
				
				//Association des text, saisie et boutton à un JPanel générale
				JPanel jp15 = new JPanel();
				jp15.setLayout(new BoxLayout(jp15,BoxLayout.Y_AXIS));
				jp15.add(jp9);
				jp15.add(jp10);
				jp15.add(jp11);
				jp15.add(jp12);
				
				jp15.add(jp14);
		
			onglet3.add(jp15,BorderLayout.NORTH);
			
			
			//Rendre le bouton actif en lui donnant une action à réaliser
			jb3.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
					// récupération des paramètres saisis par le client
					int id =Integer.parseInt(jtf8.getText());
					String nom = jtf5.getText();
					String prenom = jtf6.getText();
					String yeux = jtf7.getText();
											
					//appel de la couche service
					c.setNom(nom);
					c.setPrenom(prenom);
					c.setYeux(yeux);
					c.setId(id);
					service.modifierClient(id, nom, prenom, yeux);
					
											
					//vider les champs après ajout en base
					jtf8.setText("");
					jtf5.setText("");
					jtf6.setText("");
					jtf7.setText("");
					
				}
				
			});
			
			//Création onglet4 avec JPanel
			
			JPanel onglet4 = new JPanel();
			
			onglet4.setLayout(new BoxLayout(onglet4,BoxLayout.PAGE_AXIS));
			
			//Ajout de la recherche par Mot clé
			jpN.setLayout(new FlowLayout());
			jpN.add(JLMC);
			jpN.add(jtfMC);
			jpN.add(JBValider);
			
			onglet4.add(jpN, BorderLayout.NORTH);
			
			//Ajout du tableau
			model = new ClientModele();
			jTableClients = new JTable(model);
			jsp = new JScrollPane(jTableClients);
			
			
			//Ajout du boutton
			JBValider.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String mc = jtfMC.getText();
					model.setData((List<Client>) service.chercherParMC(mc));
					
				}
				
			});
			
			onglet4.add(jsp, BorderLayout.CENTER);
		
		
	//Associer le JPanel au JTabbedPane
	onglets.addTab("Ajouter",onglet1);
	onglets.addTab("Supprimer", onglet2);
	onglets.addTab("Modifier", onglet3);
	onglets.addTab("Lister Clients",onglet4);
	
	//Associer le JTabbed Pane à ma fenêtre
	this.add(onglets);
			
					
	};
	
		
}




