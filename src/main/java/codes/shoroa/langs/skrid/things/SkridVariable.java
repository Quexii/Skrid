package codes.shoroa.langs.skrid.things;

public class SkridVariable {
    String name,value,type;

    public SkridVariable(String inside,String line) {
        this.type = inside.split(":")[1].split("\\(")[0];
        this.name = inside.split(":")[0];
        this.value = inside.substring(inside.indexOf("(")+1,inside.indexOf(")"));
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getType() {
        return type;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
