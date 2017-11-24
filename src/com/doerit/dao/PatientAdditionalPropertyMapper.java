package com.doerit.dao;

import com.doerit.model.PatientAdditionalProperty;
import com.doerit.model.PatientAdditionalPropertyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface PatientAdditionalPropertyMapper {
    
    int countByExample(PatientAdditionalPropertyExample example);
    int deleteByExample(PatientAdditionalPropertyExample example);
    int deleteByPrimaryKey(String id);
    int insert(PatientAdditionalProperty record);
    int insertSelective(PatientAdditionalProperty record);
    List<PatientAdditionalProperty> selectByExample(PatientAdditionalPropertyExample example);
    PatientAdditionalProperty selectByPrimaryKey(String id);
    int updateByExampleSelective(@Param("record") PatientAdditionalProperty record, @Param("example") PatientAdditionalPropertyExample example);
    int updateByExample(@Param("record") PatientAdditionalProperty record, @Param("example") PatientAdditionalPropertyExample example);
    int updateByPrimaryKeySelective(PatientAdditionalProperty record);
    int updateByPrimaryKey(PatientAdditionalProperty record);
    
    @Select("SELECT * FROM tbl_patient_property WHERE PATIENT_ID = #{patientId}")
    @ResultMap("BaseResultMap")
    List<PatientAdditionalProperty> findByPatientId(@Param("patientId")String patientId);
}