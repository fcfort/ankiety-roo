package com.b2.ankiety.web;
import com.b2.ankiety.model.Subdivision;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Subdivision.class)
@Controller
@RequestMapping("/subdivisions")
@RooWebScaffold(path = "subdivisions", formBackingObject = Subdivision.class)
public class SubdivisionController {
}
