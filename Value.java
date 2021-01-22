import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Value  { 
    protected static double weight;
    public static String key;
    public static double i;

    Value(String nkey, double nweight){
        key = nkey; 
        weight = nweight;
    } 

    protected void finalize(){
        System.out.println("\n object is garbage collected");
    }

    public static double GetValue() {
        return weight;
    }

    public void displayInfo(){
        System.out.printf("\t Key: %s \tWeight: %.2f", key, weight);
    }

    public static void main(String[] args) throws IOException
    { 
        String outputFileName = "result.txt";
        BufferedWriter writter = new BufferedWriter(new FileWriter(outputFileName, true));

        Path path = Paths.get("data.txt");
        Scanner scanner = new Scanner(path);

        while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                int index1 = line.indexOf("Gramm");
                int index2 = line.indexOf("Pounds");
                int index3 = line.indexOf("Pood");

                if(index1 != - 1) {
                    String digits="";
                    for (int i = 0; i < line.length(); i++) {
                        char chrs = line.charAt(i);              
                        if (Character.isDigit(chrs))
                            digits = digits+chrs;
                    }
                        i = Double.valueOf(digits);
                        System.out.println("\n" + "Gramm " + i);

                        Gramm gramm = new Gramm("gramm", i); 
                        writter.write("From" + " " + i + " "  + "gramm to kilograms: " + GetValue() + "\n");
                        gramm.displayInfo();

                        gramm = null;
                        System.gc();
                }

                    if(index2 != - 1) {
                    String digits="";
                    for (int i = 0; i < line.length(); i++) {
                        char chrs = line.charAt(i);              
                        if (Character.isDigit(chrs))
                            digits = digits+chrs;
                    }
                        i = Double.valueOf(digits);
                        System.out.println("\n" + "Pounds = " + i);

                        Pounds pounds = new Pounds("pounds", i); 
                        writter.write("From" + " " + i + " "  + "pounds to kilograms: " + GetValue() + "\n");
                        pounds.displayInfo();

                        pounds = null;
                        System.gc();
                 }

                    if(index3 != - 1) {
                    String digits="";
                    for (int i = 0; i < line.length(); i++) {
                        char chrs = line.charAt(i);              
                        if (Character.isDigit(chrs))
                            digits = digits+chrs;
                    }
                        i = Double.valueOf(digits);
                        System.out.println("\n" + "Pood = " + i);

                        Pood pood = new Pood("pood", i); 
                        writter.write("From" + " " + i + " "  + "pood to kilograms: " + GetValue() + "\n");
                        pood.displayInfo();

                        pood = null;
                        System.gc();
                 }
                }

        writter.close();
        scanner.close();
    }
}

class Gramm extends Value{
    Gramm(String gkey, double gweight)
    {
        super(gkey, gweight*0.001);
        System.out.println("New object Gramm is created.");
    }
}

class Pounds extends Value{
    Pounds(String pkey, double pweight)
    {
        super(pkey, pweight*0.453592);
        System.out.println("New object Pounds is created.");
    }  
}

class Pood extends Value{
    Pood(String pkey, double pweight)
    {
        super(pkey, pweight*16.3807);
        System.out.println("New object Pood is created.");
    }
}
