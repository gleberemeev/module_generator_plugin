package com.github.gleberemeev.modulegeneratorplugin.action

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.Messages
import com.intellij.pom.Navigatable


class HelloWorldAction : AnAction() {
    override fun update(event: AnActionEvent) {
        super.update(event)
        val currentProject: Project? = event.project
        event.presentation.isEnabledAndVisible = currentProject != null
    }

    override fun actionPerformed(event: AnActionEvent) {
        val currentProject = event.project
        val message: StringBuilder = StringBuilder(event.presentation.text + " Selected!")
        val selectedElement: Navigatable? = event.getData(CommonDataKeys.NAVIGATABLE)
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement)
        }
        val title: String = event.presentation.description
        Messages.showMessageDialog(
            currentProject,
            message.toString(),
            title,
            Messages.getInformationIcon()
        )
    }
}