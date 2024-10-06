package com.app.spectraflix;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.GridLayout;
import android.view.Gravity;
import android.widget.ImageButton;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import java.util.List;
import android.view.View;
import android.util.DisplayMetrics;
import android.graphics.Typeface;
import android.widget.TextView;
import android.content.Context;
import android.widget.ImageView;

public class SelectSeat extends Activity
{
	private ImageButton[][] buttonArray;
	private BookableMovie movie;
	private int cinema_index, runtime_index, selected_row = -1, selected_col = -1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_seat);
		
		if(getActionBar() != null)
			getActionBar().hide();
		
		Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/nasalization.ttf");
		
		TextView seatTextView = findViewById(R.id.seat_label);
		seatTextView.setTypeface(customFont);
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		
		RelativeLayout relativeLayout = findViewById(R.id.RelativeLayout);
		
		ImageButton backButton = new ImageButton(this);
		LinearLayout.LayoutParams backButtonParams = new LinearLayout.LayoutParams(width / 8, height / 12);
		backButtonParams.gravity = Gravity.CENTER;
		backButton.setLayoutParams(backButtonParams);
		backButton.setImageResource(R.drawable.back);
		backButton.setScaleType(ImageView.ScaleType.FIT_START);
		backButton.setBackground(null);
		backButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), activity2.class);
				startActivity(intent);
			}
		});
		
		relativeLayout.addView(backButton);
		
		Intent intent = getIntent();
		String[] data = intent.getStringArrayExtra("Data");
		movie = (BookableMovie) intent.getSerializableExtra("BookableMovie");
		
		List<Cinema> cinemas = movie.getCinemas();
		for(int i = 0 ; i < cinemas.size() ; i++)
			if(cinemas.get(i).getName().equals(data[3]))
				cinema_index = i;
		
		List<Runtime> runtimes = movie.cinemas.get(cinema_index).getRuntimes();
		for(int i = 0 ; i < runtimes.size() ; i++)
			if(runtimes.get(i).getStartDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")).equals(data[4]))
				runtime_index = i;
		
		LinearLayout linearLayout = findViewById(R.id.linearlayout);
		int rows = movie.cinemas.get(cinema_index).runtimes.get(runtime_index).seats.length;
		int cols = movie.cinemas.get(cinema_index).runtimes.get(runtime_index).seats[0].length;
		
		buttonArray = new ImageButton[rows][cols];
		
		GridLayout gridLayout = new GridLayout(this);
		gridLayout.setRowCount(rows);
		gridLayout.setColumnCount(cols);
		
		LinearLayout.LayoutParams gridParams = new LinearLayout.LayoutParams(
				LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT
		);
		
		gridLayout.setLayoutParams(gridParams);
		gridLayout.setPadding(20, 20, 20, 20);
		
		for(int row = 0 ; row < rows ; row++)
		{
			for(int col = 0 ; col < cols ; col++)
			{
				ImageButton imageButton = new ImageButton(this);
				
				if(movie.cinemas.get(cinema_index).runtimes.get(runtime_index).seats[row][col] == 0)
					imageButton.setImageResource(R.drawable.chair_available);
				else
					imageButton.setImageResource(R.drawable.chair_booked);
				
				LinearLayout.LayoutParams buttonParams = new LinearLayout.LayoutParams(
					width / cols / 2,
					height / rows / 2
				);
				
				imageButton.setLayoutParams(buttonParams);
				imageButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
				imageButton.setBackground(null);
				imageButton.setPadding(5, 5, 5, 5);
				buttonArray[row][col] = imageButton;

				final int currentRow = row;
				final int currentCol = col;
				imageButton.setOnClickListener(new View.OnClickListener()
				{
					@Override
					public void onClick(View v)
					{
						if(movie.cinemas.get(cinema_index).runtimes.get(runtime_index).seats[currentRow][currentCol] == 1)
							Toast.makeText(SelectSeat.this, "Seat already booked!", Toast.LENGTH_SHORT).show();
						else
						{
							if(selected_row != -1)
							{
								buttonArray[selected_row][selected_col].setImageResource(R.drawable.chair_available);
								movie.cinemas.get(cinema_index).runtimes.get(runtime_index).seats[selected_row][selected_col] = 0;
							}
							
							buttonArray[currentRow][currentCol].setImageResource(R.drawable.chair_booked);
							selected_row = currentRow;
							selected_col = currentCol;
							movie.cinemas.get(cinema_index).runtimes.get(runtime_index).seats[currentRow][currentCol] = 1;
						}
					}
				});

				gridLayout.addView(imageButton);
			}
		}
		
		linearLayout.addView(gridLayout);
		
		ImageButton bookButton = new ImageButton(this);
		LinearLayout.LayoutParams bookButtonParams = new LinearLayout.LayoutParams(width / 4, height / 6);
		bookButtonParams.gravity = Gravity.CENTER;
		bookButton.setLayoutParams(bookButtonParams);
		bookButton.setImageResource(R.drawable.book_ticket);
		bookButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		bookButton.setBackground(null);
		bookButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
			}
		});
		
		linearLayout.addView(bookButton);
	}
}