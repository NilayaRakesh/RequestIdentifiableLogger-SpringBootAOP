package com.nr.identifiablelogging.log;

import com.nr.identifiablelogging.util.ThreadLocalUtil;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class IdentifiableLogger {

    private static final String EXCEPTION_MESSAGE_MARKER = "EXCEPTION MESSAGE: ";
    private static final String SEPARATOR = ", ";

    private org.slf4j.Logger logger;

    public IdentifiableLogger(Class clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    public void info(String message) {
        logger.info(buildIdentifiedMessage(message));
    }

    public void error(String message) {
        logger.error(buildIdentifiedMessage(message));
    }


    public void error(String message, Throwable throwable) {
        StringBuilder finalMessage = new StringBuilder(message)
                .append(SEPARATOR)
                .append(EXCEPTION_MESSAGE_MARKER)
                .append(throwable.getMessage());
        logger.error(buildIdentifiedMessage(new String(finalMessage)), throwable);
    }


    private String buildIdentifiedMessage(String msg) {
        String logId = ThreadLocalUtil.getLogId();
        StringBuilder identifiedMessage = new StringBuilder();
        if (Objects.nonNull(logId)) {
            identifiedMessage.append("[")
                    .append(logId)
                    .append("] ")
                    .append(msg);
        } else {
            identifiedMessage.append(msg);
        }

        return new String(identifiedMessage);
    }
}
