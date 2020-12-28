package lk.epic.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Orders {
    @Id
    private int oid;
    private Date date;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "userID", referencedColumnName = "id", nullable = false)
    private User user;

    public Orders() {
    }

    public Orders(int oid, Date date, double amount, User user) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid=" + oid +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
