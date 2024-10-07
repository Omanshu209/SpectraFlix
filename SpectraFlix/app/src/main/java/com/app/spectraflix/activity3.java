package com.app.spectraflix;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.graphics.drawable.ColorDrawable;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.util.DisplayMetrics;
import android.graphics.Color;
import android.view.Gravity;
import android.app.ActionBar;
import android.graphics.Typeface;
import android.widget.TextView;

public class activity3 extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        
        ActionBar actionBar = getActionBar();
        
        if(actionBar != null)
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ACD5C2")));
        
        Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/nasalization.ttf");
		TextView movieView = findViewById(R.id.add_remove_movie);
		movieView.setTypeface(customFont);
		TextView bookableMovieView = findViewById(R.id.add_remove_bookable_movie);
		bookableMovieView.setTypeface(customFont);
		
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
		
		LinearLayout linearLayout = findViewById(R.id.add_remove_movie_layout);
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		
		ImageButton addMovieButton = new ImageButton(this);
		LinearLayout.LayoutParams addMovieParams = new LinearLayout.LayoutParams(width / 3, height / 3);
		addMovieParams.gravity = Gravity.CENTER;
		addMovieButton.setLayoutParams(addMovieParams);
		addMovieButton.setImageResource(R.drawable.add);
		addMovieButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		addMovieButton.setBackground(null);
		addMovieButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), addMovie.class);
				startActivity(intent);
			}
		});
		
		ImageButton removeMovieButton = new ImageButton(this);
		LinearLayout.LayoutParams removeMovieParams = new LinearLayout.LayoutParams(width / 3, height / 3);
		removeMovieParams.gravity = Gravity.CENTER;
		removeMovieButton.setLayoutParams(removeMovieParams);
		removeMovieButton.setImageResource(R.drawable.remove);
		removeMovieButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		removeMovieButton.setBackground(null);
		removeMovieButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), removeMovie.class);
				startActivity(intent);
			}
		});
		
		linearLayout.addView(addMovieButton);
		linearLayout.addView(removeMovieButton);
		
		LinearLayout linearLayout2 = findViewById(R.id.add_remove_bookable_movie_layout);
		
		ImageButton addBookableMovieButton = new ImageButton(this);
		LinearLayout.LayoutParams addBookableMovieParams = new LinearLayout.LayoutParams(width / 3, height / 3);
		addBookableMovieParams.gravity = Gravity.CENTER;
		addBookableMovieButton.setLayoutParams(addBookableMovieParams);
		addBookableMovieButton.setImageResource(R.drawable.add);
		addBookableMovieButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		addBookableMovieButton.setBackground(null);
		addBookableMovieButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				//Intent intent = new Intent();
				//intent.setClass(getApplicationContext(), addMovie.class);
				//startActivity(intent);
			}
		});
		
		ImageButton removeBookableMovieButton = new ImageButton(this);
		LinearLayout.LayoutParams removeBookableMovieParams = new LinearLayout.LayoutParams(width / 3, height / 3);
		removeBookableMovieParams.gravity = Gravity.CENTER;
		removeBookableMovieButton.setLayoutParams(removeBookableMovieParams);
		removeBookableMovieButton.setImageResource(R.drawable.remove);
		removeBookableMovieButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		removeBookableMovieButton.setBackground(null);
		removeBookableMovieButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), removeBookableMovie.class);
				startActivity(intent);
			}
		});
		
		linearLayout2.addView(addBookableMovieButton);
		linearLayout2.addView(removeBookableMovieButton);
    }
}