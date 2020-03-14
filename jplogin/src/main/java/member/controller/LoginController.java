package member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import member.domain.AuthInfo;
import member.domain.LoginCommand;
import member.domain.MemberVO;
import member.service.AuthService;
import member.service.MemberService;


@Controller
public class LoginController {

	private AuthService authService;
	

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}	
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public String form(LoginCommand loginCommend) {
		return "/member/login";
	}

	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String submit(HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("MID");
		AuthInfo authInfo = authService.authenticate(id);
		session.setAttribute("authInfo", authInfo);		
		
		return "/member/main";
	}	
	
	@RequestMapping("/member/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/member/main";
	}

}
