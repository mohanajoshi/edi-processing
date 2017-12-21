package dao;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ShipmentStatusMessage extends BaseDao{
	private ISA_InterchangeControlHeader ISA_interchangControlHeader;
	private List<GS_FunctionalGroupHeader> listGS_functionalGroupHeader = new ArrayList<GS_FunctionalGroupHeader>();
	
	public ISA_InterchangeControlHeader getISA_interchangControlHeader() {
		return ISA_interchangControlHeader;
	}
	public void setISA_interchangControlHeader(
			ISA_InterchangeControlHeader iSA_interchangControlHeader) {
		ISA_interchangControlHeader = iSA_interchangControlHeader;
	}
	public GS_FunctionalGroupHeader getGS_functionalGroupHeader(int index) {
		return listGS_functionalGroupHeader.get(index);
	}
	public void addGS_functionalGroupHeader(
			GS_FunctionalGroupHeader gs_functionalGroupHeader) {
		this.listGS_functionalGroupHeader.add(gs_functionalGroupHeader);
	}
	@JsonIgnore
	public GS_FunctionalGroupHeader getGS_functionalGroupHeader_LastElement() {
		if(listGS_functionalGroupHeader.size() >= 1) {
			return listGS_functionalGroupHeader.get(listGS_functionalGroupHeader.size()-1);
		}
		return null;
	}
	public List<GS_FunctionalGroupHeader> getListGS_functionalGroupHeader() {
		return listGS_functionalGroupHeader;
	}
	
//	public String toString() {
//		String op =  "ISA: " + ISA_interchangControlHeader.toString() 
//				+ "\n" + "GS: " + GS_functionalGroupHeader.toString()
//				+ "\n" + "ST list length : " + listST_transactionSetHeader.size();
//		op = op + "\n" + "ST list: {";
//		for(ST_TransactionSetHeader st : listST_transactionSetHeader) {
//			op = op + "\n" + "ST: " + st.toString() + ",";
//		}
//		op = op + "\n" + "}";
//		return op;
//	}
	
}
