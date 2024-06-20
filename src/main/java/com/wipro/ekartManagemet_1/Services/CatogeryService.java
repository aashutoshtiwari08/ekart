package com.wipro.ekartManagemet_1.Services;

import com.wipro.ekartManagemet_1.Dtos.CategoryDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatogeryService {

    //create
    public CategoryDto create(CategoryDto categeryDto);


    //update
  public CategoryDto updateByid(CategoryDto categeryDto, Long id);

    //delete
  public void deleteByid(Long id);

    //find all
   public List<CategoryDto> getAll();
    //find one

    public CategoryDto getById(Long id);

}
