package com.zuehlke.database;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class CleanDBTask extends DefaultTask {

    @TaskAction
    public void cleanDB() {
        System.out.println("Clean the database");
    }
}
