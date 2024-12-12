package arreglos;

import java.util.ArrayList;
import clases.Cliente;

public class ArregloClientes {
	private ArrayList <Cliente> cli;
	
	public ArregloClientes() {
		cli = new ArrayList <Cliente>();
		adicionar (new Cliente(1001, "Edson", "Lhi Ugaz", "999999999", "88888888"));
		adicionar (new Cliente(1002, "Michael", "Chuhue", "981213192", "56600000"));
		adicionar (new Cliente(1003, "Angel", "Bances", "902095145", "75132311"));
		adicionar (new Cliente(1004, "Luis", "Pinaud", "913838185", "66666666"));
		adicionar (new Cliente(1005, "Jhosep", "Palacios", "952520615", "74990505"));
		adicionar (new Cliente(1006, "Robbi", "Mendez", "997464192", "80000000"));
		adicionar (new Cliente(1007, "Maria", "Carreras", "928208831", "78656013"));
		adicionar (new Cliente(1008, "Jose", "Marquez", "996100382", "51046277"));
		adicionar (new Cliente(1009, "Alfonso", "Tello", "908411694", "65139124"));
		adicionar (new Cliente(1010, "Juliana", "Morillo", "976128189", "63411351"));
		adicionar (new Cliente(1011, "Juan", "Reyes", "918964172", "63530702"));
		adicionar (new Cliente(1012, "Oscar", "Cordoba", "987608584", "49766191"));
		adicionar (new Cliente(1013, "Esteban", "Medrano", "908509496", "60744210"));
		adicionar (new Cliente(1014, "Luciano", "Diaz", "968046654", "42990241"));
		adicionar (new Cliente(1015, "Israel", "Mansilla", "941733719", "76825837"));
		adicionar (new Cliente(1016, "Paola", "Flores", "981543123", "71380083"));
		adicionar (new Cliente(1017,"Karla", "Ceballos", "980784356", "76527919"));
		adicionar (new Cliente(1018,"Marcus", "Camacho", "978379096", "40164210"));
		adicionar (new Cliente(1019, "Edgar", "Marcarian", "954670202", "31896457"));
		adicionar (new Cliente(1020, "Paula", "Rengifo", "902654877", "43562271"));
		adicionar (new Cliente(1021, "Piero", "Perez", "989356776", "56478799"));
		adicionar (new Cliente(1022, "Angel", "Zambrano", "921760734", "43890744"));
		adicionar (new Cliente(1023, "Gerardo", "Moreno", "999843567", "54906612"));
		adicionar (new Cliente(1024, "Lucas", "Gomez", "902678554", "54837611"));
		adicionar (new Cliente(1025, "María", "Maldonado", "933229701", "75103212"));
		adicionar (new Cliente(1026, "Felipe", "Orihuela", "965111380", "76094833"));
		adicionar (new Cliente(1027, "Carlos", "Gutierrez", "965874321", "51234567"));
		adicionar (new Cliente(1028, "Laura", "Martinez", "923456789", "67891234"));
		adicionar (new Cliente(1029, "Fernando", "Perez", "912345678", "78912345"));
		adicionar (new Cliente(1030, "Mariana", "Gomez", "978654321", "89123456"));
		adicionar (new Cliente(1031, "Roberto", "Hernandez", "937468291", "91234567"));
		adicionar (new Cliente(1032, "Diana", "Ramirez", "945678123", "12345678"));
		adicionar (new Cliente(1033, "Ricardo", "Lopez", "964512378", "23456789"));
		adicionar (new Cliente(1034, "Ana", "Vargas", "902347816", "34567891"));
		adicionar (new Cliente(1035, "Jorge", "Castillo", "943278156", "45678912"));
		adicionar (new Cliente(1036, "Carmen", "Ortega", "988761234", "56789123"));
	}
	
	public void adicionar(Cliente x) {
		cli.add(x);
	}
	public int tamanio() {
		return cli.size();
	}
	public Cliente obtener(int i) {
		return cli.get(i);
	}
	public Cliente buscar(int codigo) {
		Cliente x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getCodigoCliente() == codigo)
				return x;
		}
		return null;
	}
	public Cliente buscarTelf(String telf) {
		Cliente x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getTelefono().equals(telf))
				return x;
		}
		return null;
	}
	public Cliente buscarDni(String dni) {
		Cliente x;
		for (int i=0; i<tamanio(); i++) {
			x = obtener(i);
			if (x.getDni().equals(dni))
				return x;
		}
		return null;
	}
	public void eliminar(Cliente x) {
		cli.remove(x);
	}
	
	
	public int codigoCorrelativo() {
		if (tamanio() == 0)
			return 1001;
		else
			return obtener(tamanio()-1).getCodigoCliente() + 1;		
	}
	
}


