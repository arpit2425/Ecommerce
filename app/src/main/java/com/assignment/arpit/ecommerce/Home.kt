package com.assignment.arpit.ecommerce

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_home.*

class Home : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        var url:String="http://192.168.56.1/ecomerce/get_cat.php"
        var list=ArrayList<String>()
        var rq:RequestQueue=Volley.newRequestQueue(this)
        var jar=JsonArrayRequest(Request.Method.GET,url,null, Response.Listener{response -> 
            
            for (i in 0..response.length()-1)
                list.add(response.getJSONObject(i).getString("category"))
            var adp=ArrayAdapter(this,R.layout.my_list,list)
            home.adapter=adp
            
        },Response.ErrorListener{error ->
            Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()
        })
rq.add(jar)
        home.setOnItemClickListener { adapterView, view, i, l ->
            var cat:String=list[i]
            var obj= Intent(this,ItemScreen::class.java)
            obj.putExtra("cat",cat)
            startActivity(obj)
        }
    }
}
