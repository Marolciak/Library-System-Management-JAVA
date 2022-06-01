import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/**
 * Klasa <code>addBook</code> reprezentuje dodanie nowego uzytkownika
 */
public class addBook {

    /**
     * Metoda <code>addBookMethod</code> przechowuje wszystkie komponenty(przyciski , etykiety itp.) oraz
     *   ich ustawienie i inne funkcje.
     */
    public static void addBookMethod() {


        panelAdmin.bAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == panelAdmin.bAddBook) {

                    addUser.addUserFrame.dispose();
                    deleteUser.frameDeleteUser.dispose();
                    addBook.frameAddBook.setVisible(true);
                    addBook.pAuthor.setText(" ");
                    addBook.pTitle.setText(" ");
                    addBook.pISBN.setText(" ");
                    addBook.pQuantity.setText(" ");
                    addBook.pAuthor.setText("");
                    addBook.pTitle.setText("");
                    addBook.pISBN.setText("");
                    addBook.pQuantity.setText("");
                    addBook.sendBook();
                }
            }
        });

        frameAddBook.setTitle("Library");
        frameAddBook.setLayout(null);
        frameAddBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameAddBook.setResizable(false);//nie można przesuwac !! ważne!!
        frameAddBook.setSize(400, 600);
        frameAddBook.setLocation(740, 340);
        frameAddBook.setUndecorated(true);
        frameAddBook.setVisible(false);

        Container container = new Container();
        container = frameAddBook.getContentPane();

        eBackground.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\backgroundAddBook.png"));
        eBackground.setBounds(0, 0, 500, 600);

        pTitle.setBounds(40, 80, 300, 30);
        pTitle.setBorder(new EmptyBorder(5, 5, 5, 5));

        pAuthor.setBounds(40, 180, 300, 30);
        pAuthor.setBorder(new EmptyBorder(5, 5, 5, 5));

        pISBN.setBounds(40, 280, 300, 30);
        pISBN.setBorder(new EmptyBorder(5, 5, 5, 5));

        pQuantity.setBounds(40, 390, 300, 30);
        pQuantity.setBorder(new EmptyBorder(5, 5, 5, 5));

        bAddBook.setBounds(130, 500, 150, 50);
        //bAddBook.setBorder(new EmptyBorder(5,5,5,5));
        bAddBook.setIcon(new ImageIcon("E:\\PROJEKT\\Zdjecia\\buttonAddBook2.png"));

        container.add(pTitle);
        container.add(pAuthor);
        container.add(pISBN);
        container.add(pQuantity);
        container.add(bAddBook);
        container.add(eBackground);



    }

    /**
     * Metoda <code>sendBook</code> reprezentuje dodanie do bazy danych nowej ksiazki po spelnieniu odpowiednich
     * warunkow , takich jak uzupelnienie wszystkich pol i unikatowy ISBN ksiazki
     */
    public static void sendBook() {

        bAddBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (pTitle.getText().equals("") || pAuthor.getText().equals("") || pISBN.getText().equals("") || pQuantity.getText().equals(""))
                    JOptionPane.showMessageDialog(null, "One or more fields are empty", "Empty Fields", 2);

                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
                    Statement st = con.createStatement();
                    //checkISBN();
                    //checkTittle(pTitle.getText());
                    int rs = st.executeUpdate("INSERT INTO `books`(`ISBN`,`title`, `author`,  `quantity`) VALUES ('" + pISBN.getText() + "'  ,  '" + pTitle.getText() + "' , '" + pAuthor.getText() + "' , '" + pQuantity.getText() + "' )");
                    panelAdmin.countAuthors();
                    panelAdmin.countMembers();
                    panelAdmin.countBooks();

                    frameAddBook.dispose();
                    //int rs = st.executeUpdate("INSERT INTO  `books`(`title` , `author`,`price`,`quantity`) VALUES ('" + pTitle.getText() + "','" + pAuthor.getText() + "','" + pPrice.getText() + "' , '" + pQuantity.getText() + "')");
                    con.close();

                } catch (SQLException ex) {
                    ex.printStackTrace();

                } catch (ClassNotFoundException ex2) {
                    ex2.printStackTrace();

                }
            }
        });

    }


    /**
     * Przycisk <code>bAddBook</code> reprezentuje dodanie nowej ksiazki
     */
    public static JButton bAddBook = new JButton();
    /**
     * Pole <code>pTitle</code> pobiera wartosc podana przez uzytkownika
     */
    public static JTextField pTitle = new JTextField();
    /**
     * Pole <code>pAuthor</code> pobiera wartosc podana przez uzytkownika
     */
    public static JTextField pAuthor = new JTextField();
    /**
     * Pole <code>pISBN</code> pobiera wartosc podana przez uzytkownika
     */
    public static JTextField pISBN = new JTextField();
    /**
     * Pole <code>pQuantity</code> pobiera wartosc podana przez uzytkownika
     */
    public static JTextField pQuantity = new JTextField();
    /**
     * Tlo <code>eBackground</code>
     */
    public static JLabel eBackground = new JLabel();
    /**
     * Ramka <code>frameAddBook</code> przechowuje wszystkie komponenty zwiazane z ramka z dodawaniem ksiazki
     */
    public static JFrame frameAddBook = new JFrame();


    /**
     * Metoda <code>checkISBN</code> laczy sie z baza i sprawdza czy podany ISBN juz istnieje , jesli istnieje
     * pokazuje komunikat , jesli nie dodaje nowa ksiazke do bazy danych
     */
    public static void checkISBN() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("SELECT ISBN from books where ISBN = '" + pISBN.getText() + "' ;");
            ResultSet rs2 = st.executeQuery();

            if (rs2.next() == true)
                JOptionPane.showMessageDialog(null, "This ISBN is Already Taken, Choose Another One", "ISBN", 2);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*public static void checkTittle (String title) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/users", "root", "");
            PreparedStatement st = con.prepareStatement("select username from users where username = '" + title + "'");
            //st.setString(0, username);
            ResultSet rs2 = st.executeQuery();
            if (rs2.next())
                JOptionPane.showMessageDialog(null, "This Tittle is Already Taken, Choose Another One", "Tittle Failed", 2);

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

}

