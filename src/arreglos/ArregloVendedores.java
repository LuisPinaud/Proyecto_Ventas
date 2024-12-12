package arreglos;

import java.util.ArrayList;
import clases.Vendedor;

public class ArregloVendedores {
	private ArrayList <Vendedor> ven;
	
	public ArregloVendedores() {
		ven = new ArrayList <Vendedor>();
		adicionar(new Vendedor(2001, 1,"Carlos", "Gutierrez", "965874321", "51234567"));
		adicionar(new Vendedor(2002, 2,"Laura", "Martinez", "923456789", "67891234"));
		adicionar(new Vendedor(2003, 3,"Fernando", "Perez", "912345678", "78912345"));
		adicionar(new Vendedor(2004, 4,"Mariana", "Gomez", "978654321", "89123456"));
		adicionar(new Vendedor(2005, 5,"Roberto", "Hernandez", "937468291", "91234567"));
		adicionar(new Vendedor(2006, 6,"Diana", "Ramirez", "945678123", "12345678"));
		adicionar(new Vendedor(2007, 7,"Ricardo", "Lopez", "964512378", "23456789"));
		adicionar(new Vendedor(2008, 8,"Ana", "Vargas", "902347816", "34567891"));
		adicionar(new Vendedor(2009, 9,"Jorge", "Castillo", "943278156", "45678912"));
		adicionar(new Vendedor(2010, 10,"Carmen", "Ortega", "988761234", "56789123"));
		adicionar(new Vendedor(2011, 11,"Fernando", "Perez", "912345678", "78912345"));
		adicionar(new Vendedor(2012, 12,"Mariana", "Gomez", "978654321", "89123456"));
		adicionar(new Vendedor(2013, 13,"Roberto", "Hernandez", "937468291", "91234567"));
		adicionar(new Vendedor(2014, 14,"Diana", "Ramirez", "945678123", "12345678"));
		adicionar(new Vendedor(2015, 15,"Ricardo", "Lopez", "964512378", "23456789"));
		adicionar(new Vendedor(2016, 16,"Ana", "Vargas", "902347816", "34567891"));
		adicionar(new Vendedor(2017, 17,"Fernando", "Perez", "912345678", "78912345"));
		adicionar(new Vendedor(2018, 18,"Mariana", "Gomez", "978654321", "89123456"));
		adicionar(new Vendedor(2019, 19,"Roberto", "Hernandez", "937468291", "91234567"));
		adicionar(new Vendedor(2020, 20,"Diana", "Ramirez", "945678123", "12345678"));
		adicionar(new Vendedor(2021, 21,"Ricardo", "Lopez", "964512378", "23456789"));
		adicionar(new Vendedor(2022, 22,"Ana", "Vargas", "902347816", "34567891"));
		
	}
	
	public void adicionar(Vendedor x) {
		ven.add(x);
	}
	public int tamanio() {
		return ven.size();
	}
	public Vendedor obtener(int i) {
		return ven.get(i);
	}
	public Vendedor buscar(int codigo) {
		Vendedor x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigoVendedor() == codigo)
				return x;
		}
		return null;
	}
	public Vendedor buscarTelf(String telf) {
		Vendedor x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getTelefono().equals(telf))
				return x;
		}
		return null;
	}
	public Vendedor buscarDni(String dni) {
		Vendedor x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	public void eliminar(Vendedor x) {
		ven.remove(x);
	}
	
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 2001;
		else
			return obtener(tamanio()-1).getCodigoVendedor() + 1;		
	}

}