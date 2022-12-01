package View;

import Model.Email;
import Model.Histogram;
import java.util.List;

public class MailHistogramBuilder {
    private List<Email> emails;
    private histogramDisplay display;

    public MailHistogramBuilder(List<Email> emails) {
        this.emails = emails;
        this.display = createDisplay();
    }

    private histogramDisplay createDisplay() {
        Histogram<String> histogram = new Histogram<>();
        for (int i = 0; i < emails.size(); i++) {
            histogram.increment(emails.get(i).getEmail());    
        }
        return new histogramDisplay(histogram, "Correos");
    }
    
}
