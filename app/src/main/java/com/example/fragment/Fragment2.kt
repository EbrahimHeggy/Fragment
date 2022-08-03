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

class Fragment2(val listener:OnFragmentBClickListener ) : Fragment(){

    //lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var button: Button

    interface  OnFragmentBClickListener{
        fun onSendB(text: String)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.fragment2, container,false)
        editText=v.findViewById(R.id.txt2)
        button= v.findViewById(R.id.btn_frag2)

//        if(arguments!=null){
//            editText.text= arguments?.getString("txt").toString()
//        }

        button.setOnClickListener(){
            // Toast.makeText(activity,"Fragment 1",Toast.LENGTH_LONG).show()
            listener.onSendB(editText.text.toString())
        }
        return v

    }
    fun update(text:String){
        editText.setText(text)
    }

}