package lk.epic.service;

import lk.epic.dto.UserDTO;

import java.util.List;

public interface UserServices {
    void saveUser(UserDTO dto);

    void updateUser(UserDTO dto);

    void deleteUser(int id);

    UserDTO searchUser(int id);

    List<UserDTO> getAllUsers();
}
