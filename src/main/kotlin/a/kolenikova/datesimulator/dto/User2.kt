package a.kolenikova.datesimulator.dto

class User2 (
    val gender: Gender,
    val age: Int,
    val lastName: String,
    val firstName: String
){
    enum class Gender {
        Male, Female;
    }
}