package a.kolenikova.datesimulator.repository

import a.kolenikova.datesimulator.dto.RegisterUser
import a.kolenikova.datesimulator.dto.User
import a.kolenikova.datesimulator.dto.User2
import a.kolenikova.datesimulator.dto.UserAdd
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