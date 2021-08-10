package com.example.demo.controller

import com.example.demo.model.Student
import javafx.collections.FXCollections
import tornadofx.Controller
import tornadofx.*

class StudentListController: Controller() {
    val students = FXCollections.observableArrayList<Student>()

    init {
        students.plusAssign(Student("Lara Cook", "9709150192083", 120, "IDV, IXT, VC, RP, CC, IOT", 11000, "Degree"))
        students.plusAssign(Student("John Doe", "9808140182082", 120, "IDV, IXT, VC, RP, CC, IOS", 15000, "Degree"))
        students.plusAssign(Student("Jane Smith", "9907131584071", 60, "IXT, VC, RP", 7000, "Diploma"))
        students.plusAssign(Student("Marcus Dean", "9901010182084", 100, "IDV, IXT, VC, RP, IOT", 13000, "Degree"))
    }
}