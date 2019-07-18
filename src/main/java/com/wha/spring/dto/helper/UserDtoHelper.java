package com.wha.spring.dto.helper;

import com.wha.spring.dto.UserDto;
import com.wha.spring.model.User;

public class UserDtoHelper {
	public static UserDto userToUserDto(User user,String userType){
		return new UserDto(user.getEmail(), userType);
		
	}
}
