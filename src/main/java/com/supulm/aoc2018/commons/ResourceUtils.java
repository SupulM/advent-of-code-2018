package com.supulm.aoc2018.commons;

import java.io.File;

public class ResourceUtils {

    private static ResourceUtils resourceUtilsInstance;

    private ResourceUtils() {
    }

    public static ResourceUtils getInstance() {
        if (resourceUtilsInstance == null) {
            resourceUtilsInstance = new ResourceUtils();
        }
        return resourceUtilsInstance;
    }

    public String getFileName(String path){
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(path).getFile());

        return file.toString();
    }
}
