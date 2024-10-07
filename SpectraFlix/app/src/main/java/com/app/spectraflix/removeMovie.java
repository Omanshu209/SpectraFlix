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

public class removeMovie extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.remove_movie);
		
		if(getActionBar() != null)
			getActionBar().hide();
		
		DisplayMetrics displayMetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
		int width = displayMetrics.widthPixels;
		int height = displayMetrics.heightPixels;
		
		Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/nasalization.ttf");
		
		TextView removeTextView = findViewById(R.id.remove_movie);
		removeTextView.setTypeface(customFont);
		
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
		
		LinearLayout linearLayout = findViewById(R.id.LinearLayout);
		
		ImageButton removeButton = new ImageButton(this);
		LinearLayout.LayoutParams removeButtonParams = new LinearLayout.LayoutParams(width / 6, height / 6);
		removeButtonParams.gravity = Gravity.CENTER;
		removeButton.setLayoutParams(removeButtonParams);
		removeButton.setImageResource(R.drawable.remove);
		removeButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		removeButton.setBackground(null);
		
		removeButton.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				EditText editTitle = findViewById(R.id.editTitle);
				String title = editTitle.getText().toString();
				
				
				if(title.equals(""))
					Toast.makeText(getApplicationContext(), "PLEASE ENTER THE TITLE!", Toast.LENGTH_SHORT).show();
				
				else
				{
					DataManager dataManager = (DataManager) getApplication();
					dataManager.removeMovie(title);
					Toast.makeText(getApplicationContext(), "SUCCESSFULLY REMOVED!", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		linearLayout.addView(removeButton);
	}
}