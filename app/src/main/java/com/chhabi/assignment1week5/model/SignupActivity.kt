package com.chhabi.assignment1week5.model

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.chhabi.assignment1week5.MainActivity
import com.chhabi.assignment1week5.R

class SignupActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etProfileLink: EditText
    private lateinit var etCovID: EditText
    private lateinit var etFName: EditText
    private lateinit var etLName: EditText
    private lateinit var etSignUsername: EditText
    private lateinit var etSignPassword: EditText
    private lateinit var spinner: Spinner
    private lateinit var btnSignUp: Button
    private val batch = arrayListOf("24", "25", "26", "27")
    private var arrUser = arrayListOf<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        etProfileLink = findViewById(R.id.etProfilLink)
        etCovID = findViewById(R.id.etCovID)
        etFName = findViewById(R.id.etFName)
        etLName = findViewById(R.id.etLName)
        etSignUsername = findViewById(R.id.etSignUsername)
        etSignPassword = findViewById(R.id.etSignPassword)
        spinner = findViewById(R.id.spinner)
        btnSignUp = findViewById(R.id.btnSignUp)

        if (intent != null) {
            arrUser = intent.getSerializableExtra("user") as ArrayList<User>
        }

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            batch
        )
        spinner.adapter = adapter

        btnSignUp.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view) {
            btnSignUp -> {
                if (checkEmptyValues()) {
                    val profileLink = etProfileLink.text.toString()
                    val covID = etCovID.text.toString().toInt()
                    val firstName = etFName.text.toString()
                    val lastName = etLName.text.toString()
                    val username = etSignUsername.text.toString()
                    val password = etSignPassword.text.toString()
                    val batch: String = spinner.selectedItem.toString()

                    val user = User(covID, firstName, lastName, username, password, batch, profileLink)
                    arrUser.add(user)

                    val intent = Intent(this, MainActivity::class.java)
                    intent.putExtra("user", arrUser)
                    intent.putExtra("user", arrUser)
                    startActivity(intent)
                }
            }
        }
    }

    private fun checkEmptyValues(): Boolean {
        var flag = true
        when {
            TextUtils.isEmpty(etProfileLink.text) -> {
                etProfileLink.error = "Please enter photo link"
                etProfileLink.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etCovID.text) -> {
                etCovID.error = "Please enter your coventry ID"
                etCovID.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etFName.text) -> {
                etFName.error = "Please enter your first name"
                etFName.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etLName.text) -> {
                etLName.error = "Please enter your last name"
                etLName.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etSignUsername.text) -> {
                etSignUsername.error = "Please enter your username"
                etSignUsername.requestFocus()
                flag = false
            }
            TextUtils.isEmpty(etSignPassword.text) -> {
                etSignPassword.error = "Please enter your password"
                etSignPassword.requestFocus()
                flag = false
            }
        }
        return flag
    }
}
