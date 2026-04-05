package com.wallet.DigitalWallet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DebugController {

    @Value("${spring.h2.console.enabled:false}")
    private boolean h2Enabled;

    @Value("${spring.h2.console.path:/h2-console}")
    private String h2Path;

    @GetMapping("/debug/h2-config")
    public String checkH2Config() {
        return "H2 Console Enabled: " + h2Enabled + "\n" +
               "H2 Console Path: " + h2Path;
    }

    @GetMapping("/test")
    public String test() {
        return "App is running on port 8080";
    }
}
