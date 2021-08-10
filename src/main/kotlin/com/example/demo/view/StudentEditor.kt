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
                    textfield()
                }

                field ("ID Number"){
                    textfield()
                }

                field ("Credits"){
                    textfield()
                }

                field ("Subjects"){
                    textfield()
                }

                field ("Fees"){
                    textfield()
                }

                field ("Student Type"){
                    textfield()
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