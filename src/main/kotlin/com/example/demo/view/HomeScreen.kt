package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.HomeController
import com.example.demo.model.UserModel
import javafx.geometry.Pos
import tornadofx.*

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
            right = gridpane {
                alignment = Pos.CENTER

                row {

                    button("Staff"){
                        useMaxWidth = true
                        prefHeight = 120.0
                        gridpaneConstraints {
                            marginBottom = 10.0
                            marginTop = 10.0
                            marginLeft = 10.0
                            marginRight = 10.0
                            columnSpan = 1
                        }
                    }

                    button("Students"){
                        useMaxWidth = true
                        prefHeight = 120.0
                        gridpaneConstraints {
                            marginBottom = 10.0
                            marginTop = 10.0
                            marginLeft = 10.0
                            marginRight = 10.0
                            columnSpan = 1
                        }
                        action {
                            replaceWith<StudentList>()
                        }
                    }
                }

                row {

                    button("Subjects"){
                        useMaxWidth = true
                        prefHeight = 120.0
                        gridpaneConstraints {
                            marginBottom = 10.0
                            marginTop = 10.0
                            marginLeft = 10.0
                            marginRight = 10.0
                            columnSpan = 1
                        }
                    }

                    button("Fees"){
                        useMaxWidth = true
                        prefHeight = 120.0
                        gridpaneConstraints {
                            marginBottom = 10.0
                            marginTop = 10.0
                            marginLeft = 10.0
                            marginRight = 10.0
                            columnSpan = 1
                        }
                    }

                }

            }

        }
    }

}