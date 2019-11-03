package com.example.oui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, ListGameFragment())
            .commit()
    }
}