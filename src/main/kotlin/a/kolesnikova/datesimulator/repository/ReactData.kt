package a.kolesnikova.datesimulator.repository

import a.kolesnikova.datesimulator.dto.React
import a.kolesnikova.datesimulator.dto.User2
import org.springframework.stereotype.Repository

@Repository
class ReactData (
    val reacts: MutableList<React>
){
    fun react(id1: Int, user: User2){
        if(reacts.count{it.id==id1}==0){
            reacts.add(React(id=id1, reacts= mutableListOf()))
        }
        reacts.forEach { if(it.id==id1 && it.reacts.count{ it2 -> it2.id==user.id}==0){
            it.reacts.add(user)}
        }
    }
}