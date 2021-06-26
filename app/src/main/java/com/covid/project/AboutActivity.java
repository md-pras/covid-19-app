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
import android.widget.ImageView;
import android.content.Intent;
import android.net.Uri;

public class AboutActivity extends AppCompatActivity {
	
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout bg_blue;
	private LinearLayout bg_green;
	private LinearLayout bg_red;
	private TextView textview1;
	private TextView textview3;
	private LinearLayout linear8;
	private LinearLayout linear5;
	private ImageView imageview2;
	private TextView textview6;
	private TextView textview8;
	private LinearLayout linear9;
	private LinearLayout linear7;
	private ImageView imageview3;
	private TextView textview9;
	private TextView textview10;
	private LinearLayout linear12;
	private LinearLayout linear13;
	private ImageView imageview4;
	private TextView textview11;
	private TextView textview13;
	
	private Intent i = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.about);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		bg_blue = (LinearLayout) findViewById(R.id.bg_blue);
		bg_green = (LinearLayout) findViewById(R.id.bg_green);
		bg_red = (LinearLayout) findViewById(R.id.bg_red);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview3 = (TextView) findViewById(R.id.textview3);
		linear8 = (LinearLayout) findViewById(R.id.linear8);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview6 = (TextView) findViewById(R.id.textview6);
		textview8 = (TextView) findViewById(R.id.textview8);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview10 = (TextView) findViewById(R.id.textview10);
		linear12 = (LinearLayout) findViewById(R.id.linear12);
		linear13 = (LinearLayout) findViewById(R.id.linear13);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview11 = (TextView) findViewById(R.id.textview11);
		textview13 = (TextView) findViewById(R.id.textview13);
	}
	private void initializeLogic() {
		_gd(linear2, "#f5f5f5", "#f5f5f5", 50);
		linear2.setElevation(50);
		bg_blue.setElevation(10);
		bg_green.setElevation(10);
		bg_red.setElevation(10);
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
