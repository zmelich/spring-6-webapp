package guru.springframework.spring6webapp.controllers;


/*
Created by Zsolt Melich (BT - IVR team)
*/

import guru.springframework.spring6webapp.services.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthorController {

    //We use the interface, not the implementation class!!
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public String getAuthors(Model model){
        model.addAttribute( "authors", authorService.findAll());

        return "authors";
    }
}
