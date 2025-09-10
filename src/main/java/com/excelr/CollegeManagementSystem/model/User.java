package com.excelr.CollegeManagementSystem.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userId;
	String userName;
	String password;
	
	LocalDate accountExpiryDate; 	//subscrition 9-sept-2024  10-sept-2024
	int accountLockedStatus;			//1- Active 0-Locked
	LocalDate credentialsExpiryDate; //Banking password validity 9 May 120 days
	int accountEnabledStatus;
	
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinTable(		
			name = "users_roles",		
			joinColumns = @JoinColumn(name="fuserId"),
			inverseJoinColumns = @JoinColumn(name="froleId")
			)
	List<Role> roles;

}
