package com.example.demo.controller

import javafx.beans.property.SimpleStringProperty
import tornadofx.*

class MainController: Controller() {
    val labelText = SimpleStringProperty("My Initial Value")
    private var labelsList: List<String> = listOf(
            "Label One",
            "Label Two",
            "Label Three",
            "Label Four"
    )

    fun getRandomLabel(){
        val randomInteger: Int = (0..(labelsList.size - 1)).shuffled().first()
        labelText.value = labelsList[randomInteger]
    }
}