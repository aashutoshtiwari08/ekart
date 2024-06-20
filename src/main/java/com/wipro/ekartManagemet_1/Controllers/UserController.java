package com.wipro.ekartManagemet_1.Controllers;

import com.wipro.ekartManagemet_1.ApiResponse.ApiResponseMessage;
import com.wipro.ekartManagemet_1.Dtos.UserDto;
import com.wipro.ekartManagemet_1.Services.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController()
@RequestMapping("/User")
public class UserController {

    @Autowired
    private ServiceImpl service;



    @GetMapping("/check")
    public String check(){
        return "checking api";
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponseMessage> createUser(@Valid @RequestBody UserDto userDto){
        UserDto dto = service.createUser(userDto);
        ApiResponseMessage message= ApiResponseMessage.builder().message("user created").status(HttpStatus.CREATED).build();

            return new ResponseEntity<>(message, HttpStatus.CREATED);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponseMessage> deleteUserById(@RequestParam Long id){
        String s = service.deleteUser(id);
        ApiResponseMessage message= ApiResponseMessage.builder().message("user deleted").status(HttpStatus.OK).build();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @GetMapping("/findBy")
    public ResponseEntity<ApiResponseMessage> findById( @RequestParam Long id){
        UserDto userById = service.getUserById(id);
        ApiResponseMessage message= ApiResponseMessage.builder().message("user found"+userById).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }
    @PostMapping("/updateUserByName")
   public ResponseEntity<ApiResponseMessage> updateUserByName(@Valid @RequestBody UserDto dto, @RequestParam String name){
        UserDto userDto = service.updateUserByname(dto, name);
        ApiResponseMessage message= ApiResponseMessage.builder().message("updated by name"+userDto).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message,HttpStatus.OK);

    }@GetMapping("/getAllUsers")
    public ResponseEntity<ApiResponseMessage> getAllUsers(){
        List<UserDto> allUsers = service.getAllUsers();
        ApiResponseMessage message= ApiResponseMessage.builder().message("all users"+allUsers).status(HttpStatus.OK).build();
        return new ResponseEntity<>(message,HttpStatus.OK);
    }@GetMapping("/getUser")
    public ResponseEntity<ApiResponseMessage> getUserById(@RequestParam Long id){
        UserDto userById = service.getUserById(id);
        ApiResponseMessage message= ApiResponseMessage.builder().message("user by id is "+userById).status(HttpStatus.OK).build();
        return  new ResponseEntity<>(message,HttpStatus.OK);
    }
    // @GetMapping("getByKeyWord")
    //public List<UserDto> getUserByKeyword(@RequestParam String keyword){
      //   List<UserDto> userDtoList = service.searchUser(keyword);
        //  return userDtoList;
     }


