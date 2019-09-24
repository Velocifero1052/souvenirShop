package com.example.demo;

import com.example.demo.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.Collections;

class Fields{
    String someData1, someData2;

    public String getSomeData1() {
        return someData1;
    }

    public void setSomeData1(String someData1) {
        this.someData1 = someData1;
    }

    public String getSomeData2() {
        return someData2;
    }

    public void setSomeData2(String someData2) {
        this.someData2 = someData2;
    }
}

class ProductFields{
    String productName,
}


@Controller
@RequestMapping(path = "/demo")
public class MainController {
    @Autowired
    PersonRepository personRepository;

    @Autowired
    SomeRepo someRepo;

    @GetMapping(path = "/form2")
    public String form2(Model model){
        model.addAttribute(new Fields());
        return "form2";
    }
    @PostMapping(path = "/form2")
    public @ResponseBody String obtain2(@ModelAttribute Fields fields){
        SomeClass1 someClass1 = new SomeClass1();
        someClass1.setSomeData(fields.getSomeData1());
        SomeClass2 someClass2 = new SomeClass2();
        someClass2.setSomeData2(fields.getSomeData2());
        someClass1.setRefs(Collections.singletonList(someClass2));

        someRepo.save(someClass1);
        return "saved";
    }
    @GetMapping(path = "/all2")
    public @ResponseBody Iterable<SomeClass1> getAll(){
        return someRepo.findAll();
    }

    @GetMapping(path = "/form")
    public String form(Model model){
        model.addAttribute("formFields", new FormFields());

        return "form";
    }
    @PostMapping(path = "/form")
    public @ResponseBody String obtain(@ModelAttribute FormFields formFields){
        //person object initialization
        Passport passport = new Passport();
        passport.setSeries("Ab");

        Address address = new Address();
        address.setCity(formFields.getAddressCity());
        address.setStreet(formFields.getAddressStreet());
        address.setBuilding(formFields.getAddressBuilding());

        Person person = new Person();
        person.setFirstName(formFields.getPersonFirstName());
        person.setLastName(formFields.getPersonLastName());
        person.setPrimaryAddress(address);
        person.setPassport(passport);

        Company company = new Company();
        company.setName(formFields.getCompanyName());

        passport.setOwner(person);
        person.setWorkingPlaces(Collections.singletonList(company));
        personRepository.save(person);
        return "saved";
    }
    @GetMapping("/add_product")
    public String add_new_product(Model model){
        model.addAttribute("product_fields", );
        return "addProductForm";
    }

}
