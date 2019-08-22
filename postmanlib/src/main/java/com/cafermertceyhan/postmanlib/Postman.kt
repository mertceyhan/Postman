package com.cafermertceyhan.postmanlib

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import io.reactivex.Observable

class Postman {
    private var postmanFragment: PostmanFragment? = null

    private var getJustVerificationCode: Boolean = false

    private var verificationCodeSize: Int = 4

    private var senderNumber: String? = null

    constructor(activity: FragmentActivity) {
        startPostmanFragment(activity.supportFragmentManager)
    }

    constructor(fragment: Fragment) {
        startPostmanFragment(fragment.childFragmentManager)
    }

    fun message(): Observable<String?> {
        return Observable.fromPublisher<String> { subscriber ->
            postmanFragment?.getMessage()?.subscribe {
                var message = it

                if (getJustVerificationCode) {
                    message = fetchVerificationCode(message)
                }

                subscriber.onNext(message)
                subscriber.onComplete()
            }
        }
    }

    fun getJustVerificationCode(getJustVerificationCode: Boolean): Postman {
        this.getJustVerificationCode = getJustVerificationCode
        return this
    }

    fun verificationCodeSize(verificationCodeSize: Int): Postman {
        this.verificationCodeSize = verificationCodeSize
        return this
    }

    fun senderNumber(senderNumber: String): Postman {
        this.senderNumber
        return this
    }

    private fun fetchVerificationCode(message: String?): String? {
        val regex = Regex("\\b[0-9A-Z]{$verificationCodeSize}\\b")
        return message?.let { regex.find(it)?.value }

    }

    private fun startPostmanFragment(fragmentManager: FragmentManager) {
        postmanFragment = PostmanFragment.newInstance(senderNumber)

        postmanFragment?.let {
            fragmentManager
                    .beginTransaction()
                    .add(it, PostmanFragment.TAG)
                    .commitNow()
        }
    }
}