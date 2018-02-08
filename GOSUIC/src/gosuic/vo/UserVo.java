package gosuic.vo;

public class UserVo {

	String userEmail;
	String userID;
	String password1;
	String userName;
	String userBirthday;
	String userGender;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserBirthday() {
		return userBirthday;
	}
	public void setUserBirthday(String userBirthday) {
		this.userBirthday = userBirthday;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	@Override
	public String toString() {
		return "UserDTO [userEmail=" + userEmail + ", userID=" + userID + ", password1=" + password1 + ", userName="
				+ userName + ", userBirthday=" + userBirthday + ", userGender=" + userGender + "]";
	}
	
	
	
}
