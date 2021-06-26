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
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.view.View;

public class InfoActivity extends AppCompatActivity {
	
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear11;
	private LinearLayout bg_indo;
	private LinearLayout bg_global;
	private LinearLayout linear12;
	private ImageView imageview10;
	private TextView textview1;
	private TextView textview6;
	private ImageView imageview4;
	private TextView textview4;
	private ImageView imageview5;
	private TextView textview5;
	private LinearLayout linear13;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private ImageView imageview6;
	private ImageView imageview7;
	private ImageView imageview8;
	private ImageView line;
	
	private Intent iInfo = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.info);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		bg_indo = (LinearLayout) findViewById(R.id.bg_indo);
		bg_global = (LinearLayout) findViewById(R.id.bg_global);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview6 = (TextView) findViewById(R.id.textview6);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview4 = (TextView) findViewById(R.id.textview4);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview5 = (TextView) findViewById(R.id.textview5);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		imageview6 = (ImageView) findViewById(R.id.imageview6);
		imageview7 = (ImageView) findViewById(R.id.imageview7);
		imageview8 = (ImageView) findViewById(R.id.imageview8);
		line = (ImageView) findViewById(R.id.line);
		
		bg_indo.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iInfo.putExtra("url1", "https://covid19.go.id/");
				iInfo.setClass(getApplicationContext(), InfoIndoActivity.class);
				startActivity(iInfo);
			}
		});
		
		bg_global.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iInfo.putExtra("url2", "https://covid19.who.int/");
				iInfo.setClass(getApplicationContext(), InfoGlobalActivity.class);
				startActivity(iInfo);
			}
		});
		
		imageview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iInfo.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(iInfo);
			}
		});
		
		linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iInfo.setClass(getApplicationContext(), MainActivity.class);
				startActivity(iInfo);
			}
		});
		
		linear15.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iInfo.setClass(getApplicationContext(), GlobalActivity.class);
				startActivity(iInfo);
			}
		});
	}
	private void initializeLogic() {
		_gd(linear2, "#f5f5f5", "#f5f5f5", 50);
		linear2.setElevation(50);
		bg_indo.setElevation(20);
		bg_global.setElevation(20);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _gd (final View _view, final String _c, final String _sc, final double _r) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_c));
		gd.setCornerRadius((float)_r);
		gd.setStroke(2, Color.parseColor(_sc));
		
		_view.setBackground(gd);
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
