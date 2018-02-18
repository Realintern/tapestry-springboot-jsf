package com.boot.child.converter;

import com.boot.child.dto.UserDto;
import com.boot.child.model.User;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by manukg on 9/16/2016.
 */
public class DataConverter {
    /**
     * method converts UserDto object to User object
     * @param userDto
     * @return
     */
    public static User fromUserDto(UserDto userDto){
        User user=new User();
        user.setUserId(userDto.getUserId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }

    /**
     * method converts User object to UserDto object
     * @param user
     * @return
     */
    public static UserDto fromUser(User user){
        UserDto userDto=new UserDto();
        userDto.setUserId(user.getUserId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        return userDto;
    }


    /**
     * method converts List of UserDtos to List of Users
     * @param userDtos
     * @return
     */
    public static List<User> fromUserDtoList(List<UserDto> userDtos){

        return (userDtos!=null && userDtos.size()!=0)?
                userDtos.stream().map(userDto->fromUserDto(userDto)).
                collect(Collectors.toList()):null;
    }

    /**
     * method converts List of Users to List of UserDtos
     * @param users
     * @return
     */
    public static List<UserDto> fromUserList(List<User> users){
        return (users!=null && users.size()!=0)?
                users.stream().map(user->fromUser(user)).
                        collect(Collectors.toList()):null;
    }


}
