package Yavirac.Vin.Vinculacion.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Yavirac.Vin.Vinculacion.service.UserService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    /* @GetMapping("{username}")
    public ResponseEntity<UserDto> getUser(@PathVariable(name = "username") String username){
        return ResponseEntity.ok(this.userService.getUser(username));
    }

    @PostMapping("/edit-profile")
    public void editProfile(@RequestBody UserDto user){
        this.userService.editProfile(user);
    } */

}
