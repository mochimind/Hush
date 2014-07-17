package com.hush.medical;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.text.format.Time;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class SignForm extends Activity {
	private Signature mSignature;
	private Button back, redo, done;
	protected LinearLayout container;

	private String uniqueId;
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_sign_form);
		
		// create the signature capture canvas
		container = (LinearLayout) findViewById(R.id.sign_canvas_container);
		mSignature = new Signature(this, null);
		mSignature.setBackgroundColor(Color.WHITE);
		container.addView(mSignature);
		
		// create a unique id to store this signature
		Time now = new Time();
		now.setToNow();
		uniqueId = now.format("%Y.%m.%d.%H.%M.%S.") + "_" + Math.random();
		
		// load the buttons
		back = (Button) findViewById(R.id.sign_back);
		back.setOnClickListener(new OnClickListener() {	   
			public void onClick(View v) {
				Log.v("log_tag", "Panel Canceled");
				Intent intent = new Intent(SignForm.this, ConsentForm.class);
				startActivity(intent);
			}
		});
		redo = (Button) findViewById(R.id.sign_redo);
		redo.setEnabled(false);
		redo.setOnClickListener(new OnClickListener() {	   
			public void onClick(View v)	{
				Log.v("log_tag", "Panel Cleared");
				mSignature.clear();
				redo.setEnabled(false);
				done.setEnabled(false);
			}
		});
		done = (Button) findViewById(R.id.sign_continue);
		done.setEnabled(false); 
		done.setOnClickListener(new OnClickListener() {	   
			public void onClick(View v) {
				Log.v("log_tag", "Panel Saved");
				container.setDrawingCacheEnabled(true);
				mSignature.save(container);
				// TODO: implement the confirmation page
			}
		});
	}
}
