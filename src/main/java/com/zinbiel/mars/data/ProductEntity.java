package com.zinbiel.mars.data;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.zinbiel.mars.attributes.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by elias on 04.09.17.
 */
@Entity
@Table(name = "product", schema = "springtmp", catalog = "")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class)
public class ProductEntity extends GeneralDataEntity {
    @JsonIgnore
    private static final Logger logger = LoggerFactory.getLogger(ProductEntity.class);

    private Boolean active;

    private String string1;
    private String string2;
    private Integer int1;
    private Integer int2;
    private Float float1;
    private List<CategoryEntity> categories = new ArrayList<>();

    private Price price;

    public ProductEntity() {
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

    @Basic
    @Column(name = "intone", nullable = true)
    public Integer getInt1() {
        return int1;
    }

    public void setInt1(Integer int1) {
        this.int1 = int1;
    }

    @Basic
    @Column(name = "inttwo", nullable = true)
    public Integer getInt2() {
        return int2;
    }

    public void setInt2(Integer int2) {
        this.int2 = int2;
    }

    @Basic
    @Column(name = "floatme", nullable = true)
    public Float getFloat1() {
        return float1;
    }

    public void setFloat1(Float float1) {
        this.float1 = float1;
    }

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "currency")),
            @AttributeOverride(name = "price", column = @Column(name = "price"))
    })
    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }

    @ManyToMany
    public List<CategoryEntity> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryEntity> categories) {
        this.categories = categories;
    }
}
