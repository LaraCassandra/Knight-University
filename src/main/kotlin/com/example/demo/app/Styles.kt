package com.example.demo.app


import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*

class Styles : Stylesheet() {
    companion object {
        val login by cssclass()
        val loginWidth = 100.px

        val editor by cssclass()

        val home by cssclass()
//        val homeButtons by cssclass()

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

        editor {
            padding = box(50.px)
            fontSize = 18.px
            fontWeight = FontWeight.BOLD
            alignment = Pos.CENTER
            fontSize = 15.px
            backgroundColor += whiteColor
        }

        button {
            prefWidth = 120.px
            borderColor += box(redColor, redColor, redColor, redColor)
            fontSize = 15.px
            backgroundColor += redColor
            textFill = whiteColor
            fontWeight = FontWeight.BOLD

        }

        home {
            backgroundColor += whiteColor
            spacing = 20.px
            padding = box(100.px)
            fontSize = 15.px
            fontWeight = FontWeight.MEDIUM
        }

//        homeButtons {
//            button {
//                prefWidth = 150.px
//                prefHeight = 150.px
//                fontSize = 15.px
//                backgroundColor += whiteColor
//                textFill = redColor
//                borderColor += box(redColor)
//            }
//        }

    }
}