package jp.ac.ohara.timeseisaku.controller;

import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.timeseisaku.model.StudentHyou;

public class MainController {

	@GetMapping("/")
    public String index(Model model) {
        return "index";
    }
	

	@GetMapping("/student/")
	  public ModelAndView studenthyou(StudentHyou studenthyou, ModelAndView model)  {
	      model.addObject("studenthyou", studenthyou);
	  
	  model.setViewName("student");
	  return model;
	  
	          
	 
	}
	 @PostMapping("/studenthyou/")
	  public String studenthyou(@Validated @ModelAttribute @NonNull StudentHyou studenthyou, RedirectAttributes result, ModelAndView model,
			  RedirectAttributes redirectAttributes) {
		  try {
			  this.StudentService.save(studenthyou);
			  redirectAttributes.addFlashAttribute("exception", "");
			  
		  } catch (Exception e) {
			  redirectAttributes.addFlashAttribute("exception", e.getMessage());
		  }
		  
		  return "redirect:/";
	          
	    }

}