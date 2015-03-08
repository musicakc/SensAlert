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

import static java.lang.String.*;


public class SensorActivity extends Activity implements SensorEventListener, View.OnClickListener {

    private SensorManager mSensorManager;
    private Sensor mPressure;
    private Sensor mLight;
    private Sensor mHeat;
    private Button b1,b2,b3;
    public float millibars,temp,light;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);

        b1 = (Button) findViewById(R.id.button1);
        //b1.setOnClickListener(this);

        b2 = (Button) findViewById(R.id.button1);
        //b2.setOnClickListener(this);

        b3 = (Button) findViewById(R.id.button1);
        //b3.setOnClickListener(this);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mHeat = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);

        if (mLight == null) {
            Toast.makeText(SensorActivity.this,
                    "No Light Sensor! Quit!",
                    Toast.LENGTH_LONG).show();
        } else {
            float max = mLight.getMaximumRange();
            //lightMeter.setMax((int)max);
            //textMax.setText("Max Reading(Lux): " + String.valueOf(max));


        }
        if (mPressure == null) {
            Toast.makeText(SensorActivity.this,
                    "No Pressure Sensor! Quit!",
                    Toast.LENGTH_LONG).show();
        } else {
            float max = mPressure.getMaximumRange();
            //lightMeter.setMax((int)max);
            //textMax.setText("Max Reading(Lux): " + String.valueOf(max));


        }
        if (mHeat == null) {
            Toast.makeText(SensorActivity.this,
                    "No Heat Sensor! Quit!",
                    Toast.LENGTH_LONG).show();
        } else {
            float max = mHeat.getMaximumRange();
            //lightMeter.setMax((int)max);
            //textMax.setText("Max Reading(Lux): " + String.valueOf(max));


        }
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
         //millibars = event.values[0];
            if(event.sensor.getType()==Sensor.TYPE_LIGHT){
                final float currentReading = event.values[0];
                final String formattedNumber = Float.toString(currentReading);
                //lightMeter.setProgress((int)currentReading);
                //textReading.setText("Current Reading(Lux): " + String.valueOf(currentReading));
                b1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        //display.setText("" + String.valueOf(currentReading));
                        Toast.makeText(getApplicationContext(),formattedNumber,Toast.LENGTH_LONG).show();


                    }
                });

            }
        if(event.sensor.getType()==Sensor.TYPE_AMBIENT_TEMPERATURE){
            final float currentReading = event.values[0];
            final String formattedNumber = Float.toString(currentReading);
            //lightMeter.setProgress((int)currentReading);
            //textReading.setText("Current Reading(Lux): " + String.valueOf(currentReading));
            b2.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    //display.setText("" + String.valueOf(currentReading));
                    Toast.makeText(getApplicationContext(),formattedNumber,Toast.LENGTH_LONG).show();


                }
            });

        }
        if(event.sensor.getType()==Sensor.TYPE_PRESSURE){
            final float currentReading = event.values[0];
            final String formattedNumber = Float.toString(currentReading);
            //lightMeter.setProgress((int)currentReading);
            //textReading.setText("Current Reading(Lux): " + String.valueOf(currentReading));
            b3.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    //display.setText("" + String.valueOf(currentReading));
                    Toast.makeText(getApplicationContext(),formattedNumber,Toast.LENGTH_LONG).show();


                }
            });

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mHeat, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent in=getIntent();


    }

    /*
    @Override
    public void onClick(View v) {

        Intent in=getIntent();
        //Bundle b1=in.getExtras();
        if(v.equals(b3)) {

            Toast t = Toast.makeText(this, format("Current Pressure is %s%d!", millibars), Toast.LENGTH_LONG);
        }

        else if(v.equals(b2)) {
            Toast t = Toast.makeText(this, format("Current Temperature is %s%d!", temp), Toast.LENGTH_LONG);
        }
        else if(v.equals(b1)) {
            Toast t = Toast.makeText(this, format("Current Light is %s%d", light), Toast.LENGTH_LONG);
        }

    }*/
}
