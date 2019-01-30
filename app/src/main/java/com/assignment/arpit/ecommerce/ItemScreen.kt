package com.assignment.arpit.ecommerce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ItemScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_screen)
        var cat:String=intent.getStringExtra("cat" )
        var url:String="http://192.168.56.1/ecomerce/get_item.php?category="+cat

    }
}
