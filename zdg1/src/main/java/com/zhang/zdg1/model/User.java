package com.zhang.zdg1.model;

import java.util.Date;
import java.math.BigDecimal;

public class User {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.password
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	private String password;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.name
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	private String name;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.tel
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	private String tel;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.id
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	private Integer id;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column user.role
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	private String role;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.password
	 * @return  the value of user.password
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.password
	 * @param password  the value for user.password
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.name
	 * @return  the value of user.name
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.name
	 * @param name  the value for user.name
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.tel
	 * @return  the value of user.tel
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.tel
	 * @param tel  the value for user.tel
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.id
	 * @return  the value of user.id
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.id
	 * @param id  the value for user.id
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column user.role
	 * @return  the value of user.role
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public String getRole() {
		return role;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column user.role
	 * @param role  the value for user.role
	 * @mbg.generated  Fri Jul 05 16:30:19 CST 2019
	 */
	public void setRole(String role) {
		this.role = role;
	}
}