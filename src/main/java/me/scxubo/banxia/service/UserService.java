package me.scxubo.banxia.service;
import me.scxubo.banxia.domain.user;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    user findByid(int userId);

    void save(user user);

    void delete(user user);

    void delete(Integer id);

    void update(user user);

    user findById(Integer id);

    Iterable<user> findAll();

    Iterable<user> findAll(Pageable pageable);
}
