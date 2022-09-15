package hr.ferit.sandroblavicki.sandroapp.login

sealed class LoginScreenState (
    val loginData: LoginUiModel
        )


class LoginError(loginUiModel: LoginUiModel, val message: String): LoginScreenState(loginUiModel)
class LoginLoading(loginUiModel: LoginUiModel): LoginScreenState(loginUiModel)
class LoginValidation(loginUiModel: LoginUiModel): LoginScreenState(loginUiModel)