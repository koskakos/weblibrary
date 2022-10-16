package project.weblibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import project.weblibrary.Entities.PersonEntity;
import project.weblibrary.Services.PeopleService;

@Controller
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("/people")
    public String peopleMainPage(){
        return "people";
    }

    @GetMapping("/people/new")
    public String newPersonPage(Model model){
        model.addAttribute("person", new PersonEntity());
        return "newPeople";
    }

    @PostMapping("/people/new")
    public String addPerson(@ModelAttribute("person") PersonEntity personEntity, Model model){
        peopleService.addPeople(personEntity);
        return "redirect:/people";
    }
}
