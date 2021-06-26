package com.covid.project;

import androidx.appcompat.app.AppCompatActivity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class InfoIndoActivity extends AppCompatActivity {
	
	
	private LinearLayout linear1;
	private LinearLayout linear10;
	private LinearLayout nav;
	private LinearLayout linear7;
	private LinearLayout bg_back;
	private LinearLayout linear9;
	private LinearLayout bg_forw;
	private TextView textview1;
	private TextView textview3;
	private TextView textview2;
	private WebView webview1;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView line;
	
	private Intent iInfoInd = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.info_indo);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		nav = (LinearLayout) findViewById(R.id.nav);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		bg_back = (LinearLayout) findViewById(R.id.bg_back);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		bg_forw = (LinearLayout) findViewById(R.id.bg_forw);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview2 = (TextView) findViewById(R.id.textview2);
		webview1 = (WebView) findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		line = (ImageView) findViewById(R.id.line);
		
		bg_back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.goBack();
			}
		});
		
		bg_forw.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				webview1.goForward();
			}
		});
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iInfoInd.setClass(getApplicationContext(), MainActivity.class);
				startActivity(iInfoInd);
			}
		});
		
		linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iInfoInd.setClass(getApplicationContext(), GlobalActivity.class);
				startActivity(iInfoInd);
			}
		});
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iInfoInd.setClass(getApplicationContext(), InfoActivity.class);
				startActivity(iInfoInd);
			}
		});
	}
	private void initializeLogic() {
		webview1.loadUrl(getIntent().getStringExtra("url1"));
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
