package com;

public class Contact {
	String name;
	Long number;
	String email;
	String address;
	public Contact() {
		
	}
	public Contact(String name,Long number, String email,String address) {
		this.name=name;
		this.number=number;
		this.email=email;
		this.address=address;
	}
	public String toString() {
		return "->Name: "+name+" Number: "+number+" Email: "+email+" Address: "+address+" ";
		
	}
	public String toStringForFile() {
		
		return name+","+number+","+email+","+address;
	}

}
