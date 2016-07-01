package desingPatterns.exercises.n2.tickets.v5;

import desingPatterns.exercises.n2.tickets.v5.menu.Menu;
import desingPatterns.exercises.n2.tickets.v5.ticket.Ticket;
import desingPatterns.exercises.n2.tickets.v5.utils.Clock;

public class Supermarket {

	private final static double CLOSING_TIME = 20.0;

	private Menu menu;

	private Supermarket() {
		menu = CountryFactory.instance().getMenu();
	}

	private void sell() {
		Clock clock = new Clock();
		do {
			Ticket ticket = CountryFactory.instance().getTicket();
			menu.execute(ticket);
			ticket.close();
			System.out.println(ticket.toString());
		} while (!clock.isNowOrLater(CLOSING_TIME));
	}

	public static void main(String[] args) {
		new Supermarket().sell();
	}
}
