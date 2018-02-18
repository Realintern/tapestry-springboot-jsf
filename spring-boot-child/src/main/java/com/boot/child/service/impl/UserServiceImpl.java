package com.boot.child.service.impl;

import com.boot.child.cutomexception.DataBaseException;
import com.boot.child.dto.UserDto;
import com.boot.child.manager.impl.UserManager;
import com.boot.child.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by manukg on 9/16/2016.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserManager userManager;


    public void addUserDto(UserDto userDto) throws DataBaseException {
        userManager.addUserDto(userDto);
    }
    public UserDto getUserDtoById(Long userId) throws DataBaseException {
        return userManager.getUserDtoById(userId);
    }
    public List<UserDto> getUserDtoList() throws DataBaseException {
        return userManager.getUserDtoList();
    }
    public void updateUserDto(UserDto userDto) throws DataBaseException {
        userManager.updateUserDto(userDto);
    }
    public void deleteUserDto(Long userDtoId) throws DataBaseException {
        userManager.deleteUserDto(userDtoId);
    }

    @Override
    public UserDto findUserDtoByFirstName(String firstName) throws DataBaseException {
        return userManager.findUserDtoByFirstName(firstName);
    }
}
