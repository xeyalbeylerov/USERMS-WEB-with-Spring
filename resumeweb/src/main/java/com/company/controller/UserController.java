package com.company.controller;


import com.company.dto.UserEditDto;
import com.company.dto.UserRegistrationDto;
import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.DummyService;
import com.company.service.inter.UserServiceMvcInter;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
//@RequestMapping("/users")
public class UserController {


    @Autowired
    @Qualifier(value = "userServiceMvc")
    private UserServiceMvcInter userService;



    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              @RequestParam(value = "nid", required = false) Integer nationalityId) {
        List<User> list = userService.getAll(name, surname, nationalityId);
        ModelAndView mv = new ModelAndView("users");
//        mv.addObject("user",new UserForm());
        mv.addObject("users", list);
        return mv;
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/users")
//    public ModelAndView usersActioin(@RequestParam(value = "name", required = false) String name,
//                                     @RequestParam(value = "surname", required = false) String surname,
//                                     @RequestParam(value = "nid", required = false) Integer nationalityId,
//                                     @RequestParam(value = "ida", required = false) Integer id,
//                                     @RequestParam(value = "action", required = false) String action) {
//        if(id!=null)
//        userService.removeUser(id);
//        List<User> list = userService.getAll(name, surname, nationalityId);
//        ModelAndView mv = new ModelAndView("users");
//        mv.addObject("users", list);
//
//        return mv;
//    }
    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public String usersActioin(
                                     @RequestParam(value = "ida", required = false) Integer id,
                                     @RequestParam(value = "action", required = false) String action) {
            userService.removeUser(id);
        return "redirect:/users";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/usersm")
    public ModelAndView indexM(
            @Valid
            @ModelAttribute("user") UserForm u,
            BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("users");
        if (bindingResult.hasErrors()) {
            return mv;
        }
        List<User> list = userService.getAll(u.getName(), u.getSurname(), u.getNationalityId());

//    mv.addObject("user",new UserForm());
        mv.addObject("users", list);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/useredit")
    public ModelAndView userEditPost(
            @Valid @ModelAttribute("usered") UserEditDto user, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("useredit");
        if (bindingResult.hasErrors()) {
            return mv;
        }
        userService.updateUser(user);
        mv.addObject("usered", user);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/useredit")
    public ModelAndView userEditGet(@RequestParam(value = "id") Integer id) {
        ModelAndView mv = new ModelAndView("useredit");
        User user = userService.getById(id);
        mv.addObject("usered", user);
        return mv;
    }

    //bunuda men yazdim)
    @RequestMapping(method = RequestMethod.GET, value = "/userdetail")
    public ModelAndView userdetail(@RequestParam(value = "id") Integer id) {
        ModelAndView mv = new ModelAndView("userdetail");
        User user = userService.getById(id);
        mv.addObject("userdet", user);
        return mv;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/login")
    public String login() {
        return "login";
    }


    @RequestMapping(method = RequestMethod.GET, value = "/logout")
    public String logout() {
        return "logout";
    }




    @Autowired
    DummyService dummyService;

    @RequestMapping(method = RequestMethod.GET, value = "/foo")
    public String foo() {
        dummyService.foo();
        dummyService.foo2();
        return "foo";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/registration")
    public ModelAndView registrationGet() {
        ModelAndView mv = new ModelAndView("registration");
        UserRegistrationDto userDto = new UserRegistrationDto();
        mv.addObject("userRegistration", userDto);
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/registration")
    public ModelAndView registrationPost(@Valid @ModelAttribute("userRegistration") UserRegistrationDto user, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("registration");
        if (bindingResult.hasErrors()) {
            return mv;
        }
        try {
            userService.addUser(user);
        } catch (Exception ex) {
            mv.addObject("message", "An account for that username/email already exists.");
            return mv;
        }
        mv.addObject("userRegistration", user);
        return mv;
    }
    //Aşağıdakını yazmaq mv.addObject("user", new UserForm(null,null,null)); yazmağa bərabərdir.
    //Aşağıdakını yazmaq, bütün controller boyunca və bütün ModelAndView-lərə addObject("user", new Us... edəcək.
    @ModelAttribute("user")
    public UserForm getEmptyUserForm() {
        return new UserForm(null, null, null);
    }


//    @PostMapping("/user/registration")
//    public ModelAndView registerUserAccount(
//            @ModelAttribute("user") @Valid UserRegistrationDto userDto,
//            HttpServletRequest request, Errors errors) {
//
//        try {
//            User registered = userService.addUser(userDto);
//        } catch (UserAlreadyExistException uaeEx) {
//            mav.addObject("message", "An account for that username/email already exists.");
//            return mav;
//        }
//
//        return new ModelAndView("successRegister", "user", userDto);
//    }


    //bunu özüm yazdım
//    @RequestMapping(method = RequestMethod.GET, value = "/userdetail")
//    public ModelAndView userdetail() {
//        return new ModelAndView("userdetail");
//    }


//    @RequestMapping(method = RequestMethod.GET, value = "/userdetail")
//    public String userdetail() {
//        return "userdetail";
//    }


//    @RequestMapping(method = RequestMethod.GET)
//    public String index(HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//        String nationalityIdStr = request.getParameter("nid");
//        Integer nationalityId = null;
//        if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty()) {
//            nationalityId = Integer.parseInt(nationalityIdStr);
//        }
//        List<User> list = userService.getAll(name, surname, nationalityId);
//        request.setAttribute("list", list);
//        return "users";
//    }

//    @RequestMapping(method = RequestMethod.GET, value ="/users2")
//    public ModelAndView index2(@RequestParam(value = "name",required = false) String name,
//                              @RequestParam(value = "surname",required = false) String surname,
//                              @RequestParam(value = "nid",required = false) Integer nationalityId) {
//        List<User> list = userService.getAll(name, surname, nationalityId);
//        ModelAndView mv=new ModelAndView("users");
//        mv.addObject("list",list);
//        return mv;
//    }
}
