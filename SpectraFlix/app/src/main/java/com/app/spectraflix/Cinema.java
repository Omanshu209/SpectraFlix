package com.app.spectraflix;

import java.util.List;
import java.util.LinkedList;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Cinema implements Serializable
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
	
	public List<Runtime> getRuntimes()
	{
		return this.runtimes;
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