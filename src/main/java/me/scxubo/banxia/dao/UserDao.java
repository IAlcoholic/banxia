package me.scxubo.banxia.dao;

import me.scxubo.banxia.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface  UserDao  extends JpaRepository<user,Integer>  ,JpaSpecificationExecutor<user> {

}
