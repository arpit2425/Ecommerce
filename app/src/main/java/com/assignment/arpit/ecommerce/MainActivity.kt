package com.assignment.arpit.ecommerce

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login.setOnClickListener {
            var url:String="http://192.168.56.1/ecomerce/login.php?phone="+log_phone.text.toString()+"&password="+log_pass.text.toString()
            var rq: RequestQueue = Volley.newRequestQueue(this)
            var sr= StringRequest(
                Request.Method.GET,url, Response.Listener { response ->
                    if (response.equals("0"))
                        Toast.makeText(this,"Login failed", Toast.LENGTH_LONG).show()
                    else
                    {
                        userInfo.user_phone=log_phone.text.toString()
                        var i=Intent(this,Home::class.java)
                        startActivity(i)

                    }




                },
                Response.ErrorListener { error ->
                    Toast.makeText(this,error.message, Toast.LENGTH_LONG).show()

                })
            rq.add(sr)


        }
        sign_but.setOnClickListener {
            var i=Intent(this,registration::class.java)
            startActivity(i)
        }
    }
}
