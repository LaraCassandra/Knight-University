package com.example.demo.view

import com.example.demo.controller.StaffListController
import com.example.demo.model.Staff
import com.example.demo.model.StaffModel
import com.example.demo.model.Student
import com.example.demo.model.StudentModel
import tornadofx.View
import tornadofx.column
import tornadofx.tableview

class StaffList: View("Knight University - Students") {
    val staffListController: StaffListController by inject()
    val model: StaffModel by inject()

    override val root = tableview(staffListController.staffMembers) {
        column("Full Name", Staff::fullNameProperty)
        column("ID Number", Staff::idNumberProperty)
        column("Lecturer / Admin", Staff::eduTypeProperty)
        column("Subjects", Staff::subjectsProperty)
        column("Hours", Staff::hoursProperty)
        column("Salary", Staff::salaryProperty)
    }

}