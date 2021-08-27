package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.controller.SubjectListController
import com.example.demo.model.SubjectModel
import javafx.scene.control.TextField
import tornadofx.*

class SubjectEditor: View() {
    val subjectListController : SubjectListController by inject()
    var nameField : TextField by singleAssign()
    var codeField : TextField by singleAssign()
    var lecturerField : TextField by singleAssign()
    var hoursField : TextField by singleAssign()
    var priceField : TextField by singleAssign()
    var creditsField : TextField by singleAssign()

    override val root = Form().addClass(Styles.editor)

    init {
        with(root){

            fieldset {

                field ("Subject Name"){
                    textfield{
                        nameField = this
                    }
                }

                field ("Code"){
                    textfield {
                        codeField = this
                    }
                }

                field ("Lecturer"){
                    textfield{
                        lecturerField = this
                    }
                }

                field ("Credits"){
                    textfield{
                        creditsField = this
                    }
                }

                field ("Hours"){
                    textfield{
                        hoursField = this
                    }
                }

                field ("Price"){
                    textfield{
                        priceField = this
                    }
                }

            }

            button("Add Subject"){
                action {
                    subjectListController.addSubject(nameField.text, codeField.text, lecturerField.text, creditsField.text.toInt(), hoursField.text, priceField.text.toInt())
                    nameField.text = ""
                    codeField.text = ""
                    lecturerField.text = ""
                    creditsField.text = ""
                    hoursField.text = ""
                    priceField.text = ""
                }
            }
        }
    }

}