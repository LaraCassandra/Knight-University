package com.example.demo.view

import javafx.geometry.Pos
import tornadofx.View
import tornadofx.hbox

class StaffView: View("Knight University - Staff") {
    override val root = hbox {
        alignment = Pos.CENTER
        spacing = 20.0

        this += StaffList::class
        this += StaffEditor::class
    }
}