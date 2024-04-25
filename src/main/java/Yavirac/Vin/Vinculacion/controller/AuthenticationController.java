package Yavirac.Vin.Vinculacion.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Yavirac.Vin.Vinculacion.dto.LoginRequestDto;
import Yavirac.Vin.Vinculacion.dto.LoginResponseDto;
import Yavirac.Vin.Vinculacion.dto.RefreshTokenDto;
import Yavirac.Vin.Vinculacion.dto.RegisterRequestDto;
import Yavirac.Vin.Vinculacion.service.AuthenticationService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    public ResponseEntity<HttpStatus> signup(@RequestBody RegisterRequestDto signUpRequestDto){
        this.authenticationService.signup(signUpRequestDto);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/sign-in")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto){
        return ResponseEntity.ok().body(this.authenticationService.login(loginRequestDto));
    }

    @PostMapping("/logout")
    public ResponseEntity<HttpStatus> logout(@RequestBody RefreshTokenDto refreshTokenDto){
        this.authenticationService.logout(refreshTokenDto);
        return ResponseEntity.ok().build();
    };

    @PostMapping("/refresh-token")
    public ResponseEntity<LoginResponseDto> refreshToken(@RequestBody RefreshTokenDto refreshTokenDto ){
        return ResponseEntity.ok().body(this.authenticationService.refreshToken(refreshTokenDto));
    }

    @GetMapping("/usernames")
    public ResponseEntity<List<String>> findAllUsernames(){
        List<String> usernames = this.authenticationService.findAllUsernames();
        return ResponseEntity.ok(usernames);
    }
}
