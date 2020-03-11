package MEMBER.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import MEMBER.domain.MemberVO;
import MEMBER.mail.SendMail;
import MEMBER.seed.KISA_SEED;
import MEMBER.service.MemberService;

@Controller
public class MemberController {	
	
	private SendMail sm;
		
	public void setSm(SendMail sm) {
		this.sm = sm;
	}

	@Autowired
	private MemberService memberService;

	private BCryptPasswordEncoder pwdEncoder;

	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	public BCryptPasswordEncoder getPwdEncoder() {
		return pwdEncoder;
	}

	public void setPwdEncoder(BCryptPasswordEncoder pwdEncoder) {
		this.pwdEncoder = pwdEncoder;
	}

	@RequestMapping(value = "/MEMBER/main")
	public String main() {
		return "/MEMBER/main";
	}

	@RequestMapping(value = "/MEMBER/agreement")
	public String agreement() {
		return "/MEMBER/agreement";
	}

	@RequestMapping(value = "/MEMBER/selectMember", method = RequestMethod.POST)
	public String selectMember(@RequestParam(value = "agree", defaultValue = "false") Boolean agree) {
		if (!agree) {
			return "/MEMBER/agreement";
		}
		return "/MEMBER/selectMember";
	}

	@RequestMapping(value = "/MEMBER/writeNormal", method = RequestMethod.GET)
	public String writeNormal(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "MEMBER/writeNormal";
	}

	@RequestMapping(value = "/MEMBER/writeNormal", method = RequestMethod.POST)
	public String writeNormal(@Valid MemberVO memberVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/MEMBER/writeNormal";
		}		
		
		String inputPass = memberVO.getM_PASSWORD();
		String pass = pwdEncoder.encode(inputPass);
		memberVO.setM_PASSWORD(pass);

		String pn = memberVO.getPhnum();
		String ph = memberVO.getM_PHONE();
		String phone = pn + "-" + ph;
		memberVO.setM_PHONE(phone);

		if (memberVO.getM_ACCOUNT() != null) {
			KISA_SEED seed = new KISA_SEED();
			try {
				String account = seed.encrypt(memberVO.getM_ACCOUNT());
				memberVO.setM_ACCOUNT(account);
				System.out.println(seed.decrypt(account));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		String email = memberVO.getM_EMAIL();
		int code = (int) (Math.random()*999999)+100000;
		
		sm.sendmail(email, code);
		memberVO.setM_EMAILCHECK(Integer.toString(code));

		memberService.writeNormal(memberVO);

		return "/MEMBER/emailAuthentication";
	}

	@RequestMapping(value = "/MEMBER/writeParcelOut", method = RequestMethod.GET)
	public String writeParcelOut(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "MEMBER/writeParcelOut";
	}

	@RequestMapping(value = "/MEMBER/writeParcelOut", method = RequestMethod.POST)
	public String writeParcelOut(@Valid MemberVO memberVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/MEMBER/writeParcelOut";
		}
		String inputPass = memberVO.getM_PASSWORD();
		String pass = pwdEncoder.encode(inputPass);
		memberVO.setM_PASSWORD(pass);

		String pn = memberVO.getPhnum();
		String ph = memberVO.getM_PHONE();
		String phone = pn + "-" + ph;
		memberVO.setM_PHONE(phone);

		KISA_SEED seed = new KISA_SEED();
		try {
			String account = seed.encrypt(memberVO.getM_ACCOUNT());
			memberVO.setM_ACCOUNT(account);
			System.out.println(seed.decrypt(account));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String email = memberVO.getM_EMAIL();
		int code = (int) (Math.random()*999999)+100000;
		
		sm.sendmail(email, code);
		memberVO.setM_EMAILCHECK(Integer.toString(code));		

		memberService.writeParcelOut(memberVO);
		return "/MEMBER/emailAuthentication";
	}
	
	@RequestMapping(value = "/MEMBER/emailAuthentication", method = RequestMethod.GET)
	public String emailAuthentication(Model model) {
		
		return "MEMBER/emailAuthentication";
	}
	
	@RequestMapping(value = "/MEMBER/emailAuthentication", method = RequestMethod.POST)
	public String emailAuthentication(@ModelAttribute MemberVO memberVO) {
		
		String code = memberVO.getM_EMAILCHECK();		
		memberService.emailAuthentication(code);		
		return "redirect:/MEMBER/main";
	}

	@RequestMapping(value = "/MEMBER/idCheck.do", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String idCheck(HttpServletRequest request) {
		String userId = (String) request.getParameter("M_ID");
		int result = memberService.idCheck(userId);
		return Integer.toString(result);
	}

	@RequestMapping(value = "/MEMBER/regCheck.do", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String regCheck(HttpServletRequest request) {
		String reg = (String) request.getParameter("M_REGISTRATION");
		int result = memberService.regCheck(reg);
		return Integer.toString(result);
	}
	
	@RequestMapping(value = "/MEMBER/emailCheck.do", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String emailChk(HttpServletRequest request) {
		String eck = (String) request.getParameter("M_EMAILCHECK");
		int result = memberService.emailChk(eck);
		return Integer.toString(result);
	}

}
