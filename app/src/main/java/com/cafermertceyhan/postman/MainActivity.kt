package com.cafermertceyhan.postman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cafermertceyhan.postman.databinding.ActivityMainBinding
import com.cafermertceyhan.postmanlib.Postman

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

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
                    binding.etVerificationCode1.setText(chars[0].toString())
                    binding.etVerificationCode2.setText(chars[1].toString())
                    binding.etVerificationCode3.setText(chars[2].toString())
                    binding.etVerificationCode4.setText(chars[3].toString())
                }
            }
    }
}
