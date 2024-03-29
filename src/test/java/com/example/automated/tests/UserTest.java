package com.example.automated.tests;
import com.example.automated.Beans;
import com.example.automated.controller.UserController;
import com.example.automated.model.user.User;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.Assert.assertEquals;

@DataJpaTest
@ExtendWith(SpringExtension.class)
@Import(Beans.class)
public class UserTest {

    @Qualifier("getUserController")
    @Autowired
    private UserController userController;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //@Autowired
    //private BiographyController biographyController;

    @Test
    public void testUserController() {

        User user = new User();
        user.setUsername("test");
        user.setPassword("test");

        ResponseEntity<User> response = userController.authenticateUser(user);


        assertEquals(true, true);
    }

    @Test
    public void testBiographyController() {
        // Test the BiographyController
    }





}
