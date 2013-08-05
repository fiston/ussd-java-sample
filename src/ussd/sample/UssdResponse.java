/**
 * 
 */
package ussd.sample;


/**
 * @author Arsene Tochemey GANDOTE
 *
 */
public final class UssdResponse {

    private String Type;
    private String Message;
    private String ClientState;
    
    /**
     * 
     */
    public UssdResponse() {
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
     * @return the clientState
     */
    public String getClientState() {
        return ClientState;
    }

    /**
     * @param clientState the clientState to set
     * @throws Exception 
     */
    public void setClientState(String clientState){
    	this.ClientState = clientState;
    }

	@Override
	public String toString() {
		return String.format(
				"UssdResponse [Type=%s, Message=%s, ClientState=%s]", Type,
				Message, ClientState);
	}

}
