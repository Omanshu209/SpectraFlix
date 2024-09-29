package com.app.backend;

import java.util.List;
import java.util.LinkedList;

public class streamingMovies
{
	private List<Movie> animatedMovies = new LinkedList<Movie>();
	private List<Movie> horrorMovies = new LinkedList<Movie>();
	private List<Movie> popularMovies = new LinkedList<Movie>();
	private List<Movie> developersChoiceMovies = new LinkedList<Movie>();
	private List<Movie> documentaries = new LinkedList<Movie>();
	
	public List<Movie> getHorrorMovies()
	{
		return this.horrorMovies;
	}
	
	public List<Movie> getAnimatedMovies()
	{
		return this.animatedMovies;
	}
	
	public List<Movie> getPopularMovies()
	{
		return this.popularMovies;
	}
	
	public List<Movie> getDevelopersChoiceMovies()
	{
		return this.developersChoiceMovies;
	}
	
	public List<Movie> getDocumentaries()
	{
		return this.documentaries;
	}
	
	public void addHorrorMovie(Movie movie)
	{
		this.horrorMovies.add(movie);
	}
	
	public void addAnimatedMovie(Movie movie)
	{
		this.animatedMovies.add(movie);
	}
	
	public void addPopularMovie(Movie movie)
	{
		this.popularMovies.add(movie);
	}
	
	public void addDevelopersChoiceMovie(Movie movie)
	{
		this.developersChoiceMovies.add(movie);
	}
	
	public void addDocumentary(Movie movie)
	{
		this.documentaries.add(movie);
	}
}
