package com.example.demo.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

class Staff (fullName: String, idNumber: String, eduType: String, subjects: String, hours: Int, salary: Int) {
    val fullNameProperty = SimpleStringProperty(fullName)
    val idNumberProperty = SimpleStringProperty(idNumber)
    val eduTypeProperty = SimpleStringProperty(eduType)
    val subjectsProperty = SimpleStringProperty(subjects)
    val hoursProperty = SimpleIntegerProperty(hours)
    val salaryProperty = SimpleIntegerProperty(salary)
}

class StaffModel(): ItemViewModel<Staff>() {
    val fullName = bind{ item?.fullNameProperty }
    val idNumber = bind{ item?.idNumberProperty }
    val eduType = bind{ item?.eduTypeProperty }
    val subjects = bind{ item?.subjectsProperty }
    val hours = bind{ item?.hoursProperty }
    val salary = bind{ item?.salaryProperty }
}