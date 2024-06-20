package com.wipro.ekartManagemet_1.Repository;

import com.wipro.ekartManagemet_1.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
