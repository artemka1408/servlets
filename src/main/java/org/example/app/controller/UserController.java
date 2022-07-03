package org.example.app.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.app.dto.UserDTO;
import org.example.app.manager.UserManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequiredArgsConstructor // генерирует конструктор только для final non-static полей
public class UserController {
    private final UserManager manager;
    private final Gson gson;

    @RequestMapping("/users.getAll")
    public void getAll(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        // TODO:
        //  1. req - параметры
        //  2. передать параметры в manager'а
        //  3. записать ответ с помощью Gson
        final List<UserDTO> responseDTO = manager.getAll();
        res.getWriter().write(gson.toJson(responseDTO));
    }

    // TODO: http://localhost:8080?users.getById?id=1
    @RequestMapping("/users.getById")
    public void getById(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        // TODO:
        //  1. req - параметры
        //  2. передать параметры в manager'а
        //  3. записать ответ с помощью Gson
        final long id = Long.parseLong(req.getParameter("id"));
        final UserDTO responseDTO = manager.getById(id);
        res.getWriter().write(gson.toJson(responseDTO));
    }

    @RequestMapping("/users.create")
    public void create(final HttpServletRequest req, final HttpServletResponse res) throws ServletException, IOException {
        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        final UserDTO responseDTO = manager.create(login, password);
        res.getWriter().write(gson.toJson(responseDTO));
    }
}
