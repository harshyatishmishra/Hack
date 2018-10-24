package com.s.practice.model;

public class Details {

	String country;
	String city;
	String country_Code;
	String income;
	String gender;
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCountry_Code() {
		return country_Code;
	}
	public void setCountry_Code(String country_Code) {
		this.country_Code = country_Code;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Details [Country=" + country + ", City=" + city + ", Country Code=" + country_Code + ", Income="
				+ income + ", Gender=" + gender + "]";
	}
}
