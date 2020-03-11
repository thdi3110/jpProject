package Notice.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import Notice.domain.NoticeVO;
import Notice.service.NoticeService;

@Controller
@SessionAttributes("NoticeVO")
public class NoticeController {
	
      private NoticeService noticeService;
      
      public void setNoticeService(NoticeService noticeService) {
    	  this.noticeService = noticeService;
      }
      
      @RequestMapping(value="/Notice/Noticelist")
      public String list(Model model) {
    	  model.addAttribute("noticeList",noticeService.list());
    	  return "/Notice/Noticelist";
      }
      
      @RequestMapping(value="/Notice/Noticeread/{NBNUM}")
      public String read(Model model , @PathVariable int NBNUM) {
    	  model.addAttribute("noticeVO",noticeService.read(NBNUM));
    	  return "/Notice/Noticeread";
      }
      
      @RequestMapping(value="/Notice/Noticewrite" , method=RequestMethod.GET)
      public String write(Model model) {
    	  model.addAttribute("noticeVO", new NoticeVO());
    	  return "/Notice/Noticewrite";
      }
      
      @RequestMapping(value="/Notice/Noticewrite", method=RequestMethod.POST)
      public String write( Model model, @Valid @ModelAttribute NoticeVO noticeVO, BindingResult bindingResult) {
    	  if(bindingResult.hasErrors()) {
    		  return "/Notice/Noticewrite";
    	  }
    	  model.addAttribute("noticeVO", new NoticeVO());
    	  noticeService.write(noticeVO);
    	  return "redirect:/Notice/Noticelist";
      }
      
      @RequestMapping(value="/Notice/Noticeedit/{NBNUM}" , method=RequestMethod.GET)
      public String edit( @PathVariable int NBNUM , Model model) {
    	  NoticeVO noticeVO = noticeService.read(NBNUM);
    	  model.addAttribute("noticeVO",noticeVO);
    	  return "/Notice/Noticeedit";
      }
      
      @RequestMapping(value="/Notice/Noticeedit/{NBNUM}" , method=RequestMethod.POST)
      public String edit( @Valid @ModelAttribute NoticeVO noticeVO , 
    		  BindingResult result, 
    		  SessionStatus sessionStatus,
    		  Model model) {
    	  if(result.hasErrors()) {
    		  return"/Notice/Noticeedit";
    	  }
    	  else {
    		      noticeService.edit(noticeVO);
    			  sessionStatus.setComplete();
    			  return "redirect:/Notice/Noticelist";
    		  }
      }
      
      @RequestMapping(value="/Notice/Noticedelete/{NBNUM}" , method= {RequestMethod.GET,RequestMethod.POST})
      public String delete( @PathVariable int NBNUM , Model model) {
    	  model.addAttribute("NBNUM",NBNUM);
    	  noticeService.delete(NBNUM);
    	  return "/Notice/Noticelist";
      }      
      
      
      
}
