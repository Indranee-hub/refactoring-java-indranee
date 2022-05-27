package models;

import java.util.HashMap;
import java.util.Map;

import Exception.MovieNotFoundException;
import constants.Types;

public class RentalInfo {

	public static String generateStatement(Map<String, Movie> movies, Customer customer) throws MovieNotFoundException {

		double totalCost = 0;
		int totalBonusPoint = 0;
		StringBuilder statement = new StringBuilder();
		statement.append("Rental Record for " + customer.getName() + "\n");

		for (MovieRental rentedMovie : customer.getRentedMovies()) {
			double cost = 0;
			int bonusPoint = 0;

			Movie availableMovie;
			try {
				availableMovie = movies.get(rentedMovie.getMovieId());
				cost += availableMovie.getCost(rentedMovie.getDays());
				bonusPoint += availableMovie.getBonus(rentedMovie.getDays());
				statement.append("\t" + movies.get(rentedMovie.getMovieId()).getTitle() + "\t" + cost + "\n");
				totalCost += cost;
				totalBonusPoint += bonusPoint;
			} catch (Exception e) {
				throw new MovieNotFoundException("Invalid Movie Selected");

			}

		}
		statement.append("Amount owed is " + totalCost + "\n" + "You earned " + totalBonusPoint + " frequent points\n");

		return statement.toString();

	}

}
