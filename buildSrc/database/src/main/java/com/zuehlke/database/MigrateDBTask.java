package com.zuehlke.database;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class MigrateDBTask extends DefaultTask {
    private String from = "local";
    private String to = "remote";

    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }

    @TaskAction
    public void doSomething() {
        System.out.println("Migrate database from " + from + " to " + to);
    }
}
