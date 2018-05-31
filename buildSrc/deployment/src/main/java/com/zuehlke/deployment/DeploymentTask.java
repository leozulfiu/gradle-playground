package com.zuehlke.deployment;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class DeploymentTask extends DefaultTask {
    private String to;

    @TaskAction
    public void deploy() {
        System.out.println("Deploy to: " + to);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }
}
