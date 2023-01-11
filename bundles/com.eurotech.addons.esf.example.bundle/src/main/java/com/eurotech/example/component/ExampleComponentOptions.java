/*******************************************************************************
 * Copyright (c) 2019 Eurotech and/or its affiliates. All rights reserved.
 *******************************************************************************/
package com.eurotech.example.component;

import java.util.Map;

import com.eurotech.example.component.util.Property;

public class ExampleComponentOptions {

    private static final Property<String> EXAMPLE_PROPERTY = new Property<>("example.property", "example");

    private final String exampleProperty;

    public ExampleComponentOptions(final Map<String, Object> properties) {
        this.exampleProperty = EXAMPLE_PROPERTY.getOrDefault(properties);
    }

    public String getExampleProperty() {
        return exampleProperty;
    }

}
