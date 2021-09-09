package com.example.workwithfragment


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragment_example.SomeFragmentClickListener

class MainActivity : AppCompatActivity(), SomeFragmentClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction()
            .add(R.id.main_container, DataEntryFragment.newInstance())
            .commit()
    }


    override fun onClick(title: String, author: String) {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, ResultFragment.newInstance(title, author))
            .commit()
    }

    override fun onClickResult() {
        supportFragmentManager.beginTransaction()
            .addToBackStack(null)
            .replace(R.id.main_container, DataEntryFragment.newInstance())
            .commit()
    }

}