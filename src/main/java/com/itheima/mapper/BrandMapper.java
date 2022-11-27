package com.itheima.mapper;

import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BrandMapper {

    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand(brand_name, company_name, ordered, description, status) VALUES (#{brandName}, #{companyName}, #{ordered}, #{description}, #{status})")
    void insertBrand(Brand brand);

    void deleteByIds(@Param("ids") int[] ids);

    List<Brand> selectByLimit(@Param("begin") int begin, @Param("size") int size);

    int selectCount();

    List<Brand> selectByPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("brand") Brand brand);

    int selectTotalCountByCondition(Brand brand);
}
