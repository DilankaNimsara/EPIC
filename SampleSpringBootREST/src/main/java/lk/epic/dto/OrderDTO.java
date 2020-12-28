package lk.epic.dto;

import java.sql.Date;


public class OrderDTO {

    private int oid;
    private Date date;
    private double amount;
    private UserDTO user;

    public OrderDTO() {
    }

    public OrderDTO(int oid, Date date, double amount, UserDTO user) {
        this.oid = oid;
        this.date = date;
        this.amount = amount;
        this.user = user;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "oid=" + oid +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
