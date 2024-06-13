package com.wipro.ekartManagemet_1.Controllers;

import com.wipro.ekartManagemet_1.Dtos.UserDto;
import com.wipro.ekartManagemet_1.Services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private ServiceImpl service;



    @GetMapping("/check")
    public String check(){
        return "checking api";
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto dto = service.createUser(userDto);
        System.out.println(dto.getLastname());
            return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUserById(@RequestParam Long id){
        String s = service.deleteUser(id);
        return new ResponseEntity<>(s,HttpStatus.OK);
    }
    @GetMapping("/findBy")
    public UserDto findById( @RequestParam Long id){
        UserDto userById = service.getUserById(id);
        return userById;
    }
    @PostMapping("/updateUserByName")
   public UserDto updateUserByName(@Valid @RequestBody UserDto dto, @RequestParam String name){
        UserDto userDto = service.updateUserByname(dto, name);
        return userDto;

    }@GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDto>> getAllUsers(){
        List<UserDto> allUsers = service.getAllUsers();
        return new ResponseEntity<>(allUsers,HttpStatus.OK);
    }@GetMapping("/getUser")
    public ResponseEntity<UserDto> getUserById(@RequestParam Long id){
        UserDto userById = service.getUserById(id);
        return  new ResponseEntity<>(userById,HttpStatus.OK);
    }
    // @GetMapping("getByKeyWord")
    //public List<UserDto> getUserByKeyword(@RequestParam String keyword){
      //   List<UserDto> userDtoList = service.searchUser(keyword);
        //  return userDtoList;
     }


