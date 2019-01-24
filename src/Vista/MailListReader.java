package Vista;

import Modelo.Mail;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class MailListReader {

    private String file;
    private List<Mail> listaCorreos;

    public List<Mail> read(String fileName){
        file = fileName;
        listaCorreos = new LinkedList<>();

        try (FileReader fr = new FileReader(file)) {
            BufferedReader br = new BufferedReader(fr);
            String linea;

            while ((linea = br.readLine()) != null){
                if(linea.contains("@")){
                    listaCorreos.add(new Mail(linea));
                }
            }
        }catch (IOException e){
            System.out.println("Exception reading file: " + e);
        }
        return listaCorreos;
    }
}