package com.example.demo.view

import javafx.geometry.Pos
import tornadofx.View
import tornadofx.hbox

class SubjectView: View("Knight University - Subjects") {
    override val root = hbox {
        alignment = Pos.CENTER
        spacing = 20.0

        this += SubjectList::class
        this += SubjectEditor::class
    }
}