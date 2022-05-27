package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import constants.Types;
import models.Movie;
import models.MovieFactory;


public class TestAllMovies {

	Movie newMovie = MovieFactory.CreateMovie(Types.NEW, "Movie1");
	Movie regMovie = MovieFactory.CreateMovie(Types.REGULAR, "Movie2");
	Movie childMovie = MovieFactory.CreateMovie(Types.CHILDREN, "Movie3");

	@Test
	public void getCostForNewMovie() {
		assertEquals(18, newMovie.getCost(6), 0.0);
	}

	@Test
	public void getCostForChildMovie() {
		assertEquals(1.5, childMovie.getCost(3), 0.0);
	}

	@Test
	public void getBonusForNewMovie() {
		assertEquals(2, newMovie.getBonus(4), 0);
	}

}
