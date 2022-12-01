package View;

import java.util.Iterator;
import java.util.regex.Pattern;

public class EmailLoader implements Loader{
    private final Loader loader;
    private static final Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    
    public EmailLoader(Loader loader) {
        this.loader = loader;
    }

    @Override
    public Iterable<String> items() {
        return new Iterable<>() {
            @Override
            public Iterator<String> iterator() {
                return createIterator();
            }

            private Iterator<String> createIterator() {
                return new Iterator<>() {
                    Iterator<String> iterator = loader.items().iterator();
                    String nextEmail = nextEmail();
                    @Override
                    public boolean hasNext() {
                        return  nextEmail != null;
                    }

                    @Override
                    public String next() {
                        String email = nextEmail;
                        nextEmail = nextEmail();
                        return email;
                    }

                    private String nextEmail() {
                        while (true){
                            String line = iterator.next();
                            if (line == null) return null;
                            if (isEmail(line) == true) return line;
                        }
                    }

                    private boolean isEmail(String line) {
                        return pattern.matcher(line).matches();
                    }
                };
            }
        };
    }
    
}
