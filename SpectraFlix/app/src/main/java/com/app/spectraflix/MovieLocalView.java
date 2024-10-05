package com.app.spectraflix;

import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;
import android.widget.MediaController;
import android.content.Intent;

public class MovieLocalView extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie_url_view);
		
		if (getActionBar() != null)
			getActionBar().hide();
		
		Intent intent = getIntent();
		String moviePath = intent.getStringExtra("MoviePath");

		VideoView videoView = findViewById(R.id.videoView);
		MediaController mediaController = new MediaController(this);
		videoView.setMediaController(mediaController);
		mediaController.setAnchorView(videoView);
		videoView.setVideoPath(moviePath);
		videoView.start();
	}
}