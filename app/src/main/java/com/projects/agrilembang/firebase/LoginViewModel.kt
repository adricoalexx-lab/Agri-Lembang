package com.projects.agrilembang.firebase

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthRepository
): ViewModel() {
    private val _state = Channel<LoginState>()
    val state = _state.receiveAsFlow()

    fun loginUser(email: String, password:String, callback: (Boolean) -> Unit){
        viewModelScope.launch {
            repository.loginUser(email = email, password = password).collect { result ->
                when (result){
                    is Resource.Error -> {
                        _state.send(LoginState(error = result.message)
                        )
                        callback(false)
                    }
                    is Resource.Loading -> {
                        _state.send(LoginState(loading = true)
                        )
                    }
                    is Resource.Success -> {
                        _state.send(LoginState(success = "Login Berhasil"))
                        callback(true)
                    }
                }
            }
        }
    }

    fun registerUser(email: String, password: String, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            repository.registerUser(email = email, password = password).collect { result ->
                when (result){
                    is Resource.Error -> {
                        _state.send(LoginState(error = result.message))
                        callback(false)
                    }
                    is Resource.Loading -> {
                        _state.send(LoginState(loading = true))
                    }
                    is Resource.Success -> {
                        _state.send(LoginState(success = "Register Berhasil"))
                        callback(true)
                    }
                }
            }
        }
    }
}