package dao;

public class N_Information extends BaseDao{
	private N1_Name N1_name;
	private N2_AdditionalNameInformation N2_additionalNameInformation;
	private N3_AddressInformation N3_addressInformation;
	private N4_GeographicLocation N4_geographicLocation;
	public N1_Name getN1_name() {
		return N1_name;
	}
	public void setN1_name(N1_Name n1_name) {
		N1_name = n1_name;
	}
	public N2_AdditionalNameInformation getN2_additionalNameInformation() {
		return N2_additionalNameInformation;
	}
	public void setN2_additionalNameInformation(
			N2_AdditionalNameInformation n2_additionalNameInformation) {
		N2_additionalNameInformation = n2_additionalNameInformation;
	}
	public N3_AddressInformation getN3_addressInformation() {
		return N3_addressInformation;
	}
	public void setN3_addressInformation(N3_AddressInformation n3_addressInformation) {
		N3_addressInformation = n3_addressInformation;
	}
	public N4_GeographicLocation getN4_geographicLocation() {
		return N4_geographicLocation;
	}
	public void setN4_geographicLocation(N4_GeographicLocation n4_geographicLocation) {
		N4_geographicLocation = n4_geographicLocation;
	}
	
	
}
