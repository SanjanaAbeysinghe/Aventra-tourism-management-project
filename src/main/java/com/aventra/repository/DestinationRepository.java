package com.aventra.repository;
import com.aventra.db.DBConnection; import com.aventra.model.Destination; import java.sql.*; import java.util.*;
public class DestinationRepository {
 public List<Destination> findAll()throws SQLException{List<Destination> out=new ArrayList<>();String sql="SELECT * FROM destinations ORDER BY destination_id";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(sql);ResultSet r=p.executeQuery()){while(r.next())out.add(new Destination(r.getInt("destination_id"),r.getString("name"),r.getString("location"),r.getString("description"),r.getString("difficulty")));}return out;
 }
}
