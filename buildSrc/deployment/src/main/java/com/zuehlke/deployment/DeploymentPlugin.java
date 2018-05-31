package com.zuehlke.deployment;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DeploymentPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getExtensions().create("DeploymentTask", DeploymentTask.class);
    }
}
