package com.doerit.dao;

import com.doerit.model.DistrictRegistrationMapper;
import com.doerit.model.Patient;
import com.doerit.model.PatientExample;
import com.doerit.model.criteria.SearchCriteria;
import com.doerit.model.TotalRegistrations;
import com.doerit.util.Pager;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface PatientMapper {
  
    int countByExample(PatientExample example);
    int deleteByExample(PatientExample example);
    int deleteByPrimaryKey(String id);
    int insert(Patient record);
    int insertSelective(Patient record);
    List<Patient> selectByExample(PatientExample example);
    
    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);
    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);
    int updateByPrimaryKeySelective(Patient record);
    int updateByPrimaryKey(Patient record);

    @Select("SELECT c.*, d.NAME as DISTRICT_NAME, p.NAME as PROVINCE_NAME " + 
    		" FROM tbl_patient c LEFT JOIN tbl_district d " +  
    		" ON c.DISTRICT_ID = d.ID LEFT JOIN tbl_province p " + 
    		" ON d.PROVINCE_ID = p.ID  WHERE c.ID = #{id}")
    @ResultMap("BaseResultMap")
    Patient viewByPrimaryKey(@Param("id")String id);
    
    @Select("SELECT COUNT(*) AS total,"+
    		" SUM(sex='male') AS maleTotal," +
    		" SUM(sex='female') AS femaleTotal," +
    		" SUM(child='true') AS childTotal" +
    		" FROM tbl_patient" +
    		" WHERE INSERT_DATETIME LIKE '${date}"+"%'")
    @ResultMap("totalResultMap")
    TotalRegistrations viewTotalByDate(@Param("date")String date);
    
    @Select("SELECT COUNT(*) AS total,"+
    		" SUM(sex='male') AS maleTotal," +
    		" SUM(sex='female') AS femaleTotal," +
    		" SUM(child='true') AS childTotal" +
    		" FROM tbl_patient" +
    		" WHERE INSERT_DATETIME BETWEEN '${sDate}"+"%' AND '${eDate}" + "%'")
    @ResultMap("totalResultMap")
    TotalRegistrations viewTotalBetweenDates(@Param("sDate")String s_date, @Param("eDate")String e_date);
    
    @Select("SELECT d.NAME, s.total FROM " + 
    		"(SELECT p.DISTRICT_ID AS district, COUNT(p.DISTRICT_ID) AS total FROM tbl_patient p " +
    		"WHERE p.INSERT_DATETIME BETWEEN '${sDate}%' AND '${eDate}%' GROUP BY district) s " +
    		"RIGHT OUTER JOIN tbl_district d ON s.district=d.ID")
    @ResultMap("totalDistrictRegMap")
    List<DistrictRegistrationMapper> viewDistrictBetweenTotals(@Param("sDate")String s_date, @Param("eDate")String e_date);
    
    @Select("SELECT s2.NAME, s.total FROM" + 
    		" (SELECT DATE_FORMAT(INSERT_DATETIME, '${pattern}') AS date, DISTRICT_ID AS district, COUNT(*) AS total FROM tbl_patient c" +
    		" GROUP BY date,district HAVING date LIKE '${date}" + "%') s" + 
    		" RIGHT JOIN (SELECT ID, NAME FROM tbl_district) s2 ON s.district=s2.ID")
    @ResultMap("totalDistrictRegMap")
    List<DistrictRegistrationMapper> viewDistrictTotals(@Param("date")String date, @Param("pattern")String pattern);
    
    // SELECT d.NAME, count(p.DISTRICT_ID) AS total FROM tbl_patient p left join tbl_district d on d.ID = p.DISTRICT_ID WHERE p.INSERT_DATETIME BETWEEN '2017-08-14%' AND '2017-08-20' GROUP BY p.DISTRICT_ID;
    
    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.STATUS = #{status} " + 
    		" ORDER BY INSERT_DATETIME DESC " +
    		" LIMIT #{pager.start}, #{pager.limit}")
    @ResultMap("BaseResultMap")
	List<Patient> viewAllByStatus(@Param("pager")Pager pager,  @Param("status")byte status);
    
    @Select("SELECT count(0) " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.STATUS = #{status}")
	Integer countAllByStatus(@Param("status")byte status);
    
    @Select("SELECT count(0) " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.INSERT_DATETIME LIKE '${dateValue}"+"%'" )
	Integer countAllByDate(@Param("dateValue")String date);


    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.SURNAME LIKE #{surname} AND c.STATUS = #{status}")
    @ResultMap("BaseResultMap")
	List<Patient> search(@Param("surname")String searchWord, @Param("status")byte databaseValue);

    @Select("SELECT count(*) FROM tbl_patient WHERE SERIAL_NUMBER LIKE #{yearMonthPrefix}")
    Integer findMonthlyRegistrations(@Param("yearMonthPrefix")String serialPrefix);
	
    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.SERIAL_NUMBER LIKE #{searchValue} AND c.STATUS = #{status}")
    @ResultMap("BaseResultMap")
    List<Patient> searchBySerial(@Param("searchValue")String likeSearchValue, @Param("status")byte databaseValue);
    
    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.SURNAME LIKE #{searchValue} AND c.STATUS = #{status}")
    @ResultMap("BaseResultMap")
    List<Patient> searchBySurname(@Param("searchValue")String likeSearchValue, @Param("status")byte databaseValue);
    
    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.FIRST_NAME LIKE #{searchValue} AND c.STATUS = #{status}")
    @ResultMap("BaseResultMap")
    List<Patient> searchByFirstName(@Param("searchValue")String likeSearchValue, @Param("status")byte databaseValue);

    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.NIC LIKE #{searchValue} AND c.STATUS = #{status}")
    @ResultMap("BaseResultMap")
    List<Patient> searchByNic(@Param("searchValue")String likeSearchValue, @Param("status")byte databaseValue);    
    
    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.MOBILE LIKE #{searchValue} AND c.STATUS = #{status}")
    @ResultMap("BaseResultMap")
    List<Patient> searchByMobile(@Param("searchValue")String likeSearchValue, @Param("status")byte databaseValue);
    
    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.EMAIL LIKE #{searchValue} AND c.STATUS = #{status}")
    @ResultMap("BaseResultMap")
    List<Patient> searchByEmail(@Param("searchValue")String likeSearchValue, @Param("status")byte databaseValue);
	
    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.INSERT_DATETIME LIKE '${date}"+"%'")
    @ResultMap("BaseResultMap")
    List<Patient> viewAllByDate(@Param("date")String date);
    
    @Select("SELECT c.* " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.INSERT_DATETIME BETWEEN '${s_date}"+"%' AND " + "'${e_date}" + "%'")
    @ResultMap("BaseResultMap")
    List<Patient> viewBySelectedDate(@Param("s_date")String s_date, @Param("e_date")String e_date);
    
    @Select("SELECT c.*  " + 
    		" FROM tbl_patient c " +  
    		" WHERE c.INSERT_DATETIME LIKE '${date}"+"%'" )
    @ResultMap("BaseResultMap")
	List<? extends Object> viewAllByDateAndPage(@Param("pager")Pager p, @Param("date")String date);
	
    
    
	
}
