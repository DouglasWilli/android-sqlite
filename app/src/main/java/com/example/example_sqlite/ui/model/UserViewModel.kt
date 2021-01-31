package com.example.example_sqlite.ui.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.example_sqlite.model.BaseModel
import com.example.example_sqlite.model.User
import com.example.example_sqlite.service.UserService
import org.koin.standalone.KoinComponent

class UserViewModel(private val userService: UserService) : ViewModel(),
    KoinComponent {

    private val baseModel: MutableLiveData<BaseModel<User, Exception>> = MutableLiveData()

    fun save(user: User) {
        baseModel.value = BaseModel(BaseModel.Status.LOADING)
        userService.save(
            user, {
                baseModel.value = BaseModel(
                    status = BaseModel.Status.SUCCESS,
                    data = User.buildUser(it),
                    error = null
                )
            }, {
                baseModel.value = BaseModel(
                    status = BaseModel.Status.ERROR,
                    data = null,
                    error = it
                )
            })
    }
}