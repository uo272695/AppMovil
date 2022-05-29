package ui

import android.widget.ListAdapter

class SitioStatusListAdapter: ListAdapter<Sitio, SitiosStatusHolder>(Sitio.DIFF_CALLBACK) {
}