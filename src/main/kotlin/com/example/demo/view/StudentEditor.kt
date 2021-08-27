package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.StudentListController
import com.example.demo.model.StudentModel
import javafx.scene.control.TextField
import tornadofx.*

class StudentEditor: View() {
    val studentListController : StudentListController by inject()
    var fullNameField : TextField by singleAssign()
    var idNumberField : TextField by singleAssign()
    var creditsField : TextField by singleAssign()
    var subjectField : TextField by singleAssign()
    var feesField : TextField by singleAssign()
    var eduTypeField : TextField by singleAssign()

    override val root = Form().addClass(Styles.editor)

    init {
        with (root) {

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

                field ("Credits"){
                    textfield{
                        creditsField = this
                    }
                }

                field ("Subjects"){
                    textfield {
                        subjectField = this
                    }
                }

                field ("Funds"){
                    textfield{
                        feesField = this
                    }
                }

                field ("Student Type"){
                    textfield{
                        eduTypeField = this
                    }
                }

            }


            button("Add Student"){
                action {
                    studentListController.addStudent(fullNameField.text, idNumberField.text, creditsField.text.toInt(), subjectField.text, feesField.text.toInt(), eduTypeField.text)
                    fullNameField.text = ""
                    idNumberField.text = ""
                    creditsField.text = ""
                    subjectField.text = ""
                    feesField.text = ""
                    eduTypeField.text = ""
                }
            }

        }
    }

}