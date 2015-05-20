package com.randomaccess;

import java.io.*;

import com.utilidades.diegordonez.*;

public class RandomAccessIO {

	public static void main(String[] args) {

		File ficheroRand = Utilidades.createFile("random.rnd");
		
		readRandom(ficheroRand);

	}

	
	public static void readRandom(File fileRandom){
		
		RandomAccessFile randomFile = null;
		
		try {
			randomFile = new RandomAccessFile(fileRandom, "r");
		} catch (FileNotFoundException e) {
			System.err.println("Fichero de acceso dinámico no encontrado!");
		}finally{
			try {
				randomFile.close();
			} catch (Exception e2) {
				System.err.println("Imposible cerrar lectura aleatoria!");
			}
		}
		
	}
}
