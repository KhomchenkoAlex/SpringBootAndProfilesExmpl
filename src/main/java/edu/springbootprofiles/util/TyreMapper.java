package edu.springbootprofiles.util;

import edu.springbootprofiles.model.autoparts.SummerTyres;
import edu.springbootprofiles.model.autoparts.Tyres;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TyreMapper implements RowMapper<Tyres> {
    public Tyres mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tyres tyre = new SummerTyres(rs.getInt("tyres_size"),rs.getString("tyres_name"));
        return tyre;
    }
}
