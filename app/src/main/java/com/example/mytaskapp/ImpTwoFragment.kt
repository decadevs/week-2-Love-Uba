package com.example.mytaskapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf

/**
 *
 * A [Fragment] subclass
 * extends the android Fragment class
 *
 */

class ImpTwoFragment : Fragment() {

    lateinit var fragmentCount: TextView

    companion object {

        /**
         *
         * Stores the instance of the fragment class so it can be used across multiple classes
         *
         * */

        fun newImpTwoFragment(): ImpTwoFragment {
            return ImpTwoFragment()
        }

    }

    /**
     *
     * Overrides the system lifecycle methods starting from onCreate() lifecycle stage
     * Update the textview on
     * @param activityUpdate: with the current lifecycle stage
     *
     * */

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        /**
         *
         *Inflates the layout for this fragment
         *
         * */

        val myFragView = inflater.inflate(R.layout.fragment_imp_two, container, false)

        fragmentCount = myFragView.findViewById(R.id.fragment_count)

        /**
         *
         * Fetches the key passed in the bundle from the manager containing the position of the fragment in view
         *
         * */

        fragmentCount.text = arguments?.getString("my_key")

        return myFragView

    }

}