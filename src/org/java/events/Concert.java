package org.java.events;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concert extends Event {

//	Properties
	private LocalTime time;
	private BigDecimal price;
	
//	Constructor
	public Concert(String title, String date, int totalSeats, String time, String price) throws Exception {
		super(title, date, totalSeats);
		setTime(time);
		setPrice(price);
	}

//	Getters
	public LocalTime getTime() {
		return time;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public String getFormattedPrice() {
		DecimalFormat df = new DecimalFormat("#,##0.00");
	    String formattedPriceString = df.format(price);
	    return formattedPriceString;
	}
	
//	Setters
 	public void setTime(String timeString) {
	        LocalTime parsedTime = LocalTime.parse(timeString, DateTimeFormatter.ofPattern("HH:mm"));
	        this.time = parsedTime;
	}
 	public void setPrice(String price) throws Exception {
 	    BigDecimal convertedPrice = new BigDecimal(price);
 	    if (convertedPrice.compareTo(BigDecimal.ZERO) <= 0) {
 	        throw new IllegalArgumentException("Price must be greater than zero.");
 	    }
 	    this.price = convertedPrice;
 	}
	
	@Override
 	public String toString() {
		return "\n-----------------------------------------\n"
				+ "Data: " + getFormattedDate() + " " + getTime() +  " - " + "Evento: " + getTitle() +  " - " + "Prezzo: " + getFormattedPrice() + "\n"
				+ "-----------------------------------------\n";
	}
}
