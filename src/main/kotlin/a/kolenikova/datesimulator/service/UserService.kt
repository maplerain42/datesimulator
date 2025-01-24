package a.kolenikova.datesimulator.service

import a.kolenikova.datesimulator.dto.RegisterUser
import a.kolenikova.datesimulator.dto.User
import a.kolenikova.datesimulator.dto.User2
import a.kolenikova.datesimulator.dto.UserAdd
import a.kolenikova.datesimulator.repository.ReactData
import a.kolenikova.datesimulator.repository.UserData
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class UserService (
    val userData: UserData,
    val reactData: ReactData
){

    private fun GenerateToken(): String{
        val s = ('a'..'z')+ ('A'..'Z')
        var token: String = ""
        for(i in 1..10){
            token+= s.random()
        }
        return token
    }
    fun register(registerUser: RegisterUser){
        val token = GenerateToken()
        userData.register(registerUser, token)
    }
    fun add(userAdd: UserAdd, token: String){
        userData.add(userAdd, token)
    }
    fun get(): List<User2>{
        return userData.get()
    }
    fun react(user: User2, id:Int){
        reactData.react(id, user)
    }
}

