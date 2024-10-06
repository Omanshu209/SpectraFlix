package com.app.spectraflix;

import java.util.List;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Runtime implements Serializable
{
	private LocalDateTime startDateTime, endDateTime;
	private int[][] seats;
			
	public Runtime(String startDateTime, String endDateTime, int[] rowCol)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		this.startDateTime = LocalDateTime.parse(startDateTime, formatter);
		this.endDateTime = LocalDateTime.parse(endDateTime, formatter);
				
		this.seats = new int[rowCol[0]][rowCol[1]];
		for(int i = 0 ; i < rowCol[0] ; i++)
			for(int j = 0 ; j < rowCol[1] ; j++)
				this.seats[i][j] = 0;
	}
			
	public int[][] getSeats()
	{
		return this.seats;
	}
			
	public LocalDateTime getStartDateTime()
	{
		return this.startDateTime;
	}
			
	public LocalDateTime getEndDateTime()
	{
		return this.endDateTime;
	}
			
	public boolean bookSeat(int i, int j)
	{
		if(this.seats[i][j] == 1)
			return false;
		this.seats[i][j] = 1;
		return true;
	}
		
	public boolean cancelSeat(int i, int j)
	{
		if(this.seats[i][j] == 0)
			return false;
		this.seats[i][j] = 0;
		return true;
	}
}