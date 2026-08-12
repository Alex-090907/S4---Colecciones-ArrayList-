package principal;

import java.util.ArrayList;
import java.util.Scanner;

import clases.estudiante;
import clases.nota;

public class Main {

	static ArrayList<estudiante> estudiantes = new ArrayList<estudiante>();
	static ArrayList<nota> notas = new ArrayList<nota>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int opcion;

		do {
			System.out.println("\n===== MENU PRINCIPAL =====");
			System.out.println("1. Estudiantes");
			System.out.println("2. Calificaciones");
			System.out.println("3. Notas por Estudiante");
			System.out.println("4. Notas por Aporte");
			System.out.println("5. Salir");
			System.out.print("Elige una opcion: ");
			opcion = leerEntero();

			switch (opcion) {
			case 1:
				menuEstudiantes();
				break;
			case 2:
				menuCalificaciones();
				break;
			case 3:
				notasPorEstudiante();
				break;
			case 4:
				notasPorAporte();
				break;
			case 5:
				System.out.println("Saliendo del programa...");
				break;
			default:
				System.out.println("Opcion no valida, intenta de nuevo.");
			}

		} while (opcion != 5);

		sc.close();
	}

	// ================= OPCION 1: ESTUDIANTES =================
	static void menuEstudiantes() {
		int op;
		do {
			System.out.println("\n--- Estudiantes ---");
			System.out.println("1. Registrar estudiante");
			System.out.println("2. Listar estudiantes");
			System.out.println("3. Volver al menu principal");
			System.out.print("Elige una opcion: ");
			op = leerEntero();

			switch (op) {
			case 1:
				registrarEstudiante();
				break;
			case 2:
				listarEstudiantes();
				break;
			case 3:
				break;
			default:
				System.out.println("Opcion no valida.");
			}
		} while (op != 3);
	}

	static void registrarEstudiante() {
		estudiante e = new estudiante();

		System.out.print("Cedula: ");
		String cedula = sc.nextLine();

		if (buscarEstudiante(cedula) != null) {
			System.out.println("Ya existe un estudiante con esa cedula.");
			return;
		}

		e.setCedula(cedula);
		System.out.print("Nombre: ");
		e.setNombre(sc.nextLine());
		System.out.print("Apellido: ");
		e.setApellido(sc.nextLine());

		estudiantes.add(e);
		System.out.println("Estudiante registrado con exito.");
	}

	static void listarEstudiantes() {
		if (estudiantes.isEmpty()) {
			System.out.println("No hay estudiantes registrados.");
			return;
		}
		System.out.println("\n--- Lista de estudiantes ---");
		for (estudiante e : estudiantes) {
			System.out.println(e.toString());
		}
	}

	static estudiante buscarEstudiante(String cedula) {
		for (estudiante e : estudiantes) {
			if (e.getCedula().equalsIgnoreCase(cedula)) {
				return e;
			}
		}
		return null;
	}

	// ================= OPCION 2: CALIFICACIONES =================
	static void menuCalificaciones() {
		int op;
		do {
			System.out.println("\n--- Calificaciones ---");
			System.out.println("1. Registrar calificaciones");
			System.out.println("2. Listar calificaciones");
			System.out.println("3. Volver al menu principal");
			System.out.print("Elige una opcion: ");
			op = leerEntero();

			switch (op) {
			case 1:
				registrarNota();
				break;
			case 2:
				listarNotas();
				break;
			case 3:
				break;
			default:
				System.out.println("Opcion no valida.");
			}
		} while (op != 3);
	}

	static void registrarNota() {
		System.out.print("Cedula del estudiante: ");
		String cedula = sc.nextLine();

		estudiante e = buscarEstudiante(cedula);
		if (e == null) {
			System.out.println("No existe un estudiante con esa cedula. Registralo primero en la opcion 1.");
			return;
		}

		if (buscarNota(cedula) != null) {
			System.out.println("Este estudiante ya tiene calificaciones registradas.");
			return;
		}

		nota n = new nota();
		n.setCiestudiante(cedula);

		System.out.print("Aporte 1 (0-10): ");
		n.setN1(leerDecimal());
		System.out.print("Aporte 2 (0-10): ");
		n.setN2(leerDecimal());
		System.out.print("Aporte 3 (0-10): ");
		n.setN3(leerDecimal());
		System.out.print("Examen (0-10): ");
		n.setEx(leerDecimal());

		notas.add(n);
		System.out.println("Calificaciones registradas con exito.");
	}

	static void listarNotas() {
		if (notas.isEmpty()) {
			System.out.println("No hay calificaciones registradas.");
			return;
		}
		System.out.println("\n--- Lista de calificaciones ---");
		for (nota n : notas) {
			estudiante e = buscarEstudiante(n.getCiestudiante());
			String nombreEstudiante = (e != null) ? e.getNombre() + " " + e.getApellido() : "Desconocido";
			System.out.println("Estudiante: " + nombreEstudiante + " (" + n.getCiestudiante() + ") | "
					+ "Aporte1=" + n.getN1() + " Aporte2=" + n.getN2() + " Aporte3=" + n.getN3()
					+ " Examen=" + n.getEx());
		}
	}

	static nota buscarNota(String cedula) {
		for (nota n : notas) {
			if (n.getCiestudiante().equalsIgnoreCase(cedula)) {
				return n;
			}
		}
		return null;
	}

	// ================= OPCION 3: NOTAS POR ESTUDIANTE =================
	static void notasPorEstudiante() {
		if (estudiantes.isEmpty()) {
			System.out.println("No hay estudiantes registrados.");
			return;
		}

		System.out.print("\nIngresa la cedula del estudiante a consultar: ");
		String cedula = sc.nextLine();

		estudiante e = buscarEstudiante(cedula);
		if (e == null) {
			System.out.println("No existe un estudiante con esa cedula.");
			return;
		}

		nota n = buscarNota(cedula);
		if (n == null) {
			System.out.println("Este estudiante todavia no tiene calificaciones registradas.");
			return;
		}

		double promedioAportes = (n.getN1() + n.getN2() + n.getN3()) / 3.0;
		double notaFinal = (promedioAportes * 0.7) + (n.getEx() * 0.3);

		System.out.println("\n--- Notas de " + e.getNombre() + " " + e.getApellido() + " ---");
		System.out.println("Cedula: " + e.getCedula());
		System.out.println("Aporte 1: " + n.getN1());
		System.out.println("Aporte 2: " + n.getN2());
		System.out.println("Aporte 3: " + n.getN3());
		System.out.println("Examen: " + n.getEx());
		System.out.printf("Promedio de aportes: %.2f%n", promedioAportes);
		System.out.printf("Nota final (70%% aportes + 30%% examen): %.2f%n", notaFinal);
		System.out.println(notaFinal >= 7.0 ? "Resultado: APROBADO" : "Resultado: REPROBADO");
	}

	// ================= OPCION 4: NOTAS POR APORTE =================
	static void notasPorAporte() {
		if (notas.isEmpty()) {
			System.out.println("No hay calificaciones registradas.");
			return;
		}

		System.out.println("\nQue aporte quieres consultar?");
		System.out.println("1. Aporte 1");
		System.out.println("2. Aporte 2");
		System.out.println("3. Aporte 3");
		System.out.println("4. Examen");
		System.out.print("Elige una opcion: ");
		int op = leerEntero();

		if (op < 1 || op > 4) {
			System.out.println("Opcion no valida.");
			return;
		}

		String etiqueta = "";
		double suma = 0;

		System.out.println("\n--- Notas por aporte ---");
		for (nota n : notas) {
			double valor = 0;
			switch (op) {
			case 1:
				valor = n.getN1();
				etiqueta = "Aporte 1";
				break;
			case 2:
				valor = n.getN2();
				etiqueta = "Aporte 2";
				break;
			case 3:
				valor = n.getN3();
				etiqueta = "Aporte 3";
				break;
			case 4:
				valor = n.getEx();
				etiqueta = "Examen";
				break;
			}

			estudiante e = buscarEstudiante(n.getCiestudiante());
			String nombreEstudiante = (e != null) ? e.getNombre() + " " + e.getApellido() : "Desconocido";

			System.out.println(nombreEstudiante + " (" + n.getCiestudiante() + ") -> " + etiqueta + ": " + valor);
			suma += valor;
		}

		double promedioGrupo = suma / notas.size();
		System.out.printf("\nPromedio del grupo en %s: %.2f%n", etiqueta, promedioGrupo);
	}

	// ================= UTILIDADES DE LECTURA =================
	static int leerEntero() {
		while (!sc.hasNextInt()) {
			System.out.print("Ingresa un numero valido: ");
			sc.next();
		}
		int valor = sc.nextInt();
		sc.nextLine(); // limpiar el buffer
		return valor;
	}

	static double leerDecimal() {
		while (!sc.hasNextDouble()) {
			System.out.print("Ingresa un valor numerico valido: ");
			sc.next();
		}
		double valor = sc.nextDouble();
		sc.nextLine(); // limpiar el buffer
		return valor;
	}
}