package com.dilanka_a.restwebspringboot.entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderItem_PK implements Serializable {

    private int _iid;
    private int _oid;

    public OrderItem_PK() {
    }

    public OrderItem_PK(int iid, int oid) {
        this._iid = iid;
        this._oid = oid;
    }

}
