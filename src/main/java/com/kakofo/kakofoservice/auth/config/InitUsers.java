package com.kakofo.kakofoservice.auth.config;

import com.kakofo.kakofoservice.auth.entity.User;
import com.kakofo.kakofoservice.auth.repository.UserRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class InitUsers implements ApplicationRunner {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public InitUsers(PasswordEncoder passwordEncoder,
                     UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (userRepository.findByUsername("kakofo") != null) return;
        User user = User
                .builder()
                .username("kakofo")
                .password(passwordEncoder.encode("k@kofo2022"))
                .firstName("Tuwindi")
                .lastName("Foundation")
                .fullName("Tuwindi Foundation")
                .phone("79369550")
                .email("anba@tuwindi.org")
                .address("Banankabougou")
                .active(true)
                .admin(true)
                .build();
        userRepository.save(user);
    }
}
