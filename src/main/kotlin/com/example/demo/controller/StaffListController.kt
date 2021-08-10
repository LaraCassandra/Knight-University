package com.example.demo.controller

import com.example.demo.model.Staff
import javafx.collections.FXCollections
import tornadofx.Controller

class StaffListController: Controller() {
    val staffMembers = FXCollections.observableArrayList<Staff>()

    init {
        staffMembers.plusAssign(Staff("Adam Low", "8001120146083", "Admin", "NA", 0, 15000))
        staffMembers.plusAssign(Staff("Jesse Edwards", "7903020125071", "Lecturer", "IXT, VC", 16, 6400))
        staffMembers.plusAssign(Staff("Nelly Lavigne", "8409270183045", "Lecturer", "RP, IDV", 20, 8000))

    }
}