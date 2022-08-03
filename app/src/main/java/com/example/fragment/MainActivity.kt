package com.example.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), Fragment1.OnFragmentClickListener , Fragment2.OnFragmentBClickListener{
    lateinit var btnFragmentA:Button
    lateinit var btnFragmentB:Button
    //lateinit var editText:EditText
    lateinit var textView:TextView
    lateinit var frag1:Fragment1
    lateinit var frag2:Fragment2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.txt1)
        btnFragmentA=findViewById(R.id.btn1)
        btnFragmentB=findViewById(R.id.btn2)
        btnFragmentA.setOnClickListener{
//            val bundle = Bundle()
//            bundle.putString("txt",editText.text.toString())
            val frag = Fragment1(this)
           // frag.arguments = bundle
            setFragment(frag)
        }
        btnFragmentB.setOnClickListener{
            val frag = Fragment2(this)
            setFragment(frag)
        }
        frag1= Fragment1(this)
        frag2=Fragment2(this)
        supportFragmentManager.beginTransaction().replace(R.id.containerA,frag1).replace(R.id.containerB,frag2).commit()

    }
    fun setFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.containerA,fragment).commit()
    }

    override fun onSendA(text: String) {
       // textView.text=text
        frag1.update(text)
    }

    override fun onSendB(text: String) {
       // textView.text=text
        frag2.update(text)
    }


}