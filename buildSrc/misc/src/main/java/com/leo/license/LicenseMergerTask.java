package com.leo.license;

import com.google.common.io.Files;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.InputFile;
import org.gradle.api.tasks.OutputFile;
import org.gradle.api.tasks.TaskAction;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class LicenseMergerTask extends DefaultTask {
    private final String url = "\"https://cat-fact.herokuapp.com/facts/random\"";

    @InputFile
    private File gnuFile;

    @InputFile
    private File mitFile;

    @OutputFile
    private File finalFile = new File(getProject().getBuildDir().getAbsolutePath() + "./complete_license.txt");

    @TaskAction
    void mergeFinalLicense() {
        StringBuilder curlResponse = runCurl();

        String jsonContent = curlResponse.toString();

        String gnu = "";
        String mit = "";
        try {
            gnu = Files.asCharSource(gnuFile, Charset.defaultCharset()).read();
            mit = Files.asCharSource(mitFile, Charset.defaultCharset()).read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String finalContent = gnu + mit;
        System.out.println("Final content: " + finalContent + "\n" + jsonContent);
    }

    private StringBuilder runCurl() {
        String[] curlCommand = {"curl", url};
        StringBuilder curlResponse = new StringBuilder();

        ProcessBuilder processBuilder = new ProcessBuilder(curlCommand);
        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while (true) {
                String line = reader.readLine();
                if (line == null) {
                    break;
                }
                curlResponse.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return curlResponse;
    }
}
