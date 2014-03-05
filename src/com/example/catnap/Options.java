package com.example.catnap;

import java.util.Calendar;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Options extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_options);
		
		Calendar cal = Calendar.getInstance();
		
		int hourAhead = cal.get(Calendar.HOUR) + 1;
		System.out.println(String.valueOf(hourAhead));
		long currentTime = cal.getTimeInMillis();
		long fourtyFiveFuture = cal.getTimeInMillis() + 2700000;
		
		Calendar future = Calendar.getInstance();
		future.setTimeInMillis(fourtyFiveFuture);
		final int futureHour = future.get(Calendar.HOUR);
		final int futureMinute = future.get(Calendar.MINUTE);
		
		Button btn = (Button)findViewById(R.id.hour);

				System.out.println("Future hour: " + String.valueOf(futureHour) + "\nFuture minute: " + String.valueOf(futureMinute));
				
				Intent intent = new Intent(this, AlarmReceiver.class);
				PendingIntent pt = PendingIntent.getBroadcast(Options.this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
				AlarmManager am = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
				
				am.set(AlarmManager.RTC_WAKEUP, 1000, pt);


		
	}

		
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.options, menu);
		return true;
	}



}
