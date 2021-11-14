package com.example.demo.view

import com.example.demo.controller.SubjectListController
import com.example.demo.model.Subject
import com.example.demo.model.SubjectModel
import javafx.collections.ObservableList
import tornadofx.*

class SubjectList: View("Knight University - Subjects") {
    val subjectListController: SubjectListController by inject()
    var subjectTable : TableViewEditModel<SubjectModel> by singleAssign()
    var subjects : ObservableList<SubjectModel> by singleAssign()

    override val root = borderpane {
        subjects = subjectListController.subjects

        left = vbox {
            button("Delete") {
                action {
                    val model = subjectTable.tableView.selectedItem
                    when (model) {
                        null -> return@action
                        else -> subjectListController.deleteSubject(model)
                    }
                }
            }

            button("Save Edited"){
                action {
                    subjectListController.commitDirty(subjectTable.items.asSequence())
                }
            }

            button("Undo All"){
                action {
                    subjectTable.rollback()
                }
            }
        }

        center = tableview<SubjectModel> {
            subjectTable = editModel
            items = subjects

            enableCellEditing()
            enableDirtyTracking()

            column("Subject Name", SubjectModel::name).makeEditable()
            column("Code", SubjectModel::code).makeEditable()
            column("Lecturer", SubjectModel::lecturer).makeEditable()
            column("Credits", SubjectModel::credits).makeEditable()
            column("Hours", SubjectModel::hours).makeEditable()
            column("Price", SubjectModel::price).makeEditable()

            columnResizePolicy = SmartResize.POLICY
        }

    }

}