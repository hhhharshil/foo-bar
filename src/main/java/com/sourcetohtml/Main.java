package com.sourcetohtml;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        FileDetailGenerator  operations = new FileDetailGenerator();

        // Example usage of processStringAndMakeRequest
        String testString = "Hello World!";

        operations.getHTML(testString);
    }
}
