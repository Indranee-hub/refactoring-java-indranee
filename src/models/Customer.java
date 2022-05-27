package models;

import java.util.List;

public class Customer {
	
	private String name;
	private List<MovieRental> rentedMovies;
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	public Customer(String name, List<MovieRental> rentedMovies) {
		super();
		this.name = name;
		this.rentedMovies = rentedMovies;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the rentedMovies
	 */
	public List<MovieRental> getRentedMovies() {
		return rentedMovies;
	}
	/**
	 * @param rentedMovies the rentedMovies to set
	 */
	public void setRentedMovies(List<MovieRental> rentedMovies) {
		this.rentedMovies = rentedMovies;
	}


}
