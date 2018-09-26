package proj.banking.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

import proj.banking.utils.Enums.TransactionType;

public class TransactionLog {
	private Logger transactionLogger = LogManager.getLogger("TransactionLogger");
	
	public synchronized void transactionLog(TransactionType transaction, int bankAccNum, double amount) {
		//if(logger.isDebugEnabled()) {
		//	logger.debug("This is set to debug: "+message);
		//}
		if(transactionLogger.isInfoEnabled()) {
			ThreadContext.put("transactionType", transaction.toString());
			ThreadContext.put("acc_number", Integer.toString(bankAccNum));
			ThreadContext.put("amount", Double.toString(amount));
			//ThreadContext.put("ipAddress", request.getRemoteAddr());
			transactionLogger.info(transaction.toString()+ "\t" + String.format("%10s", bankAccNum) + "\t$" + String.format("%.2f", amount));
			
			ThreadContext.clearAll();
		}
		//logger.warn("This is set to warn: ", message);
		//logger.error("This is set to error: ", message);
		//logger.fatal("This is set to fatal: ", message);
	}

}
