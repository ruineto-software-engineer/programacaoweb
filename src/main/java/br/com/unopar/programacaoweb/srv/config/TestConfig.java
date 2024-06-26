package br.com.unopar.programacaoweb.srv.config;

import java.util.Arrays;

import br.com.unopar.programacaoweb.srv.entities.User;
import br.com.unopar.programacaoweb.srv.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        
        // Salva os usuários no banco de dados em memória.
        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
