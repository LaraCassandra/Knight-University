package com.example.demo.controller

import com.example.demo.model.User
import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class LoginController: Controller() {

    fun loginCheck(user: User): Boolean {
        return (user.usernameProperty.value == "Lara" && user.passwordProperty.value == "1234")
    }

}