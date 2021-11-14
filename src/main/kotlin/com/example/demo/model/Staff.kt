package com.example.demo.model

import org.jetbrains.exposed.dao.EntityID
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.IntIdTable
import tornadofx.ItemViewModel

object StaffMembers: IntIdTable(){

    val fullName = varchar("fullName", 255)
    val idNumber = varchar("idNumber", 255).uniqueIndex()
    val hours = varchar("hours", 255)
    val salary = integer("salary")
    val staffType = varchar("staffType", 255)

}

class Staff(id : EntityID<Int>): IntEntity(id){
    companion object : IntEntityClass<Staff>(StaffMembers)

    var fullName by StaffMembers.fullName
    var idNumber by StaffMembers.idNumber
    var hours by StaffMembers.hours
    var salary by StaffMembers.salary
    var staffType by StaffMembers.staffType

}

class StaffModel(): ItemViewModel<Staff>(){
    val fullName = bind(Staff::fullName)
    val idNumber = bind(Staff::idNumber)
    val hours = bind(Staff::hours)
    val salary = bind(Staff::salary)
    val staffType = bind(Staff::staffType)
}

