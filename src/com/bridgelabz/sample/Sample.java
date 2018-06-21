package com.bridgelabz.sample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Sample {
	public static void main(String[] args) throws ClassNotFoundException {
		 //Connection con=null;
	        PreparedStatement pstmt=null;
	        ResultSet rst=null;
	        Connection con=Utility.connections();
	         try {
	             String query="insert into studentdetails values(3,'simran')";
	             pstmt=con.prepareStatement(query);
	             pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	         finally
	         {
	             
	                 try
	                 {
	                     if(con!=null)
	                         
	                    con.close();
	                     if(pstmt!=null)
	                     {
	                         pstmt.close();
	                     }
	                     if(rst!=null)
	                     {
	                         rst.close();
	                     }
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	             
	         }
	        
	}
}
