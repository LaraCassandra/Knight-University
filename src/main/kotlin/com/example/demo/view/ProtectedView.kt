package com.example.demo.view

import tornadofx.*

class ProtectedView: View("Login Successful") {
    override val root = vbox {
        label("Logged in successfully")

        button("GO"){
            action {
                replaceWith<HomeScreen>()
            }
        }
    }
}