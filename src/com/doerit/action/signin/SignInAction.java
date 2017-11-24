package com.doerit.action.signin;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.doerit.action.AbstractManagementAction;
import com.doerit.exception.SessionNotExist;
import com.doerit.model.Employee;
import com.doerit.model.UserAccount;
import com.doerit.model.ActivityLogger.MessageType;
import com.doerit.model.Department;
import com.doerit.service.DepartmentService;
import com.doerit.service.EmployeeService;
import com.doerit.service.UserAccountService;
import com.doerit.util.SessionKey;
import com.doerit.util.SessionUser;

public class SignInAction extends AbstractManagementAction {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(SignInAction.class);

	@Autowired private UserAccountService userAccountService;
	@Autowired private EmployeeService employeeService;
	private UserAccount userAccount;

	public String myProfile() throws SessionNotExist {

		/*
		 * user = userAccountService.viewByEmail(getSessionUser().getEmail());
		 * 
		 * populateViewContent(); employee =
		 * employeeService.viewByIdForUniqueResult(user.getClientId());
		 * 
		 * if(employee == null) { addActionError("Your account not found");
		 * return INPUT; }
		 */
		return SUCCESS;
	}

	public String signIn() {

		try {

			clearSessionVariables();

			if (userAccount == null || validateSignIn()) {
				return signInError();
			}

			userAccount = userAccountService.viewByEmailAndPassword(userAccount.getUserName(), userAccount.getUserPassword());
			if (userAccount == null) {
				addActionError("Invalid credentials");
				return INPUT;
			}

			SessionUser su = getSessionUser(userAccount);

			if (su == null) {
				addActionError("User not found in the respective user category");
				return INPUT;
			} else {
				
				
				if(userAccount.getCategoryRelationId().equals("EMPLOYEE")) {
					
					String foreignKey = userAccount.getRelationId();
					
					Employee employee = employeeService.viewById(foreignKey);

					if(employee != null) {
						su.setRole("EMPLOYEE");
						su.setRoleName(employee.getUserRole());
						su.setName(employee.getFirstName() + " " + employee.getSurname());
						su.setDepartment(employee.getDepartment());
						
						addSessionUser(su);
						
						addLoggerMessage("tbl_user_account", MessageType.SIGN_IN.toString(),
								"SUCCESS", "Email: " + su.getName() + ", Host: " + ServletActionContext.getRequest().getRemoteHost());
						
					} else {
						addActionError("Employee does not exist in the employee repo");
						return INPUT;
					}
				}
				
				if(userAccount.getCategoryRelationId().equals("DEPARTMENT")) {
					
					String foreignKey = userAccount.getRelationId();
					
					Employee employee = employeeService.viewById(foreignKey);

					if(employee != null) {
						su.setRole("DEPARTMENT");
						su.setRoleName(employee.getUserRole());
						su.setName(employee.getFirstName() + " " + employee.getSurname());
						su.setDepartment(employee.getDepartment());
						addSessionUser(su);
						
						addLoggerMessage("tbl_user_account", MessageType.SIGN_IN.toString(),
								"SUCCESS", "Email: " + su.getName() + ", Host: " + ServletActionContext.getRequest().getRemoteHost());
						
					} else {
						addActionError("Department does not exist in the employee repo");
						return INPUT;
					}
				}
				
				/*				else if(userAccount.getCategoryRelationId().equals("DEPARTMENT")) {
					
					String foreignKey = userAccount.getRelationId();
					
					//Employee employee = employeeService.viewById(foreignKey);
					Department department = departmentService.viewById(foreignKey);

					if(department != null) {
						su.setRole("DEPARTMENT");
						su.setRoleName(department.getUserRole());
						su.setName(department.getName());
						addSessionUser(su);
						
						addLoggerMessage("tbl_user_account", MessageType.SIGN_IN.toString(),
								"SUCCESS", "Email: " + su.getName() + ", Host: " + ServletActionContext.getRequest().getRemoteHost());
						
					} else {
						addActionError("Department does not exist in the department repo");
						return INPUT;
					}
				}*/				
				
				/*addLoggerMessage(su.getId(), ActivityLogger.MessageType.SIGN_IN.toString(), "Web Application",
						su.getEmail());*/
				return SUCCESS;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			return signInError();
		}
	}

	private String signInError() {
		addActionError("Invalid authentication");
		return INPUT;
	}

	public String changePassword() {
		return SUCCESS;
	}

	protected SessionUser getSessionUser(UserAccount user) {

		SessionUser sessionUser = new SessionUser();
		sessionUser.setUserId(user.getId());
		sessionUser.setEmail(user.getUserName());
		
		

		return sessionUser;
	}

	public String signOut() {

		clearSessionVariables();

		return SUCCESS;
	}

	private void clearSessionVariables() {
		try {
			removeSessionVariable(SessionKey.SESSION_USER);
			removeSessionVariable(SessionKey.RESPONSE);
			removeSessionVariable(SessionKey.HISTORY_ACTION);

		} catch (SessionNotExist e) {
			logger.error(e);
		}
	}

	private boolean validateSignIn() {
		if (this.userAccount.getUserName().isEmpty()) {
			addFieldError("user.email", "Email cannot be empty");
		}

		if (this.userAccount.getUserPassword().isEmpty()) {
			addFieldError("user.userPassword", "Password cannot be empty");
		}

		return hasErrors();
	}

	public String forgotPassword() {
		return SUCCESS;
	}

	public String passwordRequest() {
		return SUCCESS;
	}

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

}
