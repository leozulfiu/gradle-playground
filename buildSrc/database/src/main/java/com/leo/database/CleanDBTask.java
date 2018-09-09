package com.leo.database;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class CleanDBTask extends DefaultTask {

    @TaskAction
    public void cleanDB() {
        Object databases = getExtensions().getExtraProperties().get("databases");
        DatabaseExtension byType = getExtensions().getByType(DatabaseExtension.class);
        System.out.println("Clean the database "+ byType.getDatabase());
    }
}
