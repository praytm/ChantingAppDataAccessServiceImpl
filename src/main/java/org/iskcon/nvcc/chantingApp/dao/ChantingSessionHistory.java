package org.iskcon.nvcc.chantingApp.dao;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Chantingsessionhistory 
 */
@Entity
@Table(schema = "test", name = "chantingsessionhistory")
public class ChantingSessionHistory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 522978050729350905L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ChantingSessionHistoryId")
	private Integer chantingSessionHistoryId;

	@ManyToOne
	@JoinColumn(name = "UserId", nullable = false)
	private User user;

	@Column(name = "ChantingSessionStartTime")
	private Date chantingSessionStartTime;

	@Column(name = "ChantingSessionEndTime")
	private Date chantingSessionEndTime;

	@Column(name = "ChantingSessionDate")
	private Date chantingSessionDate;

	@Column(name = "NumberOfBeads")
	private Integer numberOfBeads;

	public Integer getChantingSessionHistoryId() {
		return this.chantingSessionHistoryId;
	}


	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getChantingSessionStartTime() {
		return this.chantingSessionStartTime;
	}

	public void setChantingSessionStartTime(Date chantingSessionStartTime) {
		this.chantingSessionStartTime = chantingSessionStartTime;
	}

	public Date getChantingSessionEndTime() {
		return this.chantingSessionEndTime;
	}

	public void setChantingSessionEndTime(Date chantingSessionEndTime) {
		this.chantingSessionEndTime = chantingSessionEndTime;
	}

	public Date getChantingSessionDate() {
		return this.chantingSessionDate;
	}

	public void setChantingSessionDate(Date chantingSessionDate) {
		this.chantingSessionDate = chantingSessionDate;
	}

	public Integer getNumberOfBeads() {
		return this.numberOfBeads;
	}

	public void setNumberOfBeads(Integer numberOfBeads) {
		this.numberOfBeads = numberOfBeads;
	}

}
