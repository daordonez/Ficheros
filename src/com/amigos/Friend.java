package com.amigos;

public class Friend {
	
	private String name;
	private int phoneNumber;
	
	public Friend(){
		this.name = null;
		this.phoneNumber = 0;
	}
	
	public Friend(String n, int number){
		this.name = n;
		this.phoneNumber = number;
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
	
	@override
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
	
	

}
