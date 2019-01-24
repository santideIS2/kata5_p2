package Vista;

import Modelo.Histogram;
import Modelo.Mail;
import java.util.List;

public class MailHistogramBuilder {
    private Histogram<String> histogram;

    public Histogram<String> build(List<Mail> listaCorreos){
        histogram = new Histogram<>();
        for(Mail correo: listaCorreos){
            if(correo != null)
                histogram.incremet(correo.getDomain());
        }
        return histogram;
    }
}