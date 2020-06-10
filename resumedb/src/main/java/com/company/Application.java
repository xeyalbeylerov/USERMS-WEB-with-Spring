package com.company;




import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Autowired
    @Qualifier(value="userService")
    private UserServiceInter userDao;




    @Bean
    public CommandLineRunner run() {
        CommandLineRunner clr = new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {



                List<User> list = userDao.getAll("x", null);
                System.out.println(list);
                for(User u:list){System.out.println("List "+u);}
userDao.removeUser(46);
//                u.setName(u.getName().toLowerCase());
//                userDao.updateUser(u);
//                System.out.println("Name " + u.getName()+" "+u.getName());
//                User u=new User();
//                u.setName("Xeyal");
//                u.setEmail("xeyalbeylerov@gmail.com");
//                BCrypt.Hasher h=BCrypt.withDefaults();
//                String pass=h.hashToString(4,"123123".toCharArray());
//                u.setPassword(pass);
//                userDao.addUser(u);

            }

        };
        return clr;
    }


}
