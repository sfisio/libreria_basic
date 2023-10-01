package com.library.repository;

import com.library.entity.Book;
import com.library.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
    User findByEmailAndPassword(String email, String password);

}
