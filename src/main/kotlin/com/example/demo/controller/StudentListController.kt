package com.example.demo.controller

import com.example.demo.model.Student
import com.example.demo.model.StudentModel
import com.example.demo.model.Students
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

class StudentListController: Controller() {
    val students: ObservableList<StudentModel> by lazy {
        transaction {
            Student.all().map {
                StudentModel().apply {
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
            SchemaUtils.create(Students)

            Student.new{
                fullName = "Lara Cook"
                idNumber = "9709150192083"
                credits = 180
                subject = "Interaction Development"
                fees = 11000
                eduType = "Degree"
            }
        }

        transaction {
            Student.all().forEach { println(it) }
        }
    }

    fun deleteStudent(model: StudentModel){
        transaction {
            model.item.delete()
        }
        students.remove(model)
    }

    fun addStudent(fullName: String, idNumber: String, credits: Int, subject: String, fees: Int, eduType: String){
        transaction {
            val student = Student.new {
                this.fullName = fullName
                this.idNumber = idNumber
                this.credits = credits
                this.subject = subject
                this.fees = fees
                this.eduType = eduType
            }
            students.add(
                    StudentModel().apply {
                        item = student
                    }
            )
        }
    }

    fun commitDirty(modelDirtyMappings: Sequence<Map.Entry<StudentModel, TableColumnDirtyState<StudentModel>>>) {
        transaction {
            modelDirtyMappings.filter{it.value.isDirty}.forEach {
                it.key.commit()
                it.value.commit()
            }
        }
    }

}