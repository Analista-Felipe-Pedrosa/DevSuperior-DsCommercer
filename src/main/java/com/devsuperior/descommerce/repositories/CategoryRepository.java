package com.devsuperior.descommerce.repositories;

import com.devsuperior.descommerce.entities.Category;
import com.devsuperior.descommerce.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
