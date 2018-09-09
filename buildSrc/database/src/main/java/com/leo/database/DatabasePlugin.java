package com.leo.database;

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

class DatabasePlugin implements Plugin<Project> {

    public static final String EXTENSION_NAME = "databases";

    @Override
    public void apply(Project project) {
        DatabaseExtension extension = project.getExtensions().create(EXTENSION_NAME, DatabaseExtension.class);

        project.getTasks().create("cleanDB", CleanDBTask.class);
    }
}
