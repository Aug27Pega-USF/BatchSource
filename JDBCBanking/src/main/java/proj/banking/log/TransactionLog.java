package proj.banking.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import proj.banking.utils.Enums.TransactionType;

public class TransactionLog {
	private static Logger logger = LogManager.getLogger("TransactionLogger");
	
	public void loggerLevel(String message) {
		//if(logger.isDebugEnabled()) {
		//	logger.debug("This is set to debug: "+message);
		//}
		if(logger.isInfoEnabled()) {
			logger.info(message);
		}
		//logger.warn("This is set to warn: ", message);
		//logger.error("This is set to error: ", message);
		//logger.fatal("This is set to fatal: ", message);
	}
	
	public void transactionLog(TransactionType transaction, int bankAccNum, double amount) {
	}
}
