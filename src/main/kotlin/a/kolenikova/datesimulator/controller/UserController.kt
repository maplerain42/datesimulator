package a.kolenikova.datesimulator.controller

import a.kolenikova.datesimulator.dto.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.data.web.PageableDefault
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {
    @GetMapping("/users")
    fun getUsers(@PageableDefault(size=20) pageable: Pageable): Page<User> {
        return PageImpl<User>(
            listOf(
                User(id=1, token="0", login="9", password="0")
            )
        )
    }
}