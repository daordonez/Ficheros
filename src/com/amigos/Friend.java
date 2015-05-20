package com.amigos;

import java.io.*;

public class Friend implements Serializable{
	
	/**
	 * serialVersionUID generate by default by the IDE
	 */
	private static final long serialVersionUID = 6827273555724707051L;
	
	private String name;
	private String address;
	private int phoneNumber;
	
	
	public Friend(){
		this.name = null;
		this.address = null;
		this.phoneNumber = 0;
		
	}
	
	public Friend(String n, int number, String addr){
		this.name = n;
		this.phoneNumber = number;
		this.address = addr;
	}

	public String getName() {
		return name;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean equals (Object obj){
		
		boolean isFriend = false;
		
		if (obj instanceof Friend) {
			//Then casting of the new object of this class
			Friend fr = (Friend)obj;
			
			//Only check if it has the same name
			if (fr.name == this.name) {
				isFriend = true;
			}
		}
		return isFriend;
		
	}

	@Override
	public String toString() {
		return "Friend [name=" + name + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	
	
	
	

}
