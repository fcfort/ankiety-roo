package com.b2.ankiety.web;
import com.b2.ankiety.model.Person;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Person.class)
@Controller
@RequestMapping("/people")
@RooWebScaffold(path = "people", formBackingObject = Person.class)
public class PersonController {
}
