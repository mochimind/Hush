package com.hush.medical;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.Spinner;

public class SignerInformation extends Activity {

	protected View signerFirstName, signerMiddleName, signerLastName;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signer_information);
		
		// identify the containers for the signer first name, middle name, last name
		signerFirstName = findViewById(R.id.signer_signer_first_name);
		signerMiddleName = findViewById(R.id.signer_signer_middle_name);
		signerLastName = findViewById(R.id.signer_signer_last_name);
		
		// add listener to spinner
		Spinner relation = (Spinner) findViewById(R.id.signer_relation_input);
		relation.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int pos, long id) {
				if (pos == 0) { 
					hideSignerBlock(); 
				} else {
					unhideSignerBlock();
				}
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				hideSignerBlock();
			}
			
		});
		
		// add the call handlers to the buttons
		Button backButton = (Button) findViewById(R.id.signer_back);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// warp back to the main page
				Intent intent = new Intent(SignerInformation.this, FormSelector.class);
				startActivity(intent);
			}
			
		});

		Button continueButton = (Button) findViewById(R.id.signer_continue);
		continueButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO: do error checking here
				// warp to the next step
				Intent intent = new Intent(SignerInformation.this, ConsentForm.class);
				startActivity(intent);
			}
			
		});
	}
	
	public void hideSignerBlock() {
		signerFirstName.setVisibility(View.INVISIBLE);
		signerMiddleName.setVisibility(View.INVISIBLE);
		signerLastName.setVisibility(View.INVISIBLE);
	}
	
	public void unhideSignerBlock() {
		signerFirstName.setVisibility(View.VISIBLE);
		signerMiddleName.setVisibility(View.VISIBLE);
		signerLastName.setVisibility(View.VISIBLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.signer_information, menu);
		return true;
	}

}
