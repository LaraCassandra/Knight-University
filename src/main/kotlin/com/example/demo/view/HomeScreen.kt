package com.example.demo.view

import javafx.geometry.Pos
import javafx.scene.layout.HBox
import tornadofx.*

class HomeScreen: View("Knight University Home") {

    override val root : HBox = hbox() {
    spacing = 50.0

        vbox {

            label("Hello")

            button {
                this.text = "Click me"
                action {
                    print("Button Clicked!")
                }
            }

        }

    }

}