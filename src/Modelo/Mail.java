package Modelo;

public class Mail{
    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getDomain() {
        int AtIndex = mail.indexOf("@") + 1;
        if (AtIndex == -1) {
            return null;
        } else {
            return mail.substring(AtIndex);
        }
    }
}
