package com.app.spectraflix;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;

public class Ticket extends Activity
{
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticket);
		
		if (getActionBar() != null)
			getActionBar().hide();
		
		Intent intent = getIntent();
		String[] data = intent.getStringArrayExtra("Data");
		
		String text = "Name : " + data[0] + "\nPhone No. : " + data[1] + "\nEmail Address : " + data[2] + "\nCinema : " + data[3] + "\nRuntime : " + data[4] + "\nSeat : " + data[5] + "\n\nPLEASE TAKE A SCREENSHOT OF THIS PAGE";
		TextView textView = findViewById(R.id.ticket_details);
		textView.setText(text);
	}
}