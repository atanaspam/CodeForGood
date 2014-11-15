package jpm.codeforgood.model;

public class logininfo {
	private String User_UniqueID;
	private String Name;
	private String Surname;
	private String Username;
	private String Password;
	private String Rank;
	private String Moderator;
	public String getUser_UniqueID() {
		return User_UniqueID;
	}
	public void setUser_UniqueID(String user_UniqueID) {
		User_UniqueID = user_UniqueID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getRank() {
		return Rank;
	}
	public void setRank(String rank) {
		Rank = rank;
	}
	public String getModerator() {
		return Moderator;
	}
	public void setModerator(String moderator) {
		Moderator = moderator;
	}
	
	public logininfo(String user_UniqueID, String name, String surname,
			String username, String password, String rank, String moderator) {
		super();
		User_UniqueID = user_UniqueID;
		Name = name;
		Surname = surname;
		Username = username;
		Password = password;
		Rank = rank;
		Moderator = moderator;
	}
	
}