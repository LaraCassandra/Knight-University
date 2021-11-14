package com.example.demo.view

import com.example.demo.controller.StaffListController
import com.example.demo.model.Staff
import com.example.demo.model.StaffModel
import com.example.demo.model.Student
import com.example.demo.model.StudentModel
import javafx.collections.ObservableList
import tornadofx.*

class StaffList: View("Knight University - Staff") {
    val staffListController: StaffListController by inject()
    var staffTable : TableViewEditModel<StaffModel> by singleAssign()
    var staffMembers : ObservableList<StaffModel> by singleAssign()

    override val root = borderpane {
    staffMembers = staffListController.staffMembers

        left = vbox {
            button("Delete") {
                action {
                    val model = staffTable.tableView.selectedItem
                    when (model) {
                        null -> return@action
                        else -> staffListController.deleteStaff(model)
                    }
                }
            }

            button("Save Edited"){
                action {
                    staffListController.commitDirty(staffTable.items.asSequence())
                }
            }

            button("Undo All"){
                action {
                    staffTable.rollback()
                }
            }
        }

        center = tableview<StaffModel>{
            staffTable = editModel
            items = staffMembers

            enableCellEditing()
            enableDirtyTracking()

            column("Full Name", StaffModel::fullName).makeEditable()
            column("ID Number", StaffModel::idNumber).makeEditable()
            column("Staff Type", StaffModel::staffType).makeEditable()
            column("Hours", StaffModel::hours).makeEditable()
            column("Salary", StaffModel::salary).makeEditable()

            columnResizePolicy = SmartResize.POLICY

        }

    }

}