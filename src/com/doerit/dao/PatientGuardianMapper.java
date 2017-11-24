package com.doerit.dao;

import com.doerit.model.PatientGuardian;
import com.doerit.model.PatientGuardianExample;
import com.doerit.model.PatientGuardianWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface PatientGuardianMapper {
    
    int countByExample(PatientGuardianExample example);
    int deleteByExample(PatientGuardianExample example);
    int deleteByPrimaryKey(String id);
    int insert(PatientGuardianWithBLOBs record);
    int insertSelective(PatientGuardianWithBLOBs record);
    List<PatientGuardianWithBLOBs> selectByExampleWithBLOBs(PatientGuardianExample example);
    List<PatientGuardian> selectByExample(PatientGuardianExample example);
    PatientGuardianWithBLOBs selectByPrimaryKey(String id);
    int updateByExampleSelective(@Param("record") PatientGuardianWithBLOBs record, @Param("example") PatientGuardianExample example);
    int updateByExampleWithBLOBs(@Param("record") PatientGuardianWithBLOBs record, @Param("example") PatientGuardianExample example);
    int updateByExample(@Param("record") PatientGuardian record, @Param("example") PatientGuardianExample example);
    int updateByPrimaryKeySelective(PatientGuardianWithBLOBs record);
    int updateByPrimaryKeyWithBLOBs(PatientGuardianWithBLOBs record);
    int updateByPrimaryKey(PatientGuardian record);

    @Select("SELECT * FROM tbl_patient_guardian WHERE PATIENT_ID = #{patientId}")
    @ResultMap("ResultMapWithBLOBs")
	List<PatientGuardianWithBLOBs> findByPatientId(@Param("patientId")String patientId);
}