package jp.ac.ohara.timeseisaku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.timeseisaku.model.StudentHyou;
import jp.ac.ohara.timeseisaku.service.StudentService;

@Controller
public class MainController {
	@Autowired
	private StudentService studentService;

	@GetMapping("/")
    public String index(Model model) {
        return "index";
    }
	

	@GetMapping("/hyouji/")
	  public ModelAndView studenthyou(StudentHyou studenthyou, ModelAndView model)  {
	      model.addObject("studenthyou", studenthyou);
	  
	  model.setViewName("hyouji");
	  return model;
	  
	          
	 
	}
	 @PostMapping("/hyouji/")
	  public String studenthyou(@Validated @ModelAttribute @NonNull StudentHyou studenthyou, RedirectAttributes result, ModelAndView model,
			  RedirectAttributes redirectAttributes) {
		  try {
			  this.studentService.save(studenthyou);
			  redirectAttributes.addFlashAttribute("exception", "");
			  
		  } catch (Exception e) {
			  redirectAttributes.addFlashAttribute("exception", e.getMessage());
		  }
		  
		  return "redirect:/";
	        
	    }
	 @PostMapping("/kou")
	 public String tuika(@Validated @ModelAttribute @NonNull StudentHyou studenthyou, RedirectAttributes result, ModelAndView model,
			  RedirectAttributes redirectAttributes) {
		 try {
			 System.out.println(studenthyou);
			 System.out.println("test");
			 this.studentService.save(studenthyou);
			 redirectAttributes.addFlashAttribute("exception", "");
			  
		  } catch (Exception e) {
			  redirectAttributes.addFlashAttribute("exception", e.getMessage());
			  System.out.println(e);
		  }
		 return "index";
	 }
}