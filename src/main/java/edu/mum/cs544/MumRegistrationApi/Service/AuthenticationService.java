package edu.mum.cs544.MumRegistrationApi.Service;

import edu.mum.cs544.MumRegistrationApi.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService {

//    public ExtendedLoginModel login(LoginModel loginModel) {
//        User user = iAuthenticationRepo.findByUsernameAndPassword(loginModel.getUsername(),loginModel.getPassword());
//        ExtendedLoginModel extendedLoginModel = new ExtendedLoginModel();
//        if (user!=null) {
//            // generate token
//            JwtUserDetails jwtUserDetails = new JwtUserDetails();
//            jwtUserDetails.setUsername(loginModel.getUsername());
//
//            if(user.getStudent()!=null){
//                jwtUserDetails.setFirstName(user.getStudent().getFirstName());
//                jwtUserDetails.setLastName(user.getStudent().getLastName());
//                jwtUserDetails.setId(user.getStudent().getId());
//
//                extendedLoginModel.setFirstname(user.getStudent().getFirstName());
//                extendedLoginModel.setLastname(user.getStudent().getLastName());
//                extendedLoginModel.setId(user.getStudent().getId());
//                extendedLoginModel.setUsername(loginModel.getUsername());
//            }
//
//
//            if(user.getFaculty()!=null){
//                jwtUserDetails.setFirstName(user.getFaculty().getFirstName());
//                jwtUserDetails.setLastName(user.getFaculty().getLastName());
//                jwtUserDetails.setId(user.getFaculty().getId());
//
//                extendedLoginModel.setFirstname(user.getFaculty().getFirstName());
//                extendedLoginModel.setLastname(user.getFaculty().getLastName());
//                extendedLoginModel.setId(user.getFaculty().getId());
//                extendedLoginModel.setUsername(loginModel.getUsername());
//            }
//
//
//
//
//
//            // jwtUserDetails.setId(user.getStudent());
//
//            //fetch roles
//            List<String> roleList = new ArrayList<>();
//            roleList.add(user.getRole().getRole());
//
//
//            jwtUserDetails.setRoles(roleList);
//            String tokenRes = jwtUtil.encode(jwtUserDetails);
//
//            extendedLoginModel.setToken(tokenRes);
//            extendedLoginModel.setRoleList(roleList);
//
//        }
//        return extendedLoginModel;
//    }
}
