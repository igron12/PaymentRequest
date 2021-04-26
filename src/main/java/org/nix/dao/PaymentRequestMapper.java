package org.nix.dao;

import org.nix.RequestStatus;
import org.nix.models.PaymentRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class PaymentRequestMapper implements RowMapper {
    @Override
    public PaymentRequest mapRow(ResultSet resultSet, int i) throws SQLException {

        PaymentRequest request = new PaymentRequest();
        request.setIdentifier(resultSet.getInt("id"));
        request.setRouteNr(resultSet.getInt("route"));
        request.setDateAndTime(resultSet.getDate("date_time", Calendar.getInstance()));
        request.setStatus(RequestStatus.valueOf(resultSet.getString("status")).ordinal());

        return request;
    }
}
