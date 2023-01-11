/*******************************************************************************
 * Copyright (c) 2019 Eurotech and/or its affiliates. All rights reserved.
 *******************************************************************************/
package com.eurotech.example.component;

import java.util.Map;

import org.eclipse.kura.configuration.ConfigurableComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleComponent implements ConfigurableComponent {

    private static final Logger logger = LoggerFactory.getLogger(ExampleComponent.class);

    public void activate(final Map<String, Object> properties) {
        logger.info("activating...");

        logger.info("activated, properties: {}", properties);

        logger.info("activating...done");
    }

    public void updated(final Map<String, Object> properties) {
        logger.info("updating...");

        logger.info("updated, properties: {}", properties);

        logger.info("updating...done");
    }

    public synchronized void deactivate() {
        logger.info("deactivating...");
        logger.info("deactivating...done");
    }

}
