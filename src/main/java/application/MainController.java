package application;

import commands.Commands;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    private Commands commands = new Commands();

    @RequestMapping(value = { "/", "/start_page" })
    public String MyCV() {
        return "start_page";
    }

    @RequestMapping(value = { "/my_cv" })
    public String my_cv() {
        return "my_cv";
    }

    @RequestMapping(value = { "/page" })
    public String page() {
        return "page";
    }

    @RequestMapping(value = { "/proposals" }, method = RequestMethod.GET)
    public String personList(Model model) {
        model.addAttribute("persons", commands.list());
        return "proposals";
    }
}
