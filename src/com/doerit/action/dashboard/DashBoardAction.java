package com.doerit.action.dashboard;

import com.doerit.action.AbstractManagementAction;
import com.doerit.exception.SessionNotExist;

public class DashBoardAction extends AbstractManagementAction {

	private static final long serialVersionUID = 1L;

	public String index() {
		return SUCCESS;
	}
	
	public String reports() {
		return SUCCESS;
	}
	
	public String dashBoard() {
		
		String userRole = null;
		boolean isPatientAuthorizer = false;
		try {
			userRole = getUserRole();
			isPatientAuthorizer = authorizeVisits();
			
			if (userRole.equals("EMPLOYEE") && isPatientAuthorizer) {
				System.out.println("auth emp login");
				authEmployeeDashboard();
				
				return "AUTHORIZED "+userRole;
				
			} else if( userRole.equals("EMPLOYEE") ) {
				System.out.println("auth emp login");
				employeeDashboard();
				
				return userRole;
				
			} else if (userRole.equals("PATIENT")) {
				userDashboard();
				return userRole;
				
			} else if (userRole.equals("DEPARTMENT")) {
				departmentDashboard();
				
				return userRole;
			} 
			
		} catch (SessionNotExist e) {
			e.printStackTrace();
		}
				
		return userRole;
	}

	private void authEmployeeDashboard() {
		
	}

	private void departmentDashboard() {
	}

	private void employeeDashboard() { 
	}
	
	private void userDashboard() {
				
	}
	
}
