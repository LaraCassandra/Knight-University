package com.example.demo.view

import com.example.demo.controller.StaffListController
import com.example.demo.model.Staff
import com.example.demo.model.StaffModel
import com.example.demo.model.Student
import com.example.demo.model.StudentModel
import tornadofx.*

class StaffList: View("Knight University - Staff") {
    val staffListController: StaffListController by inject()
    val model: StaffModel by inject()

    override val root = tableview(staffListController.staffMembers) {
        column("Full Name", Staff::fullNameProperty)
        column("ID Number", Staff::idNumberProperty)
        column("Lecturer / Admin", Staff::eduTypeProperty)
        column("Subjects", Staff::subjectsProperty)
        column("Hours", Staff::hoursProperty)
        column("Salary", Staff::salaryProperty)

        columnResizePolicy = SmartResize.POLICY

        bindSelected(model)
    }

}