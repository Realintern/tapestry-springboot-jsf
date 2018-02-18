package com.tapestry5.child.pages;

import com.boot.child.dto.UserDto;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.springframework.web.client.RestTemplate;

/**
 * Created by manukg on 9/16/2016.
 */
public class ChangeUser {

    public static Long userId;
    private final String GET_USER_BY_ID="http://localhost:9098/user/data/";
    private final String UPDATE_USER_DTO="http://localhost:9098/user/data/update";

    @Property
    @Persist
    private UserDto userDto;

    public static Long getUserId() {
        return userId;
    }

    public void set(Long id) {
        userId = id;
    }

    public void setupRender(){
        if(userDto==null) {
            RestTemplate restTemplate = new RestTemplate();
            userDto = restTemplate.getForObject(GET_USER_BY_ID + userId, UserDto.class);
        }
    }

    public Object onSuccessFromChangeForm(){
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.put(UPDATE_USER_DTO,userDto,UserDto.class);
        return ViewUsers.class;
    }
}
