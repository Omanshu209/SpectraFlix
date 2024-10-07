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
import java.util.List;

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
		
		DataManager dataManager = (DataManager) getApplication();
		List<BookableMovie> bookableMovies = dataManager.getBookableMovies();
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int height = displayMetrics.heightPixels;
		
		for(BookableMovie movie : bookableMovies)
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
		
		final BookableMovie mov_final = movie;
		imageButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.putExtra("BookableMovie", mov_final);
				intent.setClass(getApplicationContext(), EnterDetails.class);
				startActivity(intent);
			}
		});
		
		parentLayout.addView(imageButton);
	}
}