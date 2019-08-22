package com.cafermertceyhan.postmanlib

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status

internal class PostmanBroadcastReceiver(private val fragment: Fragment) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == SmsRetriever.SMS_RETRIEVED_ACTION) {
            val extras: Bundle? = intent.extras
            val smsReceiverStatus: Status? = extras?.get(SmsRetriever.EXTRA_STATUS) as Status?

            when (smsReceiverStatus?.statusCode) {
                CommonStatusCodes.SUCCESS -> {
                    extras?.getParcelable<Intent>(SmsRetriever.EXTRA_CONSENT_INTENT).also {
                        fragment.startActivityForResult(it, REQUEST_USER_CONSENT)
                    }
                }
                CommonStatusCodes.TIMEOUT -> {
                }
            }
        }
    }

    companion object {
        const val REQUEST_USER_CONSENT = 100
    }
}