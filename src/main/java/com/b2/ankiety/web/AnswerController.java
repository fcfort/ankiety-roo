package com.b2.ankiety.web;
import com.b2.ankiety.model.Answer;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Answer.class)
@Controller
@RequestMapping("/answers")
@RooWebScaffold(path = "answers", formBackingObject = Answer.class)
public class AnswerController {
}
