package com.adith.springjpa.repo;

import com.adith.springjpa.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {

    List<User> findUserByName(String name);

    List<User> findUserByCity(String city);

    List<User> findUserByNameAndCity(String name, String city);

    @Query("select u from User u")
     List<User> getAllUser();

    @Query(value = "select * from User", nativeQuery = true)
    List<User> getAllUsers();
}
