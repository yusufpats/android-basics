package com.yusufpats.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sensorManager;
    private Sensor accelerometerSensor;

    private double accelerationPrevious = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x = sensorEvent.values[0];
        float y = sensorEvent.values[1];
        float z = sensorEvent.values[2];

        printCurrentSensorReading(x,y,z);
        printCurrentOrientation(x,y,z);
        detectIfShake(x, y, z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }


    /**
     * HELPER FUNCTIONS - things you can do with the sensor reading
     */
    void printCurrentSensorReading(float x, float y, float z) {
        Log.e("ACC.READING", "AccX: " + x);
        Log.e("ACC.READING", "AccY: " + y);
        Log.e("ACC.READING", "AccZ: " + z);
        Log.e("ACC.READING", "-----------------------------------");
    }

    void detectIfShake(float x, float y, float z) {
        double accelerationCurrent = Math.sqrt((x * x) + (y * y) + (z * z));

        double diffAcceleration = Math.abs(accelerationCurrent - accelerationPrevious);


        if (diffAcceleration > 15) {
            Log.e("SHAKE", "Theres an earthquake: " + diffAcceleration);
            accelerationPrevious = accelerationCurrent;
        }
    }

    void printCurrentOrientation(float x, float y, float z) {
        if (x >= 9.5) {
            Log.e("ORIENTATION", "Landscape");
        } else if (y >= 9.5) {
            Log.e("ORIENTATION", "portrait");
        } else if (z >= 9.5) {
            Log.e("ORIENTATION", "your phone is on the table");
        }
    }
}