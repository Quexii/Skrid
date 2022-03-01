package codes.shoroa.langs.skrid.operations;

import codes.shoroa.langs.skrid.Skrid;
import codes.shoroa.langs.skrid.things.SkridMethod;
import codes.shoroa.langs.skrid.things.SkridVariable;

public class BasicOperations {

    String line;
    int index;

    public BasicOperations(String line, int index) {
        this.line = line;
        this.index = index;
    }

    public void execute() {
            if(line.startsWith(":print("))print();
            if(line.startsWith(":println("))println();
            if(line.startsWith(":var("))var();
            if(line.startsWith(":call("))call();
    }

    void call() {
        String inside = line.substring(line.indexOf("(") + 1, line.indexOf(")"));
        for(SkridMethod method : Skrid.methods) {
            if(method.name.equals(inside)) {
                method.execute();
            }
        }
    }

    void println() {
        String inside = line.substring(line.indexOf("(") + 1, line.indexOf(")")) + ")";
        if(inside.startsWith(":string(") && inside.endsWith(")")){
            inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
            String[] phrases = inside.split("\"");
            StringBuilder sb = new StringBuilder();
            for (String phrase : phrases) {
                if(phrase.contains("+")) {
                    continue;
                }
                sb.append(phrase);
            }
            String print = sb.toString();
            System.out.println(print);
        }
        else if(inside.startsWith(":math(") && inside.endsWith(")")){
            if(inside.contains("+")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\+");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    int value = Integer.parseInt(phrase);
                    origin += value;
                }
                System.out.println(origin);
            }
            if(inside.contains("-")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\-");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    var value = Integer.parseInt(phrase);
                    origin -= value;
                }
                System.out.println(origin);
            }
            if(inside.contains("*")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\*");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    int value = Integer.parseInt(phrase);
                    origin *= value;
                }
                System.out.println(origin);
            }
            if(inside.contains("/")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\/");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    int value = Integer.parseInt(phrase);
                    origin /= value;
                }
                System.out.println(origin);
            }
            if(inside.contains("%")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\%");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    int value = Integer.parseInt(phrase);
                    origin %= value;
                }
                System.out.println(origin);
            }
        }
        else if(inside.startsWith(":var(") && inside.endsWith(")")){
            inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
            for(SkridVariable var:Skrid.variables) {
                if(var.getName().equals(inside)) {
                    if(var.getType().equals("string")) {
                        String value = var.getValue();
                        String[] phrases = value.split("\"");
                        System.out.println(phrases[1]);
                    }
                    if(var.getType().equals("num")) {
                        System.out.println(var.getValue());
                    }
                }
            }
        }
    }
    void print() {
        String inside = line.substring(line.indexOf("(") + 1, line.indexOf(")")) + ")";
        if(inside.startsWith(":string(") && inside.endsWith(")")){
            inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
            String[] phrases = inside.split("\"");
            StringBuilder sb = new StringBuilder();
            for (String phrase : phrases) {
                if(phrase.contains("+")) {
                    continue;
                }
                sb.append(phrase);
            }
            String print = sb.toString();
            System.out.print(print);
        }
        else if(inside.startsWith(":math(") && inside.endsWith(")")){
            if(inside.contains("+")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\+");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    int value = Integer.parseInt(phrase);
                    origin += value;
                }
                System.out.print(origin);
            }
            if(inside.contains("-")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\-");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    var value = Integer.parseInt(phrase);
                    origin -= value;
                }
                System.out.print(origin);
            }
            if(inside.contains("*")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\*");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    int value = Integer.parseInt(phrase);
                    origin *= value;
                }
                System.out.print(origin);
            }
            if(inside.contains("/")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\/");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    int value = Integer.parseInt(phrase);
                    origin /= value;
                }
                System.out.print(origin);
            }
            if(inside.contains("%")) {
                inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
                inside = inside.replaceAll(" ", "");
                String[] phrases = inside.split("\\%");
                int origin = Integer.parseInt(phrases[0]);
                for (String phrase : phrases) {
                    if (phrase.equals(phrases[0])) continue;
                    int value = Integer.parseInt(phrase);
                    origin %= value;
                }
                System.out.print(origin);
            }
        }
        else if(inside.startsWith(":var(") && inside.endsWith(")")){
            inside = inside.substring(inside.indexOf("(") + 1, inside.indexOf(")"));
            for(SkridVariable var:Skrid.variables) {
                if(var.getName().equals(inside)) {
                    if(var.getType().equals("string")) {
                        String value = var.getValue();
                        String[] phrases = value.split("\"");
                        System.out.print(phrases[1]);
                    }
                    if(var.getType().equals("num")) {
                        System.out.print(var.getValue());
                    }
                }
            }
        }
    }
    void var() {
        String inside = line.substring(line.indexOf("(") + 1, line.indexOf(")")) + ")";
        Skrid.variables.add(new SkridVariable(inside,line));
    }
}
