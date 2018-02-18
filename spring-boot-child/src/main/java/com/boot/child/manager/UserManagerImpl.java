package com.boot.child.manager;

import com.boot.child.converter.DataConverter;
import com.boot.child.cutomexception.DataBaseException;
import com.boot.child.dto.UserDto;
import com.boot.child.manager.impl.UserManager;
import com.boot.child.model.User;
import com.boot.child.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by manukg on 9/16/2016.
 */
@Component
public class UserManagerImpl  implements UserManager {
    @Autowired
    private UserRepository repository;

    public void addUserDto(UserDto userDto) throws DataBaseException{
        repository.save(DataConverter.fromUserDto(userDto));
    }
    public UserDto getUserDtoById(Long userId) throws DataBaseException{
        return DataConverter.fromUser(repository.getOne(userId));
    }
    public List<UserDto> getUserDtoList()throws DataBaseException{
        return DataConverter.fromUserList(repository.findAll());
    }
    public void updateUserDto(UserDto userDto)throws DataBaseException{
        User one = repository.findOne(userDto.getUserId());
        if(one!=null){
            one=DataConverter.fromUserDto(userDto);
            repository.save(one);
        }else {
            repository.save(DataConverter.fromUserDto(userDto));
        }
    }
    public void deleteUserDto(Long userDtoId)throws DataBaseException{
        repository.delete(userDtoId);
    }

    @Override
    public UserDto findUserDtoByFirstName(String firstName) throws DataBaseException {
        return DataConverter.fromUser(repository.findUserByFirstName(firstName));
    }
}
