package glassgate.controller;

import glassgate.domain.User;
import glassgate.domain.UserRole;
import glassgate.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasAuthority('ADMIN')|| hasAuthority('CREATOR')")
    @GetMapping
    public String userList(Model model) {
        model.addAttribute("users", userService.findAll());

        return "userList";
    }
    @PreAuthorize("hasAuthority('ADMIN')|| hasAuthority('CREATOR')")
    @GetMapping("{user}")
    public String userEditForm(@PathVariable User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("roles", UserRole.values());

        return "userEdit";
    }

    @PreAuthorize("hasAuthority('ADMIN')|| hasAuthority('CREATOR')")
    @PostMapping
    public String userSave(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("userId") User user) {

        userService.saveUser(user, username, form);

        return "redirect:/user";
    }

    @GetMapping("profile")
    public String getProfile(Model model, @AuthenticationPrincipal User user) {
    model.addAttribute("username", user.getUsername());
    model.addAttribute("password", user.getPassword());
    model.addAttribute("userlastname", user.getUserlastname());
    model.addAttribute("userfirstname", user.getUserfirstname());
    model.addAttribute("userpatronymic", user.getUserpatronymic());
    model.addAttribute("userphone", user.getUserphone());
    model.addAttribute("email", user.getUseremail());

    return "profile";
}

    @PostMapping("profile")
    public String updateProfile(
            @AuthenticationPrincipal User user,
            @RequestParam String password,
            @RequestParam String userlastname,
            @RequestParam String userfirstname,
            @RequestParam String userpatronymic,
            @RequestParam String userphone,
            @RequestParam String useremail
    ) {
        userService.updateProfile(user,
                password,
                userlastname,
                userfirstname,
                userpatronymic,
                userphone,
                useremail);

        return "redirect:/glass_gate_ua_logout";
    }
}