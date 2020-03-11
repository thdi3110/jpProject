package Service.controller;

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

import Service.domain.ServiceVO;
import Service.service.ServiceService;

@Controller
@SessionAttributes("ServiceVO")
public class ServiceController {
	
    

	private ServiceService serviceService;
      
      public void setServiceService(ServiceService serviceService) {
    	  this.serviceService = serviceService;
      }
      
      public ServiceService getServiceService() {
  		return serviceService;
  	}
      
      @RequestMapping("/")
      public String hello() {
    	  return "hello";
      }
      
      @RequestMapping(value="/Service/Servicelist")
      public String list(Model model) {
    	  model.addAttribute("serviceList",serviceService.list());
    	  return "/Service/Servicelist";
      }
      
      @RequestMapping(value="/Service/Serviceread/{SCNUM}")
      public String read(Model model , @PathVariable int SCNUM) {
    	  model.addAttribute("serviceVO",serviceService.read(SCNUM));
    	  return "/Service/Serviceread";
      }
      
      @RequestMapping(value="/Service/Servicewrite" , method=RequestMethod.GET)
      public String write(Model model) {
    	  model.addAttribute("serviceVO", new ServiceVO());
    	  return "/Service/Servicewrite";
      }
      
      @RequestMapping(value="/Service/Servicewrite", method=RequestMethod.POST)
      public String write( Model model, @Valid @ModelAttribute ServiceVO serviceVO, BindingResult bindingResult) {
    	  if(bindingResult.hasErrors()) {
    		  return "/Service/Servicewrite";
    	  }
    	  model.addAttribute("serviceVO", new ServiceVO());
    	  serviceService.write(serviceVO);
    	  return "redirect:/Service/Servicelist";
      }
      
      @RequestMapping(value="/Service/Serviceedit/{SCNUM}" , method=RequestMethod.GET)
      public String edit( @PathVariable int SCNUM , Model model) {
    	  ServiceVO serviceVO = serviceService.read(SCNUM);
    	  model.addAttribute("serviceVO",serviceVO);
    	  return "/Service/Serviceedit";
      }
      
      @RequestMapping(value="/Service/Serviceedit/{NBNUM}" , method=RequestMethod.POST)
      public String edit( @Valid @ModelAttribute ServiceVO serviceVO , 
    		  BindingResult result, 
    		  SessionStatus sessionStatus,
    		  Model model) {
    	  if(result.hasErrors()) {
    		  return"/Service/Serviceedit";
    	  }
    	  else {
    		      serviceService.edit(serviceVO);
    			  sessionStatus.setComplete();
    			  return "redirect:/Service/Servicelist";
    		  }
      }
      
      @RequestMapping(value="/Service/Servicedelete/{SCNUM}" , method= {RequestMethod.GET,RequestMethod.POST})
      public String delete( @PathVariable int SCNUM , Model model) {
    	  model.addAttribute("SCNUM",SCNUM);
    	  serviceService.delete(SCNUM);
    	  return "/Service/Servicelist";
      }      
      
      
      
}
