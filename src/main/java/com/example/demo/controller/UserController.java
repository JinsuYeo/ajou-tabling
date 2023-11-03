//package com.example.demo.controller;
//
//import com.example.demo.dto.UserDto;
//import com.example.demo.security.TokenProvider;
//import com.example.demo.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/auth")
//public class UserController {
//
//    private final UserService userService;
//    private TokenProvider tokenProvider;
//    private PasswordEncoder passwordEncoder;
//
////    @PostMapping("/signup")
////    public ResponseEntity<?> registerUser(@RequestBody UserDto userDto) {
////
////        try {
////
////            if (userDto == null || userDto.getPassword() == null) {
////                throw new RuntimeException("Invalid Password value.");
////            }
////
////
////
////        } catch (Exception e) {
////        }
////    }
//
//
//}
