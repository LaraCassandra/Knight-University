package com.example.demo.controller

import com.example.demo.model.Staff
import com.example.demo.model.StaffMembers
import com.example.demo.model.StaffModel
import javafx.collections.FXCollections
import javafx.collections.ObservableList
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import tornadofx.Controller
import tornadofx.*
import java.sql.Connection

class StaffListController: Controller() {
    val staffMembers: ObservableList<StaffModel> by lazy {
        transaction {
            Staff.all().map {
                StaffModel().apply {
                    item = it
                }
            }.observable()
        }
    }

    init {
        Database.connect("jdbc:sqlite:file:data:sqlite", driver = "org.sqlite.JDBC")
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE
    }

    fun setUp() {
        Database.connect("jdbc:sqlite:file:data:sqlite", driver = "org.sqlite.JDBC")
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE

        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(StaffMembers)

            Staff.new{
                fullName = "John Doe"
                idNumber = "9709150192083"
                hours = "8"
                salary = 11000
                staffType = "Lecturer"
            }

            Staff.new{
                fullName = "Mary Smith"
                idNumber = "8701300514074"
                hours = "NA"
                salary = 15000
                staffType = "Administrative"
            }
        }

        transaction {
            Staff.all().forEach { println(it) }
        }
    }

    fun deleteStaff(model: StaffModel){
        transaction {
            model.item.delete()
        }
        staffMembers.remove(model)
    }

    fun addStaff(fullName: String, idNumber: String, hours: String, salary: Int, staffType: String){
        transaction {
            val staffMember = Staff.new {
                this.fullName = fullName
                this.idNumber = idNumber
                this.hours = hours
                this.salary = salary
                this.staffType = staffType
            }
            staffMembers.add(
                    StaffModel().apply {
                        item = staffMember
                    }
            )
        }
    }

    fun commitDirty(modelDirtyMappings: Sequence<Map.Entry<StaffModel, TableColumnDirtyState<StaffModel>>>){
        transaction {
            modelDirtyMappings.filter{it.value.isDirty}.forEach {
                it.key.commit()
                it.value.commit()
            }
        }
    }

}