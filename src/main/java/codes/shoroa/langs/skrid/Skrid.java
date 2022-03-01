package codes.shoroa.langs.skrid;

import codes.shoroa.langs.skrid.operations.BasicOperations;
import codes.shoroa.langs.skrid.things.SkridMethod;
import codes.shoroa.langs.skrid.things.SkridVariable;

import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class Skrid {
    public static CopyOnWriteArrayList<String> lines = new CopyOnWriteArrayList<>();

    public static CopyOnWriteArrayList<SkridVariable> variables = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<SkridMethod> methods = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<String> toAddMeth = new CopyOnWriteArrayList<>();


    boolean functionStarted = false;

    public void begin() {
        Scanner sc = new Scanner(Skrid.class.getClassLoader().getResourceAsStream("file.skrid"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lines.add(line);
        }
        for (String line : lines) {
            while (line.startsWith(" "))line = line.replaceFirst(" ", "");
            if (line.startsWith("#"))continue;
            if (line.startsWith(":")) {
                new BasicOperations(line, lines.indexOf(line)).execute();
            }
            while (functionStarted) {
                toAddMeth.add(line);
            }
            if(functionStarted && line.endsWith("})")){
                toAddMeth.add(line);
                functionStarted = false;
            }
            if(line.startsWith(":meth")){
                if(line.endsWith("})")) {
                    String name = line.substring(line.indexOf("(")+1, line.indexOf("{"));
                    String withinBrackets = line.substring(line.indexOf("{")+1, line.indexOf("}"));
                    methods.add(new SkridMethod(name, line));
                } else {
                    functionStarted = true;
                }
                if(!functionStarted && !line.endsWith("})")){
                    System.out.println("Error: " + line);
                    String name = line.substring(line.indexOf("(")+1, line.indexOf("{"));
                    methods.add(new SkridMethod(name, String.valueOf(toAddMeth)));
                    toAddMeth.clear();
                }
            }
            System.out.println(methods.size());
        }
    }

    public static void main(String[] args) throws Exception {
        new Skrid().begin();
    }

}
