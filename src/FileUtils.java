//	Mohammad - 1191413
import java.io.*;
import java.util.Scanner;
//Star class 
public class FileUtils {
//StringBuilder
    public static StringBuilder readFile(String fileName) throws IOException {
        StringBuilder data = new StringBuilder("");//NEW StringBuilder

        try {//Exception raed in file
            File Obj = new File(fileName);
            Scanner inp = new Scanner(Obj);
            do{
                 data.append(inp.nextLine()+("\n"));
            }while(inp.hasNextLine()) ;
            inp.close();
        } catch (Exception e) {
            System.out.println("error");
            e.printStackTrace();
        }
        return data;
    }

    public static void writeFile(StringBuilder input , String fileName)  throws IOException {
        System.out.println(input);
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(new String(input));
        writer.close();
    }



}
