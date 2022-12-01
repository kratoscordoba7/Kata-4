package kata4_v1_8_30.pkg10_30;

import View.EmailLoader;
import Model.FileLoader;
import Model.Email;
import View.MailHistogramBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Kata4_V1_8_3010_30 {

    public static void main(String[] args) throws FileNotFoundException {
        Iterator<String> iterator = input();
        ArrayList<Email> emails = process(iterator);
        MailHistogramBuilder mailHistogramBuilder = output(emails);        
    }
    
    public static Iterator<String> input(){
        return new EmailLoader
        (new FileLoader
        (new File
        ("C:\\Users\\gatete\\Documents\\NetBeansProjects\\Kata4_V1_8_30-10_30\\email.txt")))
                .items().iterator();
    }
    
    public static ArrayList<Email> process(Iterator<String> iterator){
        ArrayList<Email> emails = new ArrayList<>();
        while(iterator.hasNext()){
            emails.add(new Email(iterator.next()));
        }
        return emails;
    }
    
    public static MailHistogramBuilder output(ArrayList<Email> emails){
        return new MailHistogramBuilder(emails);
    }
    
}
