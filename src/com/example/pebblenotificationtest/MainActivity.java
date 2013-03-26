package com.example.pebblenotificationtest;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	Button sendButton;
	public final static String PEBBLE_ALERT = "PEBBLE_ALERT";
	private static final String TAG = "PEBBLEALERT";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sendButton = (Button) this.findViewById(R.id.button1);
		sendButton.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		    Intent i = new Intent("com.getpebble.action.SEND_NOTIFICATION");
		 
		    Map<String, Object> data = new HashMap<String, Object>();
		    data.put("title", "Title of Alert");
		    data.put("body", "Body of Alert");
		    
		    JSONObject jsonData = new JSONObject(data);
		    String notificationData = new JSONArray().put(jsonData).toString();
		 
		    i.putExtra("messageType", "PEBBLE_ALERT");
		    i.putExtra("sender", "MyAndroidApp");
		    i.putExtra("notificationData", notificationData);
		 
		    Log.d(TAG, "About to send an alert to Pebble: " + notificationData);
		    sendBroadcast(i);
	}
	
}
