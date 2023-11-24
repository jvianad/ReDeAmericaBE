package com.project.ReDeAmericaBE.services;

import com.project.ReDeAmericaBE.repositories.iPublicationRepository;
import com.project.ReDeAmericaBE.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private iUserRepository userRepository;
    @Autowired
    private iPublicationRepository publicationRepository;
}
