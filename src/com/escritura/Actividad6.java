package com.escritura;

import java.io.*;
import java.util.*;

import com.utilidades.diegordonez.*;

public class Actividad6 {

	//Pedir frases por teclado separadas por intro
	//Ir guardandolas y escribiendolas en un fichero
	//Cuando se introduzca la palabra "fin" finaliza la ejecución
	public static void main(String[] args) {
		boolean leave = false;
		
		ArrayList<String> outputArray = new ArrayList<>();
		
		do {
			System.out.print("Introduzca frase: ");
			String tmpString = Utilidades.readString();
			if (tmpString.equals("fin") || tmpString.equals("FIN")) {
				leave = true;
			}else{
				outputArray.add(tmpString);
			}
		} while (leave == false);
		
		if ( leave == true) {
			System.out.print("Introduzca ruta de salida para fichero: ");
			String outputPATH = Utilidades.readString();
			generateWriteFile(outputArray, outputPATH);
		}
		
	}
	public static void generateWriteFile(ArrayList<String> outputArrayStrings, String outputPATH){
		
		File createdFile = Utilidades.createFile(outputPATH.concat("/GeneratedFile.txt"));
		
		for (String string : outputArrayStrings) {
			Utilidades.write(createdFile, string);
		}
	}
	
}
