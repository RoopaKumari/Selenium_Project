package com.training.bean;

public class LoginBean {
	
	private String UserName;
	private String Password;
	private String CategoryName;
	private String CategoryDescription;
	private String MetaTagTitle;
	private String MetaTagDescription;

	public LoginBean() {
	}

	public LoginBean(String UserName, String Password, String CategoryName, String CategoryDescription, String MetaTagTitle, String MetaTagDescription) {
		super();
		this.UserName = UserName;
		this.Password = Password;
		this.CategoryName = CategoryName;
		this.CategoryDescription = CategoryDescription;
		this.MetaTagTitle = MetaTagTitle;
		this.MetaTagDescription = MetaTagDescription;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String UserName) {
		this.UserName = UserName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String Password) {
		this.Password = Password;
	}

	public String getCategoryName() {
		return CategoryName;
	}

	public void setCategoryName(String CategoryName) {
		this.CategoryName = CategoryName;
	}

	public String getCategoryDescription() {
		return CategoryDescription;
	}

	public void setCategoryDescription(String CategoryDescription) {
		this.CategoryDescription = CategoryDescription;
	}
	
	public String getMetaTagTitle() {
		return MetaTagTitle;
	}

	public void setMetaTagTitle(String MetaTagTitle) {
		this.MetaTagTitle = MetaTagTitle;
	}
	
	public String getMetaTagDescription() {
		return MetaTagDescription;
	}

	public void setMetaTagDescription(String MetaTagDescription) {
		this.MetaTagDescription = MetaTagDescription;
	}
	
	
	@Override
	public String toString() {
		//return "LoginBean [UserName=" + UserName + ", Password=" + Password + "]";
		
		return "LoginBean [UserName=" + UserName + ", Password=" + Password + ", CategoryName=" + CategoryName + ", CategoryDescription=" + CategoryDescription + ", MetaTagTitle=" + MetaTagTitle + ", MetaTagDescription=" + MetaTagDescription + "]";

	}

}
