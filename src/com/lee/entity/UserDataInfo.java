package com.lee.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "user_data_info")
public class UserDataInfo implements Serializable {
	/**
	 * default
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "USER_ID")
	private BigInteger USER_ID;
	
	@Column(name = "LINKMAN")
	private String LINKMAN;
	
	@Column(name = "COMPANY_ADDRESS")
	private String COMPANY_ADDRESS;
	
	@Column(name = "POSTAL_CODE")
	private BigInteger POSTAL_CODE;
	
	@Column(name = "COMPANY_WEBSITE")
	private String COMPANY_WEBSITE;
	
	@Column(name = "EMAIL")
	private String EMAIL;
	
	@Column(name = "CONTACT_NUMBER")
	private String CONTACT_NUMBER;
	
	@Column(name = "MOBILE_PHONE")
	private String MOBILE_PHONE;
	
	@Column(name = "COMPANY_FAX")
	private String COMPANY_FAX;
	
	@Column(name = "COMPANY_NAME")
	private String COMPANY_NAME;
	
	@Column(name = "LEGAL_PERSON")
	private String LEGAL_PERSON;
	
	@Column(name = "BUSI_LICE_NUMBER")
	private String BUSI_LICE_NUMBER;
	
	@Column(name = "BUSI_LICE_NUMBER_URL")
	private String BUSI_LICE_NUMBER_URL;
	
	@Column(name = "QUALIFICATION_DOC")
	private BigInteger QUALIFICATION_DOC;
	
	@Column(name = "QUALIFICATION_DOC_URL")
	private String QUALIFICATION_DOC_URL;
	
	@Column(name = "FOUNDING_TIME")
	private Timestamp FOUNDING_TIME;
	
	@Column(name = "COMPANY_PROFILE")
	private String COMPANY_PROFILE;
	
	@Column(name = "COMPANY_PICTURE")
	private BigInteger COMPANY_PICTURE;
	
	@Column(name = "COMPANY_PICTURE_URL")
	private String COMPANY_PICTURE_URL;
	
	@Column(name = "IDENTIFICATION")
	private String IDENTIFICATION;
	
	@Column(name = "LOGIN_NAME")
	private String LOGIN_NAME;
	
	@Column(name = "USER_TYPE")
	private Long USER_TYPE;
	
	@Column(name = "USER_PRICE")
	private BigInteger USER_PRICE;
	
	@Column(name = "USER_PRICE_URL")
	private String USER_PRICE_URL;
	
	@Column(name = "IDEN_PICTURE")
	private BigInteger IDEN_PICTURE;
	
	@Column(name = "IDEN_PICTURE_URL")
	private String IDEN_PICTURE_URL;
	
	@Column(name = "STATE")
	private Long STATE;
	
	@Column(name = "CHANNEL_TYPE")
	private String CHANNEL_TYPE;
	
	@Column(name = "ORG_ID")
	private Long ORG_ID;
	
	@Column(name = "ROOT_ORG_ID")
	private Long ROOT_ORG_ID;
	
	@Column(name = "DRIVING_LICENSE")
	private BigInteger DRIVING_LICENSE;
	
	@Column(name = "DRIVING_LICENSE_URL")
	private String DRIVING_LICENSE_URL;
	
	@Column(name = "ADRIVER_LICENSE_URL")
	private String ADRIVER_LICENSE_URL;
	
	@Column(name = "ADRIVER_LICENSE")
	private BigInteger ADRIVER_LICENSE;
	
	@Column(name = "STATE_REASON")
	private String STATE_REASON;
	
	@Column(name = "MANAGER_REMARK")
	private String MANAGER_REMARK;
	
	@Column(name = "OP_ID")
	private BigInteger OP_ID;
	
	@Column(name = "OP_DATE")
	private Timestamp OP_DATE;
	
	@Column(name = "ID_TYPE")
	private Long ID_TYPE;
	
	@Column(name = "INVITE_BILL_ID")
	private String INVITE_BILL_ID;
	
	@Column(name = "NOTARIZE_COUNT")
	private Long NOTARIZE_COUNT;
	
	@Column(name = "is_perfect_info")
	private Integer is_perfect_info;
	
	@Column(name = "create_date")
	private Timestamp create_date;
	
	@Column(name = "auth_pass_date")
	private Timestamp auth_pass_date;
	
	@Column(name = "QR_CODE_ID")
	private BigInteger QR_CODE_ID;
	
	@Column(name = "QR_CODE_URL")
	private String QR_CODE_URL;
	
	@Column(name = "SOURCE_FLAG")
	private Long SOURCE_FLAG;
	
	@Column(name = "COMPANY_NAME_SHORT")
	private String COMPANY_NAME_SHORT;
	
	@Column(name = "AUTH_IMPORTANT")
	private Long AUTH_IMPORTANT;
	
	@Column(name = "AUTH_IMPORTANT_REASON")
	private String AUTH_IMPORTANT_REASON;
	
	@Column(name = "PROVINCE_ID")
	private BigInteger PROVINCE_ID;

	public BigInteger getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(BigInteger uSER_ID) {
		USER_ID = uSER_ID;
	}

	public String getLINKMAN() {
		return LINKMAN;
	}

	public void setLINKMAN(String lINKMAN) {
		LINKMAN = lINKMAN;
	}

	public String getCOMPANY_ADDRESS() {
		return COMPANY_ADDRESS;
	}

	public void setCOMPANY_ADDRESS(String cOMPANY_ADDRESS) {
		COMPANY_ADDRESS = cOMPANY_ADDRESS;
	}

	public BigInteger getPOSTAL_CODE() {
		return POSTAL_CODE;
	}

	public void setPOSTAL_CODE(BigInteger pOSTAL_CODE) {
		POSTAL_CODE = pOSTAL_CODE;
	}

	public String getCOMPANY_WEBSITE() {
		return COMPANY_WEBSITE;
	}

	public void setCOMPANY_WEBSITE(String cOMPANY_WEBSITE) {
		COMPANY_WEBSITE = cOMPANY_WEBSITE;
	}

	public String getEMAIL() {
		return EMAIL;
	}

	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}

	public String getCONTACT_NUMBER() {
		return CONTACT_NUMBER;
	}

	public void setCONTACT_NUMBER(String cONTACT_NUMBER) {
		CONTACT_NUMBER = cONTACT_NUMBER;
	}

	public String getMOBILE_PHONE() {
		return MOBILE_PHONE;
	}

	public void setMOBILE_PHONE(String mOBILE_PHONE) {
		MOBILE_PHONE = mOBILE_PHONE;
	}

	public String getCOMPANY_FAX() {
		return COMPANY_FAX;
	}

	public void setCOMPANY_FAX(String cOMPANY_FAX) {
		COMPANY_FAX = cOMPANY_FAX;
	}

	public String getCOMPANY_NAME() {
		return COMPANY_NAME;
	}

	public void setCOMPANY_NAME(String cOMPANY_NAME) {
		COMPANY_NAME = cOMPANY_NAME;
	}

	public String getLEGAL_PERSON() {
		return LEGAL_PERSON;
	}

	public void setLEGAL_PERSON(String lEGAL_PERSON) {
		LEGAL_PERSON = lEGAL_PERSON;
	}

	public String getBUSI_LICE_NUMBER() {
		return BUSI_LICE_NUMBER;
	}

	public void setBUSI_LICE_NUMBER(String bUSI_LICE_NUMBER) {
		BUSI_LICE_NUMBER = bUSI_LICE_NUMBER;
	}

	public String getBUSI_LICE_NUMBER_URL() {
		return BUSI_LICE_NUMBER_URL;
	}

	public void setBUSI_LICE_NUMBER_URL(String bUSI_LICE_NUMBER_URL) {
		BUSI_LICE_NUMBER_URL = bUSI_LICE_NUMBER_URL;
	}

	public BigInteger getQUALIFICATION_DOC() {
		return QUALIFICATION_DOC;
	}

	public void setQUALIFICATION_DOC(BigInteger qUALIFICATION_DOC) {
		QUALIFICATION_DOC = qUALIFICATION_DOC;
	}

	public String getQUALIFICATION_DOC_URL() {
		return QUALIFICATION_DOC_URL;
	}

	public void setQUALIFICATION_DOC_URL(String qUALIFICATION_DOC_URL) {
		QUALIFICATION_DOC_URL = qUALIFICATION_DOC_URL;
	}

	public Timestamp getFOUNDING_TIME() {
		return FOUNDING_TIME;
	}

	public void setFOUNDING_TIME(Timestamp fOUNDING_TIME) {
		FOUNDING_TIME = fOUNDING_TIME;
	}

	public String getCOMPANY_PROFILE() {
		return COMPANY_PROFILE;
	}

	public void setCOMPANY_PROFILE(String cOMPANY_PROFILE) {
		COMPANY_PROFILE = cOMPANY_PROFILE;
	}

	public BigInteger getCOMPANY_PICTURE() {
		return COMPANY_PICTURE;
	}

	public void setCOMPANY_PICTURE(BigInteger cOMPANY_PICTURE) {
		COMPANY_PICTURE = cOMPANY_PICTURE;
	}

	public String getCOMPANY_PICTURE_URL() {
		return COMPANY_PICTURE_URL;
	}

	public void setCOMPANY_PICTURE_URL(String cOMPANY_PICTURE_URL) {
		COMPANY_PICTURE_URL = cOMPANY_PICTURE_URL;
	}

	public String getIDENTIFICATION() {
		return IDENTIFICATION;
	}

	public void setIDENTIFICATION(String iDENTIFICATION) {
		IDENTIFICATION = iDENTIFICATION;
	}

	public String getLOGIN_NAME() {
		return LOGIN_NAME;
	}

	public void setLOGIN_NAME(String lOGIN_NAME) {
		LOGIN_NAME = lOGIN_NAME;
	}

	public Long getUSER_TYPE() {
		return USER_TYPE;
	}

	public void setUSER_TYPE(Long uSER_TYPE) {
		USER_TYPE = uSER_TYPE;
	}

	public BigInteger getUSER_PRICE() {
		return USER_PRICE;
	}

	public void setUSER_PRICE(BigInteger uSER_PRICE) {
		USER_PRICE = uSER_PRICE;
	}

	public String getUSER_PRICE_URL() {
		return USER_PRICE_URL;
	}

	public void setUSER_PRICE_URL(String uSER_PRICE_URL) {
		USER_PRICE_URL = uSER_PRICE_URL;
	}

	public BigInteger getIDEN_PICTURE() {
		return IDEN_PICTURE;
	}

	public void setIDEN_PICTURE(BigInteger iDEN_PICTURE) {
		IDEN_PICTURE = iDEN_PICTURE;
	}

	public String getIDEN_PICTURE_URL() {
		return IDEN_PICTURE_URL;
	}

	public void setIDEN_PICTURE_URL(String iDEN_PICTURE_URL) {
		IDEN_PICTURE_URL = iDEN_PICTURE_URL;
	}

	public Long getSTATE() {
		return STATE;
	}

	public void setSTATE(Long sTATE) {
		STATE = sTATE;
	}

	public String getCHANNEL_TYPE() {
		return CHANNEL_TYPE;
	}

	public void setCHANNEL_TYPE(String cHANNEL_TYPE) {
		CHANNEL_TYPE = cHANNEL_TYPE;
	}

	public Long getORG_ID() {
		return ORG_ID;
	}

	public void setORG_ID(Long oRG_ID) {
		ORG_ID = oRG_ID;
	}

	public Long getROOT_ORG_ID() {
		return ROOT_ORG_ID;
	}

	public void setROOT_ORG_ID(Long rOOT_ORG_ID) {
		ROOT_ORG_ID = rOOT_ORG_ID;
	}

	public BigInteger getDRIVING_LICENSE() {
		return DRIVING_LICENSE;
	}

	public void setDRIVING_LICENSE(BigInteger dRIVING_LICENSE) {
		DRIVING_LICENSE = dRIVING_LICENSE;
	}

	public String getDRIVING_LICENSE_URL() {
		return DRIVING_LICENSE_URL;
	}

	public void setDRIVING_LICENSE_URL(String dRIVING_LICENSE_URL) {
		DRIVING_LICENSE_URL = dRIVING_LICENSE_URL;
	}

	public String getADRIVER_LICENSE_URL() {
		return ADRIVER_LICENSE_URL;
	}

	public void setADRIVER_LICENSE_URL(String aDRIVER_LICENSE_URL) {
		ADRIVER_LICENSE_URL = aDRIVER_LICENSE_URL;
	}

	public BigInteger getADRIVER_LICENSE() {
		return ADRIVER_LICENSE;
	}

	public void setADRIVER_LICENSE(BigInteger aDRIVER_LICENSE) {
		ADRIVER_LICENSE = aDRIVER_LICENSE;
	}

	public String getSTATE_REASON() {
		return STATE_REASON;
	}

	public void setSTATE_REASON(String sTATE_REASON) {
		STATE_REASON = sTATE_REASON;
	}

	public String getMANAGER_REMARK() {
		return MANAGER_REMARK;
	}

	public void setMANAGER_REMARK(String mANAGER_REMARK) {
		MANAGER_REMARK = mANAGER_REMARK;
	}

	public BigInteger getOP_ID() {
		return OP_ID;
	}

	public void setOP_ID(BigInteger oP_ID) {
		OP_ID = oP_ID;
	}

	public Timestamp getOP_DATE() {
		return OP_DATE;
	}

	public void setOP_DATE(Timestamp oP_DATE) {
		OP_DATE = oP_DATE;
	}

	public Long getID_TYPE() {
		return ID_TYPE;
	}

	public void setID_TYPE(Long iD_TYPE) {
		ID_TYPE = iD_TYPE;
	}

	public String getINVITE_BILL_ID() {
		return INVITE_BILL_ID;
	}

	public void setINVITE_BILL_ID(String iNVITE_BILL_ID) {
		INVITE_BILL_ID = iNVITE_BILL_ID;
	}

	public Long getNOTARIZE_COUNT() {
		return NOTARIZE_COUNT;
	}

	public void setNOTARIZE_COUNT(Long nOTARIZE_COUNT) {
		NOTARIZE_COUNT = nOTARIZE_COUNT;
	}

	public Integer getIs_perfect_info() {
		return is_perfect_info;
	}

	public void setIs_perfect_info(Integer is_perfect_info) {
		this.is_perfect_info = is_perfect_info;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Timestamp getAuth_pass_date() {
		return auth_pass_date;
	}

	public void setAuth_pass_date(Timestamp auth_pass_date) {
		this.auth_pass_date = auth_pass_date;
	}

	public BigInteger getQR_CODE_ID() {
		return QR_CODE_ID;
	}

	public void setQR_CODE_ID(BigInteger qR_CODE_ID) {
		QR_CODE_ID = qR_CODE_ID;
	}

	public String getQR_CODE_URL() {
		return QR_CODE_URL;
	}

	public void setQR_CODE_URL(String qR_CODE_URL) {
		QR_CODE_URL = qR_CODE_URL;
	}

	public Long getSOURCE_FLAG() {
		return SOURCE_FLAG;
	}

	public void setSOURCE_FLAG(Long sOURCE_FLAG) {
		SOURCE_FLAG = sOURCE_FLAG;
	}

	public String getCOMPANY_NAME_SHORT() {
		return COMPANY_NAME_SHORT;
	}

	public void setCOMPANY_NAME_SHORT(String cOMPANY_NAME_SHORT) {
		COMPANY_NAME_SHORT = cOMPANY_NAME_SHORT;
	}

	public Long getAUTH_IMPORTANT() {
		return AUTH_IMPORTANT;
	}

	public void setAUTH_IMPORTANT(Long aUTH_IMPORTANT) {
		AUTH_IMPORTANT = aUTH_IMPORTANT;
	}

	public String getAUTH_IMPORTANT_REASON() {
		return AUTH_IMPORTANT_REASON;
	}

	public void setAUTH_IMPORTANT_REASON(String aUTH_IMPORTANT_REASON) {
		AUTH_IMPORTANT_REASON = aUTH_IMPORTANT_REASON;
	}

	public BigInteger getPROVINCE_ID() {
		return PROVINCE_ID;
	}

	public void setPROVINCE_ID(BigInteger pROVINCE_ID) {
		PROVINCE_ID = pROVINCE_ID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
