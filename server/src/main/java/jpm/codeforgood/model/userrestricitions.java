package jpm.codeforgood.model;

public class userrestricitions {
	
	private String User_UniqueID;
	private String Gender;
	private String Age;
	private String Religion;
	
	
	public userrestricitions(String user_UniqueID, String gender, String age,
			String religion) {
		super();
		User_UniqueID = user_UniqueID;
		Gender = gender;
		Age = age;
		Religion = religion;
	}
	
	
	public String getUser_UniqueID() {
		return User_UniqueID;
	}
	public void setUser_UniqueID(String user_UniqueID) {
		User_UniqueID = user_UniqueID;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAge() {
		return Age;
	}
	public void setAge(String age) {
		Age = age;
	}
	public String getReligion() {
		return Religion;
	}
	public void setReligion(String religion) {
		Religion = religion;
	}

}
