package com.keyin.http.cli;

import com.keyin.http.client.RESTClient;

import java.util.Scanner;
public class HTTPRestCLIApplication {

    private RESTClient restClient;

    // Constructor to initialize the RESTClient
    public HTTPRestCLIApplication() {
        this.restClient = new RESTClient();
    }

    // Method to list events at a specific venue
    public void listEventsAtVenue() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Venue ID: ");
        int venueId = scanner.nextInt();
        scanner.nextLine();

        try {
            String response = restClient.sendGetRequest("/api/events/venue/" + venueId);
            System.out.println("Events at Venue " + venueId + ": " + response);
        } catch (Exception e) {
            System.out.println("An error occurred while fetching events. Please try again later.");
            e.printStackTrace();
        }
    }

    // Method to list all attendees for a specific event
    public void listAttendeesForEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine();

        try {
            String response = restClient.sendGetRequest("/api/attendees/event/" + eventId);
            System.out.println("Attendees for Event " + eventId + ": " + response);
        } catch (Exception e) {
            System.out.println("An error occurred while fetching attendees. Please try again later.");
            e.printStackTrace();
        }
    }

    // Method to list all events for a specific attendee
    public void listEventsForAttendee() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Attendee ID: ");
        int attendeeId = scanner.nextInt();
        scanner.nextLine();

        try {
            String response = restClient.sendGetRequest("/api/events/attendee/" + attendeeId);
            System.out.println("Events for Attendee " + attendeeId + ": " + response);
        } catch (Exception e) {
            System.out.println("An error occurred while fetching events. Please try again later.");
            e.printStackTrace();
        }
    }

    // Method to list all speakers for a specific event
    public void listSpeakersForEvent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Event ID: ");
        int eventId = scanner.nextInt();
        scanner.nextLine();

        try {
            String response = restClient.sendGetRequest("/api/speakers/event/" + eventId);
            System.out.println("Speakers for Event " + eventId + ": " + response);
        } catch (Exception e) {
            System.out.println("An error occurred while fetching speakers. Please try again later.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Event Management System");
            System.out.println("1. List events at a specific venue");
            System.out.println("2. List all attendees for a specific event");
            System.out.println("3. List all events for a specific attendee");
            System.out.println("4. List all speakers for a specific event");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cliApp.listEventsAtVenue();
                    break;
                case 2:
                    cliApp.listAttendeesForEvent();
                    break;
                case 3:
                    cliApp.listEventsForAttendee();
                    break;
                case 4:
                    cliApp.listSpeakersForEvent();
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}