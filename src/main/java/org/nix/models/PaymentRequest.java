package org.nix.models;

import net.bytebuddy.implementation.bind.annotation.Default;
import org.hibernate.validator.constraints.Length;
import org.nix.RequestStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "requests")
public class PaymentRequest {

    @Id
    @SequenceGenerator(name = "clientsIdSeq", sequenceName = "clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientsIdSeq")
    @Column(name = "id")
    private long identifier;

    @Column(name = "route")
    private int routeNr;

    @DateTimeFormat(pattern = "yyMMddHHmm")
    @Future
    @Column(name = "date_time")
    private Date dateAndTime;

    private int status;

    public PaymentRequest(int routeNr, String dateAndTime) throws ParseException {
        super();
        this.routeNr = routeNr;
        this.dateAndTime = new SimpleDateFormat("yyMMddHHmm").parse(dateAndTime);
    }

    public PaymentRequest() {
    }

    public int getRouteNr() {
        return routeNr;
    }

    public void setRouteNr(int routeNr) {
        this.routeNr = routeNr;
    }

    public Date getDateAndTime() {
        return dateAndTime;
    }

    public void setDateAndTime(Date dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public long getIdentifier() {
        return identifier;
    }

    public void setIdentifier(long identifier) {
        this.identifier = identifier;
    }

    public int getStatus() {
        return status;
    }


    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "\n| " + identifier + " | " +
                routeNr + " | " + dateAndTime +
                " | " + status + " |";
    }
}
