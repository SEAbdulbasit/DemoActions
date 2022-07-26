package com.example.demo.demoaction

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.ui.Messages


/**
 * Created by abdulbasit on 18/07/2022.
 */
class DemoAction : AnAction() {
    override fun actionPerformed(event: AnActionEvent) {
        // Transitioned to outside the limit

        // Transitioned to outside the limit
        val title = "Hi, Dummy Action"
        val message = "This is a message that dummy action has been clicked"
        Messages.showMessageDialog(event.project, message, title, Messages.getInformationIcon())
    }
}