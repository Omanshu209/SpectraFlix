package com.app.spectraflix;

import android.os.Bundle;
import android.app.Activity;
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

public class addBookableMovie extends Activity
{
	private BookableMovie mov = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_bookable_movie);
		
		if(getActionBar() != null)
			getActionBar().hide();
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		
		Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/nasalization.ttf");
		TextView addTextView1 = findViewById(R.id.add_bookable_movie);
		addTextView1.setTypeface(customFont);
		TextView addTextView2 = findViewById(R.id.add_cinema);
		addTextView2.setTypeface(customFont);
		TextView addTextView3 = findViewById(R.id.add_runtime);
		addTextView3.setTypeface(customFont);
		
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
		
		LinearLayout linearLayout1 = findViewById(R.id.InnerLinearLayout1);
		
		ImageButton addButton1 = new ImageButton(this);
		LinearLayout.LayoutParams addButtonParams1 = new LinearLayout.LayoutParams(width / 6, height / 6);
		addButtonParams1.gravity = Gravity.CENTER;
		addButton1.setLayoutParams(addButtonParams1);
		addButton1.setImageResource(R.drawable.add);
		addButton1.setScaleType(ImageView.ScaleType.FIT_CENTER);
		addButton1.setBackground(null);
		
		addButton1.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EditText editName = findViewById(R.id.editMovieName);
				String name = editName.getText().toString();
				
				EditText editTitlePath = findViewById(R.id.editMovieTitlePath);
				String path = editTitlePath.getText().toString();
				
				if(name.equals("") || path.equals(""))
					Toast.makeText(getApplicationContext(), "PLEASE ENTER THE DETAILS", Toast.LENGTH_SHORT).show();
				
				else
				{
					mov = new BookableMovie(name, -1, path);
					Toast.makeText(getApplicationContext(), "SUCCESSFULLY CREATED!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		linearLayout1.addView(addButton1);
		
		LinearLayout linearLayout2 = findViewById(R.id.InnerLinearLayout2);
		
		ImageButton addButton2 = new ImageButton(this);
		LinearLayout.LayoutParams addButtonParams2 = new LinearLayout.LayoutParams(width / 6, height / 6);
		addButtonParams2.gravity = Gravity.CENTER;
		addButton2.setLayoutParams(addButtonParams2);
		addButton2.setImageResource(R.drawable.add);
		addButton2.setScaleType(ImageView.ScaleType.FIT_CENTER);
		addButton2.setBackground(null);
		
		addButton2.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EditText editName = findViewById(R.id.editName);
				String name = editName.getText().toString();
				
				EditText editNumSeats = findViewById(R.id.editNumSeats);
				String numSeats = editNumSeats.getText().toString();
				
				if(name.equals("") || numSeats.equals(""))
					Toast.makeText(getApplicationContext(), "PLEASE ENTER THE DETAILS", Toast.LENGTH_SHORT).show();
				
				else if(mov == null)
					Toast.makeText(getApplicationContext(), "PLEASE CREATE A BOOKABLE MOVIE!", Toast.LENGTH_SHORT).show();
				
				else
				{
					Cinema cinema = new Cinema(name, Integer.parseInt(numSeats));
					mov.addCinema(cinema);
					Toast.makeText(getApplicationContext(), "SUCCESSFULLY CREATED!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		linearLayout2.addView(addButton2);
		
		LinearLayout linearLayout3 = findViewById(R.id.InnerLinearLayout3);
		
		ImageButton addButton3 = new ImageButton(this);
		LinearLayout.LayoutParams addButtonParams3 = new LinearLayout.LayoutParams(width / 6, height / 6);
		addButtonParams3.gravity = Gravity.CENTER;
		addButton3.setLayoutParams(addButtonParams3);
		addButton3.setImageResource(R.drawable.add);
		addButton3.setScaleType(ImageView.ScaleType.FIT_CENTER);
		addButton3.setBackground(null);
		
		addButton3.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EditText editStart = findViewById(R.id.editStartDateTime);
				String start = editStart.getText().toString();
				
				EditText editEnd = findViewById(R.id.editEndDateTime);
				String end = editEnd.getText().toString();
				
				if(start.equals("") || end.equals(""))
					Toast.makeText(getApplicationContext(), "PLEASE ENTER THE DETAILS", Toast.LENGTH_SHORT).show();
				
				else if(mov == null)
					Toast.makeText(getApplicationContext(), "PLEASE CREATE A BOOKABLE MOVIE!", Toast.LENGTH_SHORT).show();
				
				else if(mov.getCinemas().size() == 0)
					Toast.makeText(getApplicationContext(), "PLEASE ADD A CINEMA!", Toast.LENGTH_SHORT).show();
				
				else
				{
					mov.cinemas.get(mov.getCinemas().size() - 1).addRuntime(start, end);
					Toast.makeText(getApplicationContext(), "SUCCESSFULLY CREATED!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		linearLayout3.addView(addButton3);
		
		LinearLayout linearLayout = findViewById(R.id.LinearLayout);
		
		ImageButton addButton = new ImageButton(this);
		LinearLayout.LayoutParams addButtonParams = new LinearLayout.LayoutParams(width / 4, height / 4);
		addButtonParams.gravity = Gravity.CENTER;
		addButton.setLayoutParams(addButtonParams);
		addButton.setImageResource(R.drawable.next_screen);
		addButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		addButton.setBackground(null);
		
		addButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				
				if(mov == null)
					Toast.makeText(getApplicationContext(), "PLEASE CREATE A BOOKABLE MOVIE!", Toast.LENGTH_SHORT).show();
				
				else
				{
					DataManager dataManager = (DataManager) getApplication();
					dataManager.addBookableMovie(mov);
					Toast.makeText(getApplicationContext(), "SUCCESSFULLY ADDED!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		linearLayout.addView(addButton);
	}
}