package com.example.springWeb.web.issue;

import com.example.springWeb.doman.app.IssueEntity;
import com.example.springWeb.doman.app.IssueRepository;
import com.example.springWeb.doman.app.IssueService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IssueController {
    private final IssueService issueService;

    @GetMapping("/issues")
    public String showList(Model model){
        model.addAttribute("issuesList", issueService.findAll());
        return "issues/list";
    }
    @GetMapping("/issues/creationForm")
    public String showCreateForm(Model model){
        model.addAttribute("issueForm", new IssueForm());
        return "issues/creationForm.html";
    }
    @PostMapping("/issues")
    public String create(@Validated IssueForm form, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return showCreateForm(model);
        }
        issueService.create(form.getSummary(), form.getDescription());
        return "redirect:/issues";

    }
    // GET localhost:8080/issues/1
    @GetMapping("/issues/{issueId}")
    public String showDetail(@PathVariable("issueId") long issueId, Model model){
        model.addAttribute("issue", issueService.findById(issueId));
        return "issues/detail";
    }


}


