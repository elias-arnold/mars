package com.zinbiel.mars.dao;

import com.zinbiel.mars.data.CategoryEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

/**
 * Created by elias on 04.09.17.
 */
@RepositoryRestResource(collectionResourceRel = "category", path = "category")
public interface CategoryDao extends PagingAndSortingRepository<CategoryEntity, UUID> {

}
