package com.serialization;

import java.io.Serializable;
import java.util.Scanner;

import com.utilidades.diegordonez.*;

public class Empleado implements Serializable{

	/**
	 * Esto es un numero autogenerado por el IDE
	 */
	private static final long serialVersionUID = -4767354769782631006L;
	
	private int idEmpleado ;
	private String nombreEmpleado;
	private int departamentoEmpleado;
	private double sueldoEmpleado;
	
	private static Scanner porTeclado = new Scanner(System.in);
	
	public Empleado(){
		System.out.println("Intro ID:");
		idEmpleado = Utilidades.readInt();
		System.out.println("Introduzca nombre: ");
		nombreEmpleado = Utilidades.readString();
		Utilidades.flush();
		System.out.println("Deparatamento: ");
		departamentoEmpleado = Utilidades.readInt();
		System.out.println("Sueldo: ");
		sueldoEmpleado = porTeclado.nextDouble();
	}

	public int getIdEmpleado() {
		return idEmpleado;
	}

	public String getNombreEmpleado() {
		return nombreEmpleado;
	}

	public int getDepartamentoEmpleado() {
		return departamentoEmpleado;
	}

	public double getSueldoEmpleado() {
		return sueldoEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public void setDepartamentoEmpleado(int departamentoEmpleado) {
		this.departamentoEmpleado = departamentoEmpleado;
	}

	public void setSueldoEmpleado(double sueldoEmpleado) {
		this.sueldoEmpleado = sueldoEmpleado;
	}

	@Override
	public String toString() {
		return "Empleado [idEmpleado=" + idEmpleado + ", nombreEmpleado="
				+ nombreEmpleado + ", departamentoEmpleado="
				+ departamentoEmpleado + ", sueldoEmpleado=" + sueldoEmpleado
				+ "]";
	}
	
	

}
