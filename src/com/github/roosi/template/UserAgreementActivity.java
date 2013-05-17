package com.github.roosi.template;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class UserAgreementActivity extends SherlockActivity {
	
	public static final String BUTTONS = "buttons";
	
	private boolean mButtons = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_agreement);
	
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			mButtons = extras.getBoolean(BUTTONS, false);
		}
		
		// default
		setResult(RESULT_FIRST_USER);
	}
	
	@Override
	public void onBackPressed() {
		if (mButtons) {
			setResult(RESULT_CANCELED);
		}
		super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_user_agreement, menu);
		return mButtons;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.menu_accept) {
			setResult(RESULT_OK);
		}
		else if (item.getItemId() == R.id.menu_cancel) {
			setResult(RESULT_CANCELED);
		} 
		
		finish();
		return true;
	}

}
