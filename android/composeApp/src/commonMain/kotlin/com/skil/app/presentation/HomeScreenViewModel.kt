package com.skil.app.presentation

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

/**
 * HomeScreenViewModel - Manages StateFlow Unidirectional Data Flow (UDF)
 */
class HomeScreenViewModel {
    private val _uiState = MutableStateFlow(
        HomeUiState(
            totalLogEntries = 3,
            filesTouched = 14,
            activeRulesCount = 5,
            activities = listOf(
                LogActivityItem(
                    id = "LOG-003",
                    timestamp = "2026-07-22 13:52 IST",
                    category = "RULES",
                    title = "Rule 05: Strict Ban on Browser Alerts & Memphis Toast Engine",
                    status = "COMPLETED",
                    files = listOf("TOAST_NOTIFICATION_RULES.md", "journal.html", "SUPER_ADMIN_RULES.md")
                ),
                LogActivityItem(
                    id = "LOG-002",
                    timestamp = "2026-07-22 13:49 IST",
                    category = "RULES",
                    title = "Light Mode Theme Migration & 120Hz Architecture Specs",
                    status = "COMPLETED",
                    files = listOf("journal.html", "appended-context-window.html", "SUPER_FLUID_ARCHITECTURE.md")
                ),
                LogActivityItem(
                    id = "LOG-001",
                    timestamp = "2026-07-22 13:44 IST",
                    category = "SETUP",
                    title = "System Initialization & Super Admin Rulebook Setup",
                    status = "COMPLETED",
                    files = listOf("SUPER_ADMIN_RULES.md", ".agents/AGENTS.md", "journal.html")
                )
            )
        )
    )
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun showToast(message: String) {
        _uiState.update { currentState ->
            currentState.copy(
                isToastVisible = true,
                toastMessage = message
            )
        }
    }

    fun dismissToast() {
        _uiState.update { currentState ->
            currentState.copy(isToastVisible = false)
        }
    }

    fun triggerAction(actionName: String) {
        showToast("Triggered: $actionName")
    }
}
