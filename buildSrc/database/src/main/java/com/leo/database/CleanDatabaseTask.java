package com.leo.database;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;

public class CleanDatabaseTask extends DefaultTask {
    @Input
    private String url;
    @Input
    private int port;

    @TaskAction
    public void clean() {
        System.out.println("Clean task");
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
