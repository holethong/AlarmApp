package com.example.myapplication123

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Button
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val timePicker: TimePicker = findViewById(R.id.timePicker)
        val setAlarmButton: Button = findViewById(R.id.setAlarmButton)

        setAlarmButton.setOnClickListener {
            val hour = timePicker.hour
            val minute = timePicker.minute


            val i = Intent(AlarmClock.ACTION_SET_ALARM)
            i.putExtra(AlarmClock.EXTRA_MESSAGE, "New Alarm")
            i.putExtra(AlarmClock.EXTRA_HOUR, hour)
            i.putExtra(AlarmClock.EXTRA_MINUTES, minute)
            startActivity(i)


            if (intent.resolveActivity(packageManager) != null) {
                startActivity(intent)
                Toast.makeText(this, "Alarm set for $hour:$minute", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "No alarm app available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
