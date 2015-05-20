package com.amigos;

import java.io.File;
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

		// Create new Objecto of Friend Class
		Friend createdFriend = new Friend(nameNewFriend, newPhoneNumber);
		return createdFriend;
	}

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

	private static void generateAddresBookFile(ArrayList<Friend> addrBook) {

		System.out.print("Introduzca PATH de salida: ");
		String outputPATH = Utilidades.readString();
		Utilidades.flush();

		File addBr = Utilidades.createFile(outputPATH.concat("/agenda.txt"));

		for (Friend friend : addrBook) {
			Utilidades.write(addBr, friend.getName());
			Utilidades.write(addBr, Integer.toString(friend.getPhoneNumber()));
			System.out.println();
			Utilidades.separator('*');
		}

	}

	public static void main(String[] args) {

		ArrayList<Friend> addresBookArray = new ArrayList<>();

		boolean leave = false;

		do {

			System.out.println("Agenda de amigos");
			System.out.println("1.Nuevo contacto");
			System.out.println("2.Editar contacto");
			System.out.println("3.Borrar contacto");
			System.out.println("4.Agenda --> .txt");
			System.out.println("5.Salir");
			Utilidades.separator('*');
			System.out.println();
			System.out.print("Opción: ");
			int selection = Utilidades.readInt();

			switch (selection) {
			case 1:

				// adding new contact to the main arrayList
				addresBookArray.add(newFriend());
				break;
			case 2:

				// Sort in the main ArrayList if the given contact exists or no
				// If it exists, then modify with the new information
				actionMenu("Editar", addresBookArray);
				editFriend(Utilidades.readString(), addresBookArray);

				break;
			case 3:
				actionMenu("borrar", addresBookArray);
				deleteFriend(Utilidades.readString(), addresBookArray);
				break;
			case 4:
				Utilidades.showInfo("Generar txt");
				generateAddresBookFile(addresBookArray);
				break;
			case 5:
				Utilidades.showInfo("Fin del programa!");
				leave = true;
				break;
			default:
				Utilidades.showInfo("Opción incorrecta!");
				break;
			}
		} while (leave == false);
	}
}
