package com.zuehlke.database;

import org.gradle.api.DefaultTask
import org.gradle.api.provider.Property
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction;

class CleanDBTask extends DefaultTask {
    private final Property<String> database;

    CleanDBTask() {
        database = getProject().getObjects().property(String.class);
    }

    @Input
    Property<String> getDatabase() {
        return database;
    }

    @TaskAction
    void cleanDB() {
        System.out.println("Clean the database "+ database.get());
    }
}
