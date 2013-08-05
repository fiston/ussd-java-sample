/**
 * 
 */
package ussd.sample;

/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public final class UssdRequest {

    private String Mobile;
    private String SessionId;
    private String Type;
    private String Message;
    private String Operator;
    private Integer Sequence;
    private String ClientState;
    private String ServiceCode;
    
    /**
     * 
     */
    public UssdRequest() {
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return Mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.Mobile = mobile;
    }

    /**
     * @return the sessionId
     */
    public String getSessionId() {
        return SessionId;
    }

    /**
     * @param sessionId the sessionId to set
     */
    public void setSessionId(String sessionId) {
        this.SessionId = sessionId;
    }

    /**
     * @return the type
     */
    public String getType() {
        return Type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.Type = type;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return Message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(String message) {
        this.Message = message;
    }

    /**
     * @return the operator
     */
    public String getOperator() {
        return Operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(String operator) {
        this.Operator = operator;
    }

    /**
     * @return the sequence
     */
    public Integer getSequence() {
        return Sequence;
    }

    /**
     * @param sequence the sequence to set
     */
    public void setSequence(Integer sequence) {
        this.Sequence = sequence;
    }

    /**
     * @return the clientState
     */
    public String getClientState() {
        return ClientState;
    }

    /**
     * @param clientState the clientState to set
     */
    public void setClientState(String clientState) {
        this.ClientState = clientState;
    }

    /**
     * @return the serviceCode
     */
    public String getServiceCode() {
	return ServiceCode;
    }

    /**
     * @param serviceCode the serviceCode to set
     */
    public void setServiceCode(String serviceCode) {
	this.ServiceCode = serviceCode;
    }

	@Override
	public String toString() {
		return String
				.format("UssdRequest [Mobile=%s, SessionId=%s, Type=%s, Message=%s, Operator=%s, Sequence=%s, ClientState=%s, ServiceCode=%s]",
						Mobile, SessionId, Type, Message, Operator, Sequence,
						ClientState, ServiceCode);
	}

}
