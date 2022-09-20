package steps;

import pages.AddEmployeePage;
import pages.DashboardPage;
import pages.EmployeeListPage;
import pages.LoginPage;

public class PageInitializer {

    public static LoginPage login;
    public static DashboardPage dash;
    public static AddEmployeePage add;
    public static EmployeeListPage emp;


    public static void initializeObjects(){
        login = new LoginPage();
        dash = new DashboardPage();
        add = new AddEmployeePage();
        emp = new EmployeeListPage();
    }


}
