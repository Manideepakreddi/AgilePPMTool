package hcl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hcl.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;



}