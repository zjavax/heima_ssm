package com.itheima.ssm.dao;

import com.itheima.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IProductDao {

    @Select("select * from product")
    public List<Product> findAll() throws Exception;

    @Insert("insert into product(productNum,productName,cityName,departureTime," +
            "productPrice,productDesc,productStatus) values (#{productNum},#{productName}" +
            ", #{cityName}, #{departureTime}, #{productPrice}, #{productDesc}, #{productStatus})")
    void save(Product product);


    @Select("select * from product where id = #{id}")
    Product findById(String id);


    /**
     * 根据指定id开启对应的状态
     * @param id
     */

    @Update("update product set productStatus = 1 where id = #{id}")
    void open(String id);
}

