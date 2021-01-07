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

@Service
public class UserImplementation implements UsersService {

    private final UsersDao usersDao;
    private final ModelMapper modelMapper;

    @Autowired
    public UserImplementation(UsersDao usersDao, ModelMapper modelMapper) {
        this.usersDao = usersDao;
        this.modelMapper = modelMapper;
    }

    @Override //already exists 0 success 1
    public int createUser(UsersDto usersDto) {
        Optional<Users> user = usersDao.findByUsername(usersDto.getUsername());
        if (user.isPresent()){
            return 0;
        }else {
            usersDao.save(modelMapper.map(usersDto, Users.class));
            return 1;
        }
    }

    @Override
    public List<UsersDto> getAllUsers() {
        List<Users> all = usersDao.findAll();

        return modelMapper.map(all, new TypeToken<List<UsersDto>>() {
        }.getType());
    }

    @Override
    public UsersDto getUserByID(int id) {
        Users users = usersDao.findById(id).orElse(null);
        return modelMapper.map(users, new TypeToken<UsersDto>() {
        }.getType());
    }

    @Override
    public void deleteUserbyID(int id) {
        usersDao.deleteById(id);
    }

    @Override
    public void updateUser(UsersDto usersDto, int id) {
        UsersDto usertoUpdate = getUserByID(id);
        if (usertoUpdate.getId() == id) {
            usersDao.save(modelMapper.map(usersDto, Users.class));
        }
    }
//
//    @Override
//    public UsersDto getUserByUsername(String username) {
//        Users users = usersDao.getUserByUsername(username);
//        return modelMapper.map(users, new TypeToken<UsersDto>() {
//        }.getType());
//    }

    @Override
    public int getcountByUsername(String username) {
        return usersDao.getcountByUsername(username);
    }

    @Override
    public UsersDto getUserByusernameAndPassword(String username, String password) {
        Users users = usersDao.getUserByusernameAndPassword(username, password);
        return modelMapper.map(users, new TypeToken<UsersDto>() {
        }.getType());
    }


}
