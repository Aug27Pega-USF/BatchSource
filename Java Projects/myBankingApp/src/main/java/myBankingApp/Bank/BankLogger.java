package myBankingApp.Bank;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BankLogger implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6885628961405235085L;
	
	
	static Logger logger = LogManager.getLogger(BankLogger.class);
	
	void loggerLevel(String message) { 
		
		if(logger.isDebugEnabled()) {
			logger.debug("This is set to debug: " + message);	
		}
		if(logger.isInfoEnabled()) {
			logger.info("Transaction Info: " + message);
		}
		System.out.println("\n \n \n \n LOGGING SOMETHING.... \n \n \n \n");
	}	
		
}
