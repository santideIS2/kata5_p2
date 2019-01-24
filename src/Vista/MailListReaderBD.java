package Vista;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import Modelo.Mail;
import java.util.LinkedList;

public class MailListReaderBD {

    private final List<Mail> listaCorreos = new LinkedList<>();

    public List<Mail> read(){
        String sql = "SELECT * FROM EMAIL";
        try  (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)){
             while(rs.next()){
                if(rs.getString("mail").contains("@")){
                    listaCorreos.add(new Mail(rs.getString("mail")));
                }
             }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return listaCorreos;
    }

    private Connection connect(){
        String url = "jdbc:sqlite:KATA5_v2.db";
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(url);
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;
    }

} 