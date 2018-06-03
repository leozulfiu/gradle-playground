package com.zuehlke.database

import org.gradle.api.Action;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

class DatabasePlugin implements Plugin<Project> {

    public static final String EXTENSION_NAME = "databases"

    @Override
    void apply(Project project) {
        DatabaseExtension extension = project.extensions.create(EXTENSION_NAME, DatabaseExtension, project)

        project.getTasks().create("cleanDB", CleanDBTask, new Action<CleanDBTask>() {
            void execute(CleanDBTask cleanDBTask) {
                cleanDBTask.database.set(extension.getDatabase());
            }
        })
    }
}
