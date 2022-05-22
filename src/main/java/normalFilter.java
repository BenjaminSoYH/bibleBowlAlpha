import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//hard coded (R:)
public class normalFilter {
    ArrayList<String> firstColumn = new ArrayList<String>();
    ArrayList<String> secondColumn = new ArrayList<String>();
    public String[] getArray() throws FileNotFoundException {

        String strn = "";
        String[] wordsToSeperate = {"A.", "[g]", "[a]", "[b]"};

        File myObj = new File("src/main/java/Temp.txt");
        Scanner myReader = new Scanner(myObj);

        while (myReader.hasNextLine()) {
            strn += myReader.nextLine();
        }

        for (String i : wordsToSeperate) { //replace seperation indicators
            strn = strn.replace(i, "<");
        }
        strn = strn.replace("Created using The QuizMaster © 1992-2021", ""); //remove garbage
        strn = strn.replace("ACME Quiz Products, www.acmequiz.com", "");
        strn = strn.replace("**", "");

        String[] arrOfStr = strn.split("<", 0);

        for (int i = 1; i < arrOfStr.length; i += 2) { //seperating questions and answesr into two different lists
            this.firstColumn.add(arrOfStr[i].trim());
            this.secondColumn.add(arrOfStr[i + 1].trim());
        }



        for (int i = 0; i < firstColumn.size(); i++) {
            for (int j = 0; j < firstColumn.size(); j++) { //flags same answer from the same verse
                if (i!=j) {
                    if( secondColumn.get(i).equals(secondColumn.get(j))){
                        secondColumn.set(j,secondColumn.get(j)+"$$$");
                        firstColumn.set(j,firstColumn.get(j)+"$$$");
                    }
                }
            }
            if (firstColumn.get(i).startsWith("In what book")) { //flags in what book questons
                firstColumn.set(i,firstColumn.get(i)+"$$$");
                secondColumn.set(i,secondColumn.get(i)+"$$$");
            }


            for (int j = 1; j < 40; j++) { //removes the verses tags
                for (int k = 1; k < 17; k++) {
                    secondColumn.set(i, secondColumn.get(i).replace(("(R"+k+":" + j + ")"), ""));
                    secondColumn.set(i, secondColumn.get(i).replace(("(R"+k+":" + j + "-" + (j + 1) + ")"), ""));
               }
            }
        }
        for (int i = 0; i < firstColumn.size()-1; i++) { //flags if the first question contains the scond answer, vice versa

            if ((firstColumn.get(i).toLowerCase().contains(secondColumn.get(i + 1).toLowerCase()))&&(firstColumn.get(i + 1).toLowerCase().contains(secondColumn.get(i).toLowerCase()))) {
                    firstColumn.set(i+1,firstColumn.get(i)+"$$$");
                    secondColumn.set(i+1,secondColumn.get(i)+"$$$");
            }
        }

        firstColumn.removeIf(element -> element.endsWith("$$$")); //remove flagged items
        secondColumn.removeIf(element -> element.endsWith("$$$"));
        return arrOfStr;
    }
    public ArrayList<String> getFirst() {
        return this.firstColumn;
    }
    public ArrayList<String> getSecond() {
        return this.secondColumn;
    }

}
