package com.example.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class Fragment1(val listener:OnFragmentClickListener ) : Fragment(){

    //lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var button: Button

    interface  OnFragmentClickListener{
        fun onSendA(text: String)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.fragment1, container,false)
        editText=v.findViewById(R.id.txt1)
        button= v.findViewById(R.id.btn_frag1)

//        if(arguments!=null){
//            editText.text= arguments?.getString("txt").toString()
//        }
        
        button.setOnClickListener(){
           // Toast.makeText(activity,"Fragment 1",Toast.LENGTH_LONG).show()
       listener.onSendA(editText.text.toString())
        }
            return v

    }

    fun update(text:String){
        editText.setText(text)
    }

}