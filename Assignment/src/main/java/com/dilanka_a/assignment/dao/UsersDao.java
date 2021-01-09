package com.dilanka_a.assignment.dao;

import com.dilanka_a.assignment.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * @author dilanka_a
 */

public interface UsersDao extends JpaRepository<Users, Integer> {

    /**
     * get user object by username
     *
     * @param username
     * @return
     */
    @Query("select u from Users u where u.username=:username")
    Users getUserByUsername(String username);

    /**
     * get count
     *
     * @param username
     * @return
     */
    @Query("select count(u.username) from Users u where u.username=:username")
    int getcountByUsername(String username);

    /**
     * get user object matching both username and password
     *
     * @param username
     * @param password
     * @return
     */
    @Query("select u from Users u where u.username=:username and u.password=:password")
    Users getUserByusernameAndPassword(String username, String password);

    /**
     * get user object by username
     *
     * @param userName
     * @return
     */
    Optional<Users> findByUsername(String userName);

}
