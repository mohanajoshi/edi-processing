package com.ct.parser.strategy;

import java.lang.reflect.Method;
import java.util.Properties;

import dao.B10_BeginningSegment;
import dao.L11_ReferenceNumber;
import dao.N1_Name;
import dao.N2_AdditionalNameInformation;
import dao.N3_AddressInformation;
import dao.N4_GeographicLocation;
import dao.N_Info;
import dao.N_Information;
import dao.ST_TransactionSetHeader;
import dao.ShipmentStatusMessage;

public class NParsingStrategy implements ParsingStrategy {
	
	String fieldName = null;
	@Override
	public ShipmentStatusMessage parse(Properties rules, String[] tokens, ShipmentStatusMessage msg) throws Exception {
		Class cls = ShipmentStatusMessage.class;
		Method method = null;
		String methodName = null;
		String mainToken = tokens[0];
		N_Info thisPojo = null;
		for(int i=0;i<tokens.length;i++) {
			if(i==0) {
				fieldName = rules.getProperty(mainToken);
				cls = ST_TransactionSetHeader.class;
				ST_TransactionSetHeader stObj = msg.getGS_functionalGroupHeader_LastElement().getST_transactionSetHeader_LastElement();
				if(stObj!=null) {
					if(mainToken.equals("N1")) {
						N_Information nInfo =  new N_Information();
						thisPojo = new N1_Name();
						nInfo.setN1_name((N1_Name)thisPojo);
						methodName = "add" + fieldName;
						Parser.involkeMethod(cls, stObj, methodName, N_Information.class, nInfo);
					} else {
						N_Information nInfo = stObj.getN_information_lastElement();
						if(mainToken.equals("N2")) {
							thisPojo = new N2_AdditionalNameInformation();
							nInfo.setN2_additionalNameInformation((N2_AdditionalNameInformation)thisPojo);
						} else if(mainToken.equals("N3")) {
							thisPojo = new N3_AddressInformation();
							nInfo.setN3_addressInformation((N3_AddressInformation)thisPojo);
						} else if(mainToken.equals("N4")) {
							thisPojo = new N4_GeographicLocation();
							nInfo.setN4_geographicLocation((N4_GeographicLocation)thisPojo);
						}
					}
				}
			} else {
				if(mainToken.equals("N1")) {
					cls = N1_Name.class;
				} else if(mainToken.equals("N2")) {
					cls = N2_AdditionalNameInformation.class;
				} else if(mainToken.equals("N3")) {
					cls = N3_AddressInformation.class;
				} else if(mainToken.equals("N4")) {
					cls = N4_GeographicLocation.class;
				}
				fieldName = rules.getProperty(Parser.formPropertyKeyToLookFor(i, mainToken));
				methodName = "set" + fieldName;
				Parser.involkeMethod(cls, thisPojo, methodName, String.class, tokens[i]);
			}
		}
		
		return msg;
	}
}
