package com.app.spectraflix;

import java.io.Serializable;

public class Movie implements Serializable
{
	private String title, imagePath, titleImagePath, trailerId, gDriveMovieID, movieURL, description;
	private int popularity, resImagePath, resTitleImagePath;
	
	// Action, Adventure, Animation, Comedy, Crime, Documentary, Drama, Family, Fantasy, History, Horror, Music, Mystery, Romance, Science Fiction, TV movie, Thriller, War, Western
	private int[] genres = new int[19];
	
	public Movie(String title, String imagePath, String titleImagePath, int resImagePath, int resTitleImagePath, String trailerId, String gDriveMovieID, String movieURL, int popularity, String description, int[] genres)
	{
		this.title = title;
		this.imagePath = imagePath;
		this.titleImagePath = titleImagePath;
		this.trailerId = trailerId;
		this.resImagePath = resImagePath;
		this.resTitleImagePath = resTitleImagePath;
		this.description = description;
		this.gDriveMovieID = gDriveMovieID;
		this.movieURL = movieURL;
		this.popularity = popularity;
		this.genres = genres;
	}
	
	public String getTitle()
	{
		return this.title;
	}
	
	public String getImagePath()
	{
		return this.imagePath;
	}
	
	public String getTitleImagePath()
	{
		return this.titleImagePath;
	}
	
	public int getResImagePath()
	{
		return this.resImagePath;
	}
	
	public int getResTitleImagePath()
	{
		return this.resTitleImagePath;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public String getTrailerId()
	{
		return this.trailerId;
	}
	
	public String getGDriveMovieID()
	{
		return this.gDriveMovieID;
	}
	
	public String getMovieURL()
	{
		return this.movieURL;
	}
	
	public int getPopularity()
	{
		return this.popularity;
	}
	
	public int[] getGenres()
	{
		return this.genres;
	}
	
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	public void setImagePath(String imagePath)
	{
		this.imagePath = imagePath;
	}
	
	public void setResImagePath(int resImagePath)
	{
		this.resImagePath = resImagePath;
	}
	
	public void setResTitleImagePath(int resTitleImagePath)
	{
		this.resTitleImagePath = resTitleImagePath;
	}
	
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	public void setTitleImagePath(String titleImagePath)
	{
		this.titleImagePath = titleImagePath;
	}
	
	public void setTrailerId(String trailerId)
	{
		this.trailerId = trailerId;
	}
	
	public void setGDriveMovieID(String gDriveMovieID)
	{
		this.gDriveMovieID = gDriveMovieID;
	}
	
	public void setMovieURL(String movieURL)
	{
		this.movieURL = movieURL;
	}
	
	public void setPopularity(int popularity)
	{
		this.popularity = popularity;
	}
	
	public void setGenres(int[] genres)
	{
		this.genres = genres;
	}
}