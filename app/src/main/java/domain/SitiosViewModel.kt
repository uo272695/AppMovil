package domain

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import ui.SitiosUIState

class SitiosViewModel: ViewModel() {

    private val _stopsUIStateObservable = MutableLiveData<SitiosUIState>()
    val stopsUIStateObservable: LiveData<SitiosUIState> get() = _stopsUIStateObservable


    init {
        getSitiosList()
    }

    fun getSitiosList(){
        viewModelScope.launch {
            _stopsUIStateObservable.observe(viewLifecycleOwner){ result ->
                when(result){
                    is SitiosUIState.Success -> {
                        Log.d("a", "Succes List Fragment")
                    }
                    is SitiosUIState.Error -> {
                        Toast.makeText(this.requireContext(),"Error",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }




}
