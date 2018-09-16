package com.example.leona.twoactivities2

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.leona.twoactivities2.R.id.text_message_reply
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val text_header_reply=findViewById<TextView>(R.id.text_header_reply)
    val text_message_reply=findViewById<TextView>(R.id.text_header_reply)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Log.d(LOG_TAG,"-----")
        Log.d(LOG_TAG,"Oncreate")

        if (savedInstanceState != null)
        {
            val isVisible=savedInstanceState.getBoolean("Respuesta Visible")

            if (isVisible)
            {

                text_header_reply!!.visibility=View.VISIBLE
                text_message_reply!!.text=savedInstanceState.getString("Respuesta")
                text_header_reply!!.visibility=View.VISIBLE
            }
        }

    }


    fun launchSecondActivity (v:View)
    {
       Toast.makeText(this@MainActivity,"BOTON ENVIAR",Toast.LENGTH_SHORT).show()

        val intent=Intent(this,SecondActivity::class.java)
        val editText_main=findViewById<EditText>(R.id.editText_main)
        val message=editText_main!!.text.toString()
        intent.putExtra(EXTRA_MESSAGE,message)
        startActivity(intent)


    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==TEXT_REQUEST)
        {
            if(resultCode==Activity.RESULT_OK)
            {
                val reply = data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                text_message_reply!!.visibility=View.VISIBLE
                text_message_reply!!.text=reply
                text_header_reply!!.visibility=View.VISIBLE


            }
        }
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

    override fun onSaveInstanceState(outState: Bundle?, outPersistentState: PersistableBundle?) {
        super.onSaveInstanceState(outState, outPersistentState)

        if (text_message_reply!!.visibility==View.VISIBLE)
        {
            outState!!.putBoolean("Respuesta Visible",true)
            outState.putString("Respuesta exto",text_message_reply!!.text.toString())
        }

    }

    companion object {

        private val LOG_TAG=MainActivity::class.java.simpleName
        val EXTRA_MESSAGE="com.example.leona.twoactivities2.extra.MESSAGE"

        val TEXT_REQUEST=1
    }
}
