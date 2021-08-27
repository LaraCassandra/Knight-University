package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.LoginController
import com.example.demo.controller.StudentListController
import com.example.demo.model.User
import com.example.demo.model.UserModel
import javafx.geometry.Orientation
import javafx.scene.control.Alert
import javafx.scene.control.Button
import tornadofx.*

class LoginScreen : View("Knight University") {
    val loginController: LoginController by inject()
    val studentListController: StudentListController by inject()
    val model = UserModel(User())

    override val root = Form().addClass(Styles.login)

    init {
        with(root) {

            imageview("knight-logo-3.png", lazyload = false)

            fieldset {
                labelPosition = Orientation.VERTICAL

                field ("Username"){
                    textfield(model.username).required(message = "Please enter your username")
                }
                field("Password"){
                    passwordfield(model.password).required(message = "Please enter your password")
                }
            }

            button("Login"){
                action {
                    login()
                }
            }

        }
    }

    private fun Button.login(){
//
//        studentListController.setUp()

        if(model.commit()){
            runAsync {
                loginController.loginCheck(model.user)
            } ui { success ->
                if (success){
                    replaceWith<HomeScreen>()
                }
                else {
                    alert(Alert.AlertType.WARNING, "Login Failed", "Please check that your credentials are correct")
                }
            }
        }

    }

}