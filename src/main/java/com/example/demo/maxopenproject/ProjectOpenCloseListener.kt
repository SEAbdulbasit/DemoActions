package com.example.demo.maxopenproject

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener
import com.intellij.openapi.ui.Messages


/**
 * Created by abdulbasit on 26/07/2022.
 */
class ProjectOpenCloseListener : ProjectManagerListener {
    /**
     * Invoked on project open.
     *
     * @param project opening project
     */
    override fun projectOpened(project: Project) {
        // Ensure this isn't part of testing
        if (ApplicationManager.getApplication().isUnitTestMode) {
            return
        }
        // Get the counting service
        val projectCountingService = ApplicationManager.getApplication().getService(
            ProjectCountingService::class.java
        )
        // Increment the project count
        projectCountingService.incrProjectCount()
        // See if the total # of projects violates the limit.
        if (projectCountingService.projectLimitExceeded()) {
            // Transitioned to outside the limit
            val title = String.format("Opening Project \"%s\"", project.name)
            val message = "<br>The number of open projects exceeds the SDK plugin max_opened_projects limit.<br><br>" +
                    "This is not an error<br><br>"
            Messages.showMessageDialog(project, message, title, Messages.getInformationIcon())
        }
    }

    /**
     * Invoked on project close.
     *
     * @param project closing project
     */
    override fun projectClosed(project: Project) {
        // Ensure this isn't part of testing
        if (ApplicationManager.getApplication().isUnitTestMode) {
            return
        }
        // Get the counting service
        val projectCountingService = ApplicationManager.getApplication().getService(
            ProjectCountingService::class.java
        )
        // Decrement the count because a project just closed
        projectCountingService.decrProjectCount()
    }
}
