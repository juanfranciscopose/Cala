package com.cala.util.persons;

public class RandomDataUtils {
	private static String[] discapacidades = { "vision", "movilidad", "razonamiento", "memoria", "comunicacion", "audicion"};
	
	private static String[] trabajos = { "consultor", "contador", "operador ministerio", "albañil", "comerciante", "medico"};
	
	private static String[] profesiones = { "Analista programador", "ing. sistemas", "ing. industrial", "ing. civil", "abogado",
			"Arquitecto", "Kinesiologo", "Fonoudiologo", "licenciado"};
	
	private static String[] apodos = { "gordo", "flaco", "perro", "oveja", "gomita", "negro", "discoteca"};
	
	private static String[] emails = { "@gmail.com", "@gmail.com.ar", "@hotmail.com", "@yahoo.com", "@test.com"};
	
	private static String[] nombres = { "Andrea", "David", "Baldomero", "Balduino", "Baldwin", "Baltasar", "Barry", "Bartolo",
			"Bartolomé", "Baruc", "Baruj", "Candelaria", "Cándida", "Canela", "Caridad", "Carina", "Carisa",
			"Caritina", "Carlota", "Sebastian", "Pedron", "Robertino", "Ariel"};
	
	private static String[] apellidos = { "Gomez", "Guerrero", "Cardenas", "Cardiel", "Cardona", "Cardoso", "Cariaga", "Carillo",
			"Carion", "Castiyo", "Castroman", "Castro", "Grande", "Grangenal", "Grano", "Gracia", "Griego", "Grigalva", "Garesi" }; 
	
	public static int getRandomNumbers(int max) {
		return (int) (Math.random() * max) + 1;
	}
	
	public static String[] getRandomDisabilities(int cantidad) {
		String[] discapacidadesAleatorios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			discapacidadesAleatorios[i] = getDiscapacidades()[(int) (Math.floor(Math.random() * ((getDiscapacidades().length - 1) - 0 + 1) + 0))];
		}
		return discapacidadesAleatorios;
	}
	
	public static String[] getRandomProfessions(int cantidad) {
		String[] trabajosAleatorios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			trabajosAleatorios[i] = getProfesiones()[(int) (Math.floor(Math.random() * ((getProfesiones().length - 1) - 0 + 1) + 0))];
		}
		return trabajosAleatorios;
	}
	
	public static String[] getRandomJobs(int cantidad) {
		String[] trabajosAleatorios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			trabajosAleatorios[i] = getTrabajos()[(int) (Math.floor(Math.random() * ((getTrabajos().length - 1) - 0 + 1) + 0))];
		}
		return trabajosAleatorios;
	}
	
	public static String[] getRandomNicknames(int cantidad) {
		String[] nombresAleatorios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			nombresAleatorios[i] = getApodos()[(int) (Math.floor(Math.random() * ((getApodos().length - 1) - 0 + 1) + 0))];
		}
		return nombresAleatorios;
	}
	
	public static String[] getRandomNames(int cantidad) {
		String[] nombresAleatorios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			nombresAleatorios[i] = getNombres()[(int) (Math.floor(Math.random() * ((getNombres().length - 1) - 0 + 1) + 0))];
		}
		return nombresAleatorios;
	}
	
	public static String[] getRandomSurnames(int cantidad) {
		String[] nombresAleatorios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			nombresAleatorios[i] = getApellidos()[(int) (Math.floor(Math.random() * ((getApellidos().length - 1) - 0 + 1) + 0))];
		}
		return nombresAleatorios;
	}
	
	public static String[] getRandomEmails(int cantidad) {
		String[] emailsAleatorios = new String[cantidad];

		for (int i = 0; i < cantidad; i++) {
			emailsAleatorios[i] = getEmails()[(int) (Math.floor(Math.random() * ((getEmails().length - 1) - 0 + 1) + 0))];
		}
		return emailsAleatorios;
	}

	public static String[] getEmails() {
		return emails;
	}
	
	public static String[] getNombres() {
		return nombres;
	}

	public static String[] getApellidos() {
		return apellidos;
	}

	public static String[] getApodos() {
		return apodos;
	}

	public static String[] getTrabajos() {
		return trabajos;
	}

	public static String[] getProfesiones() {
		return profesiones;
	}

	public static String[] getDiscapacidades() {
		return discapacidades;
	}
}
