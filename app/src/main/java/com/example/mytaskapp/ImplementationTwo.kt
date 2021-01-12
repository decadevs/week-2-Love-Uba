package com.example.mytaskapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf

class ImplementationTwo : AppCompatActivity() {

    /**
     *
     * holds an object of the Fragment Manager
     * @param position: keeps record of the position of fragments that have been added to backstack
     *
     * */

    val manager = supportFragmentManager

    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imp_two)

        /**
         *
         * Buttons for adding and removing fragments linked to their layout reference file
         * @param addFrag calls the add fragment method
         * @param removeFrag calls the remove fragment method
         *
         * */

        var addFrag = findViewById<Button>(R.id.add_frag)

        var removeFrag = findViewById<Button>(R.id.remove_frag)

        addFrag.setOnClickListener {
            addFragmentIn()
        }

        removeFrag.setOnClickListener {
            removeFragment()
        }


        var switchPageOne = findViewById<Button>(R.id.switchie)
        switchPageOne.setOnClickListener {
            val backToBase = Intent(this, MainActivity::class.java)
            startActivity(backToBase)
        }

    }

    /**
     *
     * The fragment is added using its object, which is added on the fragment container view created in this activity class
     * the manager keeps track of these added fragments in its backstack
     *
     * @param myBundle used to pass the fragment position from the manager to the fragment
     *
     * */

    fun addFragmentIn() {


        var myImpTwoFragment = ImpTwoFragment.newImpTwoFragment()

        val transaction = manager.beginTransaction()

        transaction.add(R.id.fragmentContainerView, myImpTwoFragment)

                .addToBackStack(null)

                .commit()

        position = manager.backStackEntryCount + 1


        var myBundle = bundleOf("my_key" to "Position $position")

        myImpTwoFragment.arguments = myBundle


    }

    fun removeFragment() {

        manager.popBackStack()

    }

}