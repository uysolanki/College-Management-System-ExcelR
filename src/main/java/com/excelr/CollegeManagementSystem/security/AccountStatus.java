package com.excelr.CollegeManagementSystem.security;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.excelr.CollegeManagementSystem.model.Role;
import com.excelr.CollegeManagementSystem.model.User;

public class AccountStatus implements UserDetails {

	User user;
	public AccountStatus(User user)
	{
		this.user=user;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
         
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
         
        return authorities;

	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() 	//subscrition 9-sept-2024  10-sept-2024
	{
		LocalDate accountExpiryDate=user.getAccountExpiryDate();	//9-sep-2026
		LocalDate todaysDate=LocalDate.now();						//10-sep-2025
		if(accountExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
		
	}

	@Override
	public boolean isAccountNonLocked() 	//
	{
		int accountLockedStatus=user.getAccountLockedStatus();
		if(accountLockedStatus==1)
			return true;
		else
			return false;
	}

	@Override
	public boolean isCredentialsNonExpired()  //Banking password validity 9 May 120 days
	{
		LocalDate credExpiryDate=user.getCredentialsExpiryDate();	//9-sep-2026
		LocalDate todaysDate=LocalDate.now();						//10-sep-2025
		if(credExpiryDate.isAfter(todaysDate))
			return true;
		else
			return false;
	}

	@Override
	public boolean isEnabled() 
	{
		int accountEnabledStatus=user.getAccountEnabledStatus();
		if(accountEnabledStatus==1)
			return true;
		else
			return false;
	}

}
