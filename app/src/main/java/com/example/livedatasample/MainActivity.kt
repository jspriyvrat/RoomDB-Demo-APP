package com.example.livedatasample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var dataBase: ContactDataBase
    @DelicateCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dataBase= ContactDataBase.getDataBase(applicationContext)

        savebtn.setOnClickListener {

            dataBase.contactDao().getContact().observe(this,{
                GlobalScope.launch {
                    dataBase.contactDao().insertContact(Contact(0,name.text.toString(),email.text.toString()))

                }
            })

        }
        showbtn.setOnClickListener {
            dataBase.contactDao().getContact().observe(this,{
                txtEmail.text=it.toString()
                txtName.text=it.toString()
            })
        }



    }
}