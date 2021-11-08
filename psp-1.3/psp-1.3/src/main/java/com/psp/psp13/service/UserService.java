package com.psp.psp13.service;

import com.psp.psp13.model.User;
import com.psp.psp13.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository repo;

    public List<User> findAll()
    {
        return (List<User>) repo.findAll();
    }
    public Optional<User> findUserById(Long id)
    {
        return repo.findById(id);
    }
    public Long findMaxId()
    {
        Iterable<User> users = repo.findAll();
        Long max = 0L;
        for (User u : users)
        {
            if(u.getId() > max) max = u.getId();
        }
        return max;
    }
    public void update(User u)
    {
        repo.save(u);
    }
    public User add(User u)
    {
        return repo.save(u);
    }
    public void deleteById(Long id)
    {
        repo.deleteById(id);
    }
    public void deleteByUser(User u)
    {
        repo.delete(u);
    }
}
