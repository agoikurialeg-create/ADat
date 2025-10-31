package pruebaAdat;

import java.util.Scanner;

public class enRaya3{
	
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		boolean turno = false, winX = false, winO = false, end = false;

		// Posiciones de las casillas

		String a1 = "[1]";
		String a2 = "[2]";
		String a3 = "[3]";
		String b1 = "[4]";
		String b2 = "[5]";
		String b3 = "[6]";
		String c1 = "[7]";
		String c2 = "[8]";
		String c3 = "[9]";
		String pos = "";



		do {// Do while mientras no gane nadie

			System.out.print("\n" + a1);

			System.out.print(a2);

			System.out.println(a3);



			System.out.print(b1);

			System.out.print(b2);

			System.out.println(b3);



			System.out.print(c1);

			System.out.print(c2);

			System.out.println(c3 + "\n");



			if (turno) {// Turno de O

				System.out.print("Turno de [O] Posicion: ");

				pos = sc.next();

				turno = false;

				switch (pos) {// Selección de casilla

				case "1":

					if (a1.equals("[1]")) {// Si no hay casilla se cambia

						a1 = "[O]";

					} else {// Si hay casilla no se cambia y se repite turno

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;

				case "2":

					if (a2.equals("[2]")) {

						a2 = "[O]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;

				case "3":

					if (a3.equals("[3]")) {

						a3 = "[O]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;

				case "4":

					if (b1.equals("[4]")) {

						b1 = "[O]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;

				case "5":

					if (b2.equals("[5]")) {

						b2 = "[O]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;

				case "6":

					if (b3.equals("[6]")) {

						b3 = "[O]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;

				case "7":

					if (c1.equals("[7]")) {

						c1 = "[O]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;

				case "8":

					if (c2.equals("[8]")) {

						c2 = "[O]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;

				case "9":

					if (c3.equals("[9]")) {

						c3 = "[O]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = true;

						break;

					}

					break;



				default:// Si introduce posición inexistente

					System.out.println("=== [!] Posicion inexistente [!] ===");

					turno = true;

					break;

				}

				// Verifica si se ha hecho 3 en raya en todas las variaciones

				if ((a1.equals("[O]")) && (a2.equals("[O]")) && ((a3.equals("[O]")))) {



					winO = true;

					end = true;

				}

				if ((b1.equals("[O]")) && (b2.equals("[O]")) && ((b3.equals("[O]")))) {



					winO = true;

					end = true;

				}

				if ((c1.equals("[O]")) && (c2.equals("[O]")) && ((c3.equals("[O]")))) {



					winO = true;

					end = true;

				}

				if ((a1.equals("[O]")) && (b1.equals("[O]")) && ((c1.equals("[O]")))) {



					winO = true;

					end = true;

				}

				if ((a2.equals("[O]")) && (b2.equals("[O]")) && ((c2.equals("[O]")))) {



					winO = true;

					end = true;

				}

				if ((a3.equals("[O]")) && (b3.equals("[O]")) && ((c3.equals("[O]")))) {



					winO = true;

					end = true;

				}

				if ((a1.equals("[O]")) && (b2.equals("[O]")) && ((c3.equals("[O]")))) {



					winO = true;

					end = true;

				}

				if ((a3.equals("[O]")) && (b2.equals("[O]")) && ((c1.equals("[O]")))) {



					winO = true;

					end = true;

				}



				// Turno de X



			} else {

				System.out.print("Turno de [X] Posicion: ");

				pos = sc.next();

				turno = true;

				switch (pos) {

				case "1":

					if (a1.equals("[1]")) {

						a1 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;

				case "2":

					if (a2.equals("[2]")) {

						a2 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;

				case "3":

					if (a3.equals("[3]")) {

						a3 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;

				case "4":

					if (b1.equals("[4]")) {

						b1 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;

				case "5":

					if (b2.equals("[5]")) {

						b2 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;

				case "6":

					if (b3.equals("[6]")) {

						b3 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;

				case "7":

					if (c1.equals("[7]")) {

						c1 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;

				case "8":

					if (c2.equals("[8]")) {

						c2 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;

				case "9":

					if (c3.equals("[9]")) {

						c3 = "[X]";

					} else {

						System.out.println("=== [!] Posicion ocupada [!] ===");

						turno = false;

						break;

					}

					break;



				default:

					turno = false;

					System.out.println("=== [!] Posicion inexistente [!] ===");

					break;

				}



				if ((a1.equals("[X]")) && (a2.equals("[X]")) && ((a3.equals("[X]")))) {



					winX = true;

					end = true;



				}

				if ((b1.equals("[X]")) && (b2.equals("[X]")) && ((b3.equals("[X]")))) {



					winX = true;

					end = true;

				}

				if ((c1.equals("[X]")) && (c2.equals("[X]")) && ((c3.equals("[X]")))) {



					winX = true;

					end = true;

				}

				if ((a1.equals("[X]")) && (b1.equals("[X]")) && ((c1.equals("[X]")))) {



					winX = true;

					end = true;

				}

				if ((a2.equals("[X]")) && (b2.equals("[X]")) && ((c2.equals("[X]")))) {



					winX = true;

					end = true;

				}

				if ((a3.equals("[X]")) && (b3.equals("[X]")) && ((c3.equals("[X]")))) {



					winX = true;

					end = true;

				}

				if ((a1.equals("[X]")) && (b2.equals("[X]")) && ((c3.equals("[X]")))) {



					winX = true;

					end = true;

				}

				if ((a3.equals("[X]")) && (b2.equals("[X]")) && ((c1.equals("[X]")))) {



					winX = true;

					end = true;

				}

			}



			if (!a1.equals("[1]") && !a2.equals("[2]") && !a3.equals("[3]") && !b1.equals("[4]") && !b2.equals("[5]") && !b3.equals("[6]") && !c1.equals("[7]") && !c2.equals("[8]") && !c3.equals("[9]")){

				end = true;



				if (!(winX || winO)) {



					System.out.print("\n= DRAW!=\n");

				}



			}



		} while (!end);



		System.out.print(a1);

		System.out.print(a2);

		System.out.println(a3);



		System.out.print(b1);

		System.out.print(b2);

		System.out.println(b3);



		System.out.print(c1);

		System.out.print(c2);

		System.out.println(c3 + "\n");



		if (winX) {



			System.out.print("\nX Winner");

		} else if (winO) {



			System.out.print("\nO Winner");

		}



		sc.close();
	}
}