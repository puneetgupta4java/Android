package com.example.puneetgupta.antitheft;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static java.lang.Math.abs;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    Sensor s;
    SensorManager sm;
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this,R.raw.t);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this , s ,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];
        float a=0,b=0,c=0;
        int flag = 0;
        if(flag == 0){
             a = x;
            b = y;
            c = z;
            flag =1 ;
        }
        else if(x==a && y==b && z==c){
            mp.pause();
        }
        else{
            if(abs(x-a)>0.2 && abs(y-b)>0.2 && abs(z-c)>0.2){
                mp.start();
            }
            else{
                mp.pause();
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
