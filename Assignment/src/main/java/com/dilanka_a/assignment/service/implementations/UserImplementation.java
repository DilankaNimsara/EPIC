package com.dilanka_a.assignment.service.implementations;

import com.dilanka_a.assignment.dao.UsersDao;
import com.dilanka_a.assignment.dto.UsersDto;
import com.dilanka_a.assignment.model.Users;
import com.dilanka_a.assignment.service.UsersService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author dilanka_a
 */


@Service
public class UserImplementation implements UsersService {

    private final UsersDao usersDao;
    private final ModelMapper modelMapper;

    @Autowired
    public UserImplementation(UsersDao usersDao, ModelMapper modelMapper) {
        this.usersDao = usersDao;
        this.modelMapper = modelMapper;
    }

    /**
     * create new user account
     *
     * @param usersDto
     * @return already exists 0 success 1
     */
    @Override
    public int createUser(UsersDto usersDto) {
        Optional<Users> user = usersDao.findByUsername(usersDto.getUsername());
        if (user.isPresent()) {
            return 0;
        } else {
            usersDao.save(modelMapper.map(usersDto, Users.class));
            return 1;
        }
    }

    /**
     * get all users
     *
     * @return users dto list
     */
    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> all = usersDao.findAll();
        return modelMapper.map(all, new TypeToken<List<UsersDto>>() {
        }.getType());
    }

    /***
     * get users by id
     * @param id
     * @return user dto
     */
    @Override
    public UsersDto getUserByID(int id) {
        Users users = usersDao.findById(id).orElse(null);
        return modelMapper.map(users, new TypeToken<UsersDto>() {
        }.getType());
    }

    /**
     * delete user by id
     *
     * @param id
     */
    @Override
    public void deleteUserbyID(int id) {
        usersDao.deleteById(id);
    }

    /**
     * update user by id
     *
     * @param usersDto
     * @param id
     */
    @Override
    public void updateUser(UsersDto usersDto, int id) {
        UsersDto usertoUpdate = getUserByID(id);
        if (usertoUpdate.getId() == id) {
            usersDao.save(modelMapper.map(usersDto, Users.class));
        }
    }

    /**
     * get count by user name
     *
     * @param username
     * @return int
     */
    @Override
    public int getcountByUsername(String username) {
        return usersDao.getcountByUsername(username);
    }

    /**
     * get user by matching username and password
     *
     * @param username
     * @param password
     * @return user dto
     */
    @Override
    public UsersDto getUserByusernameAndPassword(String username, String password) {
        Users users = usersDao.getUserByusernameAndPassword(username, password);
        return modelMapper.map(users, new TypeToken<UsersDto>() {
        }.getType());
    }


}
