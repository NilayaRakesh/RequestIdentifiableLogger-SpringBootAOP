package com.nr.identifiablelogging.controller;

import com.nr.identifiablelogging.annotation.IdentifiableLogging;
import com.nr.identifiablelogging.log.IdentifiableLogger;
import com.nr.identifiablelogging.service.LogIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogIdController {

    private LogIdService logIdService;

    private static final IdentifiableLogger LOGGER = new IdentifiableLogger(LogIdController.class);

    @Autowired
    public LogIdController(LogIdService logIdService) {
        this.logIdService = logIdService;
    }

    @GetMapping("/log_id")
    @IdentifiableLogging("GET_LOG_ID_REQ")
    public ResponseEntity<String> getLogId() {
        LOGGER.info("Entering controller. This log should be printed with log id");
        String logId = logIdService.logAndGetLogId();
        LOGGER.info("Exiting controller. This log should be printed with the same log id");
        return new ResponseEntity<>(logId, HttpStatus.OK);
    }
}
