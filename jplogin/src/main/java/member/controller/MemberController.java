package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import member.domain.LoginCommand;
import member.domain.MemberVO;
import member.service.MemberService;


@Controller
public class MemberController {		

	
	private MemberService memberService;

	
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}
	
	@RequestMapping(value = "/member/main")
	public String main() {
		return "/member/main";
	}

	@RequestMapping(value = "/member/agreement")
	public String agreement() {
		return "/member/agreement";
	}

	@RequestMapping(value = "/member/selectMember", method = RequestMethod.POST)
	public String selectMember(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		if (!agree) {
			return "/member/agreement";
		}
		return "/member/selectMember";
	}

	@RequestMapping(value = "/member/writeNormal", method = RequestMethod.GET)
	public String writeNormal(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "/member/writeNormal";
	}

	@RequestMapping(value = "/member/writeNormal", method = RequestMethod.POST)
	public String writeNormal(MemberVO memberVO,HttpServletRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/member/writeNormal";
		}		
		String password = request.getParameter("MPASSWORD");
		String email = request.getParameter("MEMAIL");		
		String phnum = request.getParameter("phnum");
		String phone = request.getParameter("MPHONE");		
		String account = request.getParameter("MACCOUNT");
		
		memberService.writeNormal(memberVO, password, email, phnum, phone, account);
		
		return "/member/emailAuthentication";
	}

	@RequestMapping(value = "/member/writeParcelOut", method = RequestMethod.GET)
	public String writeParcelOut(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "/member/writeParcelOut";
	}

	@RequestMapping(value = "/member/writeParcelOut", method = RequestMethod.POST)
	public String writeParcelOut(MemberVO memberVO, HttpServletRequest request, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/member/writeParcelOut";
		}	
		
		String password = request.getParameter("MPASSWORD");
		String email = request.getParameter("MEMAIL");		
		String phnum = request.getParameter("phnum");
		String phone = request.getParameter("MPHONE");		
		String account = request.getParameter("MACCOUNT");
		
		memberService.writeParcelOut(memberVO, password, email, phnum, phone, account);
		
		return "/member/emailAuthentication";
	}
	
	@RequestMapping(value = "/member/emailAuthentication", method = RequestMethod.GET)
	public String emailAuthentication(Model model) {
		
		return "/member/emailAuthentication";
	}
	
	@RequestMapping(value = "/member/emailAuthentication", method = RequestMethod.POST)
	public String emailAuthentication(MemberVO memberVO) {
		
		String code = memberVO.getMEMAILCHECK();		
		memberService.emailAuthentication(code);		
		return "redirect:/member/main";
	}
	
	@RequestMapping(value = "/member/reEmailAuthentication", method = RequestMethod.GET)
	public String reEmailAuthentication(Model model) {
		
		return "/member/reEmailAuthentication";
	}
	
	@RequestMapping(value = "/member/reEmailAuthentication", method = RequestMethod.POST)
	public String reEmailAuthentication(HttpServletRequest request) {
		
		String code = request.getParameter("MEMAILCHECK");
		memberService.emailAuthentication(code);		
		return "redirect:/member/login";
	}

	@RequestMapping(value = "/member/idCheck", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String userId = (String) request.getParameter("MID");		
		int result = memberService.idCheck(userId);
		return Integer.toString(result);
	}

	@RequestMapping(value = "/member/regCheck", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String regCheck(HttpServletRequest request) {
		String reg = (String) request.getParameter("MREGISTRATION");
		int result = memberService.regCheck(reg);
		return Integer.toString(result);
	}
	
	@RequestMapping(value = "/member/emailCheck", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String emailChk(HttpServletRequest request) {
		String eck = (String) request.getParameter("MEMAILCHECK");		
		int result = 0;
		if(eck == null) {
			result = 2;
			return Integer.toString(result);
		}
		
		result = memberService.emailChk(eck);		
		return Integer.toString(result);
	}
	
	@RequestMapping(value = "/member/sendEmail", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String sendEmail(HttpServletRequest request) {
		
		String MID = (String) request.getParameter("MID");		
		
		String result = memberService.sendEmail(MID);
		
		return result;
	}
	
	@RequestMapping(value = "/member/findId", method = RequestMethod.GET)
	public String findId(Model model) {
		
		return "/member/findId";
	}
	
	@RequestMapping(value = "/member/findId", method = RequestMethod.POST)
	public String findId(HttpServletRequest request) {
		
		String email = request.getParameter("MEMAIL");
		memberService.findId(email);
		
		return "redirect:/member/login";
	}	
	
	@RequestMapping(value = "/member/findIdEmailCheck", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String findIdEmailCheck(HttpServletRequest request) {
		String email = (String) request.getParameter("MEMAIL");
		int result = memberService.findIdEmailCheck(email);
		return Integer.toString(result);
	}
	
	@RequestMapping(value = "/member/findPassword", method = RequestMethod.GET)
	public String findPassword(Model model) {
		
		return "/member/findPassword";
	}
	
	
	@RequestMapping(value = "/member/findPassword", method = RequestMethod.POST)
	public String findPassword(HttpServletRequest request) {
		
		String email = (String) request.getParameter("MEMAIL");
		String id = (String) request.getParameter("MID");

		memberService.updatePassword(id, email);
		
		return "redirect:/member/login";
	}
	
	@RequestMapping(value = "/member/findPasswordCheck", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String findPasswordCheck(HttpServletRequest request) {
		String email = (String) request.getParameter("MEMAIL");
		String id = (String) request.getParameter("MID");
		int result = memberService.findPasswordCheck(id ,email);
		return Integer.toString(result);
	}
	
	@RequestMapping(value = "/member/loginCheck", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String loginCheck(HttpSession session, HttpServletRequest request) {
		String id = (String) request.getParameter("MID");
		String matchPassword = request.getParameter("MPASSWORD");		
		String result = memberService.loginCheck(id, matchPassword);
		
		return result;
	}
}
