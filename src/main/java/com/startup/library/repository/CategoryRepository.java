package com.startup.library.repository;

import com.startup.library.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,String> {
    Category findBySubjectCategory(String subject);
}
