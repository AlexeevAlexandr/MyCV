package application;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping(value = { "/", "/start_page" })
    public String MyCV() {
        return "start_page";
    }

    @RequestMapping(value = { "/my_cv" })
    public String my_cv() {
        return "my_cv";
    }

    @RequestMapping(value = { "/proposals" })
    public String proposals() {
        return "proposals";
    }

    @RequestMapping(value = { "/page" })
    public String page() {
        return "page";
    }
}
