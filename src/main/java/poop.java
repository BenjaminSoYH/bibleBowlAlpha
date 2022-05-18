
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class poop {

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
            this.firstColumn.add(arrOfStr[i]);
            this.secondColumn.add(arrOfStr[i+1]);
        }



        for (int i = 0; i < secondColumn.size(); i++) {
            for (int j = 0; j < secondColumn.size(); j++) {
                if (i !=j && (secondColumn.get(i).trim().equals(secondColumn.get(j).trim()))) {
                    secondColumn.remove(j);
                    firstColumn.remove(j);
                }
            }
        }
        for (int i = 0; i < secondColumn.size(); i++) {

            if ((firstColumn.get(i).trim().startsWith("In what book and"))){
                firstColumn.remove(i);
                secondColumn.remove(i);
            }
            if ((firstColumn.get(i).length()>120)) {
                firstColumn.remove(i);
                secondColumn.remove(i);
            }

            for (int j = 0; j < 40; j++) {
            secondColumn.set(i, secondColumn.get(i).replace(("(R15:"+j+")"),""));
            }

                    }
        for (int i = 0; i < secondColumn.size(); i++) {
            if (i < (secondColumn.size()-1)) {

                if (firstColumn.get(i).trim().toLowerCase().contains(secondColumn.get(i + 1).trim().toLowerCase())) {
                    if (firstColumn.get(i + 1).trim().toLowerCase().contains(secondColumn.get(i).trim().toLowerCase())) {
                        System.out.println(1);
                        firstColumn.remove(i+1);
                        secondColumn.remove(i+1);
        }
                }
            }
        }


        return arrOfStr;

    }
    public ArrayList<String> getFirst() {
        return this.firstColumn;
    }
    public ArrayList<String> getSecond() {
        return this.secondColumn;
    }
}



