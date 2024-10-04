package com.app.spectraflix;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.ImageButton;
import android.view.Gravity;
import android.content.Intent;
import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.widget.Button;
import android.widget.Toast;

public class PreviewActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.preview);
		
		if (getActionBar() != null)
            getActionBar().hide();
        
        Intent intent = getIntent();
        Movie mov = (Movie) intent.getSerializableExtra("Movie");
		
		Typeface customFont = Typeface.createFromAsset(getAssets(), "fonts/nasalization.ttf");
		
		TextView movieTextView = findViewById(R.id.watch_movie);
		movieTextView.setTypeface(customFont);
		
		RelativeLayout relativeLayout = findViewById(R.id.RelativeLayout);
		LinearLayout linearLayout = findViewById(R.id.LinearLayout);

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;
		
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
				intent.setClass(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
		
		relativeLayout.addView(imageButton);
		
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
			width / 2,
			height / 2
        );
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_START);
        linearLayout.setLayoutParams(layoutParams);
		
		ImageView movieTitleView = new ImageView(this);
		LinearLayout.LayoutParams movieTitleParams = new LinearLayout.LayoutParams(width / 3, height / 4);
		movieTitleParams.gravity = Gravity.CENTER;
		movieTitleView.setLayoutParams(movieTitleParams);
		movieTitleView.setImageResource(mov.getResTitleImagePath());
		movieTitleView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		
		ImageView bgImage = findViewById(R.id.background_image);
		bgImage.setImageResource(mov.getResImagePath());

        ScrollView scrollView = new ScrollView(this);

        TextView textView = new TextView(this);
        textView.setText(mov.getDescription());
		textView.setTypeface(customFont);
        textView.setTextSize(18);
		textView.setBackgroundResource(R.drawable.rounded_textview);

        scrollView.addView(textView);

		linearLayout.addView(movieTitleView);
        linearLayout.addView(scrollView);
		
		LinearLayout buttonsLayout = findViewById(R.id.WatchMoviesLayout);
		RelativeLayout.LayoutParams buttonsParams = new RelativeLayout.LayoutParams(
			width / 4, 
			height / 2
		);
		buttonsParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        buttonsParams.addRule(RelativeLayout.ALIGN_PARENT_END);
		buttonsLayout.setLayoutParams(buttonsParams);
		
		ImageButton trailerButton = new ImageButton(this);
		RelativeLayout.LayoutParams trailerParams = new RelativeLayout.LayoutParams(
			width / 8, 
			height / 8
		);
		trailerParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        trailerParams.addRule(RelativeLayout.ALIGN_PARENT_END);
		trailerButton.setLayoutParams(trailerParams);
		trailerButton.setImageResource(R.drawable.trailer);
		trailerButton.setScaleType(ImageView.ScaleType.FIT_CENTER);
		trailerButton.setBackground(null);
		
		relativeLayout.addView(trailerButton);
		
		int[] buttonIds = {R.id.icon_button1, R.id.icon_button2};
		final String[] strIds = {"MovieEmbedCode", "MovieURL"};
		final String[] strData = {mov.getMovieEmbedCode(), mov.getMovieURL()};
		final Class<?>[] classes = new Class<?>[] {
			MovieWebView.class, 
			MovieURLView.class
		};
		
		for(int i = 0 ; i < 2 ; i++)
		{
			ImageButton button = findViewById(buttonIds[i]);
			final String movieStr = strData[i];
			final int k = i;
			button.setOnClickListener(new View.OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					if(movieStr.equals("") || movieStr == null)
						Toast.makeText(getApplicationContext(), "MOVIE NOT AVAILABLE!", Toast.LENGTH_SHORT).show();
					
					else
					{
						Intent intent = new Intent();
						intent.putExtra(strIds[k], strData[k]);
						intent.setClass(getApplicationContext(), classes[k]);
						startActivity(intent);
					}
				}
			});
		}
    }
}