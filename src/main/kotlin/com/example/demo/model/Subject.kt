package com.example.demo.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import tornadofx.ItemViewModel

object Subjects: IntIdTable(){

    val name = varchar("name", 255)
    val code = varchar("code", 255).uniqueIndex()
    val lecturer = varchar("lecturer", 255)
    val credits = integer("credits")
    val hours = varchar("hours", 255)
    val price = integer("price")

}

class Subject(id : EntityID<Int>): IntEntity(id){
    companion object : IntEntityClass<Subject>(Subjects)

    var name by Subjects.name
    var code by Subjects.code
    var lecturer by Subjects.lecturer
    var credits by Subjects.credits
    var hours by Subjects.hours
    var price by Subjects.price

}

class SubjectModel(): ItemViewModel<Subject>(){
    val name = bind(Subject::name)
    val code = bind(Subject::code)
    val lecturer = bind(Subject::lecturer)
    val credits = bind(Subject::credits)
    val hours = bind(Subject::hours)
    val price = bind(Subject::price)
}

