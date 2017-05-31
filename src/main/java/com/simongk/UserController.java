package com.simongk;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/**
 * Created by Szymon Gasienica-Kotelnicki on 31.05.17.
 */
@Controller
public class UserController {

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @RequestMapping("/user")
    public String user(Model model, Principal principal) {
        UserDetails currentUser = (UserDetails) ((Authentication) principal).getPrincipal();
        model.addAttribute("username",currentUser.getUsername());
        return "user";
    }
}
