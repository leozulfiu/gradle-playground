package com.leo.deployment;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

class DeploymentPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        //project.getExtensions().create("environments", String.class);
    }
}
