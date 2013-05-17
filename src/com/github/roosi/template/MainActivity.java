package com.github.roosi.template;


import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockFragmentActivity {
	
	private static final String TAG = "MainActivity";
	private static final int REQUEST_SHOW_TUTORIAL = 0;
	private static final int REQUEST_SHOW_AGREEMENT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /*
        Intent intent = new Intent(this, UserAgreementActivity.class);
        intent.putExtra(UserAgreementActivity.BUTTONS, true);
        startActivityForResult(intent, REQUEST_SHOW_AGREEMENT);
        */
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    	
    	if (requestCode == REQUEST_SHOW_TUTORIAL) {
    		// TODO
    	}
    	else if (requestCode == REQUEST_SHOW_AGREEMENT) {
    		if (resultCode == RESULT_OK) {
    			// TODO
    		}
    		else if (resultCode == RESULT_CANCELED) {
    			// TODO
    		}
    	}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportMenuInflater().inflate(R.menu.activity_main, menu);
        
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	if (item.getItemId() == R.id.menu_settings) {
			startActivity(new Intent(this, SettingsActivity.class));
			return true;
		} else if (item.getItemId() == R.id.menu_help) {
			startActivity(new Intent(this, HelpActivity.class));
			return true;
		} else if (item.getItemId() == R.id.menu_help) {
			startActivity(new Intent(this, HelpActivity.class));
			return true;
		} else if (item.getItemId() == R.id.menu_tutorial) {
	        Intent intent = new Intent(this, TutorialActivity.class);
	        ArrayList<String> pages = new ArrayList<String>();
	        pages.add("Page 1;file:///android_asset/tutorial_page.html");
	        pages.add("Page 2;file:///android_asset/tutorial_page.html");
	        pages.add("Page 3;file:///android_asset/tutorial_page.html");
	        intent.putStringArrayListExtra(TutorialActivity.PAGES, pages);        
	        startActivityForResult(intent, REQUEST_SHOW_TUTORIAL);
	        return true;
		} else {
			return super.onOptionsItemSelected(item);
		}    	
    }
}
