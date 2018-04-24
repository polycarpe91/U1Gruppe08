package DB_connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.polycarpe;
import dao.DAOException;
import dao.DAOFactory;
import dao.DAOUtilitaire;

public class databank {
	static String sql="SELECT polycol FROM polycarpe.poly WHERE id='3';";
	
	public boolean add_brigade( ) throws SQLException{
        
	     Connection connect=null;   
       
		 PreparedStatement preparedStatement = null;
		 ResultSet resultSet = null;
		 
		 try {
			  connect=(Connection) DAOFactory.getInstance();
		       preparedStatement = (PreparedStatement) DAOUtilitaire.
		    		   initialisationRequetePreparee( connect,sql, false,"polycol");
		       resultSet=preparedStatement.executeQuery();
		       while(resultSet.next())  {
                        polycarpe liste_brigade = map_polycarpe(resultSet);
                      }   	
		       if (preparedStatement.executeUpdate()==1) 
		    	   return true   ;
		       else 
		    	   return false;
		             	
		        	
		    } catch (Exception e ) {
		        throw new DAOException( e );
		        
		    } finally {
		    	DAOUtilitaire.silentClosing( resultSet, preparedStatement, connect );
		    }
		 
	}
	
	 public static polycarpe map_polycarpe (ResultSet resultset) throws SQLException{
         polycarpe poly=new polycarpe();
        try{
        
        	poly.setNon(resultset.getString("polycol"));
        	
        	
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        //attente de code
        
        return poly;
     }
	 
	public databank() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Connection connect=null;   
	       
		 PreparedStatement preparedStatement = null;
		 ResultSet resultSet = null;
		connect=(Connection) DAOFactory.getInstance();
	       preparedStatement = (PreparedStatement) DAOUtilitaire.
	    		   initialisationRequetePreparee( connect,sql, false,"polycol");
	       resultSet=preparedStatement.executeQuery();
		System.out.println(databank.map_polycarpe(resultSet));

	}

}
