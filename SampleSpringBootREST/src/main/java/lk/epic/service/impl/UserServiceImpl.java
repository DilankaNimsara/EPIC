package lk.epic.service.impl;

import lk.epic.dto.UserDTO;
import lk.epic.entity.User;
import lk.epic.repo.UserRepo;
import lk.epic.service.UserServices;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserServices {

    private final UserRepo userRepo;
    private final ModelMapper mapper;

    @Autowired
    public UserServiceImpl(UserRepo userRepo, ModelMapper mapper) {
        this.userRepo = userRepo;
        this.mapper = mapper;
    }

    @Override
    public void saveUser(UserDTO dto) {
        User user = mapper.map(dto, User.class);
        userRepo.save(user);
    }

    @Override
    public void updateUser(UserDTO dto) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public UserDTO searchUser(int id) {
        return null;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> all = userRepo.findAll();
        return mapper.map(all, new TypeToken<List<UserDTO>>() {
        }.getType());
    }
}
