package com.app.backend;

public class Movie
{
	private String title, imagePath, titleImagePath, trailerId, wistiaMovieEmbedCode, gDriveMovieEmbedCode, localMoviePath;
	private int popularity;
	
	// Action, Adventure, Animation, Comedy, Crime, Documentary, Drama, Family, Fantasy, History, Horror, Music, Mystery, Romance, Science Fiction, TV movie, Thriller, War, Western
	private int[] genres = new int[19];
	
	public Movie(String title, String imagePath, String titleImagePath, String trailerId, String wistiaMovieEmbedCode, String gDriveMovieEmbedCode, String localMoviePath, int popularity, int[] genres)
	{
		this.title = title;
		this.imagePath = imagePath;
		this.titleImagePath = titleImagePath;
		this.trailerId = trailerId;
		this.wistiaMovieEmbedCode = wistiaMovieEmbedCode;
		this.gDriveMovieEmbedCode = gDriveMovieEmbedCode;
		this.localMoviePath = localMoviePath;
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
	
	public String getTrailerId()
	{
		return this.trailerId;
	}
	
	public String getWistiaMovieEmbedCode()
	{
		return this.wistiaMovieEmbedCode;
	}
	
	public String getGDriveMovieEmbedCode()
	{
		return this.gDriveMovieEmbedCode;
	}
	
	public String getLocalMoviePath()
	{
		return this.localMoviePath;
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
	
	public void setTitleImagePath(String titleImagePath)
	{
		this.titleImagePath = titleImagePath;
	}
	
	public void setTrailerId(String trailerId)
	{
		this.trailerId = trailerId;
	}
	
	public void setWistiaMovieEmbedCode(String wistiaMovieEmbedCode)
	{
		this.wistiaMovieEmbedCode = wistiaMovieEmbedCode;
	}
	
	public void setGDriveMovieEmbedCode(String gDriveMovieEmbedCode)
	{
		this.gDriveMovieEmbedCode = gDriveMovieEmbedCode;
	}
	
	public void setLocalMoviePath(String localMoviePath)
	{
		this.localMoviePath = localMoviePath;
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
