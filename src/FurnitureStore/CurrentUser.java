package FurnitureStore;

import FurnitureStore.base.DBController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CurrentUser {

    private static String username;
    private static int id=0;
    private static int type;

    public static String getUsername(){
        return username;
    }
    public static void setUsername(String _user){
        username = _user;
    }
    public static void setId(int _id){id = _id;}

    public static int getId() throws SQLException {
        if(id != 0){
            return id;
        }else{

            DBController ctr = new DBController();
            Connection con = ctr.getConnection();
            PreparedStatement ps = null;

            String sql = "select custID from CustomerAccount where username = ?";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            id = rs.getInt(1);

            ps.close();
            con.close();

            return id;
        }
    }


    public static int getType() {
        return type;
    }

    public static void setType(int _type) {
        CurrentUser.type = _type;
    }
}
