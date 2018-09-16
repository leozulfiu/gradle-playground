package com.leo.database;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.Test;

public class DatabasePluginTest {
    @Test
    public void databasePluginAddsTasksToProject() {
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply("database");
    }
}
