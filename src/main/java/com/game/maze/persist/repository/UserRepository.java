
package com.game.maze.persist.repository;

import com.game.maze.persist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
}
