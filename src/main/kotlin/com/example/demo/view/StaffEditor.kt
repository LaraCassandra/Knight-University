package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.model.StaffModel
import tornadofx.*

class StaffEditor: View() {
    val model: StaffModel by inject()

    override val root = Form().addClass(Styles.editor)

    init {
        with(root) {

            fieldset {

                field ("Full Name"){
                    textfield(model.fullName)
                }

                field ("ID Number"){
                    textfield(model.idNumber)
                }

                field ("Type"){
                    textfield(model.eduType)
                }

                field("Subjects"){
                    textfield(model.subjects)
                }

                field("Hours"){
                    textfield(model.hours)
                }

                field("Salary"){
                    textfield(model.salary)
                }

            }

            button("Save"){
                action {
                    model.commit()
                }
            }

        }
    }

}