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
import kotlinx.android.synthetic.main.activity_registration.*

class registration : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        sign.setOnClickListener {
            if(editText2.text.toString().equals(edit_confirm.text.toString())) {
                var url: String =
                    "http://192.168.56.1/ecomerce/register.php?name=" + edit_name.text.toString() + "&email=" + edit_email.text.toString() +
                            "&phone=" + editText.text.toString() + "&address=" + editText3.text.toString() + "&password=" + editText2.text.toString()
             var rq:RequestQueue=Volley.newRequestQueue(this)
                var sr=StringRequest(Request.Method.GET,url,Response.Listener { response ->
                    if (response.equals("0"))
                        Toast.makeText(this,"User already registered",Toast.LENGTH_LONG).show()
                    else {
                        userInfo.user_phone = editText.text.toString()
                        var i = Intent(this, Home::class.java)
                        startActivity(i)

                    }
                },
                    Response.ErrorListener { error ->
                    Toast.makeText(this,error.message,Toast.LENGTH_LONG).show()

                })
                rq.add(sr)



            }
            else
                Toast.makeText(this,"Password does not match",Toast.LENGTH_LONG).show()



        }
    }
}
