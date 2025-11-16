package com.epam.driver;

import com.epam.driver.strategy.*;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {
    private static final Map<String, DriverStrategy> strategies = new HashMap<>();

    static {
        strategies.put("chrome", new ChromeStrategy());
        strategies.put("firefox", new FirefoxStrategy());
        strategies.put("edge", new EdgeStrategy());
        strategies.put("safari", new SafariStrategy());
    }

    public static DriverStrategy getStrategy(String browser) {
        DriverStrategy strategy = strategies.get(browser.toLowerCase());
        if (strategy == null) {
            throw new IllegalArgumentException("Unknown browser: " + browser);
        }
        return strategy;
    }
}
