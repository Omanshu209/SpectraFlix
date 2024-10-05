package com.app.spectraflix;

import java.util.List;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Cinema
{
	private String name;
	private int[] seatRowCol;
	private List<Runtime> runtimes = new LinkedList<Runtime>();
	
	public Cinema(String name, int numSeats)
	{
		this.name = name;	
		this.seatRowCol = this.getMinRowCol(numSeats);
	}
	
	public String getName()
	{
		return this.name;
	}
	
	private class Runtime
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
		
	public boolean addRuntime(String startDateTime, String endDateTime)
	{
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime start = LocalDateTime.parse(startDateTime, formatter);
		LocalDateTime end = LocalDateTime.parse(endDateTime, formatter);
		
		for(Runtime rt : this.runtimes)
		{
			LocalDateTime startRt = rt.getStartDateTime(), endRt = rt.getEndDateTime();
			if((startRt.isAfter(start) && startRt.isBefore(end)) || (endRt.isAfter(start) && endRt.isBefore(end)) || (start.isAfter(startRt) && start.isBefore(endRt)) || (end.isAfter(startRt) && end.isBefore(endRt)) || (start.isEqual(startRt) && end.isEqual(endRt)))
				return false;
		}
		
		Runtime runtime = new Runtime(startDateTime, endDateTime, this.seatRowCol);
		runtimes.add(runtime);
		return true;
	}
	
	public Runtime getRuntime(int index)
	{
		return this.runtimes.get(index);
	}
	
	public int getRuntimesSize()
	{
		return this.runtimes.size();
	}
		
	public boolean removeRuntime(LocalDateTime start)
	{
		for(int i = 0 ; i < this.runtimes.size() ; i++)
		{
			Runtime runtime = runtimes.get(i);
				
			if(runtime.getStartDateTime().isEqual(start))
			{
				runtimes.remove(i);
				return true;
			}
		}
			
		return false;
	}
		
	public int[] getMinRowCol(int num)
	{
		List<int[]> listOfFactors = new LinkedList<int[]>();
			
		for(int i = 1 ; i <= num ; i++)
		{
			if(num % i != 0)
				continue;
			else if(i == num / i)
				return new int[]{i, i};
				
			int[] factors = {i, num / i};
			listOfFactors.add(factors);
		}
			
		int[] outArr = {num, 1};
		int diff = num - 1;
			
		for(int[] arr : listOfFactors)
		{
			int numDiff = arr[0] - arr[1];
			
			if(numDiff > 0 && numDiff < diff)
			{
				outArr = arr;
				diff = numDiff;
			}
		}
			
		return outArr;
	}
}