package com.amigos;

import java.io.*;
import java.util.*;

import com.utilidades.diegordonez.*;

public class AddressBook {

	// Pide nombre y numeros de tus amigos
	// Guarda los numeros en un fichero

	private static Friend newFriend() {

		// Collect new Friend information

		Utilidades.showInfo("Nuevo Amigo:");
		System.out.print("Nombre:");
		Utilidades.flush();
		String nameNewFriend = Utilidades.readString();
		System.out.print("Teléfono: ");
		int newPhoneNumber = Utilidades.readInt();
		System.out.print("Dirección: ");
		String newAddress = Utilidades.readString();
		Utilidades.flush();

		// Create new Objecto of Friend Class
		Friend createdFriend = new Friend(nameNewFriend, newPhoneNumber,
				newAddress);
		return createdFriend;
	}

	// TODO ASK teacher about this type of search
	private static int sortFriend(ArrayList<Friend> addresBook,
			String friendName) {

		int isFriend = -1;

		for (int i = 0; i < addresBook.size(); i++) {
			if (addresBook.get(i).getName().equals(friendName)) {
				isFriend = i;
			}
		}

		return isFriend;
	}

	private static void showFriend(ArrayList<Friend> addresBook,
			String friendName) {

		int indexOfFriend = sortFriend(addresBook, friendName);

		if (indexOfFriend >= 0) {
			addresBook.get(indexOfFriend).toString();
		} else {
			System.out.println("Contacto: " + friendName + " inexistente!");
		}

	}

	private static void showAllFriends(ArrayList<Friend> addresBook) {
		if (addresBook.isEmpty()) {
			System.out.println("Agenda vacia!");
		} else {
			for (Friend friend : addresBook) {
				System.out.println(friend.toString());
			}
		}
	}

	private static void editFriend(String friendName,
			ArrayList<Friend> addresBook) {

		int friendIndex = sortFriend(addresBook, friendName);

		if (friendIndex >= 0) {
			Utilidades.showInfo("Editar");
			System.out.println("Nombre: " + friendName);
			System.out.print("Introduzca nuevo nombre: ");
			addresBook.get(friendIndex).setName(Utilidades.readString());
			System.out.print("Introduzca nuevo telefono: ");
			addresBook.get(friendIndex).setPhoneNumber(Utilidades.readInt());
			System.out.println("Modificado!");
		} else {
			Utilidades.showInfo("Contacto no existente!");
		}
	}

	private static void deleteFriend(String friendToDelete,
			ArrayList<Friend> addresBook) {

		int deleteFriend = sortFriend(addresBook, friendToDelete);

		if (deleteFriend >= 0) {
			Utilidades.showInfo("Borrar contacto !!!");
			System.out.println("¿Está segundo que quiere borrar a "
					+ friendToDelete + "? [S/N]");
			String option = Utilidades.readString();

			switch (option) {
			case "s":
			case "S":
				addresBook.remove(deleteFriend);
				System.out.println("Borrado!");
				break;
			case "n":
			case "N":
				System.out.println();
				break;
			default:
				Utilidades.showInfo("Valor no permitido!");
				break;
			}
		} else {
			Utilidades.showInfo("Contacto no existente!");
		}

	}

	private static void actionMenu(String ac, ArrayList<Friend> addBook) {

		if (addBook.isEmpty()) {
			Utilidades.showInfo("No existen contactos en la agenda!");
		} else {
			Utilidades.showInfo("Editar contacto");
			System.out.print("Introduzca nombre de contacto a " + ac + " : ");
		}
	}

	private static void exportAddresBookFile(ArrayList<Friend> addrBook) {

		ObjectOutputStream outputWriter = null;
		FileOutputStream outputFile = null;

		// Ask for name of output File
		System.out.print("Introduzca el nombre de salida para la agendia: ");
		String fileName = Utilidades.readString();

		try {
			outputFile = new FileOutputStream(fileName);
			outputWriter = new ObjectOutputStream(outputFile);
			for (Friend friend : addrBook) {
				// For each object in array write a new entry in Object File
				outputWriter.writeObject(friend);
			}
		} catch (Exception e) {
			System.err.println("Error de escritura en el fichero!");
		} finally {
			try {
				outputFile.close();
			} catch (Exception e2) {
				System.err.println("Imposible cerrar escritor de objetos");
			}
		}

	}

	private static ArrayList<Friend> importAddresBookFile(
			FileInputStream addresBookFile) {

		ArrayList<Friend> readArrayFromFile = new ArrayList<>();

		// Create new reader
		ObjectInputStream reader = null;
		try {

			reader = new ObjectInputStream(addresBookFile);

			// While it exists some Object in File continues reading
			// Create a temporal object to cast

			Friend tmpFriend;

			while (addresBookFile.available() > 0) {
				tmpFriend = (Friend) reader.readObject();
				readArrayFromFile.add(tmpFriend);
			}
		} catch (Exception e) {
			System.err.println("Imposible leer el fichero introducido");
		} finally {
			try {
				reader.close();
			} catch (Exception e2) {
				System.err.println("Imposible cerrar el lector de objetos");
			}
		}

		return readArrayFromFile;
	}

	public static void main(String[] args) {

		ArrayList<Friend> addressBookArrayOUT = new ArrayList<>();
		ArrayList<Friend> addressBookArrayIN = new ArrayList<>();

		boolean leave = false;

		do {

			Utilidades.separator('*');
			System.out.println("Agenda de amigos");
			System.out.println("1.Nuevo contacto");
			System.out.println("2.Mostrar contacto");
			System.out.println("3.Cantidad de contactos");
			System.out.println("4.Mostrar todos los contactos");
			System.out.println("5.Editar contacto");
			System.out.println("6.Borrar contacto");
			System.out.println("7.Exportar agenda");
			System.out.println("8.Importar agenda");
			System.out.println("0.Salir");
			Utilidades.separator('*');
			System.out.println();
			System.out.print("Opción: ");
			int selection = Utilidades.readInt();

			switch (selection) {
			case 0:
				Utilidades.showInfo("Fin del programa!");
				leave = true;
				break;
			case 1:

				// adding new contact to the main arrayList
				addressBookArrayOUT.add(newFriend());
				break;
			case 2:

				// Showing a contact if it exists
				actionMenu("mostrar", addressBookArrayOUT);
				System.out.print("Introduzca nombre de amigo a mostrar: ");
				showFriend(addressBookArrayOUT, Utilidades.readString());

				break;
			case 3:

				// Quantity of contacts in Addres Book
				if (addressBookArrayOUT.isEmpty()) {
					System.out.println("No existen contactos todavia!");
				} else {
					System.out
					.println("La cantidad de contactos en la agenda es: "
							+ addressBookArrayOUT.size());
				}
				break;
			case 4:

				System.out.println("Mostrar agendas: ");
				System.out.println("1. Agenda existente");
				System.out.println("2. Agenda importada");
				System.out.print("Introduce opción: ");
				switch (Utilidades.readInt()) {
				case 1:

					showAllFriends(addressBookArrayOUT);
					break;
				case 2:
					showAllFriends(addressBookArrayIN);
					break;

				default:
					System.err.println("Opción incorrecta!");
					break;
				}

				break;
			case 5:
				// Sort in the main ArrayList if the given contact exists or no
				// If it exists, then modify with the new information
				actionMenu("Editar", addressBookArrayOUT);
				editFriend(Utilidades.readString(), addressBookArrayOUT);
				break;
			case 6:
				actionMenu("borrar", addressBookArrayOUT);
				deleteFriend(Utilidades.readString(), addressBookArrayOUT);
				break;
			case 7:
				Utilidades.showInfo("Exportar");
				System.out.println();
				exportAddresBookFile(addressBookArrayOUT);
				System.out.println("Exportado!");
				break;
			case 8:

				Utilidades.showInfo("Importar");
				System.out.println();
				System.out.print("Introduzca ruta origen del fichero: ");
				String inputPATH = Utilidades.readString();
				// Utilidades.flush();

				FileInputStream inputFile;

				try {
					inputFile = new FileInputStream(inputPATH);
					addressBookArrayIN = importAddresBookFile(inputFile);
					Utilidades.showInfo("Importado!");
					System.out.println();
				} catch (FileNotFoundException e) {
					System.err
					.println("El fichero que se intenta importar no existe!");
				}

				break;

			default:
				Utilidades.showInfo("Opción incorrecta!");
				break;
			}
		} while (leave == false);
	}
}
