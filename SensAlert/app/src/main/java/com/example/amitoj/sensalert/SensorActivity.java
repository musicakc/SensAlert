package com.example.amitoj.sensalert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class SensorActivity extends Activity implements SensorEventListener, View.OnClickListener {

    private SensorManager mSensorManager;
    private Sensor mPressure;
    private Sensor mMobHeat;
    private Sensor mHeat;
    private Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        b1=(Button)findViewById(R.id.button1);
        b1.setOnClickListener(this);

        b2=(Button)findViewById(R.id.button1);
        b2.setOnClickListener(this);

        b3=(Button)findViewById(R.id.button1);
        b3.setOnClickListener(this);

        mSensorManager=(SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure=mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mHeat=mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mMobHeat=mSensorManager.getDefaultSensor(Sensor.TYPE_TEMPERATURE);

    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sensor, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float millibars_of_pressure = event.values[0];
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mMobHeat, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mHeat, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onClick(View v) {
       /* Intent in=new Intent(this,FirstActivity.class);
        Bundle bun=new Bundle();
        in.putExtras(bun);
        startActivity(in);*/
        Intent in=getIntent();
        //Bundle b1=in.getExtras();
        if(v.equals(b1)) {
            Toast t = Toast.makeText(this, "Current Pressure is " + mPressure + "!", Toast.LENGTH_LONG);
        }

        if(v.equals(b2)) {
            Toast t = Toast.makeText(this, "Current Temperature is " + mHeat + "!", Toast.LENGTH_LONG);
        }
        if(v.equals(b3)) {
            Toast t = Toast.makeText(this, "Current Mobile Temp is " + mMobHeat + "!", Toast.LENGTH_LONG);
        }

    }
}
