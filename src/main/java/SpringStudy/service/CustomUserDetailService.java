package SpringStudy.service;

import SpringStudy.config.UserDetailAdaptor;
import SpringStudy.entity.Users;
import SpringStudy.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = userRepo.findByUserName(username);
        if(user.isPresent()){
            System.out.println("User found: "+user.get().getUserName());
        }
        else{
            System.out.println("no such user");
        }
        Users realUser= user.orElseThrow(()->new UsernameNotFoundException(username.concat("의 유저를 찾지 못했습니다.")));
        System.out.println("why");
        return new UserDetailAdaptor(realUser);
    }
}
