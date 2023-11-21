package org.java.events;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammEvents {
	
//	Properties
    private String title;
    private List<Event> events;

//  Constructor
    public ProgrammEvents(String title) {
        this.title = title;
        this.events = new ArrayList<>();
    }

//  Methods
    public void addEvent(Event event) {
        events.add(event);
    }
    public String dateEvents(String date) {
    	String result = "";
        List<Event> filteredEvents = events.stream()
                .filter(event -> event.getDate().equals(convertDate(date)))
                .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());
        if(filteredEvents.size() > 0)  {
            result = "Eventi per il giorno " + date + "\n";
            for (Event event : filteredEvents) {
                result += event.toString() + "\n";
            } 
        } else {
        	result = "Nessun evento per il giorno " + date + ".";
        }
        
        return result;
    }
    public int eventsQuantity() {
        return events.size();
    }
    private LocalDate convertDate(String date) {
    	LocalDate convertedDate = LocalDate.parse(date);
    	return convertedDate;
    }
    public void eraseEvents() {
        events.clear();
    }
    public String showEvents() {
    	String result = "";
        List<Event> orderedEvents = events.stream()
                .sorted(Comparator.comparing(Event::getDate))
                .collect(Collectors.toList());

        if(orderedEvents.size() > 0) {
            result = "Questa è la lista " + title + "\n";
            for (Event event : orderedEvents) {
                result += event.toString() + "\n";
            }
        } else {
        	result = "Non ci sono eventi nella lista.";
        }

        return result;
    }
}