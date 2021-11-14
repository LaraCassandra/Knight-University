package com.example.demo.view

import javafx.geometry.Pos
import tornadofx.View
import tornadofx.hbox

class StudentView: View("Knight University - Students") {
    override val root = hbox {
        alignment = Pos.CENTER
        spacing = 20.0

        this += StudentList::class
        this += StudentEditor::class
    }
}