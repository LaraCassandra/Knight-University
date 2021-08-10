package com.example.demo.view

import com.example.demo.controller.StudentListController
import com.example.demo.controller.SubjectListController
import com.example.demo.model.Student
import com.example.demo.model.StudentModel
import com.example.demo.model.Subject
import com.example.demo.model.SubjectModel
import tornadofx.View
import tornadofx.column
import tornadofx.tableview

class SubjectList: View("Knight University - Subjects") {
    val subjectListController: SubjectListController by inject()
    val model: SubjectModel by inject()

    override val root = tableview(subjectListController.subjects) {
        column("Subject Name", Subject::nameProperty)
        column("Code", Subject::codeProperty)
        column("Lecturer", Subject::lecturerProperty)
        column("Credits", Subject::creditsProperty)
        column("Hours", Subject::hoursProperty)
        column("Price", Subject::priceProperty)
        column("Students", Subject::studentsProperty)
    }

}