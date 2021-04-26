package questiontest;

public class MainA {

    public static void main(String[] args) {

//        Aobj aobj= new Aobj("valami\r\nmás\r\nvalami");
//        System.out.println(aobj.getAttr());

        Aobj aobj1= new Aobj("valami\r\nmás\r\nvalami", "vmi\r\nvalami");
        System.out.printf("%s\n%s", aobj1.getAttr(), aobj1.getAttr2());

    }
}
