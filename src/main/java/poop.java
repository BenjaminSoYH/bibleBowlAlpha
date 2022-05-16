import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.GenericArrayType;
import java.util.Scanner;

public class poop {
    public static void main(String[] args) throws FileNotFoundException {
    }

    public static String[]getArray() throws FileNotFoundException {



        File myObj = new File("src/main/java/Temp.txt");
        Scanner myReader = new Scanner(myObj);



        String strn = "";

        while (myReader.hasNextLine()) {
            strn += myReader.nextLine();

        }



        strn = strn.replace("[g]","<");
        strn = strn.replace("A.","<");
        strn = strn.replace("[a]","<"); 
        strn = strn.replace("[b]","<");
        strn = strn.replace("**","");
        strn = strn.replace("Created using The QuizMaster © 1992-2021","");
        strn = strn.replace("ACME Quiz Products, www.acmequiz.com","");

        for (int i = 0; i < 40; i++) {
//            strn = strn.replace("(R1:"+i+")","");
//            strn = strn.replace("(R2:"+i+")","");
//            strn = strn.replace("(R3:"+i+")","");
//            strn = strn.replace("(R4:"+i+")","");
//            strn = strn.replace("(R14:"+i+")","");
//            strn = strn.replace("(R15:"+i+")","");
            strn = strn.replace("(R14:"+i+")","");
        }



        String[] arrOfStr = strn.split("<", 0);
        //even number loop is answer
        return arrOfStr;

    }
}



