package Service.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("NoticeVO")
public class ServiceVO {
	
private int SCNUM;
private String SCTITLE;
private String SCWRITER;
private String SCCONTENTS;
private Date SCTIME;

public ServiceVO() {}

public ServiceVO(int sCNUM, String sCTITLE, String sCWRITER, String sCCONTENTS, Date sCTIME) {
	super();
	SCNUM = sCNUM;
	SCTITLE = sCTITLE;
	SCWRITER = sCWRITER;
	SCCONTENTS = sCCONTENTS;
	SCTIME = sCTIME;
}

public int getSCNUM() {
	return SCNUM;
}

public void setSCNUM(int sCNUM) {
	SCNUM = sCNUM;
}

public String getSCTITLE() {
	return SCTITLE;
}

public void setSCTITLE(String sCTITLE) {
	SCTITLE = sCTITLE;
}

public String getSCWRITER() {
	return SCWRITER;
}

public void setSCWRITER(String sCWRITER) {
	SCWRITER = sCWRITER;
}

public String getSCCONTENTS() {
	return SCCONTENTS;
}

public void setSCCONTENTS(String sCCONTENTS) {
	SCCONTENTS = sCCONTENTS;
}

public Date getSCTIME() {
	return SCTIME;
}

public void setSCTIME(Date sCTIME) {
	SCTIME = sCTIME;
}

}