package com.example.demo.model

import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.ItemViewModel

class Subject (name: String, code: String, lecturer: String, credits: Int, hours: Int, price: Int,students: String) {
    val nameProperty = SimpleStringProperty(name)
    val codeProperty = SimpleStringProperty(code)
    val lecturerProperty = SimpleStringProperty(lecturer)
    val creditsProperty = SimpleIntegerProperty(credits)
    val hoursProperty = SimpleIntegerProperty(hours)
    val priceProperty = SimpleIntegerProperty(price)
    val studentsProperty = SimpleStringProperty(students)
}

class SubjectModel(): ItemViewModel<Subject>() {
    val name = bind{ item?.nameProperty }
    val code = bind{ item?.codeProperty }
    val credits = bind{ item?.creditsProperty }
    val lecturer = bind{ item?.lecturerProperty }
    val hours = bind{ item?.hoursProperty }
    val price = bind{ item?.priceProperty }
    val students = bind{ item?.studentsProperty }
}