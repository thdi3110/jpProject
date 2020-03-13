package kr.co.controller;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.service.MemberService;
import kr.co.spring.AuthInfo;
import kr.co.spring.AuthService;
import kr.co.vo.LoginCommand;
import kr.co.vo.MemberVO;



@Controller
public class LoginController {
	
	@Inject
	private AuthService authService;
	@Inject
	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	@Inject
	private BCryptPasswordEncoder pwdEncoderCheck;
	
	public BCryptPasswordEncoder getPwdEncoderCheck() {
		return pwdEncoderCheck;
	}
	@Inject
	public void setPwdEncoderCheck(BCryptPasswordEncoder pwdEncoderCheck) {
		this.pwdEncoderCheck = pwdEncoderCheck;
	}
	
	@Inject
	private MemberService memberService;
	
	@Inject
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
