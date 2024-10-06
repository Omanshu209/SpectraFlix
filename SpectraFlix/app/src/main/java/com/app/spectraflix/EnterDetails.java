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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.content.Intent;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EnterDetails extends Activity
{
	private String selectedCinema;
	private String selectedRuntime;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.enter_details);
		
		if(getActionBar() != null)
			getActionBar().hide();
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		
		Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/nasalization.ttf");
		
		TextView detailsTextView = findViewById(R.id.details_label);
		detailsTextView.setTypeface(customFont);
		
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
				intent.setClass(getApplicationContext(), activity2.class);
				startActivity(intent);
			}
		});
		
		relativeLayout.addView(imageButton);
		
		Intent intent = getIntent();
		BookableMovie movie = (BookableMovie) intent.getSerializableExtra("BookableMovie");
		
		Spinner cinemaSpinner = findViewById(R.id.cinemaSpinner);
		
		List<Cinema> cinemas = movie.getCinemas();
		String[] cinemaNames = new String[cinemas.size()];
		
		for(int i = 0 ; i < cinemas.size() ; i++)
			cinemaNames[i] = cinemas.get(i).getName();
		
		ArrayAdapter<String> cinemaAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cinemaNames);
		cinemaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		cinemaSpinner.setAdapter(cinemaAdapter);
		
		final List<Cinema> cinemas_final = cinemas;
		cinemaSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
		{
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
			{
				selectedCinema = parent.getItemAtPosition(position).toString();
				Cinema cinema = null;
				
				for(Cinema cinema_item : cinemas_final)
					if(cinema_item.getName().equals(selectedCinema))
						cinema = cinema_item;
				
				List<Runtime> runtimes = cinema.getRuntimes();
				String[] runtimes_string = new String[runtimes.size()];
				
				for(int i = 0 ; i < runtimes.size() ; i++)
					runtimes_string[i] = runtimes.get(i).getStartDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
					
				Spinner runtimeSpinner = findViewById(R.id.runtimeSpinner);
					
				ArrayAdapter<String> runtimeAdapter = new ArrayAdapter<>(EnterDetails.this, android.R.layout.simple_spinner_item, runtimes_string);
				runtimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
				runtimeSpinner.setAdapter(runtimeAdapter);
				
				runtimeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
				{
					@Override
					public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
					{
						selectedRuntime = parent.getItemAtPosition(position).toString();
					}
					
					@Override
					public void onNothingSelected(AdapterView<?> parent)
					{}
				});
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent)
			{}
		});
		
		LinearLayout linearLayout = findViewById(R.id.LinearLayout);
		
		ImageButton nextButton = new ImageButton(this);
		LinearLayout.LayoutParams nextButtonParams = new LinearLayout.LayoutParams(width / 6, height / 6);
		nextButtonParams.gravity = Gravity.CENTER;
		nextButton.setLayoutParams(nextButtonParams);
		nextButton.setImageResource(R.drawable.next_screen);
		nextButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		nextButton.setBackground(null);
		
		final BookableMovie mov_final = movie;
		nextButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EditText editName = findViewById(R.id.editName);
				String enteredName = editName.getText().toString();
				
				EditText editPhoneNum = findViewById(R.id.editPhoneNum);
				String enteredPhoneNum = editPhoneNum.getText().toString();
				
				EditText editEmail = findViewById(R.id.editEmail);
				String enteredEmail = editEmail.getText().toString();
				
				final String[] data = {enteredName, enteredPhoneNum, enteredEmail, selectedCinema, selectedRuntime};
				
				Intent intent = new Intent();
				intent.putExtra("Data", data);
				intent.putExtra("BookableMovie", mov_final);
				intent.setClass(getApplicationContext(), SelectSeat.class);
				startActivity(intent);
			}
		});
		
		linearLayout.addView(nextButton);
	}
}