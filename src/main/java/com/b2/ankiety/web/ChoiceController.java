package com.b2.ankiety.web;
import com.b2.ankiety.model.Choice;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Choice.class)
@Controller
@RequestMapping("/choices")
@RooWebScaffold(path = "choices", formBackingObject = Choice.class)
public class ChoiceController {
}
