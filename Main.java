import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Marcin Gruca
 * @version 1.0.0
 */

/**
 * Klasa glowna <code>Main</code> rozszerza JFrame i implementuje ActionListener
 */
public class Main extends JFrame implements ActionListener {

    /**
     * Przycisk <code>bRegister</code> odpowiada za wyslanie podanych danych przez uzytkownika do bazy danych(dodanie uzytkownika do bazy danych)
     */
    public static JButton bRegister = new JButton(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonRegister.png"));
    /**
     * Pole <code>pRegisterPassword</code> pobiera wartosc ktora wpisze uzytkownik
     */
    public static JPasswordField pRegisterPassword = new JPasswordField();
    /**
     * Pole <code>pRegisterConfirmPassword</code> pobiera wartosc ktora wpisze uzytkownik
     */
    public static JPasswordField pRegisterConfirmPassword = new JPasswordField();
    /**
     * Pole <code>pRegisterUsername</code> pobiera wartosc ktora wpisze uzytkownik
     */
    public static JTextField pRegisterUsername = new JTextField();
    /**
     * Pole <code>pRegisterEmail</code> pobiera wartosc ktora wpisze uzytkownik
     */
    public static JTextField pRegisterEmail = new JTextField();
    /**
     * Ramka <code>registerFrame</code> ktora przechowuje wszystkie komponenty zwiazane z rejestrowaniem
     */

    public static JFrame registerFrame = new JFrame();
    /**
     * Ramka <code>loginFrame</code> ktora przechowuje wszystkie komponenty zwiazane z logowaniem
     */
    public static JFrame loginFrame = new JFrame();
    /**
     * Ramka <code>rememberFrame</code> ktora przechowuje wszystkie komponenty zwiazane z przypomnieniem hasla
     */
    public static JFrame rememberFrame = new JFrame();
    /**
     * Pole <code>pRememberEmail</code> pobiera wartosc ktora wpisze uzytkownik
     */
    public static JTextField pRememberEmail = new JTextField();
    /**
     * Tlo <code>eBackground</code>
     */
    public static JLabel eBackground = new JLabel();
    /**
     * Tlo <code>eBackground2</code>
     */
    public static JLabel eBackground2 = new JLabel();
    /**
     * Tlo <code>eBackground3</code>
     */
    public static JLabel eBackground3 = new JLabel();
    /**
     * Pole <code>pLoginUsername</code> pobiera wartosc ktora wpisze uzytkownik
     */
    public static JTextField pLoginUsername = new JTextField();
    /**
     * Pole <code>pLoginPassword</code> pobiera wartosc ktora wpisze uzytkownik
     */
    public static JPasswordField pLoginPassword = new JPasswordField();
    /**
     * Przycisk <code>bLogin</code> odpowiada za przejscie uzytkownika do glownej aplikacji
     */
    public static JButton bLogin = new JButton(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonLogin.png"));
    /**
     * Przycisk <code>bRemember</code> odpowiada za przejscie uzytkownika do ramki przypomnienia hasla
     */
    public static JButton bRemember = new JButton(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonRemember.png"));
    /**
     * Przycisk <code>bSign</code> odpowiada za wyslanie wartosci wpisanych przez uzytkownika do bazy danych
     */
    public static JButton bSign = new JButton(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonSign.png"));
    /**
     * Pole <code>pRememberUsername</code> pobiera wartosc ktora wpisze uzytkownik
     */
    public static JTextField pRememberUsername = new JTextField();
    /**
     * Przycisk <code>bSendMail</code> ktory reprezentuje wyslanie maila z haslem
     */
    public static JButton bSendMail = new JButton();
    /**
     * Pomocnicza zmienna <code>a</code>
     */
    public static String a;
    /**
     * Pomocnicza zmienna <code>b</code>
     */
    public static String b;
    /**
     * Konstruktor <code>Main</code> wywoluje wszystkie metody zawarte w klasie Main.
     *
     * @throws FileNotFoundException
     */
    // konstruktor Main , który zbiera metody z całej klasy Main
    public Main() throws FileNotFoundException {
        initComponents();
        openRegisterFrame();
        checkUsername();
        checkPassword(pLoginUsername.getText(), String.valueOf(pLoginPassword.getPassword()));
        openRememberPassword();
        sendEmail();
        panelAdmin.latestUsername();
        addBook.addBookMethod();


    }

    /**
     * Metoda <code>main</code> odpowiada za uruchomienie calego programu
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Main frame = new Main();
                    frame.setVisible(false);
                    pLoginUsername.setText(" ");
                    pLoginUsername.setText("");
                    pLoginPassword.setText(" ");
                    pLoginPassword.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Metoda<code> initComponents </code> przechowuje wszystkie komponenty(przyciski , etykiety itp.) oraz
     * ich ustawienie i inne funkcje.
     */
    //funkcja przechowującą wszystkie komponenty(przyciski,etykiety itp.)
    public static void initComponents() {

        loginFrame.setTitle("Login");
        loginFrame.setLayout(null);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //pobranie szerokosci i wysokosci komputera użytkownika
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        int widthFrame = 500;
        int heightFrame = 600;
        loginFrame.setSize(widthFrame, heightFrame);
        loginFrame.setLocation((width - widthFrame) / 2, (height - heightFrame) / 2);
        loginFrame.setResizable(false);//brak rozszerzania
        loginFrame.setUndecorated(true); // nieruchoma


        eBackground2.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\backgroundRegister2.png"));
        eBackground2.setBounds(0, 0, 500, 600);

        pLoginUsername.setBackground(new Color(49, 46, 46));
        pLoginUsername.setBorder(new EmptyBorder(5, 5, 5, 5));
        pLoginUsername.setForeground(new Color(243, 0, 0));
        pLoginUsername.setBounds(90, 100, 240, 30);
        //pLoginUsername.setText(" ");
        //pLoginUsername.setText("543534");


        pLoginPassword.setBackground(new Color(49, 46, 46));
        pLoginPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
        pLoginPassword.setForeground(new Color(243, 0, 0));
        pLoginPassword.setBounds(90, 283, 240, 30);
        //pLoginPassword.setText(" ");
        //pLoginPassword.setText("321321");


        bLogin.setBounds(60, 500, 150, 50);

        bRemember.setBounds(300, 500, 150, 50);

        bSign.setBounds(300, 400, 150, 50);

        Container loginContainer = loginFrame.getContentPane();

        loginContainer.add(pLoginUsername);
        loginContainer.add(pLoginPassword);
        loginContainer.add(bSign);
        loginContainer.add(bLogin);
        loginContainer.add(bRemember);
        loginContainer.add(eBackground2);


        registerFrame.setSize(widthFrame, heightFrame);
        registerFrame.setLocation((width - widthFrame) / 8, (height - heightFrame) / 8);

        registerFrame.setTitle("Register");
        registerFrame.setLayout(null);
        registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerFrame.setResizable(false);//nie można przesuwac !! ważne!!
        registerFrame.setUndecorated(true);

        Container registerContainer = registerFrame.getContentPane();

        eBackground.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\backgroundRegister.png"));
        eBackground.setBounds(0, 0, 500, 600);

        pRegisterUsername.setBackground(new Color(255, 215, 104));
        pRegisterUsername.setBorder(new EmptyBorder(5, 5, 5, 5));
        pRegisterUsername.setBounds(50, 110, 380, 30);

        pRegisterPassword.setBackground(new Color(255, 215, 104));
        pRegisterPassword.setBorder(new EmptyBorder(5, 5, 5, 5));
        pRegisterPassword.setBounds(50, 225, 380, 30);

        pRegisterConfirmPassword.setBounds(50, 355, 380, 30);
        pRegisterConfirmPassword.setBackground(new Color(255, 215, 104));
        pRegisterConfirmPassword.setBorder(new EmptyBorder(5, 5, 5, 5));

        pRegisterEmail.setBackground(new Color(255, 215, 104));
        pRegisterEmail.setBorder(new EmptyBorder(5, 5, 5, 5));
        pRegisterEmail.setBounds(50, 450, 380, 30);

        bRegister.setBounds(165, 500, 150, 50);

        registerContainer.add(pRegisterUsername);
        registerContainer.add(pRegisterPassword);
        registerContainer.add(pRegisterConfirmPassword);
        registerContainer.add(pRegisterEmail);
        registerContainer.add(bRegister);
        registerContainer.add(eBackground);


        rememberFrame.setSize(widthFrame, heightFrame);
        rememberFrame.setLocation((width - widthFrame) / 8, (height - heightFrame) / 8);

        rememberFrame.setTitle("Register");
        rememberFrame.setLayout(null);
        rememberFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        rememberFrame.setResizable(false);//nie można przesuwac !! ważne!!
        rememberFrame.setUndecorated(true);

        eBackground3.setBounds(0, 0, 500, 600);
        eBackground3.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\backgroundRemember2.png"));

        pRememberEmail.setBounds(41, 165, 380, 30);
        pRememberEmail.setBorder(new EmptyBorder(5, 5, 5, 5));
        pRememberEmail.setBackground(new Color(255, 215, 104));

        pRememberUsername.setBounds(41, 290, 380, 30);
        pRememberUsername.setBorder(new EmptyBorder(5, 5, 5, 5));
        pRememberUsername.setBackground(new Color(255, 215, 104));

        bSendMail.setBounds(115, 400, 250, 100);
        bSendMail.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonSendMail.png"));

        Container containerRemember = rememberFrame.getContentPane();

        containerRemember.add(bSendMail);
        containerRemember.add(pRememberEmail);
        containerRemember.add(pRememberUsername);
        containerRemember.add(eBackground3);

        panelAdmin.panelAdmin();


        loginFrame.setVisible(true);
        registerFrame.setVisible(false);
        rememberFrame.setVisible(false);
    }

    /**
     * Metoda <code>openRememberPassword</code> reprezentuje otwarcie ramki przypomnienia hasla
     * i zamkniecia innych ramek
     */
    public static void openRememberPassword() {
        bRemember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == bRemember) {
                    rememberFrame.setVisible(true);
                    //loginFrame.dispose();
                    registerFrame.dispose();
                    pRememberEmail.setText(" ");
                    pRememberEmail.setText("");
                    pRememberUsername.setText(" ");
                    pRememberUsername.setText("");
                }
            }
        });
    }

    /*
    metoda która jest wywoływana podczas otwarcia
    ramki rejestrowania , zamyka ramke przypominania
    hasła i ustawia wszystkie pole na wartości puste
    (pomocne przy ponownym otwarciu)
     */

    /**
     * Metoda <code>openRegisterFrame</code> ktora jest wywolywana podczas otwarcia
     *     ramki rejestrowania , zamyka ramke przypominania
     *     hasla i ustawia wszystkie pole na wartosci puste
     */
    public static void openRegisterFrame() {
        bSign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == bSign) {
                    registerFrame.setVisible(true);
                    rememberFrame.setVisible(false);
                    /*pRegisterUsername.setText(" ");
                    pRegisterPassword.setText(" ");
                    pRegisterConfirmPassword.setText(" ");
                    pRegisterEmail.setText(" ");*/
                    pRegisterUsername.setText("");
                    pRegisterPassword.setText("");
                    pRegisterConfirmPassword.setText("");
                    pRegisterEmail.setText("");

                }
            }
        });
    }

    /*
    polaczenie sie z baza , sprawdzenie czy istnieje taki
    uzytkownik , jesli uzytkownik istnieje pokazuje komunikat
    ze ta nazwa jest juz zarejestrowana .
     */

    /**
     *Metoda <code>existUsername</code> laczy sie z baza i sprawdza czy
     * istnieje uzytkownik o podanym username przez klienta
     * @param username podany username przez uzytkownika
     */
    public static void existUsername(String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("select username from users where username = '" + username + "'");
            //st.setString(0, username);
            ResultSet rs2 = st.executeQuery();
            if (rs2.next())
                JOptionPane.showMessageDialog(null, "This Username is Already Taken, Choose Another One", "Username Failed", 2);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     *Metoda <code>existUsername2</code> laczy sie z baza i sprawdza czy
     * istnieje uzytkownik o podanym username przez klienta
     * @param username podany username przez uzytkownika
     * @return zwraca pomocnicza zmienna
     */
    public static boolean existUsername2(String username) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("select username from users where username = '" + username + "'");
            //st.setString(0, username);
            ResultSet rs2 = st.executeQuery();
            if (!rs2.next()) {
                b = "a";
            } else
                b = "b";


            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return b == "a";

    }


    /*
    podaje pattern emaila , sprawdza czy podane pola
    przy rejestracji są puste oraz czy podane hasła
    są takie same , sprawdzenie czy email zgadza
    sie z patternem , wywołanie funkcji existUsername
    polaczenie sie z bazą i wstawienie nowego rekordu
     */

    /**
     * Metoda <code>checkUsername</code> sprawdza czy pola przy rejestracji
     * nie sa puste, czy hasla sie zgadzaja ,wywolanie funkcji existUsername
     * i wstawienie rekordu do bazy danych
     *
     */
    public static void checkUsername() {
        bRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == bRegister) {

                    String email = pRegisterEmail.getText();
                    Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
                    Matcher mat = pattern.matcher(email);

                    if (pRegisterUsername.getText().equals("") || String.valueOf(pRegisterPassword.getPassword()).equals("") || String.valueOf(pRegisterConfirmPassword.getPassword()).equals("") || pRegisterEmail.getText().equals(""))
                        JOptionPane.showMessageDialog(null, "One or more fields are empty", "Empty Fields", 2);
                    else if (!String.valueOf(pRegisterPassword.getPassword()).equals(String.valueOf(pRegisterConfirmPassword.getPassword())))
                        JOptionPane.showMessageDialog(null, "Password Doesn't Match", "Confirm Password", 2);
                    else if (!mat.matches())
                        JOptionPane.showMessageDialog(null, "Enter valid email address", "Not a valid email adresss", 2);
                    else {
                        existUsername(pRegisterUsername.getText());

                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
                            Statement stmt = con.createStatement();
                            //int rs = stmt.executeUpdate("INSERT INTO `user`( `username`, `password` , `email`) VALUES ('" + pRegisterUsername.getText() + "','" + String.valueOf(pRegisterPassword.getPassword()) + "' ,'" + pRegisterEmail.getText() + "'");
                            int rs = stmt.executeUpdate("INSERT INTO `users`(`username`, `password`, `email`, `data_dodania`,`godzina_dodania`) VALUES ('" + pRegisterUsername.getText() + "'  ,  '" + String.valueOf(pRegisterPassword.getPassword()) + "' , '" + pRegisterEmail.getText() + "', CURDATE() , CURTIME()   )");

                            con.close();
                            registerFrame.dispose();

                        } catch (Exception evt) {
                            System.out.println(evt);
                        }
                    }
                }
            }
        });
    }

        /*
        ramka logowania , jesli pole username lub
        password jest puste zwraca komunikat
        polaczenie sie z baza i sprawdzenie
        czy podany uzytkownik i haslo
        zgadzaja sie z soba , jesli tak
        wywolanie funkcji countMembers
        countAuthors countBooks , które pokazują aktualny
        stan ilości
         */

    /**
     * Metoda <code>checkPassword</code> reprezentuje pokazanie komunikatu jesli wartosci
     * w polach logowania sa puste, sprawdza czy podane haslo i username sa zgodne z soba
     * jesli sa , wywolanie fukcji countMembers, countAuthors i countBooks , ktore
     * pokazuja aktualny stan ilosci uzytkownikow , autorow i ksiazek.
     * @param username podany username przez uzytkownika
     * @param password podane haslo  przez uzytkownika
     */
    public static void checkPassword(String username, String password) {
        bLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == bLogin) {

                    if (pLoginUsername.getText().trim().equals(""))
                        JOptionPane.showMessageDialog(null, "Enter Your Username", "Empty Username", 2);
                    else if (String.valueOf(pLoginPassword.getPassword()).trim().equals(""))
                        JOptionPane.showMessageDialog(null, "Enter Your Password", "Empty Password", 2);
                    else
                        try {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
                            PreparedStatement st = con.prepareStatement("select username from users where username = '" + pLoginUsername.getText() + "'  AND password = '" + String.valueOf(pLoginPassword.getPassword()) + "'");
                            ResultSet rs2 = st.executeQuery();

                            if (rs2.next() == true) {

                                rememberFrame.dispose();
                                panelAdmin.mainFrame.setVisible(true);
                                loginFrame.dispose();
                                registerFrame.dispose();
                                panelAdmin.countMembers();
                                panelAdmin.countBooks();
                                panelAdmin.countAuthors();
                                panelAdmin.welcomeBack();
                                panelAdmin.latestUsername();
                                panelAdmin.eLatestMember.setVisible(true);
                                panelAdmin.eWelcomeBack.setText("Welcome back !, " + pLoginUsername.getText());
                                a = pLoginUsername.getText();


                            } else
                                JOptionPane.showMessageDialog(null, "Invalid Username / Password", "Login Error", 1);
                            con.close();
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        } catch (ClassNotFoundException e2) {
                            e2.printStackTrace();
                        }
                }
            }
        });
    }
        /*
        metoda sprawdzająca jakie haslo
        odpowiada podanemu emialowi i
        usernemowi
         */

    /**
     * Metoda <code>checkUsernameWithEmail</code> reprezentuje zapytanie do bazy danych , ktore
     * wyswietli hasla dla odpowiedniego username i email , ktory zostal podany przez uzytkownika
     * w ramce przypomnienia hasla
     * @return zwraca haslo
     */
    public static String checkUsernameWithEmail() {

        String s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("select password from users where username =   '" + pRememberUsername.getText() + "'    AND email = '" + pRememberEmail.getText() + "' ");
            ResultSet rs2 = st.executeQuery();

            if (rs2.next())
                s = rs2.getString(1);

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return s;
    }

    /*
    metoda sprawdzająca jakie haslo
    odpowiada podanemu emialowi i
    usernemowi
    */

    /**
     * Metoda <code>checkUsernameWithEmail2</code> reprezentuje zapytanie do bazy danych , ktore
     * wyswietli hasla dla odpowiedniego username i email , ktory zostal podany przez uzytkownika
     * w ramce przypomnienia hasla
     * @return zwraca haslo
     */
    public static int checkUsernameWithEmail2() {

        int s = 0;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("select password from users where username =   '" + pRememberUsername.getText() + "'    AND email = '" + pRememberEmail.getText() + "' ");
            ResultSet rs2 = st.executeQuery();
            s = 0;

            if (rs2.next())
                s = 1;
            else
                s = 2;

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return s;
    }

        /*
        wysłanie maila , który przypomina hasło , jesli
        podany mail i username sie nie zgadza(metoda check
        usernamewithemail2) pokazuje komunikat
         */

    /**
     * Metoda <code>sendEmail</code> reprezentuje wyslanie hasla na maila uzytkownika
     * z przypomnieniem hasla , jesli uzytkownik podal bledny mail i username metoda pokazuje komunikat
     */
    public static void sendEmail() {

        bSendMail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == bSendMail) {
                    if (checkUsernameWithEmail2() == 1) {
                        try {
                            Mail.sendMail(Main.pRememberEmail.getText(), "Czesc , twoje haslo to  " + Main.checkUsernameWithEmail(), "Przypomnienie hasla!");
                            JOptionPane.showMessageDialog(null, "Check your email", "Send Email ", 2);
                            rememberFrame.dispose();
                            loginFrame.setVisible(true);
                            pLoginPassword.setText(" ");
                            pLoginUsername.setText(" ");
                            pLoginPassword.setText("");
                            pLoginUsername.setText("");

                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        }
                    } else
                        JOptionPane.showMessageDialog(null, "Invalid Username / Email", "Send Email Error", 2);
                }
            }
        });
    }


    /**
     * Metoda <code>actionPerformed</code> reprezentuje implementacje ActionListener
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}