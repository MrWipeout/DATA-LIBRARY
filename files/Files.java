/*
 * Athanasios Exizoglou
 */

package files;



import files.data;
import java.io.BufferedWriter;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.util.ArrayList;
import java.util.Scanner;

public class Files {

    public static ArrayList<data> antikeimena = new ArrayList();

    public static void writeToFile() {
        try {
            File myObj = new File("filename.txt");//ftiaxnw txt arxeio
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        try {
            FileWriter myWriter = new FileWriter("filename.txt");

            //String titlos, String ISBN, String suggrafeas, String etos, String perigrafh, String eidos, String arithmosSelidwn, String thesh
            data biblio1 = new data("LEPS", "12341234", "katerina", "1960", "einai polu wraio biblio", "math", "351", "2A");
            data biblio2 = new data("baseis", "34563456", "isi", "1961", "einai polu wraio biblio", "math", "351", "2B");
            data biblio3 = new data("vlsi", "45674567", "someone", "1962", "einai polu wraio biblio", "math", "351", "2C");

            BufferedWriter out = new BufferedWriter(myWriter);

            out.write(biblio1.toString());
            out.newLine();//kainourgia grammh
            out.write(biblio2.toString());
            out.newLine();
            out.write(biblio3.toString());
            out.newLine();
            out.close();

            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readFromFiles() {
        int i = 0;

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {//gia ka8e grammh kai oso yparxei mia apo katw diabaze

                String data = myReader.nextLine();//apo8hkeuei sto data oti exei h grammh
  

                data book = returnObject(data);//kalw sunarthsh poy ftiaxnei antikeimeno data


                antikeimena.add(book);
                
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
         System.out.println("ARRAY :" + antikeimena.get(1).getEidos());
    }

    public static data returnObject(String data) {
        //return "data{" + "titlos=" + titlos + ", ISBN=" + ISBN + ", suggrafeas=" + suggrafeas + ", etos=" + etos + ", perigrafh=" + perigrafh + ", eidos=" + eidos + ", arithmosSelidwn=" + arithmosSelidwn + ", thesh=" + thesh + '}';
        StringBuilder xarakthres = new StringBuilder(data);

        StringBuilder titlos = new StringBuilder(data);
        titlos = titlos.replace(0, titlos.indexOf("=") + 1, "");
        titlos = titlos.replace(titlos.indexOf(","), titlos.length(), "");
        xarakthres = xarakthres.replace(0, xarakthres.indexOf(titlos.toString()), "");
     //   System.out.println("titlos:" + titlos);

        StringBuilder ISBN = new StringBuilder(xarakthres);
        ISBN = ISBN.replace(0, ISBN.indexOf("=") + 1, "");
        ISBN = ISBN.replace(ISBN.indexOf(","), ISBN.length(), "");
        xarakthres = xarakthres.replace(0, xarakthres.indexOf(ISBN.toString()), "");
    //    System.out.println("isbn:" + ISBN);

        StringBuilder suggrafeas = new StringBuilder(xarakthres);
        suggrafeas = suggrafeas.replace(0, suggrafeas.indexOf("=") + 1, "");
        suggrafeas = suggrafeas.replace(suggrafeas.indexOf(","), suggrafeas.length(), "");
        xarakthres = xarakthres.replace(0, xarakthres.indexOf(suggrafeas.toString()), "");
     //   System.out.println("sugg:" + suggrafeas);

        StringBuilder etos = new StringBuilder(xarakthres);
        etos = etos.replace(0, etos.indexOf("=") + 1, "");
        etos = etos.replace(etos.indexOf(","), etos.length(), "");
        xarakthres = xarakthres.replace(0, xarakthres.indexOf(etos.toString()), "");
     //   System.out.println("etos:" + etos);

        StringBuilder perigrafh = new StringBuilder(xarakthres);
        perigrafh = perigrafh.replace(0, perigrafh.indexOf("=") + 1, "");
        perigrafh = perigrafh.replace(perigrafh.indexOf(","), perigrafh.length(), "");
        xarakthres = xarakthres.replace(0, xarakthres.indexOf(perigrafh.toString()), "");
      //  System.out.println("perigrafh:" + perigrafh);

        StringBuilder eidos = new StringBuilder(xarakthres);
        eidos = eidos.replace(0, eidos.indexOf("=") + 1, "");
        eidos = eidos.replace(eidos.indexOf(","), eidos.length(), "");
        xarakthres = xarakthres.replace(0, xarakthres.indexOf(eidos.toString()), "");
      //  System.out.println("eidos:" + eidos);

        StringBuilder arithmosSelidwn = new StringBuilder(xarakthres);
        arithmosSelidwn = arithmosSelidwn.replace(0, arithmosSelidwn.indexOf("=") + 1, "");
        arithmosSelidwn = arithmosSelidwn.replace(arithmosSelidwn.indexOf(","), arithmosSelidwn.length(), "");
        xarakthres = xarakthres.replace(0, xarakthres.indexOf(arithmosSelidwn.toString()), "");
      //  System.out.println("arithmosSelidwn:" + arithmosSelidwn);

        StringBuilder thesh = new StringBuilder(xarakthres);
        thesh = thesh.replace(0, thesh.indexOf("=") + 1, "");
        thesh = thesh.replace(thesh.indexOf("}"), thesh.length(), "");
        xarakthres = xarakthres.replace(0, xarakthres.indexOf(thesh.toString()), "");
      //  System.out.println("thesh:" + thesh);

 
       data book=new data(titlos.toString(),ISBN.toString(),suggrafeas.toString(),etos.toString(),perigrafh.toString(),eidos.toString(),arithmosSelidwn.toString(),thesh.toString());
       return book;
    }
    public static void search(){
        int flag=0;
        System.out.println("bale ISBN bilbiou gia na bre8ei");
        Scanner sc = new Scanner(System.in);
        String isbn = sc.nextLine();
        
        for(int i=0;i<antikeimena.size();i++){
        if(antikeimena.get(i).getISBN().toString().equals(isbn)){//ama to isbn poy ebale o xrhsths einai idio me toy antikeimenou mpainei sthn if
            System.out.println("to biblio bre8hke:");
            System.out.println(antikeimena.get(i));
            flag=1;
            return;
        }
        }
        if(flag!=1)
        {
            System.out.println("to biblio den bre8hke");
        }
    
    }


    public static void main(String[] args) {

        writeToFile();
        readFromFiles();
        search();
    }

}
