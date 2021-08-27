package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.StaffListController
import com.example.demo.model.StaffModel
import javafx.scene.control.TextField
import tornadofx.*

class StaffEditor: View() {
    val staffListController : StaffListController by inject()
    var fullNameField : TextField by singleAssign()
    var idNumberField : TextField by singleAssign()
    var hoursField : TextField by singleAssign()
    var salaryField : TextField by singleAssign()
    var staffTypeField : TextField by singleAssign()

    override val root = Form().addClass(Styles.editor)

    init {
        with(root) {

            fieldset {

                field ("Full Name"){
                    textfield{
                        fullNameField = this
                    }
                }

                field ("ID Number"){
                    textfield{
                        idNumberField = this
                    }
                }

                field ("Hours (if applicable)"){
                    textfield{
                        hoursField = this
                    }
                }

                field("Salary"){
                    textfield{
                        salaryField = this
                    }
                }

                field("Staff Type"){
                    textfield{
                        staffTypeField = this
                    }
                }

            }

            button("Add Staff"){
                action {
                    staffListController.addStaff(fullNameField.text, idNumberField.text, hoursField.text, salaryField.text.toInt(), staffTypeField.text)
                    fullNameField.text = ""
                    idNumberField.text = ""
                }
            }

        }
    }

}