package Koneksi_DB;
import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Rudiono
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
public class koneksinya {
 Connection koneksi;

 public static Connection Koneksi() {
 try {
 Class.forName("com.mysql.jdbc.Driver");
 Connection koneksi =
DriverManager.getConnection("jdbc:mysql://localhost/apotek", "root", "");

 return koneksi;
 } catch(Exception e) {
 JOptionPane.showMessageDialog(null, e);

 return null;
 }
 }
}
