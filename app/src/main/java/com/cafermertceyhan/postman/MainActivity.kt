package com.cafermertceyhan.postman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cafermertceyhan.postmanlib.Postman
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*
        * You can sent to SMS with Emulator > Extended controls > Phone > SMS message
        *
        * Example SMS; Please enter the following code to confirm your mobile number: 8751
        * */


        val postman = Postman(activity = this) // Activity or Fragment
            .getJustVerificationCode(true) // You can do true this if you want access to just verification code. Default is false
            .verificationCodeSize(4) // You should specify to verification code size if you want access to just verification code.  Default is 4
            .message()
            .subscribe { verificationCode ->
                val chars = verificationCode?.toCharArray()

                if (chars?.size == 4) {
                    etVerificationCode1.setText(chars[0].toString())
                    etVerificationCode2.setText(chars[1].toString())
                    etVerificationCode3.setText(chars[2].toString())
                    etVerificationCode4.setText(chars[3].toString())
                }
            }
    }
}
