package com.wipro.ekartManagemet_1.Controllers;

import com.wipro.ekartManagemet_1.Dtos.CategoryDto;
import com.wipro.ekartManagemet_1.Services.CatogeryService;
import com.wipro.ekartManagemet_1.Services.CatogeryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/Category")
public class CategoryController {
    @Autowired
    private CatogeryServiceImpl service;
    //create
    @PostMapping("/create")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto dto){
        CategoryDto categoryDto = service.create(dto);
        System.out.println("dto data"+categoryDto);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);

    }


    //update
    @PostMapping("/update")
    public ResponseEntity<CategoryDto> updateById(@RequestBody CategoryDto dto, @RequestParam Long id){
        CategoryDto categoryDto = service.updateByid(dto, id);
        return new ResponseEntity<>(categoryDto,HttpStatus.ACCEPTED);
    }

    //getById
    @GetMapping("/getByID")
  public ResponseEntity<CategoryDto> getByid(@RequestParam Long  id){
      CategoryDto byId = service.getById(id);
      return new ResponseEntity<>(byId,HttpStatus.OK);

  }
    //getAll
    @GetMapping("/getAll")
 public ResponseEntity<List<CategoryDto>> getAllCategory(){
     List<CategoryDto> all = service.getAll();
     return new ResponseEntity<>(all,HttpStatus.OK);
 }
    //updateById








}
