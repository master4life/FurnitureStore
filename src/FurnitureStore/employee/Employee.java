package FurnitureStore.employee;

public class Employee {

    private int id;
    private String fname;
    private String lname;
    private int salary;
    private String place;
    private int plz;
    private String street;
    private int houseNo;
    private int depNo;

    public Employee(int id, String fname, String lname, int salary, String place, int plz, String street, int houseNo, int depNo) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
        this.place = place;
        this.plz = plz;
        this.street = street;
        this.houseNo = houseNo;
        this.depNo = depNo;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(int houseNo) {
        this.houseNo = houseNo;
    }

    public int getDepNo() {
        return depNo;
    }

    public void setDepNo(int depNo) {
        this.depNo = depNo;
    }


    public String toStringForSQL() {
        return "'"+id+"',"
                +"'"+fname+"',"
                +"'"+lname+"',"
                +salary+","
                +"'"+place+"',"
                +plz+","
                +"'"+street+"',"
                +houseNo+","
                +depNo;
    }
}
