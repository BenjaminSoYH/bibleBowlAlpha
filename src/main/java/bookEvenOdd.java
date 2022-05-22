
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class bookEvenOdd {

    ArrayList<String> firstColumn  = new ArrayList<String>();
    ArrayList<String> secondColumn  = new ArrayList<String>();

    public static void main(String[] args) throws FileNotFoundException {

    }

    public String[]getArray() throws FileNotFoundException {

        String strn = "";
        String[] wordsToReplace = {"A.","[g]","[a]","[b]"};


        File myObj = new File("src/main/java/Temp.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            strn += myReader.nextLine();
        }

        for(String i : wordsToReplace) {
            strn = strn.replace(i,"<");

        }
        strn = strn.replace("Created using The QuizMaster © 1992-2021","");
        strn = strn.replace("ACME Quiz Products, www.acmequiz.com","");
        strn = strn.replace("**","");



        String[] arrOfStr = strn.split("<", 0);


        for (int i = 1; i < arrOfStr.length; i+=2) {
            this.firstColumn.add(arrOfStr[i].trim());
            this.secondColumn.add(arrOfStr[i+1].trim());
        }

        for (int i = 0; i < firstColumn.size(); i++) {
            if (!firstColumn.get(i).startsWith("In what book")) {
                firstColumn.set(i,firstColumn.get(i) + "FFF");
                secondColumn.set(i,secondColumn.get(i)+ "FFF");
            }
        }




        for (int i = 0; i < firstColumn.size(); i++) {
            for (int k = 5; k < 9; k++) {
              for (int j = 1; j < 40; j ++ ) {
                if (j % 2 == 0) {
                    if (secondColumn.get(i).contains("(R" + k + ":" + j + ")") || secondColumn.get(i).contains("(R5:" + j + "-")) {
                        firstColumn.set(i, firstColumn.get(i) + "FFF");
                        secondColumn.set(i, secondColumn.get(i) + "FFF");
                    }
                } else {
                    secondColumn.set(i, secondColumn.get(i).replace(("(R"+k+":" + j + ")"), ""));
                }
                  secondColumn.set(i, secondColumn.get(i).replace(("(R"+k+":" + j + "-" + (j + 1) + ")"), ""));
            }
            }
        }

        firstColumn.removeIf(element -> element.endsWith("FFF"));
        secondColumn.removeIf(element -> element.endsWith("FFF"));


        return arrOfStr;

    }
    public ArrayList<String> getFirst() {
        return this.firstColumn;
    }
    public ArrayList<String> getSecond() {
        return this.secondColumn;
    }
}



