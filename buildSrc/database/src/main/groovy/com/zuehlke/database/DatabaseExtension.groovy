package com.zuehlke.database

import org.gradle.api.Project
import org.gradle.api.provider.Property;

class DatabaseExtension {
    private final Property<String> database;

    DatabaseExtension(Project project) {
        database = project.getObjects().property(String.class);
    }

    Property<String> getDatabase() {
        return database;
    }
}
