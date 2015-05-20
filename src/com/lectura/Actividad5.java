package com.lectura;

import java.io.*;
import java.util.*;
import com.utilidades.diegordonez.*;


public class Actividad5 {

	public static void main(String[] args) {

		File f1 = createFile(1);
		File f2 = createFile(2);

		boolean leave = false;

		do {

			System.out.println("1.Rellena ficheros con secuencia 0 - 10");
			System.out.println("2.Generar fichero a partir de ficheros");
			System.out.println("3. Salir");

			int selection = Utilidades.readInt();
			switch (selection) {
			case 1:
				fillFiles(f1);
				fillFiles(f2);
				break;
			case 2:
				ArrayList<String> a1 = read(f1);
				ArrayList<String> a2 = read(f2);

				fuseFiles(a1, a2);
				break;
			case 3:
				leave = true;
				break;
			default:
				System.out.println("Opción incorrecta!");
				break;
			}
		} while (leave == false);

	}

	public static void fillFiles(File fil) {
		for (int i = 0; i < 10; i++) {
			write(fil, "Linea : " + i + " Fichero: " + fil);
		}
	}
	public static File createFile(int fileNumber) {

		File createdFile = new File("fichero".concat(fileNumber + ".txt"));

		Utilidades.checkFile(createdFile);
		return createdFile;
	}

	public static void write(File fileToWrite, String stringToWrite) {
		
		BufferedWriter bw = null;

		// Path to write
		try {
			FileWriter fw = new FileWriter(fileToWrite, true);
			// Buffer to write on File
			bw = new BufferedWriter(fw);
			bw.write(stringToWrite);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			Utilidades.showInfo("Error de escritura");
		} finally {
			try {
				bw.close();
			} catch (IOException e) {

				Utilidades.showInfo("Imposible cerrar buffer de escritura");
			}
		}

	}

	public static ArrayList<String> read(File fileToRead) {

		ArrayList<String> stringsIn = new ArrayList<>();
		BufferedReader bw = null;

		try {
			FileReader reader = new FileReader(fileToRead);
			bw = new BufferedReader(reader);

			// While there are new lines, it continues reading
			while (bw.ready()) {
				stringsIn.add(bw.readLine());
			}
		} catch (FileNotFoundException e) {
			Utilidades.showInfo("Error de lectura");
		} catch (IOException e) {
			Utilidades.showInfo("Error de lectura");
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				Utilidades.showInfo("Imposible cerrar fichero");
			}
		}

		return stringsIn;
	}
	public static void fuseFiles(ArrayList<String> ar1, ArrayList<String> ar2) {

		File f3 = createFile(3);

		for (int i = 0; i < ar1.size(); i++) {
			String tmp = ar1.get(i).concat(" //////// " + ar2.get(i));
			write(f3, tmp);
		}

	}

}
