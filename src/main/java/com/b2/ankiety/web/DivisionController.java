package com.b2.ankiety.web;
import com.b2.ankiety.model.Division;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Division.class)
@Controller
@RequestMapping("/divisions")
@RooWebScaffold(path = "divisions", formBackingObject = Division.class)
public class DivisionController {
}
