package menjacnica.modeli;

import java.util.LinkedList;

import javax.swing.table.AbstractTableModel;

public class TabelaIzgled extends AbstractTableModel{
	private String[] kolone = {"Sifra","Skraceni naziv", "Prodajni","Srednji","Kupovni","Naziv"};
	

	
	public TabelaIzgled() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
	
		return 10;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

}