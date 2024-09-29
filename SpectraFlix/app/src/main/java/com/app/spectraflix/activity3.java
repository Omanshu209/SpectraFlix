package com.app.spectraflix;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.graphics.drawable.ColorDrawable;
import android.graphics.Color;
import android.app.ActionBar;

public class activity3 extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity3);
        
        ActionBar actionBar = getActionBar();
        
        if(actionBar != null)
            actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ACD5C2")));
		
		ImageButton button1 = findViewById(R.id.icon_button1);
        button1.setOnClickListener(new View.OnClickListener()
		{
				@Override
				public void onClick(View v)
				{
					Intent intent = new Intent();
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
					overridePendingTransition(0, 0);
				}
		});
		
		ImageButton button2 = findViewById(R.id.icon_button2);
        button2.setOnClickListener(new View.OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				Intent intent = new Intent();
				intent.setClass(getApplicationContext(), activity2.class);
				startActivity(intent);
				overridePendingTransition(0, 0);
			}
		});
    }
}