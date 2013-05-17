package com.github.roosi.template;

import java.util.List;
import java.util.Locale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragmentActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;

public class TutorialActivity extends SherlockFragmentActivity {

	public static final String PAGES = "pages";
	
	SectionsPagerAdapter mSectionsPagerAdapter = null;
	ViewPager mViewPager = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);

		Bundle extras = getIntent().getExtras();
		List<String> pages = extras.getStringArrayList(PAGES);
		
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getSupportFragmentManager(), pages);
		
		mViewPager = (ViewPager) findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);
		
		setResult(RESULT_OK);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.activity_tutorial, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
        	case R.id.menu_skip:
        		setResult(RESULT_CANCELED);
        		finish();
        		return true;        		
        	default:
        	    return super.onOptionsItemSelected(item);
	    }
	}

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		private List<String> mPages = null;

		public SectionsPagerAdapter(FragmentManager fm, List<String> pages) {
			super(fm);
			mPages = pages;
		}

		@Override
		public Fragment getItem(int position) {
			Fragment fragment = new PageSectionFragment();
			Bundle args = new Bundle();
			String link = mPages.get(position).split(";")[1];
			args.putString(PageSectionFragment.LINK, link);
			fragment.setArguments(args);
			return fragment;
		}

		@Override
		public int getCount() {
			return mPages.size();
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			String title = mPages.get(position).split(";")[0];
			return title.toUpperCase(l);
		}
	}

	public static class PageSectionFragment extends Fragment {

		public static final String LINK = "link";

		public PageSectionFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			/*
			View rootView = inflater.inflate(R.layout.fragment_tutorial_page,
					container, false);
			TextView dummyTextView = (TextView) rootView
					.findViewById(R.id.section_label);
			dummyTextView.setText(getArguments().getString(
					LINK));
			return rootView;
			*/
			String link = getArguments().getString(LINK);
			WebView webView = new WebView(getActivity());
			webView.getSettings().setJavaScriptEnabled(true);
			webView.loadUrl(link);
			return webView;
		}
	}
}
