package com.firstbit.objectfactory;

import java.util.Scanner;

import com.firstbit.models.Bus;
import com.firstbit.models.Ticket;
import com.firstbit.utils.DateUtils;
import com.firstbit.utils.TicketGenerationUtils;

public class TicketObjectFactory {

	public static Scanner scanner = new Scanner(System.in);

	public static Ticket getTicketObject(Bus bus) {

		System.out.println("================================================================");
		System.out.println("Please Enter the Ticket Details : ");
		System.out.println("Passenger Name : ");
		String passengerName = scanner.next();
		System.out.println("Passenger Age : ");
		Integer passengerAge = scanner.nextInt();
		System.out.println("Passenger Gender : ");
		String passengerGender = scanner.next();
		System.out.println("Number Of Seats to be Booked : ");
		int numberOfSeatsToBeBooked = scanner.nextInt();
		System.out.println("================================================================");
		Ticket ticket = new Ticket(TicketGenerationUtils.generatePNR(), passengerName, passengerAge, passengerGender,
				DateUtils.getDate(), DateUtils.getCurrentDate(), numberOfSeatsToBeBooked, bus.getBusNumber());
		return ticket;
	}
	
	public static Bus updateBusObject(Bus bus) {

		int choice = 0;
		System.out.println("================================================================");
		System.out.println("Enter Details What you want to Change : ");
		System.out.println("1. Bus Type");
		System.out.println("2. Bus Max Seats");
		System.out.println("3. Bus Fare");
		System.out.println("4. Source Station ");
		System.out.println("5. Destination Station");
		System.out.println("6. Source Departure Time");
		System.out.println("7. Destination Arrival Time");
		System.out.println("8. Remaining Seats");
		choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Updated Bus Type : ");
			String busType = scanner.next();
			bus.setBusType(busType);
			break;
		case 2:
			System.out.println("Updated Bus Max Seats : ");
			Integer maxSeats = scanner.nextInt();
			bus.setMaxSeats(maxSeats);
			break;
		case 3:
			System.out.println("Updated Bus Fare : ");
			Double busFare = scanner.nextDouble();
			bus.setBusFare(busFare);
			break;
		case 4:
			System.out.println("Updated Source Station : ");
			String source = scanner.next();
			bus.setSource(source);
			break;
		case 5:
			System.out.println("Updated Destination Station : ");
			String destination = scanner.next();
			bus.setDestination(destination);
			break;
		case 6:
			System.out.println("Updated Source Departure Time : ");
			String sourceTime = scanner.next();
			bus.setSourceTime(sourceTime);
			break;
		case 7:
			System.out.println("Updated Destination Arrival Time : ");
			String destinationTime = scanner.next();
			bus.setDestinationTime(destinationTime);
			break;
		case 8:
			System.out.println("Updated Remaining Seats : ");
			Integer remainingSeats = scanner.nextInt();
			bus.setRemainingSeats(remainingSeats);
			break;

		}
		System.out.println("================================================================");

		return bus;
	}


}
