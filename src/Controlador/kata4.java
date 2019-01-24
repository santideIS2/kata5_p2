package Controlador;

import Modelo.Histogram;
import Modelo.Mail;
import Vista.HistogramDisplay;
import Vista.MailHistogramBuilder;
import Vista.MailListReaderBD;
import java.io.IOException;
import java.util.List;

public class kata4 {

    public static void main(String[] args) throws IOException {

        MailListReaderBD lecturaLista = new MailListReaderBD();

        List<Mail> mailList = lecturaLista.read();

        MailHistogramBuilder histogramBuild = new MailHistogramBuilder();

        Histogram<String> histogram = histogramBuild.build(mailList);

        HistogramDisplay histo = new HistogramDisplay(histogram);

        histo.execute();

    }
}