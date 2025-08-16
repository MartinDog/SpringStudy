package SpringStudy.controller;

import SpringStudy.config.UserDetailAdaptor;
import SpringStudy.dto.UserDto;
import SpringStudy.entity.Users;
import SpringStudy.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/auth")
@AllArgsConstructor
public class LoginController {
    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;
    @PostMapping("/user/insert")
    @ResponseBody
    public String insertUser(@RequestBody UserDto inputUser ){
        Users user = Users.builder()
                .role(inputUser.getRole())
                .userName(inputUser.getUserName())
                .password(passwordEncoder.encode(inputUser.getPassword()))
                .build();
        userRepo.save(user);
        return "success";
    }
    @GetMapping("/user/getInfo")
    @ResponseBody
    public Authentication getUser(){
        Authentication authenticator = SecurityContextHolder.getContext().getAuthentication();
        return authenticator;
    }
    @GetMapping("/login")
    public String getLoginPage(){
        return "auth/login";
    }
    @GetMapping("/main")
    public String getMainPage(){
        return "auth/login_success";
    }
    @GetMapping("/whoami")
    @ResponseBody
    public void getWhoami(@AuthenticationPrincipal UserDetails user){
        System.out.println(user.getAuthorities());
        System.out.println(user.getUsername());
    }
    @GetMapping("/whoamiAuth")
    @ResponseBody
    public void getWhoamiAuth(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailAdaptor user = (UserDetailAdaptor)authentication.getPrincipal();
        System.out.println(user.getAuthorities());
        System.out.println(user.getUsername());
    }

}
