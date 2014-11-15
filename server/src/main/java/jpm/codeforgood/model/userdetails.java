package jpm.codeforgood.model;

public class userdetails {

	private String User_UniqueID;
	private String User;
	private String Username;
	private String Age;
	private String Gender;
	private String Religion;
	private String CountryCode;
	private String PhoneNo;
	
	
	public userdetails(String user_UniqueID, String user, String username,
			String age, String gender, String religion, String countryCode,
			String phoneNo) {
		super();
		User_UniqueID = user_UniqueID;
		User = user;
		Username = username;
		Age = age;
		Gender = gender;
		Religion = religion;
		CountryCode = countryCode;
		PhoneNo = phoneNo;
	}
	
	
	public String getUser_UniqueID() {
		return User_UniqueID;
	}
	public void setUser_UniqueID(String user_UniqueID) {
		User_UniqueID = user_UniqueID;
	}
	public String getUser() {
		return User;
	}
	public void setUser(String user) {
		User = user;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getReligion() {
		return Religion;
	}
	public void setReligion(String religion) {
		Religion = religion;
	}
	public String getCountryCode() {
		return CountryCode;
	}
	public void setCountryCode(String countryCode) {
		CountryCode = countryCode;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	
}
