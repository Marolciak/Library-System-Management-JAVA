import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa <code>addUser</code> reprezentuje dodanie uzytkownika do bazy danych
 */
public class addUser {
    /**
     * Metoda <code>addUserMethod</code> przechowuje wszystkie komponenty(przyciski , etykiety itp.) oraz
     * ich ustawienie i inne funkcje.
     */
    public static void addUserMethod() {

        panelAdmin.bAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == panelAdmin.bAddUser) {
                    deleteUser.frameDeleteUser.dispose();
                    addBook.frameAddBook.dispose();
                    addUser.addUserFrame.setVisible(true);
                    addUser.pUsername.setText(" ");
                    addUser.pPassword.setText(" ");
                    addUser.pConfirmPassword.setText(" ");
                    addUser.pEmail.setText(" ");
                    addUser.pUsername.setText("");
                    addUser.pPassword.setText("");
                    addUser.pConfirmPassword.setText("");
                    addUser.pEmail.setText("");
                    addUser.sendUser();
                }
            }
        });

        addUserFrame.setUndecorated(true);
        addUserFrame.setResizable(false);
        addUserFrame.setSize(400, 600);
        addUserFrame.setLocation(740, 340);
        addUserFrame.setVisible(false);

        Container containerAddUserFrame = new Container();
        containerAddUserFrame = addUserFrame.getContentPane();

        eBackground.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\backgroundAddUser.png"));
        eBackground.setBounds(0, 0, 400, 600);

        pUsername.setBounds(50, 100, 300, 30);
        pUsername.setBorder(new EmptyBorder(5, 5, 5, 5));
        // pUsername.setBackground(new Color(255, 215, 104));

        pPassword.setBounds(50, 190, 300, 30);
        pPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
        //pPassword.setBackground(new Color(255, 215, 104));

        pConfirmPassword.setBounds(50, 280, 300, 30);
        pConfirmPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
        //pConfirmPassword.setBackground(new Color(255, 215, 104));

        pEmail.setBounds(50, 370, 300, 30);
        pEmail.setBorder(new EmptyBorder(5, 5, 5, 5));

        bAddUser.setBounds(130, 500, 150, 50);
        bAddUser.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonAddUser2.png"));


        containerAddUserFrame.add(bAddUser);
        containerAddUserFrame.add(pUsername);
        containerAddUserFrame.add(pPassword);
        containerAddUserFrame.add(pConfirmPassword);
        containerAddUserFrame.add(pEmail);
        containerAddUserFrame.add(eBackground);


    }

    /**
     * Ramka <code>addUserFrame</code> przechowuje wszystkie komponenty zwiazane z ramka dodania uzytkownika
     */
    public static JFrame addUserFrame = new JFrame();
    /**
     * Tlo <code>eBackground</code>
     */
    public static JLabel eBackground = new JLabel();
    /**
     * Pole <code>pUsername</code> pobiera wartosc wpisana przez uzytkownika
     */
    public static JTextField pUsername = new JTextField();
    /**
     * Pole <code>pPassword</code> pobiera wartosc wpisana przez uzytkownika
     */
    public static JPasswordField pPassword = new JPasswordField();
    /**
     * Pole <code>pConfirmPassword</code> pobiera wartosc wpisana przez uzytkownika
     */
    public static JPasswordField pConfirmPassword = new JPasswordField();
    /**
     * Pole <code>pEmail</code> pobiera wartosc wpisana przez uzytkownika
     */
    public static JTextField pEmail = new JTextField();
    /**
     * Przycisk <code>bAddUser</code> reprezentuje dodanie nowego uzytkownika do bazy danych
     */
    public static JButton bAddUser = new JButton();


    /**
     * Metoda <code>sendUser</code> sprawdza czy adres e-mail jest poprawny , czy pola sa wypelnione
     * , czy hasla zgadzaja sie ze soba , jesli tak laczy sie z baza danych i wstawia nowy rekord
     */
    public static void sendUser() {

        bAddUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = pEmail.getText();
                Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
                Matcher mat = pattern.matcher(email);

                if (pUsername.getText().equals("") || String.valueOf(pPassword.getPassword()).equals("") || String.valueOf(pConfirmPassword.getPassword()).equals("") || pEmail.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "One or more fields are empty", "Empty Fields", 2);
                else if (!String.valueOf(pPassword.getPassword()).equals(String.valueOf(pConfirmPassword.getPassword())))
                    JOptionPane.showMessageDialog(null, "Password Doesn't Match", "Confirm Password", 2);
                else if (!mat.matches())
                    JOptionPane.showMessageDialog(null, "Enter valid email address", "Not a valid email adresss", 2);
                else {
                    //Main.existUsername(pUsername.getText());

                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
                        Statement stmt = con.createStatement();
                        //int rs = stmt.executeUpdate("INSERT INTO `user`( `username`, `password` , `email`) VALUES ('" + pRegisterUsername.getText() + "','" + String.valueOf(pRegisterPassword.getPassword()) + "' ,'" + pRegisterEmail.getText() + "'");
                        int rs = stmt.executeUpdate("INSERT INTO `users`(`username`, `password`, `email`,`data_dodania` , `godzina_dodania`) VALUES ('" + pUsername.getText() + "'  ,  '" + String.valueOf(pPassword.getPassword()) + "' , '" + pEmail.getText() + "', CURDATE() , CURTIME() )");

                        con.close();
                        addUserFrame.dispose();
                        panelAdmin.countMembers();
                        panelAdmin.latestUsername();

                    } catch (Exception evt) {

                    }
                }
            }
        });

    }
}



