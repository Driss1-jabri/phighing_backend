package com.example.phishing_backend.service.serviceImpl;

import com.example.phishing_backend.dto.AuthenticationDTO;
import com.example.phishing_backend.entities.RoleApp;
import com.example.phishing_backend.entities.User;
import com.example.phishing_backend.entities.Validation;
import com.example.phishing_backend.enums.UserRole;
import com.example.phishing_backend.exceptions.ActivationException;
import com.example.phishing_backend.exceptions.RefreshTokenExpiredException;
import com.example.phishing_backend.repositories.RoleRepository;
import com.example.phishing_backend.repositories.UserRepository;
import com.example.phishing_backend.repositories.ValidationRepository;
import com.example.phishing_backend.service.JwtService;
import com.example.phishing_backend.service.UserService;
import com.example.phishing_backend.service.ValidationService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl  implements UserService {
    private final UserRepository userRepository;
    final RoleRepository roleRepository;
    final ValidationService validationService;
    final JwtService jwtService;
    @Override
    public User registerUser(User userApp) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        RoleApp roleApp = new RoleApp();
        roleApp.setRole(UserRole.USER);
        roleApp = roleRepository.save(roleApp);

        List<RoleApp> roles = new ArrayList<>();
        roles.add(roleApp);
        userApp.setRoles(roles);

        String encodedPassword = passwordEncoder.encode(userApp.getPassword());
        userApp.setPassword(encodedPassword);
        userApp.setActive(false);
        User userApp1 =  userRepository.save(userApp);
        System.out.println(userApp1.toString());
        validationService.addNewValidation(userApp1);
        return userApp1;
    }

    @Override
    public void activationAccount(Map<String, String> activation) throws ActivationException {

        String code = activation.get("code");
        Validation validation = validationService.getValidationBuCode(code);
        if(Instant.now().isAfter(validation.getExpireAt())){
            throw new ActivationException("Code already expired!!");
        }
        User user = validation.getUserApp();
        user.setActive(true);
        userRepository.save(user);
    }

    @Override
    public Map<String, String> connexion(AuthenticationDTO authenticationDTO) throws RefreshTokenExpiredException {
        return jwtService.generateToken(authenticationDTO);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByUsername(username);
    }
}
