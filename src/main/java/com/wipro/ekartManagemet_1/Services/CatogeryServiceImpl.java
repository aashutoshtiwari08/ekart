package com.wipro.ekartManagemet_1.Services;

import com.wipro.ekartManagemet_1.Dtos.CategoryDto;
import com.wipro.ekartManagemet_1.Entities.Category;
import com.wipro.ekartManagemet_1.Repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CatogeryServiceImpl implements CatogeryService{
    @Autowired
    private CategoryRepository repository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public CategoryDto create(CategoryDto categeryDto) {
        Category entity = mapper.map(categeryDto, Category.class);
        System.out.println(entity);
        Category savedEntity = repository.save(entity);
        return mapper.map(savedEntity,CategoryDto.class);
    }

    @Override
    public CategoryDto updateByid(CategoryDto categeryDto, Long id) {
        Category found = repository.findById(id).orElseThrow(() -> new RuntimeException("id not available"));
        // found.setCatogery_id(categeryDto.getId());
         found.setCatogery_name(categeryDto.getCatogery_name());
         found.setDescription(categeryDto.getDescription());
        Category saved = repository.save(found);
        CategoryDto saveddto = mapper.map(saved, CategoryDto.class);
        return saveddto;
    }

    @Override
    public void deleteByid(Long id) {

        Category foundEntity = repository.findById(id).orElseThrow(() -> new RuntimeException("id does not exists"));
           repository.delete(foundEntity);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<CategoryDto> dtoList= new ArrayList<>();
        List<Category> all = repository.findAll();
        for (Category entity: all){
            CategoryDto dtoData = mapper.map(entity, CategoryDto.class);
            dtoList.add(dtoData);
        }
        return dtoList;
    }

    @Override
    public CategoryDto getById(Long id) {
        Category entity = repository.findById(id).orElseThrow(() -> new RuntimeException("id does not exist"));


        return mapper.map(entity, CategoryDto.class);
    }
}
