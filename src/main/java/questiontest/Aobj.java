package questiontest;

public class Aobj {
    private String attr;
    private String attr2;

    public Aobj(String attr) {
        this.attr = attr;
    }

    public Aobj(String attr, String attr2) {
        this.attr = attr;
        this.attr2 = attr2;
    }

    public String getAttr() {
        return attr;
    }

    public String getAttr2() {
        return attr2;
    }
}
