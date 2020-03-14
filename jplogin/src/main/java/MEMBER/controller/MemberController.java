package member.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import member.domain.MemberVO;
import member.mail.SendMail;
import member.seed.KISA_SEED;
import member.service.MemberService;


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
	public String writeNormal(@Valid MemberVO memberVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/member/writeNormal";
		}		
		
		String inputPass = memberVO.getMPASSWORD();
		String pass = pwdEncoder.encode(inputPass);
		memberVO.setMPASSWORD(pass);

		String pn = memberVO.getPhnum();
		String ph = memberVO.getMPHONE();
		String phone = pn + "-" + ph;
		memberVO.setMPHONE(phone);

		if (memberVO.getMACCOUNT() != null) {
			KISA_SEED seed = new KISA_SEED();
			try {
				String account = seed.encrypt(memberVO.getMACCOUNT());
				memberVO.setMACCOUNT(account);
				System.out.println(seed.decrypt(account));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		String email = memberVO.getMEMAIL();
		String code = Integer.toString((int) ((Math.random()*999999)+100000));
		
		sm.sendmail(email, code);
		memberVO.setMEMAILCHECK(code);

		memberService.writeNormal(memberVO);

		return "/member/emailAuthentication";
	}

	@RequestMapping(value = "/member/writeParcelOut", method = RequestMethod.GET)
	public String writeParcelOut(Model model) {
		model.addAttribute("memberVO", new MemberVO());
		return "/member/writeParcelOut";
	}

	@RequestMapping(value = "/member/writeParcelOut", method = RequestMethod.POST)
	public String writeParcelOut(@Valid MemberVO memberVO, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "/member/writeParcelOut";
		}
		String inputPass = memberVO.getMPASSWORD();
		String pass = pwdEncoder.encode(inputPass);
		memberVO.setMPASSWORD(pass);

		String pn = memberVO.getPhnum();
		String ph = memberVO.getMPHONE();
		String phone = pn + "-" + ph;
		memberVO.setMPHONE(phone);

		KISA_SEED seed = new KISA_SEED();
		try {
			String account = seed.encrypt(memberVO.getMACCOUNT());
			memberVO.setMACCOUNT(account);
			System.out.println(seed.decrypt(account));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		String email = memberVO.getMEMAIL();
		String code = Integer.toString((int) ((Math.random()*999999)+100000));
		
		sm.sendmail(email, code);
		memberVO.setMEMAILCHECK(code);		

		memberService.writeParcelOut(memberVO);
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
		System.out.println(result);
		return Integer.toString(result);
	}
	
	@RequestMapping(value = "/member/sendEmail", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	@ResponseBody
	public String sendEmail(HttpServletRequest request) {
		String MID = (String) request.getParameter("MID");		
		
		MemberVO member = memberService.sendEmail(MID);
		int result = 0;
		if(member==null) {
			result = 0;
			return Integer.toString(result);
		}
		String email = member.getMEMAIL();
		String emailCheck = member.getMEMAILCHECK();
		
		if(emailCheck.equals("Y")) {
			 result = 2;
			return Integer.toString(result);
		}
		
		String code = Integer.toString((int) ((Math.random()*999999)+100000));
		
		sm.sendmail(email, code);
		memberService.updateEmailCode(code, email);
		result = 1;
		
		return Integer.toString(result);
	}
	
	@RequestMapping(value = "/member/findId", method = RequestMethod.GET)
	public String findId(Model model) {
		
		return "/member/findId";
	}
	
	@RequestMapping(value = "/member/findId", method = RequestMethod.POST)
	public String findId(HttpServletRequest request) {
		
		String email = request.getParameter("MEMAIL");
		MemberVO member = memberService.findId(email);
		String id = member.getMID();
		
		sm.sendmailFindId(email, id);
		
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
		String code = Integer.toString((int) ((Math.random()*999999)+100000));
		
		sm.temporaryPassword(email, id, code);
		
		String temporaryPass = pwdEncoder.encode(code);
		
		memberService.updatePassword(id, email, temporaryPass);
		
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
	
	
}
