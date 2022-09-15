package hr.ferit.sandroblavicki.sandroapp.login

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class LoginFragment() : Fragment() {

    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = LoginViewModel()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.screenState.observe(viewLifecycleOwner){ screenState ->
            when (screenState) {
                is LoginError -> displayErrorUi(screenState)
                is LoginLoading -> displayLoadingUi(screenState)
                is LoginValidation -> displayValidationUi(screenState)
            }
        }
    }

    fun displayLoadingUi(loginLoading: LoginLoading) {

    }

    fun displayErrorUi(loginLoading: LoginError) {

    }

    fun displayValidationUi(loginLoading: LoginValidation) {

    }

}