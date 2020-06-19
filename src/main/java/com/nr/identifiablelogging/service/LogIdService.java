package com.nr.identifiablelogging.service;

import com.nr.identifiablelogging.log.IdentifiableLogger;
import com.nr.identifiablelogging.util.ThreadLocalUtil;
import org.springframework.stereotype.Service;

@Service
public class LogIdService {

    private static final IdentifiableLogger LOGGER = new IdentifiableLogger(LogIdService.class);

    public String logAndGetLogId() {
        LOGGER.info("Inside Service. This log should also be printed with the same log id");
        return ThreadLocalUtil.getLogId();
    }
}
