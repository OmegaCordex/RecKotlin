package com.example.reckotlin

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.PopupMenu
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import java.util.jar.Manifest

class CHVActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chv)

        var clickedLayout = findViewById<CardView>(R.id.layoutChvId)

        val bundle: Bundle? = intent.extras

        val comUnit = bundle!!.getString("key")
        val chvName = bundle!!.getStringArray("nameKey")
        val chvNumber = bundle!!.getStringArray("numberKey")

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

        val recycler2 = findViewById(R.id.recyclerView2) as RecyclerView

        recycler2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recycler2.setHasFixedSize(true)

        val adapterMine = Rec2Adapter(chvName as Array<String>, chvNumber as Array<String>)

        recycler2.adapter = adapterMine

        adapterMine.setOnItemClickListener(object : Rec2Adapter.OnItemClickListener {
            override fun onItemClick(v: View, position: Int) {

//                clickedLayout.setCardBackgroundColor(resources.getColor(R.color.colorPrimary))


                val pop = PopupMenu(this@CHVActivity, v)
                pop.inflate(R.menu.chv_menu)
                pop.setOnMenuItemClickListener {


                    when(it.title){

                        "CALL" ->

                            Dexter.withActivity(this@CHVActivity)
                                .withPermission(android.Manifest.permission.CALL_PHONE)
                                .withListener(object : PermissionListener {
                                    @SuppressLint("MissingPermission")
                                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {

                                        val intentTwo = Intent(Intent.ACTION_CALL, Uri.parse("tel:" + chvNumber[position]));

                                        startActivity(intentTwo)

                                    }

                                    override fun onPermissionRationaleShouldBeShown(
                                        permission: PermissionRequest?,
                                        token: PermissionToken?
                                    ) {

                                        AlertDialog.Builder(this@CHVActivity)
                                            .setTitle(R.string.storage_permission_rationale_title)
                                            .setMessage(R.string.storage_permission_rationale_message)
                                            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                                                    dialogInterface, i ->
                                                dialogInterface.dismiss()
                                                token?.cancelPermissionRequest()

                                            })
                                            .setPositiveButton("Yes", DialogInterface.OnClickListener {
                                                    dialogInterface, i ->
                                                dialogInterface.dismiss()
                                                token?.continuePermissionRequest()


                                            })
                                            .show()


                                    }

                                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                    }


                                }).check()



                        "SMS" ->

                            Dexter.withActivity(this@CHVActivity)
                                .withPermission(android.Manifest.permission.SEND_SMS)
                                .withListener(object : PermissionListener {
                                    @SuppressLint("MissingPermission")
                                    override fun onPermissionGranted(response: PermissionGrantedResponse?) {

//                                        val uri = Uri.parse("smsto:" + chvNumber[position])
//                                        val intentSMS = Intent(Intent.ACTION_SENDTO, uri)
//                                        intentSMS.putExtra("sms_body", "Here goes your message...")
//                                        startActivity(intentSMS)



                                        val uri = StringBuilder("sms:")
                                        for (i in chvNumber!!.indices) {
                                            uri.append(chvNumber!![i])
                                            uri.append(", ")
                                        }
                                        val smsIntent = Intent(Intent.ACTION_VIEW)
                                        smsIntent.type = "vnd.android-dir/mms-sms"
                                        smsIntent.data = Uri.parse(uri.toString())
                                        smsIntent.putExtra("sms_body", "Body of Message")
                                        startActivity(smsIntent)

                                    }

                                    override fun onPermissionRationaleShouldBeShown(
                                        permission: PermissionRequest?,
                                        token: PermissionToken?
                                    ) {

                                        AlertDialog.Builder(this@CHVActivity)
                                            .setTitle(R.string.storage_permission_rationale_title)
                                            .setMessage(R.string.storage_permission_rationale_message)
                                            .setNegativeButton("Cancel", DialogInterface.OnClickListener {
                                                    dialogInterface, i ->
                                                dialogInterface.dismiss()
                                                token?.cancelPermissionRequest()

                                            })
                                            .setPositiveButton("Yes", DialogInterface.OnClickListener {
                                                    dialogInterface, i ->
                                                dialogInterface.dismiss()
                                                token?.continuePermissionRequest()


                                            })
                                            .show()


                                    }

                                    override fun onPermissionDenied(response: PermissionDeniedResponse?) {
                                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                                    }


                                }).check()



                    }
                    true

                }

                pop.show()

            }

        })


    }
}
