package hr.ferit.sandroblavicki.sandroapp.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import hr.ferit.sandroblavicki.sandroapp.home.PostData

class LoginViewModel: ViewModel() {

    private val _navigationDelegate = MutableLiveData<NavDirections>()
    val navigationDelegate : LiveData<NavDirections> = _navigationDelegate

    private val _screenState = MutableLiveData<LoginScreenState>()
    val screenState : LiveData<LoginScreenState> = _screenState

}