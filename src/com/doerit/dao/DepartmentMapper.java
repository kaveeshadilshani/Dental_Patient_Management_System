package com.doerit.dao;

import com.doerit.model.Department;
import com.doerit.model.DepartmentExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface DepartmentMapper {

	int countByExample(DepartmentExample example);
    int deleteByExample(DepartmentExample example);
    int deleteByPrimaryKey(String id);
    int insert(Department record);
    int insertSelective(Department record);
    List<Department> selectByExample(DepartmentExample example);
    Department selectByPrimaryKey(String id);
    int updateByExampleSelective(@Param("record") Department record, @Param("example") DepartmentExample example);
    int updateByExample(@Param("record") Department record, @Param("example") DepartmentExample example);
    int updateByPrimaryKeySelective(Department record);
    int updateByPrimaryKey(Department record);

    @Select("SELECT * FROM tbl_department WHERE STATUS = {#state}")
    @ResultMap("BaseResultMap")
	List<Department> findAllActive(@Param("state")byte state);
}