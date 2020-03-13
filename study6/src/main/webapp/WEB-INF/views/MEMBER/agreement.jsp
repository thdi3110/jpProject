<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이용약관</title>
</head>
<body>
	<form action = "${pageContext.request.contextPath}/MEMBER/selectMember" method = "post">
	<div class="mainContent oneColumnLayout">
		<div id="liteboxHook" class="contentModuleWrapper">
			<div class="contentModule contentModuleFirst" id="contentModule-0">




				<div style="width: 93.807em">
					<h1>
						<center>
							<b>개인정보 수집ㆍ이용 동의(필수 사항)</b>
						</center>
					</h1>
				</div>



				<div style="clear: both;"></div>
			</div>
			<div class="contentModule" id="contentModule-1">




				<div class="plainDividerModule" style="width: 93.807em;"></div>


				<div style="clear: both;"></div>
			</div>
			<div class="contentModule" id="contentModule-2">




				<div style="width: 93.807em; float: left;">
					<h5 class=" fgColor_333333 fontStyleRegular"></h5>
					<span class="text fgColor_333333 fontStyleRegular">
						<b>Safety Pet</b>는 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」에 따라 다음과 같이 손님의
						개인정보를 수집ㆍ이용합니다. 본 개인정보의 수집ㆍ이용에 동의하지 않으실 경우 Safety Pet의 웹 홈페이지를
						 통한 회원가입이 불가능하고, 회원가입을 전제로 Safety Pet이 제공하는 서비스 기타 혜택을 받을 수 없습니다.
					</span>
				</div>



				<div style="clear: both;"></div>
			</div>
			<div class="contentModule" id="contentModule-3">




				<div style="width: 93.807em; float: left;">
					<h4 class=" fgColor_333333 fontStyleBold">1. 개인정보 수집ㆍ이용 목적</h4>
					<span class="text fgColor_333333 fontStyleRegular">(1) 홈페이지
						회원 가입 및 관리<br /> 회원가입 의사확인, 본인 식별ㆍ인증, 회원자격 유지ㆍ관리, 서비스 부정이용 방지, 각종 고지ㆍ통지, 이용약관 위반 회원에 대한 이용제한 조치, 서비스의 원활한 운영에
						지장을 미치는 행위 및 서비스 부정이용행위 제재, 가입 및 가입횟수 제한, 탈퇴의사 확인<br /> <br />
						(2) 재화 또는 서비스 제공<br /> 웹 홈페이지을 통한 서비스제공 등 서비스 이용과 관련된 회원확인 등 문제해결<br />
						<br /> (3) 서비스 개선<br /> 웹 홈페이지을
						이용한 서비스를 이용자의 컴퓨터 등 정보통신기기에 최적화된 방식으로 제공할 수 있도록 개선, 서비스 개발, 개선 등
						Safety Pet의 업무와 관련된 통계자료의 작성<br /> <br /> (4) 민원 처리<br /> 민원인의 신원확인,
						민원사항 확인, 사실조사를 위한 연락ㆍ통지, 처리결과 통보
					</span>
				</div>



				<div style="clear: both;"></div>
			</div>
			<div class="contentModule" id="contentModule-4">




				<div style="width: 93.807em; float: left;">
					<h4 class=" fgColor_333333 fontStyleBold">2. 수집하는 개인정보</h4>
					<span class="text fgColor_333333 fontStyleRegular">(1)
						회원가입정보: 성명(이름, 성), 휴대전화번호, 이메일, 주소, 계좌번호, 동물등록번호<br /> 
					</span>
				</div>



				<div style="clear: both;"></div>
			</div>
			<div class="contentModule" id="contentModule-5">




				<div style="width: 93.807em; float: left;">
					<h4 class=" fgColor_333333 fontStyleBold">3. 개인정보의 보유ㆍ이용 기간</h4>
					<span class="text fgColor_333333 fontStyleRegular">(1) 수집된
						개인정보는 원칙적으로 회원가입 시부터 회원탈퇴 시까지 이용됩니다.<br /> (2) 손님이 회원탈퇴를 하는 경우에는
						법령에 따라 개인정보를 보유해야 하는 경우 또는 이미 발생한 민원처리 등 회원탈퇴 이후에도 개인정보를 이용하여야 하는
						사유가 있는 경우를 제외하고는 개인정보를 지체 없이 관련 법령이 정한 바에 따라 파기합니다.
					</span>
				</div>
			</div>
		</div>
	</div>
	<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	<div>
		<label>
			<input type="checkbox" name = "agree" id = "agree" value = "true" required="required">약관동의		
		</label><br/><br/>
		<input type = "submit" id = "agreement" value = "다음 단계">
	</div>
	</form>	
</body>
</html>