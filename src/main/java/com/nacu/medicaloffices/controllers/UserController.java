package com.nacu.medicaloffices.controllers;

import com.nacu.medicaloffices.api.model.UserDTO;
import com.nacu.medicaloffices.domain.User;
import com.nacu.medicaloffices.repositories.UserRepository;
import com.nacu.medicaloffices.security.JwtTokenProvider;
import com.nacu.medicaloffices.services.UserService;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(UserController.BASE_URL)
public class UserController {

    public static final String BASE_URL = "/api/users";

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;
    private final UserRepository userRepository;
    private final UserService service;

    public UserController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider, UserRepository userRepository, UserService service) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.userRepository = userRepository;
        this.service = service;
    }

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> authenticate(@RequestBody User user) {
        JSONObject jsonObject = new JSONObject();
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
            if (authentication.isAuthenticated()) {
                String username = user.getUsername();
                jsonObject.put("username", authentication.getName());
                jsonObject.put("userId", userRepository.findByUsername(username).getId());
                jsonObject.put("authorities", authentication.getAuthorities());
                jsonObject.put("role", userRepository.findByUsername(username).getRole().getName());
                jsonObject.put("token", tokenProvider.createToken(username, userRepository.findByUsername(username).getRole()));
                return new ResponseEntity<>(jsonObject.toString(), HttpStatus.OK);
            }
        } catch (JSONException e) {
            try {
                jsonObject.put("exception", e.getMessage());
            } catch (JSONException e1) {
                e1.printStackTrace();
            }
            return new ResponseEntity<>(jsonObject.toString(), HttpStatus.UNAUTHORIZED);
        }
        return null;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody UserDTO userDTO) {
        String hashedPassword = new BCryptPasswordEncoder().encode(userDTO.getPassword());
        userDTO.setPassword(hashedPassword);
        return service.create(userDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getById(@PathVariable Long id) {
        return service.findById(id);
    }
}
