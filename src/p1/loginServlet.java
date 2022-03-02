package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://localhost:3306/amol";
	static String user = "root";
	static String pass = "Amol@9331";
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s1 = req.getParameter("email");
		System.out.println(s1);
		
		String s2 = req.getParameter("password");
		System.out.println(s2);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url,user,pass);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from login where email='"+s1+"' and password='"+s2+"'");
			if(rs.next()) {
			while(rs.next()) {
				String s3 = rs.getString(1);
				System.out.println(s3);
				String s4 = rs.getString(2);
				System.out.println(s4);
			}}
			else {System.out.println("invalid credential");}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
