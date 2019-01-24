package Controlador;

import Modelo.Histogram;
import Modelo.Mail;
import Vista.HistogramDisplay;
import Vista.MailHistogramBuilder;
import Vista.MailListReader;
import java.io.IOException;
import java.util.List;

public class kata4 {

    public static void main(String[] args) throws IOException {

        MailListReader lecturaLista = new MailListReader();

        String fileName = "email.txt";

        List<Mail> mailList = lecturaLista.read(fileName);

        MailHistogramBuilder histogramBuild = new MailHistogramBuilder();

        Histogram<String> histogram = histogramBuild.build(mailList);

        HistogramDisplay histo = new HistogramDisplay(histogram);

        histo.execute();

    }
}