package com.saydinlik.hibernatestatementinspector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.saydinlik.hibernatestatementinspector.controller.UserController;
import com.saydinlik.hibernatestatementinspector.model.User;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class HibernateStatementInspectorApplicationTests {
    @Autowired
    private MockMvc mvc;

//    @Autowired
//    private UserController userController;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void contextLoads() {
        saveDemoUser();
    }

    @SneakyThrows
    private void saveDemoUser() {
        User user = new User();
        user.setName("test");

        String userAsJson = mapper.writeValueAsString(user);
        mvc.perform(
                post("/user")
                .contentType(MediaType.APPLICATION_JSON)
                        .content(userAsJson))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
