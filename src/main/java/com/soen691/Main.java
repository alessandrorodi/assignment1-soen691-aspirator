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
            ArrayList<String> javaFiles = parseTextFile(arg);
            for (String javaFile : javaFiles) {
                try{
                    FileParser.parseFile(javaFile);

                }catch(Exception e){
                    System.out.println(e.getStackTrace());
                }
            }
        }
    }

    /**
     * returns an array of java code names we need to analyze.
     */
    private static ArrayList<String> parseTextFile(String path){

        File file = new File(Main.class.getClassLoader().getResource(path).getFile());

        ArrayList<String> javaFiles = new ArrayList<String>();

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(Main.class.getClassLoader().getResource(path).getPath()))) {

            stream.forEach(line->{
                javaFiles.add(line);
            });

        } catch (IOException e) {
            e.printStackTrace();
        }
        catch (Exception e ){
            System.out.println(e.getStackTrace());
        }

        return javaFiles;
    }

}