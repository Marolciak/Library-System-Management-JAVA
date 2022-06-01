import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

/**
 * Klasa <code>panelUser</code> reprezentuje aplikacje po poprawnym zalogowaniu sie
 */
public class panelAdmin {

    /**
     * Metoda <code>panelAdmin</code>  przechowuje wszystkie komponenty(przyciski , etykiety itp.) oraz
     *  ich ustawienie i inne funkcje.
     */
    public static void panelAdmin() {

        mainFrame.setTitle("Register");
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);//nie można przesuwac !! ważne!!
        mainFrame.setBounds(0, 0, 1940, 1040);
        mainFrame.setUndecorated(true);

        Container containerPanelAdmin = mainFrame.getContentPane();

        containerPanelAdmin.setBounds(0, 0, 400, 1040);


        bLogOut.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonLogOut.png"));
        bLogOut.setBounds(50, 930, 150, 50);

        bAddBook.setBounds(50, 400, 150, 50);
        bAddBook.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonAddBook.png"));

        eBackground.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\backgroundPanelUser3.png"));
        eBackground.setBounds(0, 0, 1940, 1040);

        eCountMembers.setFont(new Font("TAHOMA", Font.BOLD, 80));
        eCountMembers.setBounds(755, 150, 500, 300);
        eCountMembers.setVisible(false);

        eCountBooks.setFont(new Font("TAHOMA", Font.BOLD, 80));
        eCountBooks.setBounds(1225, 150, 500, 300);
        eCountBooks.setVisible(false);

        eCountAuthors.setFont(new Font("TAHOMA", Font.BOLD, 80));
        eCountAuthors.setBounds(1695, 150, 500, 300);
        eCountAuthors.setVisible(false);

        eLatestMember.setBounds(755, 600, 940, 300);
        eLatestMember.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\backgroundLatestMember.png"));
        eLatestMember.setVisible(false);


        eWelcomeBack.setFont(new Font("TAHOMA", Font.BOLD, 34));
        eWelcomeBack.setText("siema");
        eWelcomeBack.setBounds(530, 20, 600, 50);
        eWelcomeBack.setVisible(false);

        bViewBook.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonViewBook.png"));
        bViewBook.setBounds(50, 500, 150, 50);

        bMainMenu.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonMainMenu.png"));
        bMainMenu.setBounds(50, 300, 150, 50);

        bAddUser.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonAddUser.png"));
        bAddUser.setBounds(50, 500, 150, 50);

        bDeleteUser.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonDeleteUser.png"));
        bDeleteUser.setBounds(50, 600, 150, 50);

        eUsername1.setBounds(780, 735, 400, 70);
        eUsername1.setFont(new Font("TAHOMA", Font.BOLD, 20));
        eUsername1.setForeground(new Color(0x000000));
        eUsername1.setVisible(false);

        eUsername2.setBounds(970, 735, 400, 70);
        eUsername2.setFont(new Font("TAHOMA", Font.BOLD, 20));
        eUsername2.setForeground(new Color(0x000000));
        eUsername2.setVisible(false);

        eUsername3.setBounds(1150, 735, 400, 70);
        eUsername3.setFont(new Font("TAHOMA", Font.BOLD, 20));
        eUsername3.setForeground(new Color(0x000000));
        eUsername3.setVisible(false);

        eUsername4.setBounds(1320, 735, 400, 70);
        eUsername4.setFont(new Font("TAHOMA", Font.BOLD, 20));
        eUsername4.setForeground(new Color(0x000000));
        eUsername4.setVisible(false);

        eUsername5.setBounds(1520, 735, 400, 70);
        eUsername5.setFont(new Font("TAHOMA", Font.BOLD, 20));
        eUsername5.setForeground(new Color(0x000000));
        eUsername5.setVisible(false);

        //eBackground2.setIcon(new ImageIcon("C:\\Users\\marci\\Desktop 2\\PROJEKT\\rightPanel.png"));
        //eBackground2.setBounds(400,0,1540,1040);

        containerPanelAdmin.add(eUsername1);
        containerPanelAdmin.add(eUsername2);
        containerPanelAdmin.add(eUsername3);
        containerPanelAdmin.add(eUsername4);
        containerPanelAdmin.add(eUsername5);
        containerPanelAdmin.add(eWelcomeBack);
        containerPanelAdmin.add(eCountAuthors);
        containerPanelAdmin.add(eCountBooks);
        containerPanelAdmin.add(eLatestMember);
        containerPanelAdmin.add(eCountMembers);
        containerPanelAdmin.add(bLogOut);
        containerPanelAdmin.add(bAddUser);
        containerPanelAdmin.add(bDeleteUser);
        containerPanelAdmin.add(bMainMenu);
        containerPanelAdmin.add(bAddBook);
        // containerPanelUser.add(bViewBook);
        containerPanelAdmin.add(eBackground);
        containerPanelAdmin.add(eBackground2);

        addBookFrame.setLayout(null);
        addBookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addBookFrame.setResizable(false);//nie można przesuwac !! ważne!!
        addBookFrame.setBounds(0, 0, 400, 400);

        Container mainContainer = addBookFrame.getContentPane();
        mainContainer.setSize(1540, 1040);
        mainContainer.setLocation(400, 0);

        mainFrame.setVisible(false);
        addBookFrame.setVisible(false);

        logOut();
        addBook.addBookMethod();
        mainMenu();
        addUser.addUserMethod();
        deleteUser.deleteUserMethod();


    }

    /**
     * Etykieta <code>eCountMembers</code> przechowuje ilosc obecnych uzytkownikow
     */
    public static JLabel eCountMembers = new JLabel();
    /**
     * Etykieta <code>eCountBooks</code> przechowuje ilosc obecnych ksiazek
     */
    public static JLabel eCountBooks = new JLabel();
    /**
     * Etykieta <code>eCountAuthors</code> przechowuje ilosc obecnych autorow
     */
    public static JLabel eCountAuthors = new JLabel();
    /**
     * Etykieta <code>eLatestMember</code> przechowuje obrazek
     */
    public static JLabel eLatestMember = new JLabel();

    /**
     * Ramka <code>mainFrame</code> ktora przechowuje wszystkie komponenty zwiazane z glowna ramka panelu admina
     */
    public static JFrame mainFrame = new JFrame();
    /**
     * Ramka <code>addBookFrame</code> ktora przechowuje komponenty zwiazane z ramka dodawanie ksiazki
     */
    public static JFrame addBookFrame = new JFrame();
    /**
     * Tlo <code>eBackground</code>
     */
    public static JLabel eBackground = new JLabel();
    /**
     * Tlo <code>eBackground2</code>
     */
    public static JLabel eBackground2 = new JLabel();
    /**
     * Przycisk <code>bLogOut</code> odpowiada za wylogowanie sie z panelu
     */
    public static JButton bLogOut = new JButton();
    /**
     * Przycisk <code>bAddBook</code> reprezentuje przejscie do ramki z dodaniem ksiazki
     */
    public static JButton bAddBook = new JButton();
    /**
     * Etykieta <code>eWelcomeBack</code> reprezentuje napis welcome back i nazwe zalogowanego uzytkownika
     */
    public static JLabel eWelcomeBack = new JLabel();
    /**
     * Przycisk <code>bViewBook</code> reprezentuje przejscie do ramki wyswietlenia ksiazek
     */
    public static JButton bViewBook = new JButton();
    /**
     * Przycisk <code>bMainMenu</code> reprezentuje przejscie do glownego menu
     */
    public static JButton bMainMenu = new JButton();
    /**
     * Przycisk <code>bAddUser</code> reprezentuje przejscie do ramki z dodaniem uzytkownika
     */
    public static JButton bAddUser = new JButton();
    /**
     * Przycisk <code>bDeleteUser</code> reprezentuje przejscie do ramki z usunieciem uzytkownika
     */
    public static JButton bDeleteUser = new JButton();
    /**
     * Etykieta <code>eUsername1</code> reprezentuje najnowszego uzytkownika
     */
    public static JLabel eUsername1 = new JLabel();
    /**
     * Etykieta <code>eUsername2</code> reprezentuje najnowszego uzytkownika
     */
    public static JLabel eUsername2 = new JLabel();
    /**
     * Etykieta <code>eUsername3</code> reprezentuje najnowszego uzytkownika
     */
    public static JLabel eUsername3 = new JLabel();
    /**
     * Etykieta <code>eUsername4</code> reprezentuje najnowszego uzytkownika
     */
    public static JLabel eUsername4 = new JLabel();
    /**
     * Etykieta <code>eUsername6</code> reprezentuje najnowszego uzytkownika
     */
    public static JLabel eUsername5 = new JLabel();


    /**
     * Metoda <code>logOut</code> reprezentuje wylogowanie sie  z glownej ramki
     * i wrocenie do ramki logowania
     */

    public static void logOut() {
        bLogOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == bLogOut) {
                    mainFrame.dispose();
                    addBook.frameAddBook.dispose();
                    addUser.addUserFrame.dispose();
                    deleteUser.frameDeleteUser.dispose();
                    Main.loginFrame.setVisible(true);
                    Main.pLoginPassword.setText(" ");
                    Main.pLoginUsername.setText(" ");
                    Main.pLoginPassword.setText("");
                    Main.pLoginUsername.setText("");
                    //viewBook.getBooks();

                }
            }
        });


    }

    /**
     * Metoda <code>countMembers</code> sprawdza aktualny stan ilosci uzytkownikow
     */
    public static void countMembers() {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("SELECT COUNT(username) FROM users");
            ResultSet rs2 = st.executeQuery();


            rs2.next();
            eCountMembers.setText(String.valueOf(rs2.getInt(1)));
            eCountMembers.setVisible(true);


            int b = rs2.getInt(1);

            if (b > 9)
                eCountMembers.setBounds(725, 150, 500, 300);
            else if(b <10)
                    eCountMembers.setBounds(755, 150, 500, 300);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda <code>countBooks</code> sprawdza aktualny stan ilosci ksiazek
     */
    public static void countBooks() {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("SELECT COUNT(ISBN) FROM books;");
            ResultSet rs2 = st.executeQuery();


            rs2.next();
            eCountBooks.setText(String.valueOf(rs2.getInt(1)));
            eCountBooks.setVisible(true);

            int b = rs2.getInt(1);

            if (b > 9)
                eCountBooks.setBounds(1195, 150, 500, 300);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Metoda <code>countAuthors</code> sprawdza aktualny stan ilosci autorow
     */
    public static void countAuthors() {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("SELECT COUNT(DISTINCT author) FROM books;");
            ResultSet rs2 = st.executeQuery();


            rs2.next();
            eCountAuthors.setText(String.valueOf(rs2.getInt(1)));
            eCountAuthors.setVisible(true);
            int b = rs2.getInt(1);

            if (b > 9) {
                eCountAuthors.setBounds(1665, 150, 500, 300);
                if (b < 10)
                    eCountAuthors.setBounds(1695, 150, 500, 300);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metoda <code>welcomeBack</code> reprezentuje wlaczenie widocznosci poszczegolnych komponentow
     */
    public static void welcomeBack() {
        eWelcomeBack.setVisible(true);
        eUsername1.setVisible(true);
        eUsername2.setVisible(true);
        eUsername3.setVisible(true);
        eUsername4.setVisible(true);
        eUsername5.setVisible(true);

    }

    /**
     * Metoda <code>mainMenu</code> reprezentuje przejscie do glownego menu i wylaczenie
     * innych ramek
     */
    public static void mainMenu() {
        bMainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == bMainMenu) {
                    addUser.addUserFrame.dispose();
                    addBook.frameAddBook.dispose();
                    deleteUser.frameDeleteUser.dispose();
                }
            }
        });
    }

    /**
     * Metoda <code>latestUsername</code> reprezentuje otrzymanie nazw 5 najnowszych uzytkownikow i przypisanie ich
     * do zmiennych
     */
    public static void latestUsername() {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("select username from users order by data_dodania DESC ,godzina_dodania desc LIMIT 5;");
            ResultSet rs2 = st.executeQuery();


            ArrayList<String> list = new ArrayList<>();

            while (rs2.next()) {
                list.add(rs2.getString(1));
            }

            eUsername1.setText(list.get(0));
            eUsername2.setText(list.get(1));
            eUsername3.setText(list.get(2));
            eUsername4.setText(list.get(3));
            eUsername5.setText(list.get(4));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
