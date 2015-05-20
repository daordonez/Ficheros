package com.randomaccess;

import java.io.*;

import com.utilidades.diegordonez.*;

public class RandomAccessIO {

	public static void main(String[] args) {

		File ficheroRand = Utilidades.createFile("random.rnd");
		
		readRandom(ficheroRand);

	}

	
	public static String readRandom(File fileRandom){
		
		RandomAccessFile randomFile = null;
		
		String tmpString = null;
		
		try {
			randomFile = new RandomAccessFile(fileRandom, "r");
			randomFile.seek(0);
			tmpString = randomFile.readUTF();
			
		} catch (FileNotFoundException e) {
			System.err.println("Fichero de acceso dinámico no encontrado!");
		} catch (IOException e) {
			System.err.println("Imposible situarse en la posición indicada");
		}finally{
			try {
				randomFile.close();
			} catch (Exception e2) {
				System.err.println("Imposible cerrar lectura aleatoria!");
			}
		}
	
		return tmpString;
	}
}
