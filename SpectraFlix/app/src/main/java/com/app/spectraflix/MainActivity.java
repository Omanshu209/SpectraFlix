package com.app.spectraflix;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.app.ActionBar;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.view.Gravity;

import java.util.List;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		ActionBar actionBar = getActionBar();
		
		if(actionBar != null)
			actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ACD5C2")));
		
		ImageButton button2 = findViewById(R.id.icon_button2);
		button2.setOnClickListener(new View.OnClickListener()
		{
				@Override
				public void onClick(View v)
				{
					Intent intent = new Intent();
					intent.setClass(getApplicationContext(), activity2.class);
					startActivity(intent);
					overridePendingTransition(0, 0);
				}
		});
		
		ImageButton button3 = findViewById(R.id.icon_button3);
		button3.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), activity3.class);
				startActivity(intent);
				overridePendingTransition(0, 0);
			}
		});
		
		Movie mov1 = new Movie("Moana", "", "", R.drawable.moana, R.drawable.moana_title, "", "", "", "", 0, "", new int[19]);
		Movie mov2 = new Movie("Zootopia", "", "", R.drawable.zootopia, R.drawable.zootopia_title, "", "", "", "", 0, "", new int[19]);
		Movie mov3 = new Movie("Toy Story 3", "", "", R.drawable.toy_story_3, R.drawable.toy_story_3_title, "", "", "", "", 0, "", new int[19]);
		Movie mov4 = new Movie("Frozen II", "", "", R.drawable.frozen_2, R.drawable.frozen_2_title, "", "", "", "", 0, "", new int[19]);
		Movie mov5 = new Movie("Oppenheimer", "", "", R.drawable.oppenheimer, R.drawable.oppenheimer_title, "", "", "", "", 0, "", new int[19]);
		Movie mov6 = new Movie("Free Guy", "", "", R.drawable.free_guy, R.drawable.free_guy_title, "", "", "", "", 0, "", new int[19]);
		Movie mov7 = new Movie("Kill", "", "", R.drawable.kill, R.drawable.kill_title, "", "", "", "", 0, "", new int[19]);
		Movie mov8 = new Movie("Srikanth", "", "", R.drawable.srikanth, R.drawable.srikanth_title, "", "", "", "", 0, "", new int[19]);
		Movie mov9 = new Movie("The Conjuring", "", "", R.drawable.the_conjuring, R.drawable.the_conjuring_title, "", "", "", "", 0, "", new int[19]);
		Movie mov10 = new Movie("The Conjuring 2", "", "", R.drawable.the_conjuring_2, R.drawable.the_conjuring_2_title, "", "", "", "", 0, "", new int[19]);
		Movie mov11 = new Movie("Annabelle Creation", "", "", R.drawable.annabelle_creation, R.drawable.annabelle_creation_title, "", "", "", "", 0, "", new int[19]);
		Movie mov12 = new Movie("The Nun II", "", "", R.drawable.the_nun_2, R.drawable.the_nun_2_title, "", "", "", "", 0, "", new int[19]);
		Movie mov13 = new Movie("Interstellar", "", "", R.drawable.interstellar, R.drawable.interstellar_title, "", "", "", "", 0, "", new int[19]);
		Movie mov14 = new Movie("The Boy In The Striped Pyjamas", "", "", R.drawable.the_boy_in_the_striped_pyjamas, R.drawable.the_boy_in_the_striped_pyjamas_title, "", "", "", "", 0, "", new int[19]);
		Movie mov15 = new Movie("RRR", "", "", R.drawable.rrr, R.drawable.rrr_title, "", "", "", "", 0, "", new int[19]);
		Movie mov16 = new Movie("Ralph Breaks The Internet", "", "", R.drawable.ralph_breaks_the_internet, R.drawable.ralph_breaks_the_internet_title, "", "", "", "", 0, "", new int[19]);
		
		streamingMovies categories = new streamingMovies();
		
		categories.addAnimatedMovie(mov1);
		categories.addAnimatedMovie(mov2);
		categories.addAnimatedMovie(mov3);
		categories.addAnimatedMovie(mov4);
		
		categories.addPopularMovie(mov5);
		categories.addPopularMovie(mov6);
		categories.addPopularMovie(mov7);
		categories.addPopularMovie(mov8);
		
		categories.addHorrorMovie(mov9);
		categories.addHorrorMovie(mov10);
		categories.addHorrorMovie(mov11);
		categories.addHorrorMovie(mov12);
		
		categories.addDevelopersChoiceMovie(mov13);
		categories.addDevelopersChoiceMovie(mov14);
		categories.addDevelopersChoiceMovie(mov15);
		categories.addDevelopersChoiceMovie(mov16);
		
		List<Movie> animatedMovies = categories.getAnimatedMovies();
		List<Movie> popularMovies = categories.getPopularMovies();
		List<Movie> horrorMovies = categories.getHorrorMovies();
		List<Movie> developersChoiceMovies = categories.getDevelopersChoiceMovies();
		
		List<Movie>[] moviesList = {animatedMovies, popularMovies, horrorMovies, developersChoiceMovies};
		int[] scrollViews = {R.id.animated_movies_scroll_view, R.id.popular_movies_scroll_view, R.id.horror_movies_scroll_view, R.id.developers_choice_scroll_view};
		
		for(int i = 0 ; i < 4 ; i++)
			for(Movie mov : moviesList[i])
				addStreamingMovie(scrollViews[i], mov.getResTitleImagePath(), mov.getResImagePath());
	}
	
	public void addStreamingMovie(int scrollView, int resMovieTitlePath, int resMoviePosterPath)
	{
		LinearLayout parentLayout = findViewById(scrollView);

		LinearLayout newLayout = new LinearLayout(this);
		newLayout.setLayoutParams(new LinearLayout.LayoutParams(
									  LinearLayout.LayoutParams.WRAP_CONTENT,
									  LinearLayout.LayoutParams.MATCH_PARENT));
		newLayout.setOrientation(LinearLayout.VERTICAL);
		newLayout.setGravity(Gravity.CENTER);

		ImageView movieTitleView = new ImageView(this);
		LinearLayout.LayoutParams movieTitleParams = new LinearLayout.LayoutParams(200, 150);
		movieTitleParams.gravity = Gravity.CENTER;
		movieTitleView.setLayoutParams(movieTitleParams);
		movieTitleView.setImageResource(resMovieTitlePath);
		movieTitleView.setScaleType(ImageView.ScaleType.FIT_CENTER);

		ImageView moviePosterView = new ImageView(this);
		LinearLayout.LayoutParams moviePosterParams = new LinearLayout.LayoutParams(
			LinearLayout.LayoutParams.WRAP_CONTENT, 400);
		moviePosterParams.gravity = Gravity.CENTER;
		moviePosterView.setLayoutParams(moviePosterParams);
		moviePosterView.setImageResource(resMoviePosterPath);
		moviePosterView.setScaleType(ImageView.ScaleType.FIT_CENTER);

		ImageButton imageButton = new ImageButton(this);
		LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(100, 75);
		buttonParams.gravity = Gravity.CENTER;
		imageButton.setLayoutParams(buttonParams);
		imageButton.setImageResource(R.drawable.watching);
		imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageButton.setBackground(null);

		newLayout.addView(movieTitleView);
		newLayout.addView(moviePosterView);
		newLayout.addView(imageButton);

		parentLayout.addView(newLayout);
	}
}