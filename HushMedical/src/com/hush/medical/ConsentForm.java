package com.hush.medical;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.format.Time;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class ConsentForm extends Activity {

	private boolean canProceed = false;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consent_form);
		
		// hook up the buttons
		Button back = (Button) findViewById(R.id.consent_back);
		back.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// warp to the patient consent builder
				Intent intent = new Intent(ConsentForm.this, SignerInformation.class);
				startActivity(intent);

			}
		});
		
		Button forward = (Button) findViewById(R.id.consent_continue);
		forward.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (canProceed) {
					Intent intent = new Intent(ConsentForm.this, SignForm.class);
					startActivity(intent);
				} else {
					// TODO: add alert box to inform user here
				}
			}
		});
		
		// checkbox should control whether page can continue or not
		CheckBox cb = (CheckBox) findViewById(R.id.consent_agree_box);
		cb.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (((CheckBox) view).isChecked()) {
					canProceed = true;
				} else {
					canProceed = false;
				}
			}
		});		
		
		// autopopulate the date
		EditText dateVal = (EditText) findViewById(R.id.consent_date_input);
		/*
		Time now = new Time();
		now.setToNow();
		dateVal.setText(now.format("%Y/%m/%d"));
		*/
		DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(getApplicationContext());
		dateVal.setText(dateFormat.format(Calendar.getInstance().getTime()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consent_form, menu);
		return true;
	}
}
