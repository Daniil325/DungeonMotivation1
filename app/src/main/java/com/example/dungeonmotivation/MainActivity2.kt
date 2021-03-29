package com.example.dungeonmotivation

import android.content.Context
import android.content.Context.*
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity2 : AppCompatActivity() {

    private lateinit var mSensorManager: SensorManager
    private lateinit var mAccelerometr: Sensor
    private lateinit var mGravity: Sensor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometr = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(object: SensorEventListener {
            val currentTime: Long = System.currentTimeMillis()
            override fun onSensorChanged(p0: SensorEvent?){
                val sensorName: String = p0?.sensor!!.getName()
                Log.d("Sensor", sensorName + " X " + p0.values[0] + " Y " + p0.values[1]
                + " Z " + p0.values[2])
            }
            override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
                TODO("Not yet implemented")
            }
        }, mAccelerometr, SensorManager.SENSOR_DELAY_NORMAL)
    }
}