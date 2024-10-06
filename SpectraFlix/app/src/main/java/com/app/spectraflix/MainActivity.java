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
import android.graphics.Typeface;
import android.widget.TextView;
import android.util.DisplayMetrics;
import android.Manifest;
import android.content.pm.PackageManager;

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
		
		if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
			requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
		
		Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/nasalization.ttf");
		
		TextView textView1 = findViewById(R.id.category_label_1);
		textView1.setTypeface(customFont);
		
		TextView textView2 = findViewById(R.id.category_label_2);
		textView2.setTypeface(customFont);
		
		TextView textView3 = findViewById(R.id.category_label_3);
		textView3.setTypeface(customFont);
		
		TextView textView4 = findViewById(R.id.category_label_4);
		textView4.setTypeface(customFont);
		
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
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		
		Movie mov1 = new Movie("Moana", "", "", R.drawable.moana, R.drawable.moana_title, "LKFuXETZUsI", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4", "", "Moana, daughter of chief Tui, embarks on a journey to return the heart of goddess Te Fitti from Maui, a demigod, after the plants and the fish on her island start dying due to a blight.");
		Movie mov2 = new Movie("Zootopia", "", "", R.drawable.zootopia, R.drawable.zootopia_title, "jWM0ct-OLsM", "<iframe width = \"100%\" height=\"100%\" src = \"https://drive.google.com/file/d/1LUvPO6INLgLZg2EegeKuTDXKe5uKp2ct/preview\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe>", "", "", "When Judy Hopps, a rookie officer in the Zootopia Police Department, sniffs out a sinister plot, she enlists the help of a con artist to solve the case in order to prove her abilities to Chief Bogo.");
		Movie mov3 = new Movie("Toy Story 3", "", "", R.drawable.toy_story_3, R.drawable.toy_story_3_title, "2BlMNH1QTeE", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4", "", "Before Andy leaves for college, his toys are mistakenly delivered to a day care centre. Woody convinces the other toys that they were not dumped and leads them on an expedition back home.");
		Movie mov4 = new Movie("Frozen II", "", "", R.drawable.frozen_2, R.drawable.frozen_2_title, "Zi4LMpSDccc", "<iframe width = \"100%\" height=\"100%\" src = \"https://drive.google.com/file/d/1FilPpbqmjmbtYBu_1k7QJ-1G1tQZGzLN/preview\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe>", "", "", "Three years after her coronation when Elsa celebrates Autumn, she hears a mysterious voice. She follows that voice along with Anna and their friends as they are forced to uncover the truth.");
		Movie mov5 = new Movie("Oppenheimer", "", "", R.drawable.oppenheimer, R.drawable.oppenheimer_title, "uYPbbksJxIg", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4", "", "During World War II, Lt. Gen. Leslie Groves Jr. appoints physicist J. Robert Oppenheimer to work on the top-secret Manhattan Project. Oppenheimer and a team of scientists spend years developing and designing the atomic bomb. Their work comes to fruition on July 16, 1945, as they witness the world's first nuclear explosion, forever changing the course of history.");
		Movie mov6 = new Movie("Free Guy", "", "", R.drawable.free_guy, R.drawable.free_guy_title, "X2m-08cOAbc", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerJoyrides.mp4", "", "Guy lives a seemingly peaceful life as a bank teller. However, an encounter with a pretty but mysterious woman makes him realise that he is a non-playable character in a massive online video game.");
		Movie mov7 = new Movie("Kill", "", "", R.drawable.kill, R.drawable.kill_title, "da7lKeeS67c", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerMeltdowns.mp4", "", "A train to New Delhi becomes a combat battleground as a pair of commandos faces off against an army of invading bandits.");
		Movie mov8 = new Movie("Srikanth", "", "", R.drawable.srikanth, R.drawable.srikanth_title, "OMeuJP5iBWY", "", "", "", "In a world where the odds are against him, Srikanth defies the norms and makes his way from rural India to becoming the first visually impaired student at MIT.");
		Movie mov9 = new Movie("The Conjuring", "", "", R.drawable.the_conjuring, R.drawable.the_conjuring_title, "k10ETZ41q5o", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4", "", "Rod and Carolyn find their pet dog dead under mysterious circumstances and experience a spirit that harms their daughter Andrea. They finally call investigators who can help them get out of the mess.");
		Movie mov10 = new Movie("The Conjuring 2", "", "", R.drawable.the_conjuring_2, R.drawable.the_conjuring_2_title, "VFsmuRPClr4", "<iframe width = \"100%\" height=\"100%\" src = \"https://drive.google.com/file/d/1B6OqDkR45Z2MmPkCoRvKEkg6b5Ol7DWv/preview\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe>", "", "", "Peggy, a single mother of four children, seeks the help of occult investigators Ed and Lorraine Warren when she and her children witness strange, paranormal events in their house.");
		Movie mov11 = new Movie("Annabelle Creation", "", "", R.drawable.annabelle_creation, R.drawable.annabelle_creation_title, "KisPhy7T__Q", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4", "", "A doll-maker and his wife embed the spirit of their deceased daughter inside a doll. Years later, a nun and several girls from a shuttered orphanage become victims of the possessed doll, Anabelle.");
		Movie mov12 = new Movie("The Nun II", "", "", R.drawable.the_nun_2, R.drawable.the_nun_2_title, "QF-oyCwaArU", "", "", "", "In 1956 France, a priest is murdered, and it seems an evil is spreading. Sister Irene once again comes face to face with a demonic force.");
		Movie mov13 = new Movie("Interstellar", "", "", R.drawable.interstellar, R.drawable.interstellar_title, "zSWdZVtXT7E", "", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4", "", "When Earth becomes uninhabitable in the future, a farmer and ex-NASA pilot, Joseph Cooper, is tasked to pilot a spacecraft, along with a team of researchers, to find a new planet for humans.");
		Movie mov14 = new Movie("The Boy In The Striped Pyjamas", "", "", R.drawable.the_boy_in_the_striped_pyjamas, R.drawable.the_boy_in_the_striped_pyjamas_title, "uwysOfnX2Qg", "<iframe width = \"100%\" height=\"100%\" src = \"https://drive.google.com/file/d/17VcFkKk7mvDxVvqRE5E41KcA5Ziby9Ob/preview\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe>", "", "", "Bruno, the son of a Nazi commander, meets Shmuel, a Jewish boy living in a concentration camp. Later, both the children become friends while being oblivious to the reality of the situation.");
		Movie mov15 = new Movie("RRR", "", "", R.drawable.rrr, R.drawable.rrr_title, "GY4BgdUSpbE", "", "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4", "", "A fearless revolutionary and an officer in the British force, who once shared a deep bond, decide to join forces and chart out an inspirational path of freedom against the despotic rulers.");
		Movie mov16 = new Movie("Ralph Breaks The Internet", "", "", R.drawable.ralph_breaks_the_internet, R.drawable.ralph_breaks_the_internet_title, "_BcYBFC6zfY", "", "", "", "On a quest to save the video game 'Sugar Rush' and to find a replacement, Ralph and his best friend Vanellope travel to the World Wide Web through a Wi-Fi router they find at the arcade.");
		
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
				addStreamingMovie(scrollViews[i], mov, width);
	}
	
	public void addStreamingMovie(int scrollView, Movie mov, int width)
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
		movieTitleView.setImageResource(mov.getResTitleImagePath());
		movieTitleView.setScaleType(ImageView.ScaleType.FIT_CENTER);

		ImageView moviePosterView = new ImageView(this);
		LinearLayout.LayoutParams moviePosterParams = new LinearLayout.LayoutParams(
			(int) Math.round(width * 0.75), 400);
		moviePosterParams.gravity = Gravity.CENTER;
		moviePosterView.setLayoutParams(moviePosterParams);
		moviePosterView.setImageResource(mov.getResImagePath());
		moviePosterView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		moviePosterView.setPadding((int) Math.round(width * 0.05), 0, (int) Math.round(width * 0.05), 0);

		ImageButton imageButton = new ImageButton(this);
		LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(100, 75);
		buttonParams.gravity = Gravity.CENTER;
		imageButton.setLayoutParams(buttonParams);
		imageButton.setImageResource(R.drawable.watching);
		imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageButton.setBackground(null);
		
		final Movie mov_final = mov;
		imageButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.putExtra("Movie", mov_final);
				intent.setClass(getApplicationContext(), PreviewActivity.class);
				startActivity(intent);
			}
		});

		newLayout.addView(movieTitleView);
		newLayout.addView(moviePosterView);
		newLayout.addView(imageButton);

		parentLayout.addView(newLayout);
	}
}
