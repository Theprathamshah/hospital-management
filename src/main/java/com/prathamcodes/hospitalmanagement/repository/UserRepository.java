package com.prathamcodes.hospitalmanagement.repository;

import com.prathamcodes.hospitalmanagement.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface UserRepository extends CrudRepository<User,Long> {
    public User getUserByEmail(String email);
}
