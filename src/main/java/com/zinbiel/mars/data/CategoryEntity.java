package com.zinbiel.mars.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elias on 04.09.17.
 */

@Entity
@Table(name = "category", schema = "springtmp", catalog = "")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class)
public class CategoryEntity extends GeneralDataEntity {
    @JsonIgnore
    private static final Logger logger = LoggerFactory.getLogger(CategoryEntity.class);

    private Boolean active;

    private String string1;
    private String string2;
    private List<ProductEntity> products = new ArrayList<>();

    public CategoryEntity() {
    }

    @Basic
    @Column(name = "active", nullable = true)
    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }


    @Basic
    @Column(name = "stringone", nullable = true, length = 255)
    public String getString1() {
        return string1;
    }

    public void setString1(String string1) {
        this.string1 = string1;
    }

    @Lob
    @Column(name = "stringtwo", nullable = true, length = 10000)
    public String getString2() {
        return string2;
    }

    public void setString2(String string2) {
        this.string2 = string2;
    }

    @ManyToMany(mappedBy = "categories")
    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }

}
