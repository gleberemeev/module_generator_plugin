package com.github.gleberemeev.modulegeneratorplugin.services

import com.intellij.openapi.project.Project
import com.github.gleberemeev.modulegeneratorplugin.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
