package com.tapestry5.child.pages;


import com.boot.child.dto.UserDto;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.InjectPage;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.Form;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/**
 * Created by manukg on 9/16/2016.
 */
public class ViewUsers {
    private final String USERS="http://localhost:9098/user/data/all";
    private final String DELETE_USERS="http://localhost:9098/user/data/delete/";


    @Property
    private List<UserDto> userDtos;

    @Property
    private UserDto userDto;

    @InjectPage
    private ChangeUser changeUser;

    @Component
    private Form userForm;

    public List<UserDto> fillUserDtoList(){
        RestTemplate restTemplate=new RestTemplate();
        UserDto[] forObject = restTemplate.getForObject(USERS, UserDto[].class);
        return Arrays.asList(forObject);
    }

    public void setupRender(){
        if(userDtos==null){
            userDtos= fillUserDtoList();
        }
    }

    public Object onEdit(Long userId){
        changeUser.set(userId);
        return ChangeUser.class;
    }

    public Object onDelete(String userId){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.delete(DELETE_USERS+userId);
        return this;
    }

}
