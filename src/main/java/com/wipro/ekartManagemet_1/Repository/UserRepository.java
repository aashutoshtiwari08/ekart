package com.wipro.ekartManagemet_1.Repository;

import com.wipro.ekartManagemet_1.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{

}
