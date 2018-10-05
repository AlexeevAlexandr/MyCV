package application;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    @RequestMapping(value = { "/my_cv" })
    public String my_cv() {
        return "my_cv";
    }

    @RequestMapping(value = { "/", "/start_page" })
    public String MyCV() {
        return "start_page";
    }
}
