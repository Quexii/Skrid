package codes.shoroa.langs.skrid.things;

import codes.shoroa.langs.skrid.Skrid;
import codes.shoroa.langs.skrid.operations.BasicOperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SkridMethod {
    public String name;
    public List<String> lines;

    public SkridMethod(String name, String... lines) {
        this.name = name;
        this.lines = Arrays.asList(lines);
    }

    public void execute() {
        System.out.println(lines.size());
        if(lines.size() == 1) {
            String line = lines.get(0);
            String inside = line.substring(line.indexOf("{") + 1, line.indexOf("}"));
            if (inside.startsWith(":")) {
                new BasicOperations(inside, Skrid.lines.indexOf(line)).execute();
            }
        } else {
            for (String line : lines) {
                while (line.startsWith(" "))line = line.replaceFirst(" ", "");
                if (line.startsWith("#"))continue;
                if (line.startsWith(":")) {
                    new BasicOperations(line, Skrid.lines.indexOf(line)).execute();
                }
            }
        }
    }
}
