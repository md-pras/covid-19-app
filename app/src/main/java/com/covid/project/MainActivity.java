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
import java.util.ArrayList;
import java.util.HashMap;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainActivity extends AppCompatActivity {
	
	
	private ArrayList<HashMap<String, Object>> ambilData = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout bg_title;
	private LinearLayout bg_yellow;
	private LinearLayout bg_green;
	private LinearLayout bg_red;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private ImageView imageview4;
	private TextView textview12;
	private TextView text_pos;
	private TextView textview5;
	private TextView text_sem;
	private TextView textview7;
	private TextView text_men;
	private TextView textview9;
	private TextView textview10;
	private TextView textview11;
	private LinearLayout nav;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private LinearLayout linear11;
	private ImageView imageview1;
	private ImageView line;
	private ImageView imageview2;
	private ImageView imageview3;
	
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private Intent i = new Intent();
	private Intent iIndonesia = new Intent();
	private Intent iGlobal = new Intent();
	private AlertDialog.Builder connection_lost;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		bg_title = (LinearLayout) findViewById(R.id.bg_title);
		bg_yellow = (LinearLayout) findViewById(R.id.bg_yellow);
		bg_green = (LinearLayout) findViewById(R.id.bg_green);
		bg_red = (LinearLayout) findViewById(R.id.bg_red);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview12 = (TextView) findViewById(R.id.textview12);
		text_pos = (TextView) findViewById(R.id.text_pos);
		textview5 = (TextView) findViewById(R.id.textview5);
		text_sem = (TextView) findViewById(R.id.text_sem);
		textview7 = (TextView) findViewById(R.id.textview7);
		text_men = (TextView) findViewById(R.id.text_men);
		textview9 = (TextView) findViewById(R.id.textview9);
		textview10 = (TextView) findViewById(R.id.textview10);
		textview11 = (TextView) findViewById(R.id.textview11);
		nav = (LinearLayout) findViewById(R.id.nav);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		linear10 = (LinearLayout) findViewById(R.id.linear10);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		line = (ImageView) findViewById(R.id.line);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		req = new RequestNetwork(this);
		connection_lost = new AlertDialog.Builder(this);
		
		linear6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ProvinsiActivity.class);
				startActivity(i);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(i);
			}
		});
		
		linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iGlobal.setClass(getApplicationContext(), GlobalActivity.class);
				startActivity(iGlobal);
			}
		});
		
		linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), InfoActivity.class);
				startActivity(i);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				ambilData = new Gson().fromJson(_response, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				text_pos.setText(ambilData.get((int)0).get("positif").toString());
				text_sem.setText(ambilData.get((int)0).get("sembuh").toString());
				text_men.setText(ambilData.get((int)0).get("meninggal").toString());
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				connection_lost.setMessage("Koneksi Gagal.\nSilakan periksa koneksi jaringan Anda.");
			}
		};
	}
	private void initializeLogic() {
		req.startRequestNetwork(RequestNetworkController.GET, "https://api.kawalcorona.com/indonesia", "A", _req_request_listener);
		_gd(bg_red, "#e74a3b", "#e74a3b", 30);
		_gd(bg_green, "#1cc88a", "#1cc88a", 30);
		_gd(bg_yellow, "#f6c23e", "#f6c23e", 30);
		_gd(bg_title, "#f5f5f5", "#f5f5f5", 50);
		_gd(linear6, "#cfd8dc", "#cfd8dc", 50);
		bg_red.setElevation(40);
		bg_green.setElevation(40);
		bg_yellow.setElevation(40);
		bg_title.setElevation(50);
		linear6.setElevation(20);
		imageview4.setElevation(50);
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
	
	
	private void _gds (final View _view, final double _r) {
		android.graphics.drawable.GradientDrawable gds = new android.graphics.drawable.GradientDrawable();
		
		gds.setCornerRadius((float)_r);
		
		_view.setBackground(gds);
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
