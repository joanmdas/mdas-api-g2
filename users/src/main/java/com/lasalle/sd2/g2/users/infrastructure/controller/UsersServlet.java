package com.lasalle.sd2.g2.users.infrastructure.controller;

import com.google.gson.Gson;
import com.lasalle.sd2.g2.users.application.CreateUser;
import com.lasalle.sd2.g2.users.domain.User;
import com.lasalle.sd2.g2.users.infrastructure.dto.CreateUserResponseBody;
import com.lasalle.sd2.g2.users.infrastructure.repository.InMemoryUsersRepository;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UsersServlet extends HttpServlet {

    private static final long serialVersionUID = -248277058454234512L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        CreateUser createUser = new CreateUser(new InMemoryUsersRepository());

        User user = createUser.execute();
        CreateUserResponseBody responseBody = new CreateUserResponseBody(user.getId());

        resp.getWriter().println(new Gson().toJson(responseBody));
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_OK);
    }
}
