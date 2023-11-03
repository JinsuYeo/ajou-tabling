//package com.example.demo.service;
//
//import com.example.demo.domain.User;
//import com.example.demo.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class UserService {
//
//    private final UserRepository userRepository;
//
//    public Long join(User user) {
//        validateDuplicateUser(user);
//        validateEmail(user.getEmail());
//
//        userRepository.save(user);
//        return user.getId();
//    }
//
//    private static void validateEmail(String email) {
//        if (!email.contains("@") || !email.split("@")[1].equals("ajou.ac.kr")) {
//            throw new IllegalStateException("아주대 학생이 아닙니다.");
//        }
//    }
//
//    private void validateDuplicateUser(User user) {
//        User findUsers = userRepository.findByEmail(user.getEmail());
//        if (findUsers == null) {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }
//    }
//
//    public List<User> findUsers() {
//        return userRepository.findAll();
//    }
//
//    public User getByCredentials(final String userEmail, final String password, final PasswordEncoder encoder) {
//        final User originalUser = userRepository.findByEmail(userEmail);
//
//        if (originalUser != null && encoder.matches(password, originalUser.getPassword())) {
//            return originalUser;
//        }
//
//        return null;
//    }
//}
