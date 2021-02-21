package train_usecase;

/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TrainDao {
static final String Driver_name="com.mysql.cj.jdbc.Driver";
static final String DB_URL="jdbc:mysql://localhost:3306/train?autoReconnect=true&useSSL=false";
static final String USERNAME="root";

static final String Password="root";

Train findTrain(int trainNo) {
	Train train=null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");//1st step
		System.out.println("class found");
		
		//second Step
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/train?autoReconnect=true&useSSL=false", "root", "root");
		System.out.println("Connected");
		
		PreparedStatement ps= con.prepareStatement("insert into traininfo values(?,?,?,?,?)");
		ps.setInt(1,trainNo);
		ResultSet rs=ps.executeQuery();
while (rs.next()) {
	System.out.println(rs.getInt(1) +"" +rs.getString(2)+""+rs.getString(3)+""+rs.getInt(4));
}
	}
	
	catch(Exception e) {
		System.out.println(e);
	}
	return train;
}

}
*/

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;



public class TrainDao {
	String DRIVER_NAME="com.mysql.cj.jdbc.Driver";
	String DB_URL = "jdbc:mysql://localhost:3306/train?useSSL=false";
	//String DB_URL="jdbc:mysql://localhost:3306/train?autoReconnect=true&useSSL=FALSE";
	String USERNAME="root";
	String PASSWORD="root";
	
	public Train findTrain(int trainNo)
	{
		int TRAIN_NO=trainNo;
		//System.out.println(trainNo);
		Train train=null;
		
		try 
		{
			//step1
			Class.forName(DRIVER_NAME);
			System.out.println("Driver class found");
			
			//step2
			System.out.println("Connecting to DataBase...");
			Connection con = DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
			System.out.println("connected");
			//step3
			//PreparedStatement pstmt=con.prepareStatement("SELECT * FROM trains");
			java.sql.Statement stmt  = con.createStatement();
			//pstmt.setInt(1, TRAIN_NO);
			//ResultSet rs=pstmt.executeQuery();
			String sql = "SELECT * FROM trains where TRAIN_NO="+ trainNo;
			System.out.println(sql);
			ResultSet rs    = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				train= new Train(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDouble(5));
				
			}
			con.close();
			//System.out.println(train);
		}
		catch(Exception e)
		{
			System.out.println("class not found");
			System.out.println(e);
		}
		return train;
			
		}
}
	

