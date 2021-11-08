package com.psp.psp13.service;

import com.psp.psp13.Application;
import com.psp.psp13.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Application.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceTest
{
    @Autowired
    private UserService service;

    @Test
    void saveUserTest_GoodUser_ShouldBeTrue()
    {
        User u = new User(1L, "Vardas", "Pavarde", "861111111", "email@email.com", "address", "Password!");
        User added = service.add(u);
        assertEquals(u, added);
    }
    @Test
    void findAllUsersTest_ShouldBeTrue()
    {
        User u = new User(1L, "Vardas", "Pavarde", "861111111", "email@email.com", "address", "Password!");
        User u2 = new User(2L, "Vardas2", "Pavarde2", "862222222", "mail@mail.com", "address2", "Password@");
        service.add(u);
        service.add(u2);

        List<User> expected = List.of(u, u2);
        List<User> actual = service.findAll();

        assertEquals(expected, actual);
    }
    @Test
    void findByIdTest_ShouldBeTrue()
    {
        User u = new User(1L, "Vardas", "Pavarde", "861111111", "email@email.com", "address", "Password!");
        User u2 = new User(2L, "Vardas2", "Pavarde2", "862222222", "mail@mail.com", "address2", "Password@");
        service.add(u);
        service.add(u2);

        Optional<User> a = service.findUserById(1L);
        User actual = a.get();
        assertEquals(u, actual);
    }
    @Test
    void deleteUserTest_ShouldBeTrue()
    {
        User u = new User(1L, "Vardas", "Pavarde", "861111111", "email@email.com", "address", "Password!");
        User u2 = new User(2L, "Vardas2", "Pavarde2", "862222222", "mail@mail.com", "address2", "Password@");
        service.add(u);
        service.add(u2);

        service.deleteById(1L);
        List<User> actual = service.findAll();

        assertEquals(List.of(u2), actual);
    }
    @Test
    void updateUserTest_ShouldBeTrue()
    {
        User u = new User(1L, "Vardas", "Pavarde", "861111111", "email@email.com", "address", "Password!");
        User u2 = new User(1L, "Vardas2", "Pavarde2", "862222222", "mail@mail.com", "address2", "Password@");
        service.add(u);

        service.update(u2);
        Optional<User> a = service.findUserById(1L);
        User actual = a.get();

        assertEquals(u2, actual);
    }
}
