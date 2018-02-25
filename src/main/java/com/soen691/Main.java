package com.soen691;

import StaticChecker.FileParser;
import StaticChecker.StaticChecker;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        if (args == null || args.length == 0){
            System.out.println("No arguments provided.");
        }

        for (String arg: args) {
            System.out.println("Processing argument "+arg);
            File listOfFilesToProcess = new File(arg);
            ArrayList<String> javaFiles = parseTextFile(listOfFilesToProcess);
            for (String javaFile : javaFiles) {
                try{
                    //System.out.println("Processing file "+javaFile);
                    FileParser.parseFile(javaFile);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * returns an array of java code names we need to analyze.
     */
    private static ArrayList<String> parseTextFile(File file){
        ArrayList<String> javaFiles = new ArrayList<>();

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(file.toPath())) {

            stream.forEach(line->{
                javaFiles.add(line);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

        return javaFiles;
    }

}