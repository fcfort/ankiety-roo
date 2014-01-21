package com.b2.ankiety.web;
import com.b2.ankiety.model.Dictionary;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Dictionary.class)
@Controller
@RequestMapping("/dictionarys")
@RooWebScaffold(path = "dictionarys", formBackingObject = Dictionary.class)
public class DictionaryController {
}
