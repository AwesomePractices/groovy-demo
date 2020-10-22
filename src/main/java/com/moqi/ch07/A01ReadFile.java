package com.moqi.ch07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

/**
 * Java 读取文件
 *
 * @author moqi On 10/22/20 10:12
 */

public class A01ReadFile {

    private static final String THOREAU_PATH = "/Users/moqi/Code/groovy-demo/src/main/resources/thoreau.txt";

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(THOREAU_PATH));
            String line;
            while (Objects.nonNull(line = reader.readLine())) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
