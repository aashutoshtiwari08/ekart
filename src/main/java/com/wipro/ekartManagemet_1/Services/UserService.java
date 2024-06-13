package com.wipro.ekartManagemet_1.Services;

import com.wipro.ekartManagemet_1.Dtos.UserDto;

import java.util.List;

public interface UserService {

    //create
    public UserDto createUser(UserDto userDto);

    UserDto updateUserByname(UserDto userDto, String name);

    //update
 //   public UserDto updateUserByname(UserDto userDto,String name);
    //delete by Id
    public String deleteUser(Long id);
    //getall
    public List<UserDto> getAllUsers();

    //getById
    public UserDto getUserById(Long id);

    //search User
  //  public List<UserDto> searchUser(String keyword);
}
