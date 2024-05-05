package br.com.unopar.programacaoweb.srv.services;

import br.com.unopar.programacaoweb.srv.entities.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    Optional<User> findById(Long id);
    User insert(User user);
    void delete(Long id);
    User update(Long id, User user);
}
