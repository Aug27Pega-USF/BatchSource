package proj.banking.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TransactionLog {
	private static Logger logger = LogManager.getLogger(TransactionLog.class);
	
	
	public void loggerLevel(String message) {
		if(logger.isDebugEnabled()) {
			logger.debug("This is set to debug: ", message);
		}
		if(logger.isInfoEnabled()) {
			logger.info("This is set to info: ", message);
		}
		logger.warn("This is set to info: ", message);
		logger.error("This is set to info: ", message);
		logger.fatal("This is set to info: ", message);
	}
}
