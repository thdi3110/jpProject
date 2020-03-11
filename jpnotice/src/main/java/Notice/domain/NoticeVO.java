package Notice.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;

@Alias("NoticeVO")
public class NoticeVO {
	
private int NBNUM;
private String NBTITLE;
private String NBWRITER;
private String NBCONTENTS;
private Date NBTIME;

public NoticeVO() {}

public NoticeVO(int nBNUM, String nBTITLE, String nBWRITER, String nBCONTENTS, Date nBTIME) {
	super();
	NBNUM = nBNUM;
	NBTITLE = nBTITLE;
	NBWRITER = nBWRITER;
	NBCONTENTS = nBCONTENTS;
	NBTIME = nBTIME;
}

public int getNBNUM() {
	return NBNUM;
}

public void setNBNUM(int nBNUM) {
	NBNUM = nBNUM;
}

public String getNBTITLE() {
	return NBTITLE;
}

public void setNBTITLE(String nBTITLE) {
	NBTITLE = nBTITLE;
}

public String getNBWRITER() {
	return NBWRITER;
}

public void setNBWRITER(String nBWRITER) {
	NBWRITER = nBWRITER;
}

public String getNBCONTENTS() {
	return NBCONTENTS;
}

public void setNBCONTENTS(String nBCONTENTS) {
	NBCONTENTS = nBCONTENTS;
}

public Date getNBTIME() {
	return NBTIME;
}

public void setNBTIME(Date nBTIME) {
	NBTIME = nBTIME;
}

}
