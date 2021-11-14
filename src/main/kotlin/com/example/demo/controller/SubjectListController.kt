package com.example.demo.controller

import com.example.demo.model.Subject
import com.example.demo.model.SubjectModel
import com.example.demo.model.Subjects
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

class SubjectListController: Controller() {
    val subjects: ObservableList<SubjectModel> by lazy {
        transaction {
            Subject.all().map {
                SubjectModel().apply {
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
            SchemaUtils.create(Subjects)

            Subject.new{
                name = "Interactive Development 300"
                code = "IDV300"
                lecturer = "John Doe"
                credits = 40
                hours = "16"
                price = 11000
            }
        }

        transaction {
            Subject.all().forEach { println(it) }
        }
    }

    fun deleteSubject(model: SubjectModel){
        transaction {
            model.item.delete()
        }
        subjects.remove(model)
    }

    fun addSubject(name: String, code: String, lecturer: String, credits: Int, hours: String, price: Int){
        transaction {
            val subject = Subject.new {
                this.name = name
                this.code = code
                this.lecturer = lecturer
                this.credits = credits
                this.hours = hours
                this.price = price
            }
            subjects.add(
                    SubjectModel().apply {
                        item = subject
                    }
            )
        }
    }

    fun commitDirty(modelDirtyMappings: Sequence<Map.Entry<SubjectModel, TableColumnDirtyState<SubjectModel>>>) {
        transaction {
            modelDirtyMappings.filter{it.value.isDirty}.forEach {
                it.key.commit()
                it.value.commit()
            }
        }
    }

}