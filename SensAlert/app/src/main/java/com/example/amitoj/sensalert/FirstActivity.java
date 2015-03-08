package com.example.amitoj.sensalert;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


public class FirstActivity extends ActionBarActivity implements View.OnClickListener,SensorEventListener{

    private ImageButton b;
    private SensorManager mSensorManager;
    private Sensor mPressure;
    private Sensor mLight;
    private Sensor mHeat;
    public float milli,tem,ligh1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        b=(ImageButton)findViewById(R.id.imageButton);

        mSensorManager = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        mPressure = mSensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
        mHeat = mSensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        mLight = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub



        if (mPressure == null) { Toast.makeText(FirstActivity.this,"No Pressure Sensor!", Toast.LENGTH_LONG).show();}
        else {  milli=mPressure.getMaximumRange();
         }
         if (mHeat == null) { Toast.makeText(FirstActivity.this,"No Temperature Sensor!", Toast.LENGTH_LONG).show();}
        else {tem=mHeat.getMaximumRange();//onSensorChanged(mHeat);
        }
        if (mLight == null) { Toast.makeText(FirstActivity.this,"No Light Sensor!", Toast.LENGTH_LONG).show();}
        else {ligh1=mLight.getMaximumRange();//onSensorChanged(mLight);
        }
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        /*Intent openMainActivity =  new Intent(SplashActivity.this, FirstActivity.class);
                        startActivity(openMainActivity);
                        overridePendingTransition(R.anim.abc_fade_out, R.anim.abc_slide_out_top);
                        finish();*/


                        if (mPressure == null && mHeat == null && mLight == null) {
                            Intent in = new Intent(FirstActivity.this, SensorActivity.class);
                            startActivity(in);
                        }

                    }
                    }, 10000);
                }





        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first, menu);
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
    public void onClick(View v) {

        /*Intent in = new Intent(FirstActivity.this, SensorActivity.class);
        Intent in1 = getIntent();
        startActivity(in);
        */

    }

    @Override
    public void onSensorChanged(SensorEvent event) {


            /*if(event.sensor.getType()==Sensor.TYPE_PRESSURE) {
                //lightMeter.setProgress((int)currentReading);
                //textReading.setText("Current Reading(Lux): " + String.valueOf(currentReading));
                final float currentReading = event.values[0];

                b.setOnClickListener(new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {
                        // TODO Auto-generated method stub
                        //display.setText("" + String.valueOf(currentReading));
                        //Toast t=Toast.makeText(getApplicationContext(),formattedNumber,Toast.LENGTH_LONG);
                        if(currentReading>milli) {
                            try {
                                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                                Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                                r.play();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }


                });

            }

        if(event.sensor.getType()==Sensor.TYPE_AMBIENT_TEMPERATURE) {
            //lightMeter.setProgress((int)currentReading);
            //textReading.setText("Current Reading(Lux): " + String.valueOf(currentReading));
            final float currentReading = event.values[0];

            b.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    //display.setText("" + String.valueOf(currentReading));
                    //Toast t=Toast.makeText(getApplicationContext(),formattedNumber,Toast.LENGTH_LONG);
                    if(currentReading>tem) {
                        try {
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                            r.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


            });

        }

        if(event.sensor.getType()==Sensor.TYPE_LIGHT) {
            //lightMeter.setProgress((int)currentReading);
            //textReading.setText("Current Reading(Lux): " + String.valueOf(currentReading));
            final float currentReading = event.values[0];

            b.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    //display.setText("" + String.valueOf(currentReading));
                    //Toast t=Toast.makeText(getApplicationContext(),formattedNumber,Toast.LENGTH_LONG);
                    if(currentReading>ligh1) {
                        try {
                            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                            Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                            r.play();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


            });

        }*/

        float[] values = event.values;

        int sensorType = event.sensor.getType();
        StringBuilder sb = null;

        switch (sensorType) {

            case Sensor.TYPE_AMBIENT_TEMPERATURE:
                if(values[0]>tem) {
                    try {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                sb = new StringBuilder();
                sb.append("Temperature is：");
                sb.append(values[0]);
                Toast.makeText(FirstActivity.this,sb,Toast.LENGTH_LONG).show();
                break;

            case Sensor.TYPE_LIGHT:
                if(values[0]>ligh1) {
                    try {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                sb = new StringBuilder();
                sb.append("Light is：");
                sb.append(values[0]);
                Toast.makeText(FirstActivity.this,sb,Toast.LENGTH_LONG).show();
                break;

            case Sensor.TYPE_PRESSURE:
                if(values[0]>tem) {
                    try {
                        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
                        Ringtone r = RingtoneManager.getRingtone(getApplicationContext(), notification);
                        r.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                sb = new StringBuilder();
                sb.append("Pressure is：");
                sb.append(values[0]);
                Toast.makeText(FirstActivity.this,sb,Toast.LENGTH_LONG).show();
                break;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(FirstActivity.this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(FirstActivity.this, mPressure, SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(FirstActivity.this, mHeat, SensorManager.SENSOR_DELAY_NORMAL);
    }

    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }
}
