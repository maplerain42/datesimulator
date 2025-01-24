package a.kolesnikova.datesimulator.controller

import a.kolesnikova.datesimulator.dto.RegisterUser
import a.kolesnikova.datesimulator.dto.User
import a.kolesnikova.datesimulator.dto.User2
import a.kolesnikova.datesimulator.dto.UserAdd
import a.kolesnikova.datesimulator.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
     val userService: a.kolesnikova.datesimulator.service.UserService
) {
    @GetMapping("/users")
    fun getUsers(): List<User2>{
        return userService.get()
    }
    @PostMapping("/users")
    fun register(@RequestBody registerUser: RegisterUser) = userService.register(registerUser)

    @PutMapping("/users")
    fun addInfo(@RequestBody user: UserAdd, @RequestHeader("Authorization") token: String) = userService.add(user, token)
    @PostMapping("/{id}/reaction")
    fun addReact(@RequestBody user: User2, @RequestParam id:Int
    ){
        userService.react(user, id)
    }
}