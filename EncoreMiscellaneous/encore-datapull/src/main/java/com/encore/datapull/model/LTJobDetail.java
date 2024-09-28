package com.encore.datapull.model;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class LTJobDetail {

	private String header;
	private String datePosted;
	private String location;
	private String desc1;
	private String desc2;
	private Map<String, String> contactDetails = new HashMap<>();
	private Map<String, String> jobDetails = new HashMap<>();
	private Instant createDtm;

	public String getHeader() {
		return this.header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public String getDatePosted() {
		return this.datePosted;
	}

	public void setDatePosted(String datePosted) {
		this.datePosted = datePosted;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDesc1() {
		return this.desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getDesc2() {
		return this.desc2;
	}

	public void setDesc2(String desc2) {
		this.desc2 = desc2;
	}

	public Map<String, String> getContactDetails() {
		return this.contactDetails;
	}

	public void setContactDetails(Map<String, String> contactDetails) {
		this.contactDetails = contactDetails;
	}

	public Map<String, String> getJobDetails() {
		return this.jobDetails;
	}

	public void setJobDetails(Map<String, String> jobDetails) {
		this.jobDetails = jobDetails;
	}

	public Instant getCreateDtm() {
		return this.createDtm;
	}

	public void setCreateDtm(Instant createDtm) {
		this.createDtm = createDtm;
	}

	public String toString() {
		return ReflectionToStringBuilder.toString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}
