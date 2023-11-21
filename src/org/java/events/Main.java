package org.java.events;

public class Main {

	public static void main(String[] args) throws Exception {
		
		Event prova = new Event("Concerto", "2023-11-23", 100);
		
		System.out.println(prova);
		System.out.println(prova.getTotalSeats());
		System.out.println(prova.getReservedSeats());
		prova.booking();
		System.out.println(prova);
		System.out.println(prova.getTotalSeats());
		System.out.println(prova.getReservedSeats());

	}
}
