package Model;

import View.Loader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;

public class FileLoader implements Loader{
    private final File file;

    public FileLoader(File file) {
        this.file = file;
    }
    

    @Override
    public Iterable<String> items() {
        return new Iterable<String>() {
            @Override
            public Iterator<String> iterator() {
                return createIterator();
            }
        };
    }
    private Iterator<String> createIterator() {
        return new Iterator(){
            BufferedReader reader = createReader();
            String nextLine = nextLine();
            
            @Override
            public boolean hasNext() {
                return nextLine != null;
            }

            @Override
            public Object next() {
                String line = nextLine;
                nextLine = nextLine();
                return line;
            }

            private String nextLine() {
                try{
                    return reader.readLine();    
                } catch (Exception e){
                    return null;
                }
                
            }

            private BufferedReader createReader(){
                try{
                    return new BufferedReader(new FileReader(file));    
                } catch (FileNotFoundException  ex){
                    return null;
                }
            }
            
        };
    }
    
    
}
