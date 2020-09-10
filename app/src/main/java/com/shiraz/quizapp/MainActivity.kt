package com.shiraz.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun radioGroupAction(view: View) {

    }

    //When Submit Button is Clicked
    fun submitAction(view: View) {

        //Check question 1 is answered or not
        if (radioGroup.checkedRadioButtonId == -1){
            Toast.makeText(this,"Question 1 not answered.", Toast.LENGTH_SHORT).show()
        }

        //Check question 2 is answered or not
        if (!checkBox1.isChecked && !checkBox2.isChecked && !checkBox3.isChecked){
            Toast.makeText(this, "Question 2 is not answered.",Toast.LENGTH_SHORT).show()
        }


        //Calculate Score
        var score = 0

        var radioButtonID: Int = radioGroup.checkedRadioButtonId

        val selectedRadio: RadioButton = findViewById(radioButtonID)
        if (selectedRadio.id == radioButton1.id) {
            score += 50
        }

        if (checkBox2.isChecked) {
            score += 50
        }

        //Show Alert Dialog
        this.showAlertDialog(score)

    }

    //show Alert Dialog method
    private fun showAlertDialog(score: Int) {
        val formatter = SimpleDateFormat("MMM dd yyyy, HH:mm a")
        val currentDate: String = formatter.format(Date())


        val builder = AlertDialog.Builder(this)
        builder.setTitle("Finished")
        builder.setIcon(R.drawable.ic_launcher_foreground)
        builder.setMessage("""Congratulations! 
            |You submitted on $currentDate.
            |Your achieved ${score}%.""".trimMargin())

        builder.setNeutralButton("Reset") { _, _ ->
            this.resetAction()
        }

        builder.setPositiveButton("Dismiss") { _, _ -> }

        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    //When Reset Button is Clicked
    fun resetAction() {
        radioGroup.clearCheck()
        checkBox1.isChecked = false
        checkBox2.isChecked = false
        checkBox3.isChecked = false

        Toast.makeText(this,"Reset Quiz Successful", Toast.LENGTH_SHORT).show()
    }

}