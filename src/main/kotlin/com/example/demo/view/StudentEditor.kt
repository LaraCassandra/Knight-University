package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.model.StudentModel
import tornadofx.*

class StudentEditor: View() {
    val model: StudentModel by inject()

    override val root = Form().addClass(Styles.editor)

    init {
        with (root) {

            fieldset {

                field ("Full Name"){
                    textfield(model.fullName)
                }

                field ("ID Number"){
                    textfield(model.idNumber)
                }

                field ("Credits"){
                    textfield(model.credits)
                }

                field ("Subjects"){
                    textfield(model.subjects)
                }

                field ("Funds"){
                    textfield(model.fees)
                }

                field ("Student Type"){
                    textfield(model.eduType)
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