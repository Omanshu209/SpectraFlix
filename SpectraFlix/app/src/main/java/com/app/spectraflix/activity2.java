package com.app.spectraflix;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.view.Gravity;
import android.util.DisplayMetrics;
import android.graphics.Color;
import android.app.ActionBar;

public class activity2 extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        
        ActionBar actionBar = getActionBar();
        
        if(actionBar != null)
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ACD5C2")));
		
		ImageButton button1 = findViewById(R.id.icon_button1);
        button1.setOnClickListener(new View.OnClickListener()
		{
				@Override
				public void onClick(View v)
				{
					Intent intent = new Intent();
					intent.setClass(getApplicationContext(), MainActivity.class);
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
		
		Cinema cinema1 = new Cinema("Theater A", 24);
		cinema1.addRuntime("2024-10-14 11:15", "2024-10-14 14:00");
		cinema1.addRuntime("2024-10-15 11:15", "2024-10-15 14:00");
		
		Cinema cinema2 = new Cinema("Theater B", 36);
		cinema2.addRuntime("2024-10-17 07:00", "2024-10-14 10:00");
		cinema2.addRuntime("2024-10-15 17:35", "2024-10-15 20:20");
		
		BookableMovie movie1 = new BookableMovie("Free Guy", R.drawable.free_guy_title,null);
		movie1.addCinema(cinema1);
		movie1.addCinema(cinema2);
		
		BookableMovie movie2 = new BookableMovie("Moana", R.drawable.moana_title, null);
		movie2.addCinema(cinema2);
		
		BookableMovie movie3 = new BookableMovie("Interstellar", R.drawable.interstellar_title, null);
		movie2.addCinema(cinema1);
		
		BookableMovie movie4 = new BookableMovie("RRR", R.drawable.rrr_title, null);
		movie2.addCinema(cinema2);
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int height = displayMetrics.heightPixels;
		
		BookableMovie[] movies = {movie1, movie2, movie3, movie4};
		for(BookableMovie movie : movies)
			addBookableMovie(movie, height);
    }
    
    public void addBookableMovie(BookableMovie movie, int height)
	{
		LinearLayout parentLayout = findViewById(R.id.ImageLinearLayout);
		
		ImageButton imageButton = new ImageButton(this);
		LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
			LinearLayout.LayoutParams.MATCH_PARENT, 
			height / 3
		);
		buttonParams.gravity = Gravity.CENTER;
		imageButton.setLayoutParams(buttonParams);
		imageButton.setImageResource(movie.getResMovieTitlePath());
		imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		imageButton.setBackground(null);
		
		parentLayout.addView(imageButton);
	}
}