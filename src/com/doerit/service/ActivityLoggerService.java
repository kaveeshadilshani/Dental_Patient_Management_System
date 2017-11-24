package com.doerit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doerit.dao.ActivityLoggerMapper;
import com.doerit.model.ActivityLogger;

@Service
public class ActivityLoggerService extends AbstractService {

	@Autowired
	private ActivityLoggerMapper activityLoggerMapper;

	public int save(ActivityLogger activityLog) {
		return activityLoggerMapper.insert(activityLog);
	}

	public List<ActivityLogger> findLatest(int size) {
		return activityLoggerMapper.findLatest(size);
	}
	
	public List<ActivityLogger> findLatestByInsertUserId(int size, String insertUserId) {
		return activityLoggerMapper.findLatestByInsertUserId(size, insertUserId);
	}

	
	public List<ActivityLogger> findLatestSignIn(int size) {
		return activityLoggerMapper.findLatestRequestsByType(size, ActivityLogger.MessageType.SIGN_IN.toString());
	}

	public int insert(ActivityLogger logger) {
		return activityLoggerMapper.insert(logger);
	}
	
	public List<ActivityLogger> findLatestByUserId(int size, String id) {
		return activityLoggerMapper.findLatest(size);
	}
	
}
