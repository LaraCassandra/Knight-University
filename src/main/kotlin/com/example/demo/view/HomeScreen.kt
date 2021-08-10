package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.HomeController
import com.example.demo.model.User
import com.example.demo.model.UserModel
import javafx.geometry.Pos
import tornadofx.*
import java.awt.Color

class HomeScreen: View("Knight University Home") {
    val homeController: HomeController by inject()
    val model: UserModel by inject()

    override val root = borderpane().addClass(Styles.home)

    init {
        with (root) {

            // LEFT SIDE
            left = vbox() {
                spacing = 20.0
                alignment = Pos.CENTER

                imageview("knight-logo-3.png", lazyload = false)

                label("Welcome back to Knight University Administration")

                button("Log out") {
                    action {
                        replaceWith<LoginScreen>()
                    }
                }

            }

            // CENTER
            center = vbox {

                button("REFRESH")
                button("COMMIT")

            }

        }
    }

}