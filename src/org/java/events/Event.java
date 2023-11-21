package org.java.events;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {

//	Properties
	private String title;
	private LocalDate date;
	private int totalSeats;
	private int reservedSeats = 0;

//	Constructor
	public Event(String title, String date, int totalSeats) throws Exception {
		setTitle(title);
		setDate(date);
		setTotalSeats(totalSeats);
	}

//	Getters
	public String getTitle() {
		return title;
	}
	public LocalDate getDate() {
		return date;
	}
	public int getReservedSeats() {
		return reservedSeats;
	}
	public int getTotalSeats() {
		return totalSeats;
	}
	private LocalDate getToday() {
		return LocalDate.now();
	}
	public String getFormattedDate() {	
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return  getDate().format(formatter); 
	}
	public int getRemainingSeats() throws Exception{
		if(reservedSeats > totalSeats) {
			throw new IllegalArgumentException("reservedSeats exceed totalSeats.");
		}
		return totalSeats - reservedSeats;
	}

//	Setters
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDate(String date) throws Exception {
		LocalDate convertedDate = LocalDate.parse(date);
		if(convertedDate.isBefore(getToday())) {
			throw new IllegalArgumentException("Date must be earlier.");
		}
		
		this.date = convertedDate;
	}
	private void setTotalSeats(int totalSeats) throws Exception {
		
		if(totalSeats <= 0) {
			throw new IllegalArgumentException("TotalSeats must be > 0.");
		}
			
		this.totalSeats = totalSeats;
	}

//	Methods
	public void booking() throws Exception {
		if(!isPossibileToBook()) {
			throw new IllegalArgumentException("Date must be earlier & TotalSeats must be > 0.");
		} 
		reservedSeats += 1;
	}
	public void delete() throws Exception{
		if(reservedSeats <= 0) {
			throw new IllegalArgumentException("reservedSeats is empty.");
		}
		reservedSeats -= 1;
	}
	private boolean isFull() {
		return (reservedSeats < totalSeats);
	}
	private boolean areSeatsAvailable() {
		return !(totalSeats <= 0);
	}
	private boolean isPossibileToBook() {
		if(date.isBefore(getToday()) && !isFull() && areSeatsAvailable() ) {
			return false;
		}
		return true;
	}

	@Override
 	public String toString() {
		return "\n-----------------------------------------\n"
				+ "Data: " + getFormattedDate() + " - " + "Evento: " + getTitle() + "\n"
				+ "-----------------------------------------\n";
	}
}
