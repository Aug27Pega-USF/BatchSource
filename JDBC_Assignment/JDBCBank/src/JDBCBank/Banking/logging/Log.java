package JDBCBank.Banking.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Log {
	static Logger logger = LogManager.getLogger(Log.class);
	
	private void loggerLevel(String message) {
		
		if(logger.isDebugEnabled()) {
			logger.debug("This is set to debug:" + message);
		}
		if(logger.isInfoEnabled()) {
			logger.info("This is set to info:" + message);
		}
		logger.warn("This is set to warn:" + message);
		logger.error("This is set to error:" + message);
		logger.fatal("This is set to fatal:" + message);
	}
}
