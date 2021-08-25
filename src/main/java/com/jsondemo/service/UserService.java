package com.jsondemo.service;

import java.util.Arrays;
import java.util.List;

import com.jsondemo.pkg.user;

public class UserService 
{
	public List<user> getUser()
	{
		return Arrays.asList(new user(1,"kruthi","kruthi@gmail.com"),
				new user(2,"medini","medini@gmail.com"));
	}
	
}
