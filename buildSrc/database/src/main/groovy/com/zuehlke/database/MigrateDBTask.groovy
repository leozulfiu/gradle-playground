package com.zuehlke.database;

import org.gradle.api.DefaultTask;
import org.gradle.api.internal.plugins.DefaultExtraPropertiesExtension;
import org.gradle.api.tasks.TaskAction;

class MigrateDBTask extends DefaultTask {
    private String from = "local";
    private String to = "remote";

    String getFrom() {
        return from;
    }
    void setFrom(String from) {
        this.from = from;
    }
    String getTo() {
        return to;
    }
    void setTo(String to) {
        this.to = to;
    }

    @TaskAction
    void doSomething() {
        DefaultExtraPropertiesExtension asdf = (DefaultExtraPropertiesExtension) this.getExtensions().getByName("ext");
        System.out.println("Migrate database from " + from + " to " + to + " for "+ asdf.get("databases"));
    }
}
