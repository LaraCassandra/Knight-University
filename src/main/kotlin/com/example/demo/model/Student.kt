package com.example.demo.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import tornadofx.ItemViewModel

object Students: IntIdTable(){

    val fullName = varchar("fullName", 255)
    val idNumber = varchar("idNumber", 255).uniqueIndex()
    val credits = integer("credits")
    val subject = varchar("subject", 255)
    val fees = integer("fees")
    val eduType = varchar("eduType", 255)

}

class Student(id : EntityID<Int>): IntEntity(id){
    companion object : IntEntityClass<Student>(Students)

    var fullName by Students.fullName
    var idNumber by Students.idNumber
    var credits by Students.credits
    var subject by Students.subject
    var fees by Students.fees
    var eduType by Students.eduType

}

class StudentModel(): ItemViewModel<Student>(){
    val fullName = bind(Student::fullName)
    val idNumber = bind(Student::idNumber)
    val credits = bind(Student::credits)
    val subject = bind(Student::subject)
    val fees = bind(Student::fees)
    val eduType = bind(Student::eduType)
}

