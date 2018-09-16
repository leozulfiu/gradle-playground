package com.leo.deployment;

import org.gradle.api.DomainObjectCollection;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

class DeploymentPlugin implements Plugin<Project> {
    public static final String EXTENSION_NAME = "deployments";

    @Override
    public void apply(Project project) {
        NamedDomainObjectContainer<Deployment> deployments = project.container(Deployment.class);
        project.getExtensions().add(EXTENSION_NAME, deployments);

        project.afterEvaluate(project1 -> {
            DomainObjectCollection<Deployment> allDeployments = (DomainObjectCollection<Deployment>) project1.getExtensions().getByName(EXTENSION_NAME);
            allDeployments.all(deployment -> {
                System.out.println(deployment);
            });
        });
    }
}
