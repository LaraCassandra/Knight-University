package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.MainController
import javafx.geometry.Pos
import tornadofx.*

class MainView : View("Hello TornadoFX") {
    val mainController: MainController by inject()

    override val root = vbox {
        alignment = Pos.CENTER
        spacing = 50.0

        label(mainController.labelText) {
            //DO NOT NEED TO BIND OR CAN PASS IT AS PARAMETER
            //bind(mainController.labelText)
            addClass(Styles.heading)
        }

        button {
            this.text = "Click Me"
            action{
                mainController.getRandomLabel()
            }
        }
    }
}