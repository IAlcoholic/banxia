package me.scxubo.banxia.service.Impl;
import me.scxubo.banxia.dao.UserDao;
import me.scxubo.banxia.domain.user;
import me.scxubo.banxia.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao UserDao;

    @Override
    public List<user> findAll() {
        return UserDao.findAll();
    }

    @Override
    public Iterable<user> findAll(Pageable pageable) {
        Page<user> users= UserDao.findAll( pageable );
        return users;
    }

    @Override
    public user findByid(int userId) {
        return UserDao.findOne( userId );
    }

    @Override
    public void save(user user) {

    }

    @Override
    public void delete(user user) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(user user) {

    }

    @Override
    public user findById(Integer id) {
        user user = UserDao.findOne( id );
        return null;
    }


}
