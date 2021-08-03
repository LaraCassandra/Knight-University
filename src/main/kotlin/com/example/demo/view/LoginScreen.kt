package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.LoginController
import com.example.demo.model.User
import com.example.demo.model.UserModel
import javafx.geometry.Orientation
import javafx.scene.control.Alert
import javafx.scene.control.Button
import javafx.scene.image.Image
import tornadofx.*

class LoginScreen : View("Hello TornadoFX") {
    val loginController: LoginController by inject()
    val model = UserModel(User())

    override val root = Form().addClass(Styles.login)

    init {
        with(root) {

//            label {
//                graphic = imageview("knight-logo.png", lazyload = false)
//            }

            fieldset {
                labelPosition = Orientation.VERTICAL

                field ("Username"){
                    textfield(model.username).required(message = "Please enter your username")
                }
                field("Password"){
                    passwordfield(model.password).required(message = "Please enter your password")
                }
            }

            button("Login Now"){
                action {
                    login()
                }
            }

        }
    }

    private fun Button.login(){

        if(model.commit()){
            runAsync {
                loginController.loginCheck(model.user)
            } ui { success ->
                if (success){
                    replaceWith<ProtectedView>()
                }
                else {
                    alert(Alert.AlertType.WARNING, "Login Failed", "Please check that your credentials are correct")
                }
            }
        }

    }

}