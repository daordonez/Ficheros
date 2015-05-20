package com.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.utilidades.diegordonez.Utilidades;

public class PrincipalEmp {

	public static void main(String[] args) {
		
		//Crear empleados
		Empleado empleado1 = new Empleado();
		Empleado empleado2 = new Empleado();
		
		//Crear dos ficheros uno de entrada y otro de salida
		FileInputStream ficheroEntrada = null;
		FileOutputStream ficheroSalida  = null;
		
		//Crear lector/escritor de objetos
		ObjectOutputStream escritorObjetosSerializados = null;
		ObjectInputStream lectorObjetosSerializados = null;
		
		//Gestionar Objetos enntrada
		try {
			//Crerar fichero donde se va a escribir
			ficheroSalida = new FileOutputStream("Objetos.txt");
			//Al escritor se le pasa el lugar donde tiene que escribir
			escritorObjetosSerializados = new ObjectOutputStream(ficheroSalida);
			//Se le pasa por parametro al escritor el objeto a guardr en el fichero
			escritorObjetosSerializados.writeObject(empleado1);
			escritorObjetosSerializados.writeObject(empleado2);
			
			Utilidades.showInfo("Fichero con objetos serializados creado!");
			
			//Cierra la conexión
			escritorObjetosSerializados.close();
		} catch (Exception e) {
			System.err.println("Error de escritura en el fichero");
		}
		
		//Gestionar Objetos Salida
		ArrayList<Empleado> arrayEmpleados = new ArrayList<>();
		
		Empleado empleadoLeido1 = null;
		try {
			//Cramos fichero de entrada
			ficheroEntrada = new FileInputStream("Objetos.txt");
			//Crear lector de objectos
			lectorObjetosSerializados = new ObjectInputStream(ficheroEntrada);
			//Leer objetos mientras exista alguno
			while (ficheroEntrada.available() > 0) {
				empleadoLeido1 = (Empleado)lectorObjetosSerializados.readObject();
				arrayEmpleados.add(empleadoLeido1);
			}
			System.out.println();
			Utilidades.showInfo("Lectura de Fichero con objetos serializados creado!");
			
			//Cierre de conexión.
			lectorObjetosSerializados.close();
		} catch (Exception e) {
			System.err.println("Error de lectura de objetos desde ficheros");
		}
		
		File ObjectosEnArray = Utilidades.createFile("ObjetosArray.txt");
		
		for (Empleado empleado : arrayEmpleados) {
			Utilidades.write(ObjectosEnArray, empleado.toString());
		}
		
		
	}
}
