package com.zuehlke.license;

import groovy.json.JsonSlurper
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction
import org.gradle.api.tasks.InputFile

class LicenseMergerTask extends DefaultTask {
    String url = "\"https://cat-fact.herokuapp.com/facts/random\""

    @InputFile
    def gnuFile

    @InputFile
    def mitFile

    def finalFilePath = "./ZE_license.txt"

    @TaskAction
    void mergeFinalLicense() {
        def curlResponse = ['curl', url].execute()
        def jsonContent = new JsonSlurper().parseText(curlResponse.text)

        String gnu = gnuFile.text
        String mit = mitFile.text

        String finalContent = gnu + mit
        finalContent += "\n" + jsonContent

        (new File(finalFilePath)).text = finalContent
    }
}