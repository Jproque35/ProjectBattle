package game.managers;

public abstract class NotificationManager {

	protected boolean notificationReady;
	protected String message;
	
	/**
	 * Readies a message to be sent.
	 * 
	 * @param message The message to be sent.
	 */
	public void readyNotification(String message) {
		
		this.message = message;
		this.notificationReady = true;
		
	}
	
	/**
	 * Method retrieving the status of the message to be sent
	 * 
	 * @return Returns true if the notification is ready to be sent. Otherwise, returns  false.
	 */
	public boolean isNotificationReady() {
		
		return notificationReady;
		
	}
	
	/**
	 * Sends the message by returning it as a String.
	 * 
	 * @return Returns the string that was stored in the NotificationManager
	 */
	public String sendNotification() {

		if(notificationReady) {
			
			notificationReady = false;
			return message;
			
		}
		
		return "";
		
	}
	
}
