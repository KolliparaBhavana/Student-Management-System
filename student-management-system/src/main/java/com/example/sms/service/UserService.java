package com.example.sms.service;

import com.example.sms.dto.UserDto;
import com.example.sms.entity.User;

public interface UserService {
	User findByUsername(String username);
	User save (UserDto userDto);

}
