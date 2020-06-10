package com.company.service;


import com.company.entity.User;
import com.company.service.inter.UserServiceMvcInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    @Qualifier("userServiceMvc")
    private UserServiceMvcInter userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);

        if (user != null) {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);
            builder.disabled(false);
            builder.password(user.getPassword());

            String[] authoritiesArr = new String[]{"USER"};//"ADMIN",//bura arr kimi userin authoitieslrini göndəririrk.
            builder.authorities(authoritiesArr);
            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found");
        }


    }
}
