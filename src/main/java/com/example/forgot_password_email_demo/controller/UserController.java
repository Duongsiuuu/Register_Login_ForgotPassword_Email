package com.example.forgot_password_email_demo.controller;

import com.example.forgot_password_email_demo.dto.LoginDto;
import com.example.forgot_password_email_demo.dto.RegisterDto;
import com.example.forgot_password_email_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterDto registerDto) {
        return new ResponseEntity<>(userService.register(registerDto), HttpStatus.OK);
    }
    @PutMapping("/verify-account")
    public ResponseEntity<String> verifyAccount(@RequestParam String email,
                                                @RequestParam String otp) {
        return new ResponseEntity<>(userService.verifyAccount(email, otp), HttpStatus.OK);
    }
    @PutMapping("/regenerate-otp")
    public ResponseEntity<String> regenerateOtp(@RequestParam String email) {
        return new ResponseEntity<>(userService.regenerateOtp(email), HttpStatus.OK);
    }
    @PutMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDto loginDto) {
        return new ResponseEntity<>(userService.login(loginDto), HttpStatus.OK);
    }
    @PutMapping("/forgot-password")
    public ResponseEntity<String> forgotPassword(@RequestParam String email) {
        return new ResponseEntity<>(userService.forgotPassword(email), HttpStatus.OK);
    }
    @PutMapping("/set-password")
    public ResponseEntity<String> setPassword(@RequestParam String email,
                                             @RequestHeader String newPassword) {
        return new ResponseEntity<>(userService.setPassword(email, newPassword), HttpStatus.OK);
    }
}
