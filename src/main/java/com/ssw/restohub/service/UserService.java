package com.ssw.restohub.service;

import com.ssw.restohub.data.UserRole;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    public UserRole getUser(String Username);

}
