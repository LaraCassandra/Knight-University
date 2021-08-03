package com.example.demo.app


import javafx.scene.text.FontWeight
import tornadofx.Stylesheet
import tornadofx.WizardStyles.Companion.graphic
import tornadofx.box
import tornadofx.cssclass
import tornadofx.px

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
//            imageView {
//                prefWidth = 50.px
//                prefHeight = 50.px
//            }
        }
    }
}