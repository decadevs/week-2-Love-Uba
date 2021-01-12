package com.example.mytaskapp

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.location.LocationListener
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.*
import org.w3c.dom.Text
import java.util.*


    /**
     *
     * Class extends the android AppCompactActivity() class and overrides certain methods
     *
     * */

class MainActivity : AppCompatActivity() {

    lateinit var activityUpdate: TextView

    lateinit var updateOrientation: TextView

        val createState = "onCreate()"
        val startState = "onStart()"
        val resumeState = "onResume()"
        val restartState = "onRestart()"
        val pauseState = "onPause()"
        val stopState = "onStop()"
        val destroyState = "onDestroy()"

    /**
     *
     * Created a companion object to hold certain attributes that are common across classes and hold their state
     *
     * */

    companion object {

        var count = 0

    }

    /**
     *
     * Overrides the system lifecycle methods starting from onCreate() lifecycle stage
     * Update the textview on
     * @param activityUpdate: holds the current lifecycle stage
     * @param updateOrientation: holds the current screen orientation and count orientation changes
     * */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /**
         *
         * This sets the layout of this activity to the provided layout reference file
         *
         * */

        setContentView(R.layout.activity_main)

        activityUpdate = findViewById(R.id.activity_update)

        updateOrientation = findViewById(R.id.orientation_update)

        activityUpdate.text = createState

        /**
         *
         * Switches between implementations of the Task
         * {@link com.example.mytaskapp.ImplementationTwo }
         *
         * */

        var switchPage = findViewById<Button>(R.id.switch_page)

        switchPage.setOnClickListener {
            val intiee = Intent(this, ImplementationTwo::class.java)
            startActivity(intiee)
        }

        /**
         *
         * Calls for the screen orientation check
         *
         * */

        myConfigurationChanged()

    }

    override fun onStart() {
        super.onStart()
        activityUpdate = findViewById(R.id.activity_update)
        activityUpdate.text = startState
    }

    override fun onResume() {
        super.onResume()
        activityUpdate = findViewById(R.id.activity_update)
        activityUpdate.text = resumeState

    }

    override fun onRestart() {
        super.onRestart()
        activityUpdate = findViewById(R.id.activity_update)
        activityUpdate.text = restartState

    }

    override fun onPause() {
        super.onPause()
        activityUpdate = findViewById(R.id.activity_update)
        activityUpdate.text = pauseState

    }

    override fun onStop() {
        super.onStop()
        activityUpdate = findViewById(R.id.activity_update)
        activityUpdate.text = stopState

    }

    override fun onDestroy() {
        super.onDestroy()
        activityUpdate = findViewById(R.id.activity_update)
        activityUpdate.text = destroyState
    }

    /**
     *
     * Function comparing the orientation gotten and the standard orientations available
     *
     * @param count: counts the orientation changes that has occurred
     *
     * */

    fun myConfigurationChanged() {

        var orientation = this.getResources().getConfiguration().orientation

        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            updateOrientation.text = "LANDSCAPE\n$count ROTATION"
        } else {
            updateOrientation.text = "PORTRAIT\n$count ROTATION"
        }
        count++
    }


}
