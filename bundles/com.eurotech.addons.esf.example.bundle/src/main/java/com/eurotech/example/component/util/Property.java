/*******************************************************************************
 * Copyright (c) 2019 Eurotech and/or its affiliates. All rights reserved.
 *******************************************************************************/
package com.eurotech.example.component.util;

import java.util.Map;

public class Property<T> {

    protected final String key;
    protected final Class<T> valueType;
    protected final T defaultValue;

    @SuppressWarnings("unchecked")
    public Property(final String key, final T defaultValue) {
        this.key = key;
        this.valueType = (Class<T>) defaultValue.getClass();
        this.defaultValue = defaultValue;
    }

    public T get(final Map<String, Object> properties) {

        return getInternal(properties.get(key));
    }

    public T getOrDefault(final Map<String, Object> properties) {
        try {
            return get(properties);
        } catch (final Exception e) {
            return defaultValue;
        }
    }

    @SuppressWarnings("unchecked")
    private T getInternal(final Object value) {
        if (valueType.isInstance(value)) {
            return (T) value;
        }

        if (!(value instanceof String)) {
            throw new IllegalArgumentException("Parameter " + key + " cannot be retrieved from properties");
        }

        return parse((String) value);
    }

    @SuppressWarnings("unchecked")
    private T parse(final String valueString) {
        final Object result;

        if (valueType == Boolean.class) {
            result = Boolean.parseBoolean(valueString);
        } else if (valueType == Short.class) {
            result = Short.parseShort(valueString);
        } else if (valueType == Integer.class) {
            result = Integer.parseInt(valueString);
        } else if (valueType == Long.class) {
            result = Long.parseLong(valueString);
        } else if (valueType == Float.class) {
            result = Float.parseFloat(valueString);
        } else if (valueType == Double.class) {
            result = Double.parseDouble(valueString);
        } else {
            throw new IllegalArgumentException("Cannot parse " + valueType + " from string");
        }

        return (T) result;
    }
}
