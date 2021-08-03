package com.example.demo.view

import tornadofx.View
import tornadofx.label
import tornadofx.vbox

class HomeScreen: View("Knight University Home") {

    override val root = vbox() {
        label("Hello")
    }

}