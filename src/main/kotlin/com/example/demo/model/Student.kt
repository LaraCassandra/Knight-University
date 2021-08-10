package com.example.demo.model

import com.sun.xml.internal.fastinfoset.util.StringArray
import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

class Student (fullName: String, idNumber: String, credits: Int, subjects: String, fees: Int, eduType: String) {
    val fullNameProperty = SimpleStringProperty(fullName)
    val idNumberProperty = SimpleStringProperty(idNumber)
    val creditsProperty = SimpleIntegerProperty(credits)
    val subjectsProperty = SimpleStringProperty(subjects)
    val feesProperty = SimpleIntegerProperty(fees)
    val eduTypeProperty = SimpleStringProperty(eduType)
}

class StudentModel(): ItemViewModel<Student>() {
    val fullName = bind{ item?.fullNameProperty }
    val idNumber = bind{ item?.idNumberProperty }
    val credits = bind{ item?.creditsProperty }
    val subjects = bind{ item?.subjectsProperty }
    val fees = bind{ item?.feesProperty }
    val eduType = bind{ item?.eduTypeProperty }
}