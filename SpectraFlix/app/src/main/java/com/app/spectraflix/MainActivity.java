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
import android.net.Uri;
import java.io.File;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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
		
		DataManager dataManager = (DataManager) getApplication();
		List<Movie> movies = dataManager.getMovies();
		streamingMovies categories = new streamingMovies();
		
		for(Movie mov : movies)
		{
			switch(mov.getCategory())
			{
				case 1:
					categories.addAnimatedMovie(mov);
					break;
				
				case 2:
					categories.addPopularMovie(mov);
					break;
				
				case 3:
					categories.addHorrorMovie(mov);
					break;
				
				case 4:
					categories.addDevelopersChoiceMovie(mov);
					break;
			}
		}
		
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
		
		if(mov.getResTitleImagePath() == -1)
		{
			try
			{
				File file = new File(mov.getTitleImagePath());
				Uri imageUri = Uri.fromFile(file);
				Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
				movieTitleView.setImageBitmap(bitmap);
			}
			
			catch(Exception e)
			{}
		}
		
		else
			movieTitleView.setImageResource(mov.getResTitleImagePath());
		
		movieTitleView.setScaleType(ImageView.ScaleType.FIT_CENTER);

		ImageView moviePosterView = new ImageView(this);
		LinearLayout.LayoutParams moviePosterParams = new LinearLayout.LayoutParams(
			(int) Math.round(width * 0.75), 400);
		moviePosterParams.gravity = Gravity.CENTER;
		moviePosterView.setLayoutParams(moviePosterParams);
		
		if(mov.getResImagePath() == -1)
		{
			try
			{
				File file = new File(mov.getImagePath());
				Uri imageUri = Uri.fromFile(file);
				Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
				moviePosterView.setImageBitmap(bitmap);
			}
			
			catch(Exception e)
			{}
		}
		
		else
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
