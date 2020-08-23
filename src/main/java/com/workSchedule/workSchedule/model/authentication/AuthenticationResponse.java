package com.workSchedule.workSchedule.model.authentication;

import com.workSchedule.workSchedule.model.MyUser;

public class AuthenticationResponse {

	private String token;
    private MyUser user;

    public AuthenticationResponse() {
    }

    public AuthenticationResponse(String token, MyUser user) {
        this.token = token;
        this.user = user;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
}
