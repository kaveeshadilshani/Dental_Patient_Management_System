package com.doerit.dao;

import com.doerit.model.ActivityLogger;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

public interface ActivityLoggerMapper {

	@Select("SELECT * FROM tbl_activity_logger ORDER BY INSERT_DATETIME desc limit #{size}")
	@ResultMap("BaseResultMap")
	List<ActivityLogger> findLatest(@Param("size") int size);
	
	@Select("SELECT * FROM tbl_activity_logger WHERE INSERT_USER_ID = #{insertUserId} ORDER BY INSERT_DATETIME desc limit #{size}")
	@ResultMap("BaseResultMap")
	List<ActivityLogger> findLatestByInsertUserId(@Param("size") int size, @Param("insertUserId")String insertUserId);

	@Select("SELECT * FROM tbl_activity_logger WHERE MESSAGE_TYPE = \'SIGN_IN\' ORDER BY INSERT_DATETIME DESC limit #{size}")
	@ResultMap("BaseResultMap")
	List<ActivityLogger> findLatestSignIn(@Param("size") int size);

	@Select("SELECT * FROM tbl_activity_logger WHERE MESSAGE_TYPE = #{type} ORDER BY INSERT_DATETIME DESC limit #{size}")
	@ResultMap("BaseResultMap")
	List<ActivityLogger> findLatestRequestsByType(@Param("size") int size, @Param("type")String type);
	
	int deleteByPrimaryKey(String id);

	int insert(ActivityLogger record);

	int insertSelective(ActivityLogger record);

	ActivityLogger selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(ActivityLogger record);

	int updateByPrimaryKeyWithBLOBs(ActivityLogger record);

	int updateByPrimaryKey(ActivityLogger record);
}