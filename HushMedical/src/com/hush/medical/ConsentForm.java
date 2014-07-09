package com.hush.medical;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ConsentForm extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consent_form);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consent_form, menu);
		return true;
	}

}
