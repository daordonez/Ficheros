package com.utilidades.diegordonez;



import java.io.*;
import java.util.*;

public class Utilidades {

	private static Scanner tec = new Scanner(System.in);

	public static void showInfo(String messageToShow) {
		separator('*');
		System.out.println();
		System.out.println(messageToShow);
		for (int i = 0; i < 15; i++) {
			System.out.print("*");
		}
	}

	public static int readInt() {

        int numInt = 0;

        boolean isInt = false;

        do {
            try {
                numInt = tec.nextInt();
                isInt = true;
            } catch (java.util.InputMismatchException e) {
                showInfo("Caracter no reconocido. Debe ser Entero (Int)");
                flush();
            }
        } while (isInt == false);

        return numInt;
    }

	public static boolean checkFile(File fil) {
		boolean isCreated = false;

		if (fil.exists()) {
			showInfo("Fichero ya creado!");
			isCreated = true;
		} else {
			// If dosn´t exists, then create it
			try {
				if (fil.createNewFile()) {
					showInfo("Fichero creado exitosamente!");
					System.out.println();
					isCreated = true;
				}
			} catch (IOException e) {
				showInfo("Error de comprobación de fichero");
			}
		}
		return isCreated;

	}

	public static void flush(){
		tec.nextLine();
	}
	public static String readString() {
		
		String str = null;
		boolean isString = false;
		do {
			try {
				str = tec.next();
				isString = true;
			} catch (InputMismatchException e) {
				showInfo("Caracter no valido. Debe ser cadena");
			}
		} while (isString == false);
		return str;
	}

	public static File createFile(String fileName) {
		
		File file = new File(fileName);
		return file;
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
	
	public static void separator (char separatorCharacter){
		for (int i = 0; i < 10; i++) {
			System.out.print(separatorCharacter);
		}
	}
}
