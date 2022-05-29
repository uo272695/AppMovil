package ui

import state.AppStatus

sealed class SitiosUIState (val state: AppStatus) {
    data class Success (val sitios: ArrayList<ArrayList<String>> ): SitiosUIState(AppStatus.SUCCESS)
    data class Error (val message:String): SitiosUIState(AppStatus.ERROR)
}
