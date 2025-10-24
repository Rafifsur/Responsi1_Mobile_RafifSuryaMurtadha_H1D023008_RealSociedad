package com.example.responsi1mobile_h1d023008.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobile_h1d023008.data.model.Coach
import com.example.responsi1mobile_h1d023008.data.model.Player
import com.example.responsi1mobile_h1d023008.data.network.RetrofitInstance
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {

    private val _players = MutableLiveData<List<Player>>()
    val players: LiveData<List<Player>> = _players

    private val _coach = MutableLiveData<Coach?>()
    val coach: LiveData<Coach?> = _coach

    private val _error = MutableLiveData<String?>()
    val error: LiveData<String?> = _error

    private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean> = _loading

    // Uses the user-requested ID 92
    fun fetchCoach() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                val response = RetrofitInstance.api.getTeamById(92)
                if (response.isSuccessful) {
                    _coach.value = response.body()?.coach
                    Log.d("COACH_SUCCESS", "${response.body()?.coach}")
                    _error.postValue(null)
                } else {
                    val msg = "${response.code()} ${response.message()}"
                    Log.e("COACH_ERROR", msg)
                    _error.postValue(msg)
                }
            } catch (e: Exception) {
                val msg = e.localizedMessage ?: "Unknown error"
                Log.e("COACH_EXCEPTION", msg)
                _error.postValue(msg)
            }
            finally {
                _loading.postValue(false)
            }
        }
    }

    fun fetchTeam() {
        viewModelScope.launch {
            try {
                _loading.postValue(true)
                val response = RetrofitInstance.api.getTeamById(92)
                if (response.isSuccessful) {
                    _players.value = response.body()?.squad ?: emptyList()
                    Log.d("TEAM_SUCCESS", "${response.body()?.squad}")
                    _error.postValue(null)
                } else {
                    val msg = "${response.code()} ${response.message()}"
                    Log.e("TEAM_ERROR", msg)
                    _error.postValue(msg)
                }
            } catch (e: Exception) {
                val msg = e.localizedMessage ?: "Unknown error"
                Log.e("TEAM_EXCEPTION", msg)
                _error.postValue(msg)
            }
            finally {
                _loading.postValue(false)
            }
        }
    }

}
