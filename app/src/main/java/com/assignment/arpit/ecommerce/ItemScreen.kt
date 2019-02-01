package com.assignment.arpit.ecommerce

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_item_screen.*

class ItemScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_screen)
        var cat:String=intent.getStringExtra("cat" )
        var url:String="http://192.168.56.1/ecomerce/get_item.php?category="+cat
        var list=ArrayList<items>()
        var rq: RequestQueue = Volley.newRequestQueue(this)
        var jar= JsonArrayRequest(Request.Method.GET,url,null, Response.Listener{ response ->

            for (i in 0..response.length()-1)
                list.add(items(response.getJSONObject(i).getInt("id"),response.getJSONObject(i).getString("name"),response.getJSONObject(i).getInt("price")))
            var adp= itemAdaptor(this,list)
            recycle.layoutManager=LinearLayoutManager(this)
            recycle.adapter=adp


        }, Response.ErrorListener{ error ->
            Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()
        })
        rq.add(jar)

    }
}
