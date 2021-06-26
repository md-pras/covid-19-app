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
import android.view.View;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GlobalActivity extends AppCompatActivity {
	
	
	private ArrayList<HashMap<String, Object>> listGlobal = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout bg_title;
	private LinearLayout bg_yellow;
	private LinearLayout bg_red;
	private LinearLayout bg_green;
	private LinearLayout bg_negara;
	private LinearLayout linear20;
	private ImageView imageview10;
	private TextView textview7;
	private TextView text_pos;
	private TextView textview2;
	private TextView text_men;
	private TextView textview6;
	private TextView text_sem;
	private TextView textview4;
	private TextView textview8;
	private TextView textview9;
	private LinearLayout linear25;
	private LinearLayout linear26;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private ImageView imageview4;
	private ImageView img_global;
	private ImageView line2;
	private ImageView imageview9;
	
	private Intent ii = new Intent();
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private RequestNetwork req1;
	private RequestNetwork.RequestListener _req1_request_listener;
	private RequestNetwork req2;
	private RequestNetwork.RequestListener _req2_request_listener;
	private Intent iNegara = new Intent();
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.global);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		bg_title = (LinearLayout) findViewById(R.id.bg_title);
		bg_yellow = (LinearLayout) findViewById(R.id.bg_yellow);
		bg_red = (LinearLayout) findViewById(R.id.bg_red);
		bg_green = (LinearLayout) findViewById(R.id.bg_green);
		bg_negara = (LinearLayout) findViewById(R.id.bg_negara);
		linear20 = (LinearLayout) findViewById(R.id.linear20);
		imageview10 = (ImageView) findViewById(R.id.imageview10);
		textview7 = (TextView) findViewById(R.id.textview7);
		text_pos = (TextView) findViewById(R.id.text_pos);
		textview2 = (TextView) findViewById(R.id.textview2);
		text_men = (TextView) findViewById(R.id.text_men);
		textview6 = (TextView) findViewById(R.id.textview6);
		text_sem = (TextView) findViewById(R.id.text_sem);
		textview4 = (TextView) findViewById(R.id.textview4);
		textview8 = (TextView) findViewById(R.id.textview8);
		textview9 = (TextView) findViewById(R.id.textview9);
		linear25 = (LinearLayout) findViewById(R.id.linear25);
		linear26 = (LinearLayout) findViewById(R.id.linear26);
		linear27 = (LinearLayout) findViewById(R.id.linear27);
		linear28 = (LinearLayout) findViewById(R.id.linear28);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		img_global = (ImageView) findViewById(R.id.img_global);
		line2 = (ImageView) findViewById(R.id.line2);
		imageview9 = (ImageView) findViewById(R.id.imageview9);
		req = new RequestNetwork(this);
		req1 = new RequestNetwork(this);
		req2 = new RequestNetwork(this);
		
		bg_negara.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				iNegara.setClass(getApplicationContext(), NegaraActivity.class);
				startActivity(iNegara);
			}
		});
		
		imageview10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ii.setClass(getApplicationContext(), AboutActivity.class);
				startActivity(ii);
			}
		});
		
		linear26.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ii.setClass(getApplicationContext(), MainActivity.class);
				startActivity(ii);
			}
		});
		
		linear28.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ii.setClass(getApplicationContext(), InfoActivity.class);
				startActivity(ii);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				listGlobal = new Gson().fromJson(_response.replace("{", "[{").replace("}", "}]"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				text_pos.setText(listGlobal.get((int)0).get("value").toString());
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_req1_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				listGlobal = new Gson().fromJson(_response.replace("{", "[{").replace("}", "}]"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				text_sem.setText(listGlobal.get((int)0).get("value").toString());
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_req2_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _response = _param2;
				listGlobal = new Gson().fromJson(_response.replace("{", "[{").replace("}", "}]"), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				text_men.setText(listGlobal.get((int)0).get("value").toString());
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	private void initializeLogic() {
		req.startRequestNetwork(RequestNetworkController.GET, "https://api.kawalcorona.com/positif", "B", _req_request_listener);
		req1.startRequestNetwork(RequestNetworkController.GET, "https://api.kawalcorona.com/sembuh", "C", _req1_request_listener);
		req2.startRequestNetwork(RequestNetworkController.GET, "https://api.kawalcorona.com/meninggal", "D", _req2_request_listener);
		_gd(bg_yellow, "#f6c23e", "#f6c23e", 30);
		_gd(bg_green, "#1cc88a", "#1cc88a", 30);
		_gd(bg_red, "#e74a3b", "#e74a3b", 30);
		_gd(bg_title, "#f5f5f5", "#f5f5f5", 50);
		_gd(bg_negara, "#cfd8dc", "#cfd8dc", 50);
		bg_yellow.setElevation(40);
		bg_green.setElevation(40);
		bg_red.setElevation(40);
		bg_title.setElevation(50);
		bg_negara.setElevation(20);
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
