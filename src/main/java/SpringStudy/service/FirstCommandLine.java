package SpringStudy.service;

import SpringStudy.entity.Users;
import SpringStudy.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@AllArgsConstructor
public class FirstCommandLine implements CommandLineRunner {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        Users user = Users.builder()
                .role("ADMIN")
                .userName("ADMIN")
                .password(passwordEncoder.encode("admin"))
                .build();
        userRepo.save(user);
    }
}
