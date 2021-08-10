package com.example.demo.app

import com.example.demo.view.HomeScreen
import com.example.demo.view.LoginScreen
import javafx.stage.Stage
import tornadofx.App

class MyApp: App(HomeScreen::class, Styles::class) {
    override fun start(stage: Stage) {
        with(stage) {
            width = 900.0
            height = 900.0
        }
        super.start(stage)
    }
}