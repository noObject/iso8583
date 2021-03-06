package cn.agiledata.iso8583.entity;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import cn.agiledata.iso8583.MessageFactory;
import cn.agiledata.iso8583.util.ISO8583Util;

/**
 * 消费请求报文
 * 
 * @author zln
 *
 */
public class ConsumeRequest extends AbstractRequestMsg {

	private static final long serialVersionUID = 2069184814100605630L;
	
	/**
	 * 沃支付密码
	 */
	private String woePinData;

	/*
	 * 主账号
	 */
	private String primaryAcctNo;
	
	/*
	 * 交易处理码
	 */
	private String processCode;
	
	/*
	 * 交易金额
	 */
	private BigDecimal amount;
	
	/*
	 * 受卡方系统跟踪号
	 */
	private String traceNo;
	
	/*
	 * 服务点输入方式码
	 */
	private String entryMode;
	
	/*
	 * 卡片序列号
	 */
	private String seqNo;
	
	/*
	 * 服务点条件码
	 */
	private String conditionMode;
	
	/*
	 * 服务点PIN获取码
	 */
	private String pinCaptureCode;
	
	/*
	 * 2磁道数据
	 */
	private String track2Data;
	
	/*
	 * 3磁道数据
	 */
	private String track3Data;
	
	/*
	 * 终端号
	 */
	private String terminalNo;
	
	/*
	 * 终端序列号
	 */
	private String terminalSn;
	
	/*
	 * 商户号
	 */
	private String merNo;
	
	/*
	 * 附加响应数据
	 */
	private String additionalData;
	
	/*
	 * 交易货币代码
	 */
	private String currency;
	
	/*
	 * PIN
	 */
	private String pinData;
	
	/*
	 * 安全控制信息
	 */
	private String securityInfo;
	
	/*
	 * MAC
	 */
	private String mac;
	
	/*
	 * 交易类型码
	 */
	private String transType;
	
	/*
	 * 批次号
	 */
	private String batchNo;
	
	private String reserved60;
	
	/*
	 * 手机号
	 */
	private String mobile;
	
	/*
	 * 二维码数据
	 */
	private String barCode;
	
	/*
	 * 账户类型
	 */
	private String accountType;
	
	/*
	 * PBOC电子钱包标准的交易信息
	 */
	private String pbocElecData;
	
	/*
	 * CPU卡防伪随机数
	 */
	private String randomCode;
	
	/*
	 * CPU卡防伪校验码
	 */
	private String verifyCode;
	
	/*
	 * 交易日期
	 */
	private String localDate;
	
	/*
	 * 交易时间
	 */
	private String localTime;
	
	public ConsumeRequest() {
		this.code = MessageFactory.TRANS_CODE_CONSUME;
	}

	public String getPrimaryAcctNo() {
		return primaryAcctNo;
	}

	public void setPrimaryAcctNo(String primaryAcctNo) {
		this.primaryAcctNo = primaryAcctNo;
	}

	public String getProcessCode() {
		return processCode;
	}

	public void setProcessCode(String processCode) {
		this.processCode = processCode;
	}

	public String getAmount() {
		// 转换为单位为分的字符串
		if(this.amount != null) {
			return String.valueOf(this.amount.multiply(new BigDecimal(100)).intValue());
		}
		else {
			return null;
		}
	}

	/**
	 * 金额单位为元，两位小数
	 * @param amount
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getTraceNo() {
		return traceNo;
	}

	public void setTraceNo(String traceNo) {
		this.traceNo = traceNo;
	}

	public String getEntryMode() {
		return entryMode;
	}

	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}

	public String getSeqNo() {
		return seqNo;
	}

	public void setSeqNo(String seqNo) {
		this.seqNo = seqNo;
	}

	public String getConditionMode() {
		return conditionMode;
	}

	public void setConditionMode(String conditionMode) {
		this.conditionMode = conditionMode;
	}

	public String getPinCaptureCode() {
		return pinCaptureCode;
	}

	public void setPinCaptureCode(String pinCaptureCode) {
		this.pinCaptureCode = pinCaptureCode;
	}

	public String getTrack2Data() {
		// 转换二磁信息中的等号为D，便于进行BCD压缩
		if(StringUtils.isNotBlank(track2Data) && track2Data.indexOf("=") > 0) {
			track2Data = track2Data.replace("=", "D");
			return track2Data;
		}
		else {
			return track2Data;
		}
	}

	public void setTrack2Data(String track2Data) {
		this.track2Data = track2Data;
	}

	public String getTrack3Data() {
		return track3Data;
	}

	public void setTrack3Data(String track3Data) {
		this.track3Data = track3Data;
	}

	public String getTerminalNo() {
		return terminalNo;
	}

	public void setTerminalNo(String terminalNo) {
		this.terminalNo = terminalNo;
	}
	

	public String getTerminalSn() {
		return terminalSn;
	}

	public void setTerminalSn(String terminalSn) {
		this.terminalSn = terminalSn;
	}

	public String getMerNo() {
		return merNo;
	}

	public void setMerNo(String merNo) {
		this.merNo = merNo;
	}

	public String getAdditionalData() {
		return additionalData;
	}

	public void setAdditionalData(String additionalData) {
		this.additionalData = additionalData;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPinData() {
		return pinData;
	}

	/**
	 * 参数为十六进制
	 * @param pinData
	 */
	public void setPinData(String pinData) {
		this.pinData = ISO8583Util.byteToBinaryString(ISO8583Util.hexStringToByte(pinData));
	}

	public String getSecurityInfo() {
		return securityInfo;
	}

	public void setSecurityInfo(String securityInfo) {
		this.securityInfo = securityInfo;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}
	
	public void setReserved60(String reserved60) {
		this.reserved60 = reserved60;
	}

	public String getReserved60() {
		return reserved60;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getPbocElecData() {
		return pbocElecData;
	}

	public void setPbocElecData(String pbocElecData) {
		this.pbocElecData = pbocElecData;
	}

	public String getRandomCode() {
		return randomCode;
	}

	public void setRandomCode(String randomCode) {
		this.randomCode = randomCode;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getLocalDate() {
		return localDate;
	}

	public void setLocalDate(String localDate) {
		this.localDate = localDate;
	}

	public String getLocalTime() {
		return localTime;
	}

	public void setLocalTime(String localTime) {
		this.localTime = localTime;
	}

	public String getWoePinData() {
		return woePinData;
	}

	public void setWoePinData(String woePinData) {
		this.woePinData = woePinData;
	}
	
	
}
