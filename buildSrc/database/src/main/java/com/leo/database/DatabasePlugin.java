package com.leo.database;

import org.gradle.api.DomainObjectCollection;
import org.gradle.api.NamedDomainObjectContainer;
import org.gradle.api.Plugin;
import org.gradle.api.Project;

class DatabasePlugin implements Plugin<Project> {

    public static final String EXTENSION_NAME = "databases";

    @Override
    public void apply(Project project) {
        NamedDomainObjectContainer<Database> databases = project.container(Database.class);
        project.getExtensions().add(EXTENSION_NAME, databases);

        createCleanupTasks(project);
    }

    private void createCleanupTasks(Project project) {
        project.afterEvaluate(project1 -> {
            DomainObjectCollection<Database> allDatabases = (DomainObjectCollection<Database>) project1.getExtensions().getByName(EXTENSION_NAME);
            allDatabases.all(database -> {
                project.getTasks().create("clean" + database.getName(), CleanDatabaseTask.class,
                        cleanDatabaseTask -> {
                            cleanDatabaseTask.setGroup("database");
                            cleanDatabaseTask.setDescription("Cleans the " + database.getName() + " database");
                            cleanDatabaseTask.setUrl(database.getUrl());
                            cleanDatabaseTask.setPort(database.getPort());
                        });
            });
        });
    }
}
