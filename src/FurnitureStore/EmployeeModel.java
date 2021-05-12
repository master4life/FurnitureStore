package FurnitureStore;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeModel {

    DBController dbController = new DBController();

    public EmployeeModel() throws SQLException {
    }


    public void createEmployee(Employee employee) throws SQLException {
        PreparedStatement stmt = dbController.getConnection().prepareStatement(
                "insert into Employee values ("+employee.toStringForSQL()+")",
                Statement.RETURN_GENERATED_KEYS);

        stmt.executeUpdate();
    }


}
