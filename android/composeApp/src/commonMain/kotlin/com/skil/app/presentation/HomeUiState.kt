package com.skil.app.presentation

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable

@Stable
@Immutable
data class LogActivityItem(
    val id: String,
    val timestamp: String,
    val category: String,
    val title: String,
    val status: String,
    val files: List<String>
)

@Stable
@Immutable
data class HomeUiState(
    val totalLogEntries: Int = 3,
    val filesTouched: Int = 14,
    val activeRulesCount: Int = 5,
    val isToastVisible: Boolean = false,
    val toastMessage: String = "",
    val activities: List<LogActivityItem> = emptyList()
)
