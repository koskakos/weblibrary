package project.weblibrary.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.weblibrary.Entities.PersonEntity;
import project.weblibrary.Services.PeopleService;

import java.util.Optional;

@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

    @GetMapping("")
    public String peopleMainPage(Model model){
        model.addAttribute("persons", peopleService.getPersons());
        return "people";
    }

    @GetMapping("/new")
    public String newPersonPage(Model model){
        model.addAttribute("person", new PersonEntity());
        return "newPeople";
    }

    @PostMapping("/new")
    public String addPerson(@ModelAttribute("person") PersonEntity personEntity, Model model){
        peopleService.addPerson(personEntity);
        return "redirect:/people/new";
    }

    @GetMapping("/{id}")
    public String personPage(@PathVariable("id") Long id, Model model){
        model.addAttribute("person", peopleService.getPersonById(id));
        return "personPage";
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable("id") Long id){
        peopleService.deletePersonById(id);
        return "redirect:/people";
    }
}
