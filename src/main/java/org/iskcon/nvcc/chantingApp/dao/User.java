package org.iskcon.nvcc.chantingApp.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * User
 */
@Entity
@Table(schema = "JaiNrisimha", name = "user")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -190296968762303053L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private Integer userId;

	/**
	 * 
	 */
	@Column(name = "Name")
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "Mobile")
	private String mobile;

	@Column(name = "CreationDate")
	private Date creationDate;

	@Column(name = "LastLoginDate")
	private Date lastLoginDate;

	@Column(name = "UserStatus")
	private String userStatus;
	
	@Column(name = "Password")
	private String password;
	
	@Column(name = "GoogleAuthToken")
	private String googleAuthToken;
	
	@Column(name = "profilepic")
	private String profilepic;
	
	@Column(name = "RegisteredViaGoogle")
	private Boolean isRegisteredViaGoogle;

	@OneToMany(mappedBy = "user")
	private Set<ChantingSessionHistory> chantingSessionHistories;

	public Integer getUserId() {
		return this.userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Set<ChantingSessionHistory> getChantingSessionHistories() {
		return this.chantingSessionHistories;
	}

	public void setChantingSessionHistories(
			Set<ChantingSessionHistory> chantingSessionHistories) {
		this.chantingSessionHistories = chantingSessionHistories;
	}

	/**
	 * @return the googleAuthToken
	 */
	public String getGoogleAuthToken() {
		return googleAuthToken;
	}

	/**
	 * @param googleAuthToken the googleAuthToken to set
	 */
	public void setGoogleAuthToken(String googleAuthToken) {
		this.googleAuthToken = googleAuthToken;
	}

	/**
	 * @return the isRegisteredViaGoogle
	 */
	public Boolean getIsRegisteredViaGoogle() {
		return isRegisteredViaGoogle;
	}
	
	

	public String getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}

	/**
	 * @param isRegisteredViaGoogle the isRegisteredViaGoogle to set
	 */
	public void setIsRegisteredViaGoogle(Boolean isRegisteredViaGoogle) {
		this.isRegisteredViaGoogle = isRegisteredViaGoogle;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email
				+ ", mobile=" + mobile + ", creationDate=" + creationDate
				+ ", lastLoginDate=" + lastLoginDate + ", userStatus="
				+ userStatus + ", password=" + password
				+ ", chantingSessionHistories=" + chantingSessionHistories
				+ ", profilepic=" + profilepic
				+ "]";
	}

	
}
