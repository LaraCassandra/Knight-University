package com.example.demo.view

import com.example.demo.controller.StudentListController
import com.example.demo.model.Student
import com.example.demo.model.StudentModel
import javafx.collections.ObservableList
import tornadofx.*

class StudentList: View("Knight University - Students") {
    val studentListController: StudentListController by inject()
    var studentTable : TableViewEditModel<StudentModel> by singleAssign()
    var students : ObservableList<StudentModel> by singleAssign()

    override val root = borderpane {
        students = studentListController.students


        left = vbox {
                button("Delete") {
                    action {
                        val model = studentTable.tableView.selectedItem
                        when (model) {
                            null -> return@action
                            else -> studentListController.deleteStudent(model)
                        }
                    }
                }

                button("Save Edited"){
                    action {
                        studentListController.commitDirty(studentTable.items.asSequence())
                    }
                }

                button("Undo All"){
                    action {
                        studentTable.rollback()
                    }
                }
            }

        center = tableview<StudentModel> {
            studentTable = editModel
            items = students

            enableCellEditing()
            enableDirtyTracking()

            column("Full Name", StudentModel::fullName).makeEditable()
            column("ID Number", StudentModel::idNumber).makeEditable()
            column("Credits", StudentModel::credits).makeEditable()
            column("Subject", StudentModel::subject).makeEditable()
            column("Funds", StudentModel::fees).makeEditable()
            column("Type", StudentModel::eduType).makeEditable()

            columnResizePolicy = SmartResize.POLICY
        }

    }

}