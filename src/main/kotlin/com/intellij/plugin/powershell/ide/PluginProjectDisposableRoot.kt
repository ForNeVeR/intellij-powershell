package com.intellij.plugin.powershell.ide

import com.intellij.openapi.Disposable
import com.intellij.openapi.components.Service
import com.intellij.openapi.components.service
import com.intellij.openapi.project.Project

/**
 * [Project] cannot be used in [com.intellij.openapi.util.Disposer.register],
 * so we use this project-level service for that.
 */
@Service(Service.Level.PROJECT)
class PluginProjectDisposableRoot(val project: Project) : Disposable {
  override fun dispose() {
  }

  companion object {
    fun getInstance(project: Project): PluginProjectDisposableRoot {
      return project.service<PluginProjectDisposableRoot>()
    }
  }
}