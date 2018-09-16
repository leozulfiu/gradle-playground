package com.leo.deployment;

import groovy.lang.Closure;
import org.gradle.api.provider.Property;

public class Deployment {
    private String name;
    private String url;
    private Property<CloudProperties> cloudProperties;

    public Deployment(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Property<CloudProperties> getCloudProperties() {
        return cloudProperties;
    }

    public void cloudProperties(Closure closure) {
        System.out.println();
    }
}
