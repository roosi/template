package com.github.roosi.template;


import com.actionbarsherlock.app.SherlockActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.actionbarsherlock.view.MenuItem;

public class LicensesActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
		WebView webView = new WebView(this);
		setContentView(webView);
		webView.getSettings().setJavaScriptEnabled(true);
		webView.loadUrl("file:///android_asset/licenses.html");
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	finish();
	            return true;
	    }
	    return super.onOptionsItemSelected(item);
	}
}
