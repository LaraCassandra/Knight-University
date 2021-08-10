package com.example.demo.view

import com.example.demo.controller.StudentListController
import com.example.demo.model.Student
import com.example.demo.model.StudentModel
import tornadofx.View
import tornadofx.column
import tornadofx.tableview

class StudentList: View("Knight University - Students") {
    val studentListController: StudentListController by inject()
    val model: StudentModel by inject()

    override val root = tableview(studentListController.students) {
        column("Full Name", Student::fullNameProperty)
        column("ID Number", Student::idNumberProperty)
        column("Credits", Student::creditsProperty)
        column("Subjects", Student::subjectsProperty)
        column("Fees", Student::feesProperty)
        column("Degree / Diploma", Student::eduTypeProperty)
    }

}