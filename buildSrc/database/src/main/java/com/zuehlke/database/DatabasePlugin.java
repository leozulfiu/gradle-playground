package com.zuehlke.database;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class DatabasePlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        project.getTasks().create("migrateDB", MigrateDBTask.class);


        DatabaseExtension databases = project.getExtensions().create("databases", DatabaseExtension.class);
    }
}
