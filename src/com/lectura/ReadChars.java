package com.lectura;

import com.utilidades.diegordonez.*;

import java.io.*;

public class ReadChars {

	public static void main(String[] args) {

		// Create new file
		File fileChars = Utilidades.createFile("fichero3.txt");

		// vocalsFile(fileChars);

		int[] charactersCounting = counterChars(fileChars);

		vectorCharReader(charactersCounting);

	}

	/**
	 * Full a given file as parameter with 20 vocals of each one
	 * 
	 * @param fileToFull
	 *            File to full of vocals
	 * @return Same file with 20 vocals.
	 */
	public static File vocalsFile(File fileToFull) {

		String as = "a", es = "e", is = "i", os = "o", us = "u";

		for (int i = 0; i < 19; i++) {
			as = as.concat("a");
			es = es.concat("e");
			is = is.concat("i");
			os = os.concat("o");
			us = us.concat("u");
		}

		Utilidades.write(fileToFull, as);
		Utilidades.write(fileToFull, es);
		Utilidades.write(fileToFull, is);
		Utilidades.write(fileToFull, os);
		Utilidades.write(fileToFull, us);

		System.out.println("LLenado!");

		return fileToFull;
	}

	public static int[] counterChars(File fileToRead) {
		/*
		 * Static vector for each vocal, whiteSpaces, Capital leter, lower cases
		 * and words 0 ==> 'a' 1 ==> 'e'; 2 ==> 'i'; 3 ==> 'o'; 4 ==> 'u'; 5 ==>
		 * 'CL'; 6 ==> 'lc'; 7 ==> 'wsp';
		 */
		int[] valuesOfChars = new int[10];

		FileReader reader = null;
		int asciiValue, as = 0, es = 0, is = 0, os = 0, us = 0, cp = 0, lc = 0, wsp = 0;

		try {
			reader = new FileReader(fileToRead);
			while ((asciiValue = reader.read()) != -1) {

				// If it`s a capital lettter
				if (asciiValue >= 65 && asciiValue <= 90) {
					valuesOfChars[5] = ++cp;
					// If it`s a lower case
				} else if (asciiValue >= 97 && asciiValue <= 122) {
					valuesOfChars[6] = ++lc;
				}

				char tmpChar = (char) asciiValue;
				switch (tmpChar) {
				case 'a':
				case 'A':
					valuesOfChars[0] = ++as;
					break;
				case 'e':
				case 'E':
					valuesOfChars[1] = ++es;
					break;
				case 'i':
				case 'I':
					valuesOfChars[2] = ++is;
					break;
				case 'o':
				case 'O':
					valuesOfChars[3] = ++os;
					break;
				case 'u':
				case 'U':
					valuesOfChars[4] = ++us;
					break;
				case ' ':
					valuesOfChars[7] = ++wsp;
					break;
				default:
					break;

				}

			}
		} catch (Exception e) {
			System.err.println("Error de lectura de fichero!");
		} finally {
			// Close anyway the file reader
			try {
				reader.close();
			} catch (Exception e2) {
				System.err.println("Imposible cerrar el lector de caracteres");
			}
		}

		return valuesOfChars;
	}

	public static void vectorCharReader(int[] characterVecotor) {

		/*
		 * Static vector for each vocal, whiteSpaces, Capital leter, lower cases
		 * and words 0 ==> 'a' 1 ==> 'e'; 2 ==> 'i'; 3 ==> 'o'; 4 ==> 'u'; 5 ==>
		 * 'CL'; 6 ==> 'lc'; 7 ==> 'wsp';
		 */

		Utilidades.separator('*');
		System.out.println();
		System.out.println("Vocales --> a: " + characterVecotor[0] + " e: "
				+ characterVecotor[1] + " i: " + characterVecotor[2] + " o:"
				+ characterVecotor[3] + " u:" + characterVecotor[4]);
		System.out.println("Mayusculas --> CL: " + characterVecotor[5]);
		System.out.println("Minusculas --> lc: " + characterVecotor[6]);
		System.out
		.println("Espacios en blanco --> wsp: " + characterVecotor[7]);
	}

}
