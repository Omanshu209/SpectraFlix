package com.app.spectraflix;

import android.app.Application;
import java.util.LinkedList;
import java.util.List;

public class DataManager extends Application
{
	private List<Movie> movies;
	public List<BookableMovie> bookableMovies;

	@Override
	public void onCreate()
	{
		super.onCreate();
		
		this.movies = new LinkedList<Movie>();
		
		this.movies.add(new Movie("Moana", "", "", R.drawable.moana, R.drawable.moana_title, "LKFuXETZUsI", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "", "Moana, daughter of chief Tui, embarks on a journey to return the heart of goddess Te Fitti from Maui, a demigod, after the plants and the fish on her island start dying due to a blight.", 1));
		this.movies.add(new Movie("Zootopia", "", "", R.drawable.zootopia, R.drawable.zootopia_title, "jWM0ct-OLsM", "<iframe width = \"100%\" height=\"100%\" src = \"https://drive.google.com/file/d/1LUvPO6INLgLZg2EegeKuTDXKe5uKp2ct/preview\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe>", "", "", "When Judy Hopps, a rookie officer in the Zootopia Police Department, sniffs out a sinister plot, she enlists the help of a con artist to solve the case in order to prove her abilities to Chief Bogo.", 1));
		this.movies.add(new Movie("Toy Story 3", "", "", R.drawable.toy_story_3, R.drawable.toy_story_3_title, "2BlMNH1QTeE", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4", "", "Before Andy leaves for college, his toys are mistakenly delivered to a day care centre. Woody convinces the other toys that they were not dumped and leads them on an expedition back home.", 1));
		this.movies.add(new Movie("Frozen II", "", "", R.drawable.frozen_2, R.drawable.frozen_2_title, "Zi4LMpSDccc", "<iframe width = \"100%\" height=\"100%\" src = \"https://drive.google.com/file/d/1FilPpbqmjmbtYBu_1k7QJ-1G1tQZGzLN/preview\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe>", "", "", "Three years after her coronation when Elsa celebrates Autumn, she hears a mysterious voice. She follows that voice along with Anna and their friends as they are forced to uncover the truth.", 1));
		this.movies.add(new Movie("Oppenheimer", "", "", R.drawable.oppenheimer, R.drawable.oppenheimer_title, "uYPbbksJxIg", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4", "", "During World War II, Lt. Gen. Leslie Groves Jr. appoints physicist J. Robert Oppenheimer to work on the top-secret Manhattan Project. Oppenheimer and a team of scientists spend years developing and designing the atomic bomb. Their work comes to fruition on July 16, 1945, as they witness the world's first nuclear explosion, forever changing the course of history.", 2));
		this.movies.add(new Movie("Free Guy", "", "", R.drawable.free_guy, R.drawable.free_guy_title, "X2m-08cOAbc", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4", "", "Guy lives a seemingly peaceful life as a bank teller. However, an encounter with a pretty but mysterious woman makes him realise that he is a non-playable character in a massive online video game.", 2));
		this.movies.add(new Movie("Kill", "", "", R.drawable.kill, R.drawable.kill_title, "da7lKeeS67c", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4", "", "A train to New Delhi becomes a combat battleground as a pair of commandos faces off against an army of invading bandits.", 2));
		this.movies.add(new Movie("Srikanth", "", "", R.drawable.srikanth, R.drawable.srikanth_title, "OMeuJP5iBWY", "", "", "", "In a world where the odds are against him, Srikanth defies the norms and makes his way from rural India to becoming the first visually impaired student at MIT.", 2));
		this.movies.add(new Movie("The Conjuring", "", "", R.drawable.the_conjuring, R.drawable.the_conjuring_title, "k10ETZ41q5o", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4", "", "Rod and Carolyn find their pet dog dead under mysterious circumstances and experience a spirit that harms their daughter Andrea. They finally call investigators who can help them get out of the mess.", 3));
		this.movies.add(new Movie("The Conjuring 2", "", "", R.drawable.the_conjuring_2, R.drawable.the_conjuring_2_title, "VFsmuRPClr4", "<iframe width = \"100%\" height=\"100%\" src = \"https://drive.google.com/file/d/1B6OqDkR45Z2MmPkCoRvKEkg6b5Ol7DWv/preview\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe>", "", "", "Peggy, a single mother of four children, seeks the help of occult investigators Ed and Lorraine Warren when she and her children witness strange, paranormal events in their house.", 3));
		this.movies.add(new Movie("Annabelle Creation", "", "", R.drawable.annabelle_creation, R.drawable.annabelle_creation_title, "KisPhy7T__Q", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4", "", "A doll-maker and his wife embed the spirit of their deceased daughter inside a doll. Years later, a nun and several girls from a shuttered orphanage become victims of the possessed doll, Anabelle.", 3));
		this.movies.add(new Movie("The Nun II", "", "", R.drawable.the_nun_2, R.drawable.the_nun_2_title, "QF-oyCwaArU", "", "", "", "In 1956 France, a priest is murdered, and it seems an evil is spreading. Sister Irene once again comes face to face with a demonic force.", 3));
		this.movies.add(new Movie("Interstellar", "", "", R.drawable.interstellar, R.drawable.interstellar_title, "zSWdZVtXT7E", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4", "", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.", 4));
		this.movies.add(new Movie("The Boy In The Striped Pyjamas", "", "", R.drawable.the_boy_in_the_striped_pyjamas, R.drawable.the_boy_in_the_striped_pyjamas_title, "uwysOfnX2Qg", "<iframe width = \"100%\" height=\"100%\" src = \"https://drive.google.com/file/d/17VcFkKk7mvDxVvqRE5E41KcA5Ziby9Ob/preview\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe>", "", "", "Bruno, the son of a Nazi commander, meets Shmuel, a Jewish boy living in a concentration camp. Later, both the children become friends while being oblivious to the reality of the situation.", 4));
		this.movies.add(new Movie("RRR", "", "", R.drawable.rrr, R.drawable.rrr_title, "GY4BgdUSpbE", "", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4", "", "A fearless revolutionary and an officer in the British force, who once shared a deep bond, decide to join forces and chart out an inspirational path of freedom against the despotic rulers.", 4));
		this.movies.add(new Movie("Ralph Breaks The Internet", "", "", R.drawable.ralph_breaks_the_internet, R.drawable.ralph_breaks_the_internet_title, "_BcYBFC6zfY", "", "", "", "On a quest to save the video game 'Sugar Rush' and to find a replacement, Ralph and his best friend Vanellope travel to the World Wide Web through a Wi-Fi router they find at the arcade.", 4));
		
		this.bookableMovies = new LinkedList<BookableMovie>();
		
		Cinema cinema1 = new Cinema("Theater A", 24);
		cinema1.addRuntime("2024-10-14 11:15", "2024-10-14 14:00");
		cinema1.addRuntime("2024-10-15 11:15", "2024-10-15 14:00");
		
		Cinema cinema2 = new Cinema("Theater B", 36);
		cinema2.addRuntime("2024-10-17 07:00", "2024-10-17 10:00");
		cinema2.addRuntime("2024-10-15 17:35", "2024-10-15 20:20");
		
		BookableMovie movie1 = new BookableMovie("Free Guy", R.drawable.free_guy_title,null);
		movie1.addCinema(cinema1);
		movie1.addCinema(cinema2);
		
		BookableMovie movie2 = new BookableMovie("Moana", R.drawable.moana_title, null);
		movie2.addCinema(cinema2);
		
		BookableMovie movie3 = new BookableMovie("Interstellar", R.drawable.interstellar_title, null);
		movie3.addCinema(cinema1);
		
		BookableMovie movie4 = new BookableMovie("RRR", R.drawable.rrr_title, null);
		movie4.addCinema(cinema2);
		
		this.bookableMovies.add(movie1);
		this.bookableMovies.add(movie2);
		this.bookableMovies.add(movie3);
		this.bookableMovies.add(movie4);
	}

	public List<Movie> getMovies()
	{
		return this.movies;
	}

	public void addMovie(Movie mov)
	{
		this.movies.add(mov);
	}

	public void removeMovie(String title)
	{
		for(int i = 0 ; i < this.movies.size() ; i++)
			if(this.movies.get(i).getTitle().toLowerCase().equals(title.toLowerCase()))
				this.movies.remove(i);
	}
	
	public List<BookableMovie> getBookableMovies()
	{
		return this.bookableMovies;
	}
	
	public void removeBookableMovie(String movieName)
	{
		for(int i = 0 ; i < this.bookableMovies.size() ; i++)
			if(this.bookableMovies.get(i).getMovieName().toLowerCase().equals(movieName.toLowerCase()))
				this.bookableMovies.remove(i);
	}
	
	public void addBookableMovie(BookableMovie mov)
	{
		this.bookableMovies.add(mov);
	}
}