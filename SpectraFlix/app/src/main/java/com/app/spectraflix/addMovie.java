package com.app.spectraflix;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.graphics.Typeface;
import android.widget.TextView;
import android.view.View;
import android.view.Gravity;
import android.util.DisplayMetrics;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.Intent;
import java.util.List;

public class addMovie extends Activity
{
	private String selectedCategory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_movie);
		
		if(getActionBar() != null)
			getActionBar().hide();
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		
		Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/nasalization.ttf");
		
		TextView addTextView = findViewById(R.id.add_movie);
		addTextView.setTypeface(customFont);
		
		RelativeLayout relativeLayout = findViewById(R.id.RelativeLayout);
		
		ImageButton imageButton = new ImageButton(this);
		LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(width / 8, height / 12);
		buttonParams.gravity = Gravity.CENTER;
		imageButton.setLayoutParams(buttonParams);
		imageButton.setImageResource(R.drawable.back);
		imageButton.setScaleType(ImageView.ScaleType.FIT_START);
		imageButton.setBackground(null);
		imageButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), activity3.class);
				startActivity(intent);
			}
		});
		
		relativeLayout.addView(imageButton);
		
		Spinner categorySpinner = findViewById(R.id.movieCategory);
		
		String[] categories = {"Animated Movie", "Popular Movie", "Horror Movie", "Developer's Choice"};
		
		ArrayAdapter<String> categoriesAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, categories);
		categoriesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		categorySpinner.setAdapter(categoriesAdapter);
		
		categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				selectedCategory = parent.getItemAtPosition(position).toString();
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{}
		});
		
		LinearLayout linearLayout = findViewById(R.id.LinearLayout);
		
		ImageButton addButton = new ImageButton(this);
		LinearLayout.LayoutParams addButtonParams = new LinearLayout.LayoutParams(width / 6, height / 6);
		addButtonParams.gravity = Gravity.CENTER;
		addButton.setLayoutParams(addButtonParams);
		addButton.setImageResource(R.drawable.add);
		addButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		addButton.setBackground(null);
		
		addButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EditText editTitle = findViewById(R.id.editTitle);
				String title = editTitle.getText().toString();
				
				EditText editImagePath = findViewById(R.id.editImagePath);
				String imagePath = editImagePath.getText().toString();
				
				EditText editTitleImagePath = findViewById(R.id.editTitleImagePath);
				String titleImagePath = editTitleImagePath.getText().toString();
				
				EditText editTrailerId = findViewById(R.id.editTrailerId);
				String trailerId = editTrailerId.getText().toString();
				
				EditText editCode = findViewById(R.id.editMovieEmbedCode);
				String code = editCode.getText().toString();
				
				EditText editURL = findViewById(R.id.editMovieURL);
				String url = editURL.getText().toString();
				
				EditText editLocalPath = findViewById(R.id.editMovieLocalPath);
				String localPath = editLocalPath.getText().toString();
				
				EditText editDescription = findViewById(R.id.editMovieDescription);
				String description = editDescription.getText().toString();
				
				int category = -1;
				if(selectedCategory.equals("Animated Movie"))
					category = 1;
				else if(selectedCategory.equals("Popular Movie"))
					category = 2;
				else if(selectedCategory.equals("Horror Movie"))
					category = 3;
				else
					category = 4;
				
				if(title.equals("") || imagePath.equals("") || titleImagePath.equals(""))
					Toast.makeText(getApplicationContext(), "PLEASE ENTER THE DETAILS", Toast.LENGTH_SHORT).show();
				
				else
				{
					Movie newMovie = new Movie(title, imagePath, titleImagePath, -1, -1, trailerId, code, url, localPath, description, category);
					DataManager dataManager = (DataManager) getApplication();
					dataManager.addMovie(newMovie);
					Toast.makeText(getApplicationContext(), "SUCCESSFULLY ADDED!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		linearLayout.addView(addButton);
	}
}