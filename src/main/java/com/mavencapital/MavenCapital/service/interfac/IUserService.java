package com.mavencapital.MavenCapital.service.interfac;

import com.mavencapital.MavenCapital.dto.LoginRequest;
import com.mavencapital.MavenCapital.dto.Response;
import com.mavencapital.MavenCapital.entity.User;

public interface IUserService {
    Response register(User user);

    Response login(LoginRequest loginRequest);

    Response getAllUsers();

    Response getUserBookingHistory(String userId);

    Response deleteUser(String userId);

    Response getUserById(String userId);

    Response getMyInfo(String email);

}