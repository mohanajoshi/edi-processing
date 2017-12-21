package dao;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class GS_FunctionalGroupHeader extends BaseDao{
	
	
	private String GS01_functIdentifierCode;	

	private String GS02_appSenderCode;
	
	private String GS03_appReceiverCode;
	
	private String GS04_ediDate;
	
	private String GS05_ediTime;
	
	private String GS06_grpControlNo;
	
	private String GS07_respAgencyCode;
	
	private String GS08_ediVersionNo;
	
	private List<ST_TransactionSetHeader> listST_transactionSetHeader = new ArrayList<ST_TransactionSetHeader>();
	
	
	public String getGS01_functIdentifierCode() {
		return GS01_functIdentifierCode;
	}

	
	public void setGS01_functIdentifierCode(String gS01_functIdentifierCode) {
		GS01_functIdentifierCode = gS01_functIdentifierCode;
	}

	
	public String getGS02_appSenderCode() {
		return GS02_appSenderCode;
	}

	
	public void setGS02_appSenderCode(String gS02_appSenderCode) {
		GS02_appSenderCode = gS02_appSenderCode;
	}

	
	public String getGS03_appReceiverCode() {
		return GS03_appReceiverCode;
	}

	
	public void setGS03_appReceiverCode(String gS03_appReceiverCode) {
		GS03_appReceiverCode = gS03_appReceiverCode;
	}

	
	public String getGS04_ediDate() {
		return GS04_ediDate;
	}

	public void setGS04_ediDate(String gS04_ediDate) {
		GS04_ediDate = gS04_ediDate;
	}

	
	public String getGS05_ediTime() {
		return GS05_ediTime;
	}

	
	public void setGS05_ediTime(String gS05_ediTime) {
		GS05_ediTime = gS05_ediTime;
	}

	public String getGS06_grpControlNo() {
		return GS06_grpControlNo;
	}

	
	public void setGS06_grpControlNo(String gS06_grpControlNo) {
		GS06_grpControlNo = gS06_grpControlNo;
	}

	
	public String getGS07_respAgencyCode() {
		return GS07_respAgencyCode;
	}
	

	public void setGS07_respAgencyCode(String gS07_respAgencyCode) {
		GS07_respAgencyCode = gS07_respAgencyCode;
	}
	

	public String getGS08_ediVersionNo() {
		return GS08_ediVersionNo;
	}
	

	public void setGS08_ediVersionNo(String gS08_ediVersionNo) {
		GS08_ediVersionNo = gS08_ediVersionNo;
	}
	
	public ST_TransactionSetHeader getST_transactionSetHeader(int index) {
		return listST_transactionSetHeader.get(index);
	}
	
	@JsonIgnore
	public ST_TransactionSetHeader getST_transactionSetHeader_LastElement() {
		if(listST_transactionSetHeader.size() >= 1) {
			return listST_transactionSetHeader.get(listST_transactionSetHeader.size()-1);
		}
		return null;
	}
	public void addST_transactionSetHeader(
			ST_TransactionSetHeader ST_transactionSetHeader) {
		this.listST_transactionSetHeader.add(ST_transactionSetHeader);
	}
	public List<ST_TransactionSetHeader> getListST_transactionSetHeader() {
		return listST_transactionSetHeader;
	}
	
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "GS01: " + GS01_functIdentifierCode + ", GS02: " + GS02_appSenderCode ;
//	}
}
