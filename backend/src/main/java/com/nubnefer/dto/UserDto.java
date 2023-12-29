package com.nubnefer.dto;

import javax.validation.constraints.NotBlank;

public class UserDto {
	private Long id;
	@NotBlank
	private String userName;
	private String password;
	private Long roleId;
	private Long cartId;
	private String thumnail;
	
	public UserDto() {}
	
	public UserDto(Long id, @NotBlank String userName, String password, Long roleId, Long cartId, String thumnail) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
		this.cartId = cartId;
		this.thumnail = thumnail;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getCartId() {
		return cartId;
	}
	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}
	public String getThumnail() {
		return thumnail;
	}
	public void setThumnail(String thumnail) {
		this.thumnail = thumnail;
	}
		
}
