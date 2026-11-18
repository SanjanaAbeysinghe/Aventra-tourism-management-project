package com.aventra.repository;
import com.aventra.db.DBConnection; import com.aventra.model.*; import java.sql.*; import java.util.*;
public class PackageRepository { public List<TourismPackage> findAll() throws SQLException {List<TourismPackage> out=new ArrayList<>();
    String q="SELECT * FROM tourism_packages ORDER BY package_id";
    try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q);ResultSet s=p.executeQuery()){
        while(s.next()){String cat=s.getString("category"); Object[] a={s.getInt("package_id"),s.getInt("destination_id"),s.getString("name"),cat,s.getString("description"),s.getInt("duration_days"),s.getBigDecimal("price"),s.getInt("max_guests"),s.getString("itinerary"),s.getString("accommodation"),s.getString("transport"),s.getString("meals"),s.getString("difficulty"),s.getString("best_season"),s.getString("inclusions"),s.getString("exclusions")}; if("RELAXATION".equalsIgnoreCase(cat))out.add(new RelaxationPackage((int)a[0],(int)a[1],(String)a[2],(String)a[3],(String)a[4],(int)a[5],(java.math.BigDecimal)a[6],(int)a[7],(String)a[8],(String)a[9],(String)a[10],(String)a[11],(String)a[12],(String)a[13],(String)a[14],(String)a[15]));
            else out.add(new AdventurePackage((int)a[0],(int)a[1],(String)a[2],(String)a[3],(String)a[4],(int)a[5],(java.math.BigDecimal)a[6],(int)a[7],(String)a[8],(String)a[9],(String)a[10],(String)a[11],(String)a[12],(String)a[13],(String)a[14],(String)a[15]))
                    ;}
    }
    return out;}
}
