package com.wipro.ekartManagemet_1.Services;


import com.wipro.ekartManagemet_1.Dtos.UserDto;
import com.wipro.ekartManagemet_1.Entities.UserEntity;
import com.wipro.ekartManagemet_1.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ServiceImpl implements UserService{
    @Autowired
    private UserRepository UserRepo;
    @Autowired
    private ModelMapper map;

    @Override
    public UserDto createUser(UserDto userDto) {
        UserEntity entity = map.map(userDto, UserEntity.class);
        UserEntity saved = UserRepo.save(entity);
        UserDto dto = map.map(saved, UserDto.class);
        return dto;
    }
 // Update User By Name
    @Override
    public UserDto updateUserByname(UserDto userDto, String name) {
        return null;
    }
//delete User ById
    @Override
    public String deleteUser(Long id) {
        UserEntity userEntity = UserRepo.findById(id).orElseThrow(() -> new RuntimeException("id does not exists"));
        UserRepo.delete(userEntity);

        return "deleted";
    }
//get All User
    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> dtoList=new ArrayList<>();
        List<UserEntity> all = UserRepo.findAll();
       for(UserEntity ent:all)
       {
           UserDto userDto = entTodto(ent);
           dtoList.add(userDto);

       }
        return dtoList;
    }
//get User By Id
    @Override
    public UserDto getUserById(Long id) {
        UserEntity userEntity = UserRepo.findById(id).orElseThrow(() -> new RuntimeException("user does not exists"));
        UserDto userDto = entTodto(userEntity);
        return userDto;
    }

public UserDto entTodto(UserEntity ent){

    UserDto dto = map.map(ent, UserDto.class);
    return dto;
}
public UserEntity dtoToent(UserDto dto){
    UserEntity ent = map.map(dto, UserEntity.class);
   return ent;
}
}


