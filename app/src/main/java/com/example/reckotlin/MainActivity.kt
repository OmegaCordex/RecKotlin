package com.example.reckotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //These are my inits

        var amagoroNames = resources.getStringArray(R.array.Amagoro)
        var amoniNames = resources.getStringArray(R.array.Amoni)
        var modingNames = resources.getStringArray(R.array.Moding)
        var kodedemaNames = resources.getStringArray(R.array.Kodedema)
        var kolaitNames = resources.getStringArray(R.array.Kolait)
        var olobaiNames = resources.getStringArray(R.array.Olobai)
        var amagoroNumbers = resources.getStringArray(R.array.amagoroNums)
        var amoniNumbers = resources.getStringArray(R.array.amoniNums)
        var modingNumbers = resources.getStringArray(R.array.modingNums)
        var kodedemaNumbers = resources.getStringArray(R.array.kodedemaNums)
        var kolaitNumbers = resources.getStringArray(R.array.kolaitNums)
        var olobaiNumbers = resources.getStringArray(R.array.olobaiNums)

        var array = resources.getStringArray(R.array.cUnit)

        val recyclerView = findViewById(R.id.recyclerView) as RecyclerView

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val recAdapter = RecAdapter(array)

        recyclerView.adapter = recAdapter

        recAdapter.setOnItemClickListener(object : RecAdapter.OnItemClickListener {
            override fun onItemClick(v: View, position: Int) {

                if (v != null){

                    var clickText : String = v.findViewById<TextView>(R.id.textView).text.toString()

                    if (clickText.equals("Amagoro", true)){

                        val intent = Intent(this@MainActivity, CHVActivity::class.java)

                        intent.putExtra("cuNameKey", array[position])

                        intent.putExtra("nameKey", amagoroNames)

                        intent.putExtra("numberKey", amagoroNumbers)

                        startActivity(intent)


                    }else if (clickText.equals("Amoni", true)){

                        val intent = Intent(this@MainActivity, CHVActivity::class.java)

                        intent.putExtra("cuNameKey", array[position])

                        intent.putExtra("nameKey", amoniNames)

                        intent.putExtra("numberKey", amoniNumbers)

                        startActivity(intent)

                    }else if (clickText.equals("Moding", true)){

                        val intent = Intent(this@MainActivity, CHVActivity::class.java)

                        intent.putExtra("cuNameKey", array[position])

                        intent.putExtra("nameKey", modingNames)

                        intent.putExtra("numberKey", modingNumbers)

                        startActivity(intent)

                    }else if (clickText.equals("Kodedema", true)){

                        val intent = Intent(this@MainActivity, CHVActivity::class.java)

                        intent.putExtra("cuNameKey", array[position])

                        intent.putExtra("nameKey", kodedemaNames)

                        intent.putExtra("numberKey", kodedemaNumbers)

                        startActivity(intent)

                    }else if (clickText.equals("Kolait", true)){

                        val intent = Intent(this@MainActivity, CHVActivity::class.java)

                        intent.putExtra("cuNameKey", array[position])

                        intent.putExtra("nameKey", kolaitNames)

                        intent.putExtra("numberKey", kolaitNumbers)

                        startActivity(intent)

                    }else if (clickText.equals("Olobai", true)){

                        val intent = Intent(this@MainActivity, CHVActivity::class.java)

                        intent.putExtra("cuNameKey", array[position])

                        intent.putExtra("nameKey", olobaiNames)

                        intent.putExtra("numberKey", olobaiNumbers)

                        startActivity(intent)

                    }
                }

            }
        })



    }
}
