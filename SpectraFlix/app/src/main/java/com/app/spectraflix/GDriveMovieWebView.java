package com.app.spectraflix;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.app.Activity;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import android.content.Intent;
import android.util.DisplayMetrics;
import android.widget.ImageButton;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;

public class GDriveMovieWebView extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gdrive_webview);
		
		if (getActionBar() != null)
			getActionBar().hide();
		
		DisplayMetrics dM = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dM);
		int width = dM.widthPixels;
		int height = dM.heightPixels;
		
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
				intent.setClass(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
		
		relativeLayout.addView(imageButton);
		
		Intent intent = getIntent();
		String movieID = intent.getStringExtra("MovieID");

		WebView webView = findViewById(R.id.webView);
		
		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);
		
		webView.setWebViewClient(new WebViewClient());
		
		String embedCode = "<p align = \"center\"><iframe src = \"https://drive.google.com/file/d/" + movieID + "/preview\" width = \"" + (int) Math.round(width * 0.99) + "\" height=\"" + (int) Math.round(height * 0.95) + "\" allow = \"autoplay\" sandbox = \"allow-same-origin allow-scripts\" allowfullscreen = \"true\" scrolling = \"no\"></iframe></p>";
		webView.loadData(embedCode, "text/html", "UTF-8");
	}
}