package models;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import Exception.MovieNotFoundException;
import constants.Types;

public class Main {

	public static void main(String[] args) throws MovieNotFoundException {
		Map<String, Movie> movies = new HashMap<>();
		movies.put("F001", MovieFactory.CreateMovie(Types.REGULAR, "You've Got Mail"));
		movies.put("F002", MovieFactory.CreateMovie(Types.REGULAR, "Matrix"));
		movies.put("F003", MovieFactory.CreateMovie(Types.CHILDREN, "Cars"));
		movies.put("F004", MovieFactory.CreateMovie(Types.NEW, "Fast & Furious X"));
		String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

		new RentalInfo();
		String result = RentalInfo.generateStatement(movies,
				new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1))));

		if (!result.equals(expected)) {
			throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected)
					+ System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
		}

		System.out.println("success");
	}
}
