<p align="center"> <img src="https://i.ibb.co/VB3wkPr/postman-banner.jpg" alt="postman"> </p>

## What is Postman?
Postman is a reactive One-tap SMS verification library. This library allows the usage of RxJava with <a href="https://developers.google.com/identity/sms-retriever/user-consent/overview">The SMS User Consent API</a>

## Usage
Postman allows you to easily access the SMS. You can access to all message or just verification code if the user allows. You should subscribe before sent SMS to phone.

### All Message
This function returns the all message to you if the user allows.

```kotlin
 val postman = Postman(activity = this) // Activity or Fragment
                .message()
                .subscribe { message ->

                }
```

### Just verification code
This function returns the just verification code to you if the user allows.

```kotlin
val postman = Postman(activity = this) // Activity or Fragment
                .getJustVerificationCode(true) // You can do true this if you want access to just verification code. Default is false
                .verificationCodeSize(4) // You should specify to verification code size if you want access to just verification code.  Default is 4
                .message()
                .subscribe { verificationCode ->

                }
```
## Setup

```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation 'com.github.mertceyhan:Postman:1.0.0'
}
```

## Demo
You can sent to SMS with "Emulator > Extended controls > Phone > SMS message" after subscribe to Postman.
Example SMS; Please enter the following code to confirm your mobile number: 8751

<p align="center"> <img src="https://i.ibb.co/FDjvLsc/postman-screenshot-large.jpg" alt="postman"> </p>


## Credits
Thanks to <a href="https://dribbble.com/IanSui">IanSui</a> for this beautiful illustration.


License
--------


    Copyright 2019 Cafer Mert Ceyhan

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
