package edu.mum.cs544.MumRegistrationApi.Controller;

import edu.mum.cs544.MumRegistrationApi.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/authentication")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService  ;

//    @PostMapping
//    public ExtendedLoginModel login(@RequestBody LoginModel loginModel) {
//        return iAuthenticationService.login(loginModel);
//    }
}
