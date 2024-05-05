package br.com.unopar.programacaoweb.srv.repositories;

import br.com.unopar.programacaoweb.srv.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
