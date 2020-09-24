package com.moqi;

import java.io.*;
import java.util.Objects;

/**
 * @author moqi
 * On 9/24/20 21:59
 */

public class A03JavaExecuteProcess {

    public static void main(String[] args) {
        try {
            Process proc = Runtime.getRuntime().exec("git help");
            BufferedReader result = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line;

            while (Objects.nonNull((line = result.readLine()))) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
