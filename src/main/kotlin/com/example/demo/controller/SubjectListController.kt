package com.example.demo.controller

import com.example.demo.model.Student
import com.example.demo.model.Subject
import javafx.collections.FXCollections
import tornadofx.Controller

class SubjectListController: Controller() {
    val subjects = FXCollections.observableArrayList<Subject>()

    init {
        subjects.plusAssign(Subject("Interactive Development", "IDV", "Nelly Lavigne", 20, 16, 1200, "Lara Cook, John Doe, Marcus Dean"))
        subjects.plusAssign(Subject("Research Practice", "RP", "Nelly Lavigne", 20, 4, 1000, "Lara Cook, John Doe, Jane Smith, Marcus Dean"))
        subjects.plusAssign(Subject("Visual Culture", "VC", "Jesse Edwards", 20, 8, 1200, "Lara Cook, John Doe, Jane Smith, Marcus Dean"))
        subjects.plusAssign(Subject("Interaction Theory", "IXT", "Jesse Edwards", 20, 4, 1000, "Lara Cook, Jane Doe, Jane Smith, Marcus Dean"))
        subjects.plusAssign(Subject("Smart Objects", "CC", "Emilia Johnson", 20, 8, 1000, "Lara Cook, John Doe"))
        subjects.plusAssign(Subject("Internet of Things", "IOT", "Jay Wilson", 20, 8, 1000, "Lara Cook, Marcus Dean"))
        subjects.plusAssign(Subject("iOS", "IOS", "Victor Brown", 20, 8, 1000, "John Doe"))

    }
}