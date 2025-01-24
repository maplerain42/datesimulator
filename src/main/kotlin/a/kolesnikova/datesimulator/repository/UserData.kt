package a.kolesnikova.datesimulator.repository

import a.kolesnikova.datesimulator.dto.RegisterUser
import a.kolesnikova.datesimulator.dto.User
import a.kolesnikova.datesimulator.dto.User2
import a.kolesnikova.datesimulator.dto.UserAdd
import org.springframework.stereotype.Repository

@Repository
class UserData (
    val users: MutableList<User>
){
    fun register(user: RegisterUser, token: String){
        users.add(User(id=users.size, token=token, login = user.login, password = user.password))
    }
    fun add(userAdd: UserAdd, token: String){
        users.forEach{
            if(it.token==token){
                it.age = userAdd.age
                it.gender= userAdd.gender
                it.lastName = userAdd.lastname
                it.firstName = userAdd.firstname
            }
        }
    }
    fun get(): List<User2>{
        return users.map{
            User2(id=it.id,
                gender=it.gender,
                age=it.age,
                lastName = it.lastName,
                firstName = it.firstName)
        }
    }
}