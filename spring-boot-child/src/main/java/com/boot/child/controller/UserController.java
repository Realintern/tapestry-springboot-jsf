package com.boot.child.controller;

import com.boot.child.cutomexception.DataBaseException;
import com.boot.child.dto.UserDto;
import com.boot.child.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by manukg on 9/16/2016.
 */
@RestController
@RequestMapping(value = "/user/data")
public class UserController {

    private final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> addUserDto(@RequestBody UserDto userDto) throws DataBaseException {
        try {
            userService.addUserDto(userDto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception exp){
            LOGGER.error("[UserController][addUserDto] unable to save userdto object");
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/{userId}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> getUserById(@PathVariable(value = "userId") Long userId) throws DataBaseException {
        try {
            return new ResponseEntity<UserDto>(userService.getUserDtoById(userId),HttpStatus.OK);
        }catch (Exception exp){
            LOGGER.error("[UserController][getUserById] unable to get userDto by this userId:[{}]",userId);
            return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/all",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<UserDto>> getUserDtoList() throws DataBaseException {
        try {
            return new ResponseEntity<List<UserDto>>(userService.getUserDtoList(), HttpStatus.OK);
        }catch (Exception exp){
            LOGGER.error("[UserController][getUserDtoList] unable to get all userDtos");
            return new ResponseEntity<List<UserDto>>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateUserDto(@RequestBody UserDto userDto) throws DataBaseException {
        try {
            userService.updateUserDto(userDto);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception exp){
            LOGGER.error("[UserController][updateUserDto] unable to update userDto");
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @RequestMapping(value = "/delete/{userId}",method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUserDto(@PathVariable(value = "userId") Long userId) throws DataBaseException {
        try {
            userService.deleteUserDto(userId);
            return new ResponseEntity<Void>(HttpStatus.OK);
        }catch (Exception exp){
            LOGGER.error("[UserController][]deleteUserDto unable to delete userDto by this userId : [{}]",userId);
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
    }
    @RequestMapping(value = "/firstName/{firstName}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDto> findUserDtoByFirstName(@PathVariable(value = "firstName") String firstName) throws DataBaseException{
       try{
           return new ResponseEntity<UserDto>(userService.findUserDtoByFirstName(firstName),HttpStatus.OK);
       }catch (Exception exp){
           LOGGER.error("[UserController][findUserDtoByFirstName] unable to get userDto by firstName : [{}]",firstName);
           return new ResponseEntity<UserDto>(HttpStatus.NOT_FOUND);
       }
    }
}
