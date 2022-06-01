import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.regex.Matcher;

/**
 * Klasa <code>deleteUser</code> reprezentuje usuniecie uzytkownika z bazy danych
 */
public class deleteUser {

    /**
     * Metoda <code>deleteUserMethod</code>  przechowuje wszystkie komponenty(przyciski , etykiety itp.) oraz
     *   ich ustawienie i inne funkcje.
     */
    public static void deleteUserMethod() {

        panelAdmin.bDeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == panelAdmin.bDeleteUser) {
                    addBook.frameAddBook.dispose();
                    addUser.addUserFrame.dispose();
                    deleteUser.frameDeleteUser.setVisible(true);
                    deleteUser.pUsername.setText(" ");
                    deleteUser.pUsername.setText("");
                    deleteUser.pCode.setVisible(false);
                    deleteUser.sendDeleteUser();
                    deleteUser.pCode.setVisible(false);
                    deleteUser.bDeleteUser2.setVisible(false);
                    deleteUser.bDeleteUser.setVisible(true);
                    deleteUser.pCode.setText(" ");
                    deleteUser.pCode.setText("");
                    deleteUser.pUsername.setText(" ");
                    deleteUser.pUsername.setText("");
                }
            }
        });

        frameDeleteUser.setUndecorated(true);
        frameDeleteUser.setResizable(false);
        frameDeleteUser.setSize(500, 600);
        frameDeleteUser.setLocation(740, 340);
        frameDeleteUser.setVisible(false);

        Container containerDeleteUser = new Container();
        containerDeleteUser = frameDeleteUser.getContentPane();

        eBackground.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\backgroundDeleteUser.png"));
        eBackground.setBounds(0, 0, 500, 600);

        pUsername.setBounds(55, 230, 400, 50);
        pUsername.setBorder(new EmptyBorder(5, 5, 5, 5));

        bDeleteUser.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonDeleteUser2.png"));
        bDeleteUser.setBounds(180, 500, 150, 50);

        bDeleteUser2.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonDeleteUser2.png"));
        bDeleteUser2.setBounds(180, 500, 150, 50);
        bDeleteUser2.setVisible(false);

        pCode.setBounds(200, 460, 100, 30);
        pCode.setBorder(new EmptyBorder(5, 5, 5, 5));
        pCode.setVisible(false);


        containerDeleteUser.add(bDeleteUser);
        containerDeleteUser.add(bDeleteUser2);
        containerDeleteUser.add(pUsername);
        containerDeleteUser.add(pCode);
        containerDeleteUser.add(eBackground);


    }

    /**
     * Ramka <code>frameDeleteUser</code> przechowuje wszystkie komponenty zwiazane z ramka usuniecia uzytkownika
     */
    public static JFrame frameDeleteUser = new JFrame();
    /**
     * Tlo <code>eBackground</code>
     */
    public static JLabel eBackground = new JLabel();
    /**
     * Pole <code>pUsername</code> pobiera wartosc podana przez uzytkownika
     */
    public static JTextField pUsername = new JTextField();
    /**
     * Przycisk <code>bDeleteUser</code> reprezentuje usuniecie uzytkownika z bazy danych
     */
    public static JButton bDeleteUser = new JButton();
    /**
     * Pole <code>pCode</code> pobiera wartosc podana przez uzytkownika
     */
    public static JTextField pCode = new JTextField();
    /**
     * Przycisk <code>bDeleteUser2</code> reprezentuje usuniecie uzytkownika z bazy danych
     */
    public static JButton bDeleteUser2 = new JButton();
    /**
     * Pomocnicza zmiena <code>emailRevice</code>
     */
    public static String emailRevice;
    /**
     * Pomocnicza zmienna <code>username</code>
     */
    public static String username;
    /**
     * Zmienna <code>mat</code> typu Matcher
     */
    public static Matcher mat;

    /**
     * Metoda <code>sendDeleteUser</code> sprawdza czy istnieje uzytkownik , jesli tak usuwa uzytkownika
     * i wywoluje metode <code>latestUsername</code>
     */
    public static void sendDeleteUser() {

        bDeleteUser.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (Main.existUsername2(pUsername.getText()) == true)
                    System.out.println("m");
                else {
                    deleteMethod(pUsername.getText());
                    panelAdmin.latestUsername();
                }
            }

        });

    }


    /**
     * Metoda <code>deleteMethod</code> laczy sie z baza i wykonuje zapytanie usuniecia uzytkownika
     * @param username podany username przez uzytkownika
     */
    public static void deleteMethod(String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate("DELETE FROM users WHERE username LIKE '" + username + "' ");
            con.close();
            frameDeleteUser.dispose();
            panelAdmin.countMembers();
        } catch (Exception evt) {
            System.out.println(evt);
        }
    }

    /**
     * Metoda <code>buttonMethod2</code> reprezentuje usuniecie uzytkownika z bazy danych po wcisnieciu przycisku
     *
     * @param n pomocnicza zmienna
     */
    public static void buttonMethod2(int n) {
        bDeleteUser2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == bDeleteUser2) {
                    if (pCode.getText().equals(String.valueOf(n)))
                        deleteMethod(pUsername.getText());
                    else {
                        frameDeleteUser.dispose();
                    }
                }
            }
        });
    }
}
