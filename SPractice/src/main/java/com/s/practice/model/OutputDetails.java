package com.s.practice.model;

public class OutputDetails {
	String country;
	String gender;
	String income;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIncome() {
		return income;
	}

	public void setIncome(String income) {
		this.income = income;
	}

	@Override
	public String toString() {
		return "OutputDetails [country=" + country + ", gender=" + gender + ", income=" + income + "]";
	}

}
