package org.java.events;

import java.util.Scanner;

public class Main {
	public static void printResult(Event event) {	
		System.out.println(event);
		System.out.println("Posti totali: " + event.getTotalSeats());
		System.out.println("Posti prenotati: " + event.getReservedSeats());
		
		try {
			System.out.println("Posti rimanenti: " + event.getRemainingSeats() + "\n");
		} catch (Exception e) {
			System.err.println("ERROR: " + e);
		}
	}
	public static void main(String[] args)  {
		
		Scanner in = new Scanner(System.in);
		System.out.println("Vuoi inserire un nuovo evento? \n");
		String input = in.nextLine().trim().toLowerCase();
		
//		Const for Testing
//		final String TIME = "21:00";
//		final String PRICE = "70.00";
		
		if(input.equals("si")) {
			
			try {				
				Event newEvent = null;
				
//				User inputs
				System.out.println("Inserisci il nome dell'evento:");
				String title = in.nextLine().trim();
				System.out.println("Inserisci la data dell'evento con formato AAAA-MM-GG");
				String date = in.nextLine().trim();
				System.out.println("Inserisci i posti a sedere:");
				String stringSeats = in.nextLine();
				int seats = Integer.valueOf(stringSeats);
				
//				Concert inputs
				System.out.println("L'evento in question è un concerto? \n");
				String concertInput = in.nextLine().trim().toLowerCase();
				
				if(concertInput.equals("si")) {
					System.out.println("Inserisci l'ora del concerto: ");
					String time = in.nextLine().trim();
					System.out.println("Inserisci il prezzo del biglietto: ");
					String price = in.nextLine().trim();
					Concert newEvent = new Concert(title, date, seats, time, price);
					
				} else {
					Event newEvent = new Event(title, date, seats);
				}
				
				
//				New instances
				System.out.println("Evento creato: \n");
				printResult(newEvent);
				
//				Booking
				System.out.println("Vuoi prenotare dei posti? \n");
				String bookingInput = in.nextLine().trim().toLowerCase();
				if(bookingInput.equals("si")) {
					System.out.println("Quanti posti vuoi prenotare? \n");
					String bookedSeats = in.nextLine();
					int reservedSeats = Integer.valueOf(bookedSeats);
					
					for(int i = 0; i < reservedSeats; i++) {
						newEvent.booking();
					}
				}
				
//				Outputs
				printResult(newEvent);
				
//				Delete
				System.out.println("Vuoi disdire delle prenotazioni? \n");
				String deleteInput = in.nextLine().trim().toLowerCase();
				if(deleteInput.equals("si")) {
					System.out.println("Quanti posti vuoi disdire? \n");
					String StringDeletedSeats = in.nextLine();
					int deletedSeats  = Integer.valueOf(StringDeletedSeats);
					
					for(int i = 0; i < deletedSeats; i++) {
						newEvent.delete();
					}
				}
				
//				Outputs
				printResult(newEvent);
				
			} catch (Exception e) {
				System.err.println("ERROR: " + e);
			} finally {
				if (in != null)
					in.close();
			}

		} else {
			System.out.println("Programma terminato");
		}
	}
}
