package com.example.demo.app


import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val login by cssclass()
        val loginWidth = 100.px

        val home by cssclass()

        private val redColor = c("#FA6565")
        private val whiteColor = c("#FFFFFF")

    }

    init {
        form and login {
            padding = box(300.px)
            fontSize = 18.px
            fontWeight = FontWeight.BOLD
            prefWidth = loginWidth
            alignment = Pos.CENTER
            fontSize = 15.px
            backgroundColor += whiteColor
            button {
                prefWidth = 120.px
                borderColor += box(redColor, redColor, redColor, redColor)
                fontSize = 15.px
                backgroundColor += redColor
                textFill = whiteColor
            }
        }

        button {
            prefWidth = 120.px
            borderColor += box(redColor, redColor, redColor, redColor)
            fontSize = 15.px
            backgroundColor += redColor
            textFill = whiteColor

        }

        home {
            backgroundColor += whiteColor
            spacing = 20.px
            padding = box(100.px)
        }

    }
}