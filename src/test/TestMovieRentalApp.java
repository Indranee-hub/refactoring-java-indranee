package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import Exception.MovieNotFoundException;
import constants.Types;
import models.Customer;
import models.Movie;
import models.MovieFactory;
import models.MovieRental;
import models.RentalInfo;

public class TestMovieRentalApp {
	Map<String, Movie> movies = new HashMap<>();

	RentalInfo RentalInfo = new RentalInfo();

	@Test
	public void totalCostValidation_case1() throws MovieNotFoundException {
		movies.put("F001", MovieFactory.CreateMovie(Types.REGULAR, "You've Got Mail"));
		movies.put("F002", MovieFactory.CreateMovie(Types.REGULAR, "Matrix"));
		movies.put("F003", MovieFactory.CreateMovie(Types.CHILDREN, "Cars"));
		movies.put("F004", MovieFactory.CreateMovie(Types.NEW, "Fast & Furious X"));
		Customer customer = new Customer("C. U. Stomer",
				Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1)));
		String result = models.RentalInfo.generateStatement(movies, customer);
		assertTrue(result.contains("Amount owed is 5.5"));
	}

	@Test
	public void totalCostValidation_case2() throws MovieNotFoundException {
		movies.put("F001", MovieFactory.CreateMovie(Types.REGULAR, "You've Got Mail"));
		movies.put("F002", MovieFactory.CreateMovie(Types.REGULAR, "Matrix"));
		Customer customer = new Customer("C. U. Stomer2",
				Arrays.asList(new MovieRental("F001", 10), new MovieRental("F002", 10)));
		String result = models.RentalInfo.generateStatement(movies, customer);
		assertTrue(result.contains("Amount owed is 28"));
	}

	@Test
	public void totalBonusValidation_case2() throws MovieNotFoundException {
		movies.put("F001", MovieFactory.CreateMovie(Types.REGULAR, "You've Got Mail"));
		movies.put("F002", MovieFactory.CreateMovie(Types.REGULAR, "Matrix"));
		movies.put("F003", MovieFactory.CreateMovie(Types.CHILDREN, "Cars"));
		movies.put("F004", MovieFactory.CreateMovie(Types.NEW, "Fast & Furious X"));
		Customer customer = new Customer("C. U. Stomer2",
				Arrays.asList(new MovieRental("F001", 10), new MovieRental("F004", 10), new MovieRental("F002", 10)));
		String result = models.RentalInfo.generateStatement(movies, customer);
		assertTrue(result.contains("You earned 4 frequent points"));

	}

	@Test
	public void invalid_movieId_exception() {
		movies.put("F001", MovieFactory.CreateMovie(Types.REGULAR, "You've Got Mail"));
		movies.put("F002", MovieFactory.CreateMovie(Types.REGULAR, "Matrix"));
		Customer customer = new Customer("C. U. Stomer2",
				Arrays.asList(new MovieRental("F009", 10), new MovieRental("F004", 10), new MovieRental("F002", 10)));
		assertThrows(MovieNotFoundException.class, () -> {
			String result = models.RentalInfo.generateStatement(movies, customer);

		});
	}

}
