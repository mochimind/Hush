package com.hush.medical;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class FormSelector extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form_selector);

		Button addPeeps = (Button) findViewById(R.id.form_selector_patient_consent);
		addPeeps.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				// warp to the patient consent builder
				Intent intent = new Intent(FormSelector.this, SignerInformation.class);
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.form_selector, menu);
		return true;
	}

}
