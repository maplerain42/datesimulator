package a.kolenikova.datesimulator.controller

import a.kolenikova.datesimulator.dto.RegisterUser
import a.kolenikova.datesimulator.dto.User
import a.kolenikova.datesimulator.dto.User2
import a.kolenikova.datesimulator.dto.UserAdd
import a.kolenikova.datesimulator.service.UserService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
     val userService: UserService
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