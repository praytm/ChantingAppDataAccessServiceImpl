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
@Table(schema = "test", name = "user")
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
	@Column(name = "UserId")
	private String name;

	@Column(name = "Email")
	private String email;

	@Column(name = "Mobile")
	private Integer mobile;

	@Column(name = "CreationDate")
	private Date creationDate;

	@Column(name = "LastLoginDate")
	private Date lastLoginDate;

	@Column(name = "UserStatus")
	private String userStatus;

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

	public Integer getMobile() {
		return this.mobile;
	}

	public void setMobile(Integer mobile) {
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

	public Set<ChantingSessionHistory> getChantingSessionHistories() {
		return this.chantingSessionHistories;
	}

	public void setChantingSessionHistories(
			Set<ChantingSessionHistory> chantingSessionHistories) {
		this.chantingSessionHistories = chantingSessionHistories;
	}

}
