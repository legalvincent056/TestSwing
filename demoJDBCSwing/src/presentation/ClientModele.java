package presentation;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.Client;

public class ClientModele extends AbstractTableModel {

	//colonnes de ma table
	private String[] tableColumnNames = new String [] {"Id","Nom", "Prenom", "Couleur des yeux"			
	};
	
	//lignes de ma table
	private Vector<String[]> tableValues = new Vector<String[]>(); //Chaque ligne est un tableau dans un tableau
	
	//nombre de colonnes
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return tableColumnNames.length;
	}

	//nombre de lignes
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return tableValues.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return tableValues.get(rowIndex)[columnIndex];
		
		}

	
	//retourne le nom de la colonne
	public String getColumnName(int column){
		return tableColumnNames[column];
	}
	
	//remplir le tableau avec les données issues de la bdd
	public void setData(List<Client> clients){
	tableValues = new Vector<String[]>();
	for(Client c : clients){
			tableValues.add(new String[] {
					String.valueOf(c.getId()), c.getNom(), c.getPrenom(), c.getYeux()});
		}
		fireTableChanged(null);
	}
	
}
