package com.library.repository;

import com.library.entity.Book;
import com.library.entity.BookUser;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface BookUserRepository extends CrudRepository<BookUser, Integer> {

    //ArrayList<BookUser> findById_user(Integer id_user);
}
