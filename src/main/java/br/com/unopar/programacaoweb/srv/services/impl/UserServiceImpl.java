package br.com.unopar.programacaoweb.srv.services.impl;

import br.com.unopar.programacaoweb.srv.entities.User;
import br.com.unopar.programacaoweb.srv.exceptions.ResourceNotFoundException;
import br.com.unopar.programacaoweb.srv.repositories.UserRepository;
import br.com.unopar.programacaoweb.srv.services.UserService;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }
    
    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(userRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("User not found with id: " + id)));
    }
    
    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Could not delete user with id: " + id + ", user not found.");
        }
    }
    
    @Override
    public User update(Long id, User user) {
        try {
            return userRepository.findById(id).map(existingUser -> {
                existingUser.setNome(user.getNome());
                existingUser.setEmail(user.getEmail());
                existingUser.setTelefone(user.getTelefone());
                existingUser.setPassword(user.getPassword());
                return userRepository.save(existingUser);
            }).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        } catch (Exception e) {
            throw new ResourceNotFoundException("Could not update user with id: " + id + ", user not found.");
        }
    }
}
