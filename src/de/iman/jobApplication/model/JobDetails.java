package de.iman.jobApplication.model;

// Generated 14.05.2015 20:05:49 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * JobDetails generated by hbm2java
 */
@Entity
@Table(name = "JOB_DETAILS",uniqueConstraints = @UniqueConstraint(columnNames = "JOB_TITLE"))
public class JobDetails implements java.io.Serializable {

	private Integer jobId;
	private CompDetails compDetails;
	private String jobTitle;
	private String jobType;
	private Set<UserDetails> userDetailses = new HashSet<UserDetails>(0);
	private Set<Applications> applicationses = new HashSet<Applications>(0);

	public JobDetails() {
	}

	public JobDetails(CompDetails compDetails, String jobTitle, String jobType) {
		this.compDetails = compDetails;
		this.jobTitle = jobTitle;
		this.jobType = jobType;
	}

	public JobDetails(CompDetails compDetails, String jobTitle, String jobType,
			Set<UserDetails> userDetailses, Set<Applications> applicationses) {
		this.compDetails = compDetails;
		this.jobTitle = jobTitle;
		this.jobType = jobType;
		this.userDetailses = userDetailses;
		this.applicationses = applicationses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "JOB_ID", unique = true, nullable = false)
	public Integer getJobId() {
		return this.jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "COMP_ID", nullable = false)
	public CompDetails getCompDetails() {
		return this.compDetails;
	}

	public void setCompDetails(CompDetails compDetails) {
		this.compDetails = compDetails;
	}

	@Column(name = "JOB_TITLE", unique = true, nullable = false, length = 30)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Column(name = "JOB_TYPE", nullable = false, length = 50)
	public String getJobType() {
		return this.jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobDetails")
	public Set<UserDetails> getUserDetailses() {
		return this.userDetailses;
	}

	public void setUserDetailses(Set<UserDetails> userDetailses) {
		this.userDetailses = userDetailses;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "jobDetails")
	public Set<Applications> getApplicationses() {
		return this.applicationses;
	}

	public void setApplicationses(Set<Applications> applicationses) {
		this.applicationses = applicationses;
	}

}
