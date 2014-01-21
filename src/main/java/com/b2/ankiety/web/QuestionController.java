package com.b2.ankiety.web;
import com.b2.ankiety.model.Question;
import org.springframework.roo.addon.web.mvc.controller.json.RooWebJson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.roo.addon.web.mvc.controller.scaffold.RooWebScaffold;

@RooWebJson(jsonObject = Question.class)
@Controller
@RequestMapping("/questions")
@RooWebScaffold(path = "questions", formBackingObject = Question.class)
public class QuestionController {
}
