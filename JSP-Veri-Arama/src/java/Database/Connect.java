package Database;

import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

    private Connection conn = null; //Bağlantı nesnemiz
    private String url = "jdbc:mysql://localhost:3306/";//veritabanının adresi ve portu
    private String dbName = "magaza"; //veritabanının ismi
    private String properties= "?useUnicode=true&characterEncoding=utf8"; //Türkçe karakter problemi yaşamamak için
    private String driver = "com.mysql.jdbc.Driver";//MySQL-Java bağlantısını sağlayan JDBC sürücüsü
    private String userName = "root"; //veritabanı için kullanıcı adı
    private String password = "123456"; //kullanıcı şifresi
    private ResultSet rs; // sorgulardan dönecek kayıtlar (sonuç kümesi) bu nesne içerisinde tutulacak
    
    
    public Statement baglantiAc() throws Exception {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url + dbName + properties, userName, password);//bağlantı açılıyor
        return (Statement) conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        //return conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
    }
    public void baglantiKapat() throws Exception {
        conn.close();
    }
    public ResultSet KayitArama(String tcNo) throws SQLException, Exception
    {
        try {
        Statement st = baglantiAc(); //veritabanına bağlanılıyor
        rs = st.executeQuery("SELECT * FROM  musteri2 WHERE kimlikNo='"+tcNo+"'"); //tablodaki kayıtlar getiriliyor
        //rs.next(); //tablonun ilk kaydını göster.
        //System.out.println(rs.getString("kimlikNo"));
        //System.out.println(rs.getString("ad"));
        //System.out.println(rs.getString("soyad"));
        //System.out.println(rs.getString("adres"));
        //System.out.println(rs.getString("telefon"));
        return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
        }    
    }
    public void KayitEkle(String tcNo, String ad, String soyad, String adres, String telefon) throws Exception
    {
        try {
        Statement st = baglantiAc();
        String sql= "INSERT INTO musteri2 (kimlikNo, ad, soyad, adres, telefon) VALUES (" +
        "'" + tcNo + "', " +
        "'" + ad + "', " +
        "'" + soyad + "', " +
        "'" + adres + "', " +
        "'" + telefon + "')";
        
        st.executeUpdate(sql); //sorguyu çalıştır
        System.out.println("Kayıt eklendi.");
        baglantiKapat(); //bağlantıyı kapat
        } catch (Exception e) {
            e.printStackTrace();            
        } finally {
        }    
    }
    public void KayitGuncelle(String tcNo, String ad, String soyad, String adres, String telefon) throws SQLException, Exception {
        try {
        Statement st = baglantiAc();
        String sql2 = "UPDATE musteri2 SET " +
        "ad='" + ad + "', " +
        "soyad='" + soyad + "', " +
        "adres='" + adres + "', " +
        "telefon='" + telefon +
        "' WHERE kimlikNo='" + tcNo +"'";
        st.executeUpdate(sql2); //sorguyu çalıştır
        System.out.println("Kayıt güncellendi.");
        baglantiKapat(); //bağlantıyı kapat
        } catch (Exception e) {
            e.printStackTrace();
            
        } finally {
        }    
    }
    public void KayitSil(String isim) throws Exception {
        Statement st = baglantiAc();
        st.executeUpdate("DELETE FROM  musteri2 WHERE ad='"+isim+"'");
        System.out.println("Kayıt silindi.");        
        baglantiKapat(); //bağlantıyı kapat
    }
    public static void main(String[] args) {
        Connect db=new Connect();
        try {
            //db.KayitArama("Ensar");
            //db.KayitEkle("1242672369","Ensar","Karabudak","Abdulhazi mah.","05XXXXXXX7");
            //db.KayitSil("Ensar");
            //db.KayitGuncelle(1242672369,"Ensar","Karabudak","Abdullahpasa Mahallesi","05XXXXXX8);
        } catch (Exception ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
}
