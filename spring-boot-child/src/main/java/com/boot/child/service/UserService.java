package com.boot.child.service;

import com.boot.child.cutomexception.DataBaseException;
import com.boot.child.dto.UserDto;

import java.util.List;

/**
 * Created by manukg on 9/19/2016.
 */
public interface UserService {
    void addUserDto(UserDto userDto) throws DataBaseException;
    UserDto getUserDtoById(Long userId) throws DataBaseException;
    List<UserDto> getUserDtoList() throws DataBaseException;
    void updateUserDto(UserDto userDto) throws DataBaseException;
    void deleteUserDto(Long userDtoId) throws DataBaseException;
    UserDto findUserDtoByFirstName(String firstName) throws DataBaseException;
}
