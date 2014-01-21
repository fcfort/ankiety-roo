// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.b2.ankiety.web;

import com.b2.ankiety.model.Answer;
import com.b2.ankiety.model.Choice;
import com.b2.ankiety.model.Person;
import com.b2.ankiety.model.Question;
import com.b2.ankiety.web.AnswerController;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect AnswerController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST, produces = "text/html")
    public String AnswerController.create(@Valid Answer answer, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, answer);
            return "answers/create";
        }
        uiModel.asMap().clear();
        answer.persist();
        return "redirect:/answers/" + encodeUrlPathSegment(answer.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(params = "form", produces = "text/html")
    public String AnswerController.createForm(Model uiModel) {
        populateEditForm(uiModel, new Answer());
        return "answers/create";
    }
    
    @RequestMapping(value = "/{id}", produces = "text/html")
    public String AnswerController.show(@PathVariable("id") Long id, Model uiModel) {
        uiModel.addAttribute("answer", Answer.findAnswer(id));
        uiModel.addAttribute("itemId", id);
        return "answers/show";
    }
    
    @RequestMapping(produces = "text/html")
    public String AnswerController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            final int firstResult = page == null ? 0 : (page.intValue() - 1) * sizeNo;
            uiModel.addAttribute("answers", Answer.findAnswerEntries(firstResult, sizeNo));
            float nrOfPages = (float) Answer.countAnswers() / sizeNo;
            uiModel.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            uiModel.addAttribute("answers", Answer.findAllAnswers());
        }
        return "answers/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT, produces = "text/html")
    public String AnswerController.update(@Valid Answer answer, BindingResult bindingResult, Model uiModel, HttpServletRequest httpServletRequest) {
        if (bindingResult.hasErrors()) {
            populateEditForm(uiModel, answer);
            return "answers/update";
        }
        uiModel.asMap().clear();
        answer.merge();
        return "redirect:/answers/" + encodeUrlPathSegment(answer.getId().toString(), httpServletRequest);
    }
    
    @RequestMapping(value = "/{id}", params = "form", produces = "text/html")
    public String AnswerController.updateForm(@PathVariable("id") Long id, Model uiModel) {
        populateEditForm(uiModel, Answer.findAnswer(id));
        return "answers/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "text/html")
    public String AnswerController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model uiModel) {
        Answer answer = Answer.findAnswer(id);
        answer.remove();
        uiModel.asMap().clear();
        uiModel.addAttribute("page", (page == null) ? "1" : page.toString());
        uiModel.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/answers";
    }
    
    void AnswerController.populateEditForm(Model uiModel, Answer answer) {
        uiModel.addAttribute("answer", answer);
        uiModel.addAttribute("choices", Choice.findAllChoices());
        uiModel.addAttribute("people", Person.findAllPeople());
        uiModel.addAttribute("questions", Question.findAllQuestions());
    }
    
    String AnswerController.encodeUrlPathSegment(String pathSegment, HttpServletRequest httpServletRequest) {
        String enc = httpServletRequest.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        } catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}
