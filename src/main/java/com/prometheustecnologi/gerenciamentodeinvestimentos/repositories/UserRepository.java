package com.prometheustecnologi.gerenciamentodeinvestimentos.repositories;

import com.prometheustecnologi.gerenciamentodeinvestimentos.entities.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
