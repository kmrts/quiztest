package questiontest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadQuestions {

    private List<Question> questionList= new ArrayList<>();

    private static final int START_INDEX= 24;

    public void readToList(){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(ReadQuestions.class.getResourceAsStream("/kérdésekEL.txt")))) {
            // kell a '/' elé
            String line;
            while ((line = br.readLine())  != null) {

                String[] parts= line.split("', '");

                String question= parts[0].substring(1);
                String ansCorrect= "";
                for(int i=1; i<5; i++){

                    if(parts[i].startsWith("@")){
                        parts[i]= parts[i].substring(1);
                        ansCorrect= parts[i];
                    }
                }
                Question qu= new Question(question, parts[1], parts[2], parts[3],
                        parts[4].substring(0, parts[4].length()-1), ansCorrect);

                // '-es verzió, #25-nél pl nem jó
//                String[] parts= line.split(", ");
//
//                String question= parts[0];
//                String ansCorrect= "";
//                for(int i=1; i<5; i++){
//
//                    if(parts[i].startsWith("'@")){
//                        parts[i]= "'"+parts[i].substring(2);
//                        ansCorrect= parts[i];
//                    }
//                }
//                Question qu= new Question(question, parts[1], parts[2], parts[3],
//                        parts[4], ansCorrect);

//                System.out.println(qu);



                questionList.add(qu);

            }
            System.out.println(questionList.size());
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
    public void writeQuestion(int count){
//        for(int i=0; i<db; i++){
//
//            Question actual= questionList.get(i);
//            Scanner sc= new Scanner(System.in);
//
//            System.out.printf("\n%s\n\nA) %s\n\nB) %s\n\nC) %s\n\nD) %s\n\n", actual.getQuestion(), actual.getAnswerA(), actual.getAnswerB(),
//                    actual.getAnswerC(), actual.getAnswerD());
//            System.out.println("Quit: Q\n");
//            String answ= "";
//
//            while(answ.toUpperCase() !="Q"){
//
//                sc.nextLine();
//                System.out.printf("a helyes.\n%s\n", "answcorr"); //actual.getAnsCorrect()
//            }
//
//        }
        Scanner sc= new Scanner(System.in);
//        int count= 0;
        String answ= "";
        boolean quit= false;
        while(!quit){
            writeNextQuestion(sc, count);

            System.out.println("Tovább, vagy kilép (Q) ?");
            answ= sc.nextLine();
//            sc.nextLine();
//            System.out.println("mit "+ answ.toUpperCase());
            if(answ.toUpperCase().equals("Q") ){
                quit= true;
//                System.out.println("kilép\n");
            }
            count++;
        }
    }

    private void writeNextQuestion(Scanner sc, int count) {
        Question actual= questionList.get(count);
        System.out.println(actual);

        String question= actual.getQuestion();
//        System.out.println(question);
//        System.out.print(question);

//        String question= "Mit ír ki az alábbi kódrészlet?\r\nint[] i = {1, 2, 3, 4}"; //jó
//        String question= "Mit ír ki az alábbi kódrészlet?\nint[] i = {1, 2, 3, 4}"; //jó
//        String question= "Mit ír ki az alábbi kódrészlet?\\r\\nint[] i = {1, 2, 3, 4}"; //nem jó
//        "%n%d%n%n%s%n%nA) %s\n\nB) %s\n\nC) %s\n\nD) %s\n\n"
//        System.out.println("Mit ír ki az alábbi kódrészlet?\r\npublic class Incrementer {\r\n  public int inc(int i) {\r\n    return i + 1;" +
//                "\r\n  }\r\n\r\n  public static void main(String[] args) "); //jó

//        boolean i= "áéíóöőúüű".contains(String.valueOf('ö'));
//        System.out.println(i);

//        StringBuilder sb= new StringBuilder();
//        sb.append(count).append("\n").append(actual.getQuestion());
//        System.out.println(sb.toString());  //nem

//        String[] ques= question.split("\r\n");
//        System.out.println(ques.length); //nem vágja fel, 1db
//        StringBuilder sb= new StringBuilder();
//        for(int i= 0; i< ques.length; i++){
//            System.out.println(ques[i]);
//            sb.append(ques[i]).append("\n");
//        }
//        System.out.println(sb.toString());

//        System.out.println( question.contains("\r\n") ); //false
//
//        for(Character ch: question.toCharArray()){
//            System.out.println(ch);
//        }//itt kiírja \r\n -vel

//        System.out.println(question.replace("%n", "\r\n"));
//
        System.out.printf("%n%d%n%s%n%nA) %s%n%nB) %s%n%nC) %s%n%nD) %s%n%n", count, question, actual.getAnswerA(), actual.getAnswerB(),
                actual.getAnswerC(), actual.getAnswerD());
        System.out.println("A válaszod: ");

        sc.nextLine();
        System.out.printf("A helyes válasz:\n%s\n", actual.getAnsCorrect()); //actual.getAnsCorrect()
    }

    public static void main(String[] args) {
        ReadQuestions rq= new ReadQuestions();
        rq.readToList();
        rq.writeQuestion(START_INDEX);

//        System.out.println("Mit ír ki az alábbi kódrészlet?\r\nint[] i = {1, 2, 3, 4}");  //ez jó kéne legyen
//        System.out.println("Mit ír ki az alábbi kódrészlet?%nint[] i = {1, 2, 3, 4}");  //nem
//        System.out.printf("%s", "Mit ír ki az alábbi kódrészlet?\r\nint[] i = {1, 2, 3, 4}" );  //műk
    }
}
