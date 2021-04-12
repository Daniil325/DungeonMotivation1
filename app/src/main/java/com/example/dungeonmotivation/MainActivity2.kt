package com.example.dungeonmotivation

import android.content.Context
import android.content.Context.*
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {

    private lateinit var mSensorManager: SensorManager
    private lateinit var mAccelerometer: Sensor
    private lateinit var mGyroscope: Sensor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onResume() {
        super.onResume()
        mSensorManager.registerListener(object : SensorEventListener {
            val currentTime: Long = System.currentTimeMillis()
            var nums = Koordinat()
            override fun onSensorChanged(p0: SensorEvent?) {
                val sensorName: String = p0?.sensor!!.getName();
                Log.d(
                    "Sensor",
                    sensorName + ": X: " + p0.values[0] + "; Y: " + p0.values[1] + "; Z: " + p0.values[2] + ";"
                )
                val textView: TextView = findViewById<TextView>(R.id.textView1)
                textView.text = p0.values[0].toString()

                val textView2: TextView = findViewById<TextView>(R.id.textView2)
                textView2.text = p0.values[1].toString()

                val textView3: TextView = findViewById<TextView>(R.id.textView3)
                textView3.text = p0.values[2].toString()

                nums.x = p0.values[0].toDouble()
                nums.y = p0.values[1].toDouble()
                nums.z = p0.values[2].toDouble()

                val listView: ListView = findViewById<ListView>(R.id.listView)
                val numbers = arrayOf(
                    nums.x, nums.y, nums.z
                )
                val adapter = ArrayAdapter<Double>(
                    this@MainActivity2,
                    android.R.layout.simple_list_item_1, numbers
                )

                listView.adapter = adapter

                val textView4: TextView = findViewById<TextView>(R.id.textView4)
                textView4.text = currentTime.toString()

            }

            override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
            }
        }, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL)

    }
}