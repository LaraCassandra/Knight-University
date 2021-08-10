package com.example.demo.controller

import com.example.demo.model.Student
import javafx.collections.FXCollections
import tornadofx.Controller
import tornadofx.*

class StudentListController: Controller() {
    val students = FXCollections.observableArrayList<Student>()

    init {
        students.plusAssign(Student("Lara Cook", "9709150192083", 80, "IDV, IXT, VC, RP", 11000, "Degree"))
        students.plusAssign(Student("John Doe", "9808140182082", 80, "IDV, IXT, VC, RP", 15000, "Degree"))
        students.plusAssign(Student("Jane Smith", "9907131584071", 60, "IXT, VC, RP", 7000, "Diploma"))
        students.plusAssign(Student("Marcus Dean", "9901010182084", 80, "IDV, IXT, VC, RP", 13000, "Degree"))
    }
}