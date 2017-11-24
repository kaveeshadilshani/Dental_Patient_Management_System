package com.doerit.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Patient implements InsertUpdate {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private static final int NUMBER_OF_SURNAME_CHAR_STICKER = 19;
	
	private String id;
	private String serialNumber;
	private String fileNumber;
	private String title;
	private String surname;
	private String initials;
	private String firstName;
	private String nic;
	private String child;
	private Date dateOfBirth;
	private String sex;
	private String ethnicity;
	private String country;
	private String mobile;
	private String email;
	private String address;
	private String maritalStatus;
	private String comment;
	private String districtId = "14";
	private String districtName;
	private String provinceId;
	private String provinceName;
	private Byte status;
	private Integer sortOrder;
	private String insertUserId;
	private String updateUserId;
	private Date insertDatetime;
	private Date updateDatetime;	
	
	private String birthDayString;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber == null ? null : serialNumber.trim();
	}

	public String getFileNumber() {
		return fileNumber;
	}

	public void setFileNumber(String fileNumber) {
		this.fileNumber = fileNumber == null ? null : fileNumber.trim();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname == null ? null : surname.trim();
		
		if(this.surname != null && this.surname.length() > 1) {
			this.surname = Character.toUpperCase(
					this.surname.charAt(0)) + this.surname.substring(1).toLowerCase();
		}
	}

	public String getInitials() {
		return initials;
	}

	public void setInitials(String initials) {
		this.initials = initials == null ? null : initials.trim();
		
		if(this.initials != null) {
			this.initials = this.initials.toUpperCase();
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName == null ? null : firstName.trim();
		
		if(this.firstName != null && this.firstName.length() > 1) {
			this.firstName = Character.toUpperCase(
					this.firstName.charAt(0)) + this.firstName.substring(1).toLowerCase();
		}
	}

	public String getNic() {
		return nic;
	}

	public void setNic(String nic) {
		this.nic = nic == null ? null : nic.trim();
	}

	public String getChild() {
		return child;
	}

	public void setChild(String child) {
		this.child = child == null ? null : child.trim();
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex == null ? null : sex.trim();
	}

	public String getEthnicity() {
		return ethnicity;
	}

	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity == null ? null : ethnicity.trim();
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country == null ? null : country.trim();
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile == null ? null : mobile.trim();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus == null ? null : maritalStatus.trim();
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}

	public String getDistrictId() {
		return districtId;
	}

	public void setDistrictId(String districtId) {
		this.districtId = districtId == null ? null : districtId.trim();
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getInsertUserId() {
		return insertUserId;
	}

	public void setInsertUserId(String insertUserId) {
		this.insertUserId = insertUserId == null ? null : insertUserId.trim();
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId == null ? null : updateUserId.trim();
	}

	public Date getInsertDatetime() {
		return insertDatetime;
	}

	public void setInsertDatetime(Date insertDatetime) {
		this.insertDatetime = insertDatetime;
	}

	public Date getUpdateDatetime() {
		return updateDatetime;
	}

	public void setUpdateDatetime(Date updateDatetime) {
		this.updateDatetime = updateDatetime;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", serialNumber=" + serialNumber + ", fileNumber=" + fileNumber + ", title="
				+ title + ", surname=" + surname + ", initials=" + initials + ", firstName=" + firstName + ", nic="
				+ nic + ", child=" + child + ", dateOfBirth=" + dateOfBirth + ", sex=" + sex + ", ethnicity="
				+ ethnicity + ", country=" + country + ", mobile=" + mobile + ", email=" + email + ", address="
				+ address + ", maritalStatus=" + maritalStatus + ", comment=" + comment + ", districtId=" + districtId
				+", districtName=" + districtName
				+ ", status=" + status + ", sortOrder=" + sortOrder + ", insertUserId=" + insertUserId
				+ ", updateUserId=" + updateUserId + ", insertDatetime=" + insertDatetime + ", updateDatetime="
				+ updateDatetime + "]";
	}

	public String getBirthDayString() {
		if(this.dateOfBirth != null) {
			birthDayString = sdf.format(this.dateOfBirth);
		}
		return birthDayString;
	}

	public void setBirthDayString(String birthDayString) {
		this.birthDayString = birthDayString;
		
		if(this.birthDayString != null && !this.birthDayString.isEmpty()) {
			
			try {
				Date date = sdf.parse(this.birthDayString);
				this.dateOfBirth = date;
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			this.dateOfBirth = null;
		}
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	public String getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(String provinceId) {
		this.provinceId = provinceId;
	}
	
	public String getPrintName() {
		
		String title = "";
		String surname = "";
		String initials = "";
		
		if(this.getInitials() != null) {
			initials = this.getInitials();
		}
		
		if(this.getSurname() != null) {
			surname = this.getSurname();
		}
		
		if(this.getTitle() != null) {
			title = this.getTitle() + ".";
		}
		
		return title + " " + surname + " " + initials.toUpperCase();
	}
	
	public String getPrintNameForSticker() {
		
		String title = "";
		String surname = "";
		String initials = "";
		
		if(this.getInitials() != null) {
			initials = this.getInitials();
		}
		
		if(this.getSurname() != null) {
			surname = this.getSurname();
			
			if(surname.length() > NUMBER_OF_SURNAME_CHAR_STICKER) {
				surname = surname.substring(0, NUMBER_OF_SURNAME_CHAR_STICKER - 1) + ".";
			}
		}
		
		if(this.getTitle() != null) {
			title = this.getTitle() + ".";
		}
		
		return title + " " + surname + " " + initials.toUpperCase();
	}
	
	
}