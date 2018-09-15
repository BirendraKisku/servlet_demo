package com.cg.laxman.servlet;

public class Programs {
	private String ProgramName;
	private String Description;
	private String Application_Eligibility;
	private int duration;
	private String Degree_Certificate_Offered;
	public String getProgramName() {
		return ProgramName;
	}
	public void setProgramName(String programName) {
		ProgramName = programName;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getApplication_Eligibility() {
		return Application_Eligibility;
	}
	public void setApplication_Eligibility(String application_Eligibility) {
		Application_Eligibility = application_Eligibility;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getDegree_Certificate_Offered() {
		return Degree_Certificate_Offered;
	}
	public void setDegree_Certificate_Offered(String degree_Certificate_Offered) {
		Degree_Certificate_Offered = degree_Certificate_Offered;
	}
	
}
