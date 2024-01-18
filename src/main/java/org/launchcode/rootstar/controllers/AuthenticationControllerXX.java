//package org.launchcode.rootstar.controllers;
//
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpSession;
//import jakarta.validation.Valid;
//import org.launchcode.rootstar.models.User;
//import org.launchcode.rootstar.models.data.UserRepository;
//import org.launchcode.rootstar.models.dto.LoginFormDTO;
//import org.launchcode.rootstar.models.dto.RegistrationFormDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.ui.Model;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping
//@CrossOrigin
//public class AuthenticationControllerXX {
//
//    @Autowired
//    private UserRepository userRepository; // gives us access to database for the User
//
//    private static final String userSessionKey  = "user"; // the key establish that the User has created a session
//
//    private static void  setUserInSession(HttpSession session, User user) { // to create a session object
//        session.setAttribute(userSessionKey, user.getId()); // "I want to create a key (user session key = String "user")-value pair (userid)"
//        System.out.println("session: " + session.getAttribute("user"));
//    }
//
//    public User getUserFromSession(HttpSession session) { //now we need to look for the user in the session
//
//        Integer userId = (Integer) session.getAttribute(userSessionKey); //"go get the user that is associated with this session key"
//
//        if (userId == null){
//            return null;
//        }
//
//        Optional<User> userOpt = userRepository.findById(userId); //Optional container (may be we get the user may be not)
//
//        if (userOpt.isEmpty()) {
//            return null;
//        }
//        return userOpt.get(); // we need to unbox the user object (takes it out of the optional and unbox it)
//    }
//
//
//    // create handlers
//
//    @GetMapping("/register")
//    public String displayRegistrationForm (Model model, HttpSession session) { //Model class to pass data
//        model.addAttribute(new RegistrationFormDTO());
//        model.addAttribute("loggedIn", session.getAttribute(userSessionKey) != null);
//
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public ResponseEntity<?> processRegistrationForm(@ModelAttribute @Valid RegistrationFormDTO registrationFormDTO,
//                                                     Errors errors,
//                                                     HttpServletRequest request) {
//        if (errors.hasErrors()) {
//            return ResponseEntity.badRequest().body("Registration form has errors");
//        }
//
//        User existingUser = userRepository.findByUsername(registrationFormDTO.getUsername());
//
//        if (existingUser != null) {
//            return ResponseEntity.badRequest().body("The user with that username already exists");
//        }
//
//        String password = registrationFormDTO.getPassword();
//        String verifyPassword = registrationFormDTO.getVerifyPassword();
//
//        if (!password.equals(verifyPassword)) {
//            return ResponseEntity.badRequest().body("Passwords do not match");
//        }
//
//        User newUser = new User(registrationFormDTO.getUsername(), registrationFormDTO.getPassword());
//
//        userRepository.save(newUser);
//        setUserInSession(request.getSession(), newUser);
//
//        return ResponseEntity.ok("Registration successful");
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> processLoginForm(@ModelAttribute @Valid LoginFormDTO loginFormDTO,
//                                              Errors errors,
//                                              HttpServletRequest request) {
//        if (errors.hasErrors()) {
//            return ResponseEntity.badRequest().body("Login form has errors");
//        }
//
//        User theUser = userRepository.findByUsername(loginFormDTO.getUsername());
//
//        String password = loginFormDTO.getPassword();
//
//        if (theUser == null || !theUser.isMatchingPassword(password)) {
//            return ResponseEntity.badRequest().body("Wrong credentials. Try again");
//        }
//
//        setUserInSession(request.getSession(), theUser);
//
//        return ResponseEntity.ok("Login successful");
//    }
//
//
//    @GetMapping("/checkSession")
//    public ResponseEntity<?> checkSession(HttpServletRequest request) {
//        HttpSession session = request.getSession(false); // false means don't create a new session if none exists
//        boolean loggedIn = session != null && session.getAttribute("user") != null;
//        return ResponseEntity.ok(loggedIn);
//    }
//
//
//    @GetMapping("/logout")
//    public ResponseEntity<?> logout(HttpServletRequest request) {
//        request.getSession().invalidate();
//        return ResponseEntity.ok("Logout successful");
//    }
//}
