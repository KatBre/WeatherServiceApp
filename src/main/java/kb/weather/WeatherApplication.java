package kb.weather;

import kb.weather.security.User;
import kb.weather.security.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@SpringBootApplication
@RequiredArgsConstructor
public class WeatherApplication implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public static void main(String[] args) {
        SpringApplication.run(WeatherApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();
        userRepository.save(new User("user", passwordEncoder.encode("user1"), Collections.singletonList(() -> "ROLE_USER")));
        userRepository.save(new User("admin", passwordEncoder.encode("admin1"), Collections.singletonList(() -> "ROLE_ADMIN")));
    }
}
