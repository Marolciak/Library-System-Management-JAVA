import java.io.*;

/**
 * Klasa <code>Mail</code> reprezentuje wyslanie maila
 */
public class Mail {


    /**
     * Metoda <code>sendMail</code> pobiera wartosci a nastepnie zapisuje je w pliku python , po to
     * by nastepnie go wywolac i wyslac maila
     * @param emailRevice email na ktory zostanie wyslany mail
     * @param message wiadomosc maila
     * @param tittle tytul maila
     * @throws FileNotFoundException
     */
    public static void sendMail(String emailRevice, String message, String tittle) throws FileNotFoundException {

        //String emailRevice = Main.pRememberEmail.getText();
        //String message = "Czesc , twoje haslo to  "  + Main.checkUsernameWithEmail()   ;

        PrintWriter zapis = new PrintWriter("E:\\PROJEKT\\Mail\\main.py");
        zapis.println("import smtplib\n" +
                "import sys\n" +
                "\n" +
                "sender_email = \"hasla.przypomnienie@gmail.com\"\n" +
                "rec_mail = '" + emailRevice + "'\n" +
                "\n" +
                "subject = '" + tittle + "'\n" +
                "text = '" + message + "'\n" +
                "\n" +
                "password = \"Test123!\"\n" +
                "message = 'Subject: {}\\n\\n{}'.format(subject, text)\n" +
                "\n" +
                "server = smtplib.SMTP('smtp.gmail.com', 587)\n" +
                "server.starttls()\n" +
                "server.login(sender_email, password)\n" +
                "print(\"Login succes\")\n" +
                "server.sendmail(sender_email  ,rec_mail, message)\n" +
                "print(\"email has been sent to\")");
        zapis.close();

        try {
            String s = null;
            Process p = Runtime.getRuntime().exec("python  E:\\PROJEKT\\Mail\\main.py   ");
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));

            while ((s = in.readLine()) != null) {
                System.out.println(s);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
