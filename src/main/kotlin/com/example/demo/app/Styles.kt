package com.example.demo.app

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px
import java.awt.Color.blue

class Styles : Stylesheet() {
    companion object {
        val login by cssclass()
        val loginWidth = 500.px
    }

    init {
        form and login {
            padding = box(50.px)
            fontSize = 18.px
            fontWeight = FontWeight.BOLD
            prefWidth = loginWidth
            button {
                prefWidth = 200.px
            }
        }
    }
}