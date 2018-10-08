package tz.co.hosannahighertech.kotlincontactviewer

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import tz.co.hosannahighertech.kotlincontacviewer.R

class MainActivity : AppCompatActivity() {
    val REQUEST_CONTACT = 2015

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        takeContact.setOnClickListener {
            checkContactPermission()
        }
    }

    private fun checkContactPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            launchContactPicker()

        } else {
            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_CONTACTS)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_CONTACTS), REQUEST_CONTACT)
            }

        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            REQUEST_CONTACT -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    launchContactPicker()
                } else {
                    Toast.makeText(this, "Permission denied. You can't read contacts!", Toast.LENGTH_LONG).show()
                }
                return
            }
        }
    }

    private fun launchContactPicker() {
        Intent(Intent.ACTION_PICK, ContactsContract.CommonDataKinds.Phone.CONTENT_URI).also { intent ->
            intent.resolveActivity(packageManager)?.also {
                startActivityForResult(intent, REQUEST_CONTACT)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == REQUEST_CONTACT && resultCode == RESULT_OK) {
            // Get the URI and query the content provider for the phone number
            val uri = data.data as Uri
            val projection = arrayOf(ContactsContract.CommonDataKinds.Phone.NUMBER)
            val cursor = contentResolver.query(uri, projection, null, null, null)

            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                val phoneIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)
                val nameIdx = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)

                val number = cursor.getString(phoneIdx)
                val name = cursor.getString(nameIdx)
                val contact = "$name\n$number"

                selectedContact.text = contact

            }

            cursor.close()
        }
    }
}
