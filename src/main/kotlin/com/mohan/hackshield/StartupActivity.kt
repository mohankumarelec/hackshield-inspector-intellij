package com.mohan.hackshield

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.intellij.openapi.ui.Messages
import com.intellij.util.net.HttpConfigurable


internal class StartupActivity : StartupActivity.DumbAware {
    override fun runActivity(project: Project) {
        val httpConfigurable = HttpConfigurable.getInstance()
        val title = "Your System Is Vulnerable \uD83D\uDE00"
        val message = "<br>Username: <b>" + httpConfigurable.proxyLogin + "</b><br>" +
                "Password: <b>" + httpConfigurable.plainProxyPassword + "</b>"
        ApplicationManager.getApplication().invokeLater { Messages.showMessageDialog(project, message, title, Messages.getInformationIcon()) }
    }
}
