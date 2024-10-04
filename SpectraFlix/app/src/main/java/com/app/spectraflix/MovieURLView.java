package com.app.spectraflix;

import android.app.Activity;
import android.os.Bundle;
import android.net.Uri;
import android.widget.VideoView;
import android.content.Intent;
import android.widget.MediaController;

public class MovieURLView extends Activity
{

	private VideoView videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie_url_view);
		
		if (getActionBar() != null)
			getActionBar().hide();
		
		Intent intent = getIntent();
		String movieURL = intent.getStringExtra("MovieURL");

		videoView = findViewById(R.id.videoView);
		
		Uri uri = Uri.parse(movieURL);
		videoView.setVideoURI(uri);
		MediaController mediaController = new MediaController(this);
		mediaController.setAnchorView(videoView);
		videoView.setMediaController(mediaController);
		videoView.start();
	}
}