package com.example.demo.view

import com.example.demo.app.Styles
import com.example.demo.model.SubjectModel
import tornadofx.*

class SubjectEditor: View() {
    val model: SubjectModel by inject()

    override val root = Form().addClass(Styles.editor)

    init {
        with(root){

            fieldset {

                field ("Subject Name"){
                    textfield(model.name)
                }

                field ("Code"){
                    textfield(model.code)
                }

                field ("Lecturer"){
                    textfield(model.lecturer)
                }

                field ("Credits"){
                    textfield(model.credits)
                }

                field ("Hours"){
                    textfield(model.hours)
                }

                field ("Price"){
                    textfield(model.price)
                }

                field ("Students"){
                    textfield(model.students)
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