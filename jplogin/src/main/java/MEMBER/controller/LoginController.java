package MEMBER.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import MEMBER.domain.MemberVO;
import MEMBER.service.MemberService;
import MEMBER.spring.AuthInfo;
import MEMBER.spring.AuthService;

@Controller
public class LoginController {

	private AuthService authService;

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	private BCryptPasswordEncoder pwdEncoderCheck;
	
	public BCryptPasswordEncoder getPwdEncoderCheck() {
		return pwdEncoderCheck;
	}

	public void setPwdEncoderCheck(BCryptPasswordEncoder pwdEncoderCheck) {
		this.pwdEncoderCheck = pwdEncoderCheck;
	}
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	public void setMemberService(MemberService memberService) {
		this.memberService = memberService;
	}

	@RequestMapping(value = "/MEMBER/login", method = RequestMethod.GET)
	public String form(LoginCommand loginCommend) {
		return "/MEMBER/login";
	}

	@RequestMapping(value = "/MEMBER/login", method = RequestMethod.POST)
	public String submit(LoginCommand loginCommend, HttpSession session) {

		AuthInfo authInfo = authService.authenticate(loginCommend.getMID());
		session.setAttribute("authInfo", authInfo);		
		
		return "/MEMBER/main";
	}
	
	@RequestMapping(value = "/MEMBER/login.do", method = RequestMethod.GET, produces = "application/text; charset=utf8")
	@ResponseBody
	public String loginCheck(HttpServletRequest request) {
		String userId = (String) request.getParameter("MID");
		String newPassowrd = (String) request.getParameter("MPASSWORD");
		MemberVO member = memberService.loginCheck(userId);
		int result = 0;		
		if(member == null) {
			result = 0;
			return Integer.toString(result);
		}
		String oldPassword = member.getMPASSWORD();
		String emailCheck = member.getMEMAILCHECK();
		
		if(!pwdEncoderCheck.matches(newPassowrd,oldPassword)) {
			 result = 0;
		}else if(!emailCheck.equals("Y")){
			 result = 1;
		}else {
			 result = 2;
		}
		return Integer.toString(result);
	}

}
