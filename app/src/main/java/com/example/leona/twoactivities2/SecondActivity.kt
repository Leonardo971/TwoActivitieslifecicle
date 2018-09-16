package com.example.leona.twoactivities2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent=intent
        val message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
         val text_message=findViewById<TextView>(R.id.text_message)
        text_message.text=message

    }


    public fun returnReply(v:View)
    {
            val res=findViewById<EditText>(R.id.editText_second)
            val reply=res!!.text.toString()

        val replyintent=intent
        replyintent.putExtra(EXTRA_REPLY,reply)
        setResult(Activity.RESULT_OK,replyintent)
        Log.d(LOG_TAG,"End Second Activitie")
        finish()


    }

    public override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG,"onStar")
    }

    public override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG,"onRestart")

    }

    public override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG,"onResume")

    }

    public override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG,"onPause")
    }

    public override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG,"onStop")
    }

    public override fun onDestroy() {
        super.onDestroy()
       Log.d(LOG_TAG,"onDestroy")
    }

    companion object {
        val EXTRA_REPLY="com.example.leona.twoactivities2.extra.REPLY"

       private  val LOG_TAG=SecondActivity::class.java.simpleName
    }


}
