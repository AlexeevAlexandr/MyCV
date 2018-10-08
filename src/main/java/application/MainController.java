package application;

import commands.Commands;
import dataBaseConnect.PersonForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
    private Commands commands = new Commands();

    @Value("Incorrect email address!")
    private String errorMessageEmail;

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

    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
        PersonForm personForm = new PersonForm();
        model.addAttribute("personForm", personForm);
        return "addPerson";
    }

    @RequestMapping(value = { "/addPerson" }, method = RequestMethod.POST)
    public String savePerson(Model model, @ModelAttribute("personForm") PersonForm personForm) {

        String firstName = personForm.getFirstName();
        String lastName = personForm.getLastName();
        String email = personForm.getEmail();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        try {
            commands.add(firstName, lastName, email, date);
            return "redirect:/proposals";

        }catch (Exception e){
            model.addAttribute("errorMessage", errorMessageEmail);
            return "addPerson";
        }

    }

}
