package com.boot.child.dao;

import com.boot.child.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by manukg on 9/16/2016.
 */
public interface UserRepository extends JpaRepository<User,Long>{
    User findUserByFirstName(String firstName);
}
