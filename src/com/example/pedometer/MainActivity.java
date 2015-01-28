package com.example.pedometer;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends Activity implements SensorEventListener{

	private TextView textView;
	private SensorManager mSensorManager;
	private Sensor mStepCounterSensor;
	private Sensor mStepDetectorSensor;

	 private float mPrevCount; // ステップカウンターの前回値
	 private float mCount; // アプリで管理する歩数

	Button b1;

	int i;

	int value = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		textView = (TextView)findViewById(R.id.textView1);
		b1 = (Button)findViewById(R.id.button1);

		mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
		mStepDetectorSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_DETECTOR);
		mStepCounterSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);

	}



	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO 自動生成されたメソッド・スタブ
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO 自動生成されたメソッド・スタブ
		Sensor sensor = event.sensor;
		float[] values = event.values;


		if(values.length > 0){
			value = (int) values[0];
		}
		  if (sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
		        textView.setText("現在 " + value + "歩です");
		     } else if (sensor.getType() == Sensor.TYPE_STEP_DETECTOR) {
		         // For test only. Only allowed value is 1.0 i.e. for step taken
		         textView.setText(" " + value);
		     }

	}
		protected void onResume(){
			super.onResume();
			mSensorManager.registerListener(this, mStepCounterSensor,SensorManager.SENSOR_DELAY_NORMAL);
			mSensorManager.registerListener(this, mStepDetectorSensor,SensorManager.SENSOR_DELAY_NORMAL);
	}
		protected void onPause(){
			super.onPause();
			mSensorManager.unregisterListener(this,mStepCounterSensor);
			mSensorManager.unregisterListener(this,mStepDetectorSensor);
		}




	}
