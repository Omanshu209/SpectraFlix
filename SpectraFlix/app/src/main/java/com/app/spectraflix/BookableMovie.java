package com.app.spectraflix;

import java.io.Serializable;
import java.util.List;
import java.util.LinkedList;

public class BookableMovie implements Serializable
{
	private int resMovieTitlePath;
	private String movieName, movieTitlePath;
	public List<Cinema> cinemas = new LinkedList<Cinema>();
	
	public BookableMovie(String movieName, int resMovieTitlePath, String movieTitlePath)
	{
		this.movieName = movieName;
		this.resMovieTitlePath = resMovieTitlePath;
		this.movieTitlePath = movieTitlePath;
	}
	
	public List<Cinema> getCinemas()
	{
		return this.cinemas;
	}
	
	public void addCinema(Cinema cinema)
	{
		this.cinemas.add(cinema);
	}
	
	public void removeCinema(Cinema cinema)
	{
		this.cinemas.remove(cinema);
	}
	
	public String getMovieName()
	{
		return this.movieName;
	}
	
	public String getMovieTitlePath()
	{
		return this.movieTitlePath;
	}
	
	public int getResMovieTitlePath()
	{
		return this.resMovieTitlePath;
	}
}