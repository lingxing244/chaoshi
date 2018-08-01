package com.entity;

import java.util.List;

public class BillData {
    private int total;

    private List<Bill> rows ;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Bill> getRows() {
        return rows;
    }

    public void setRows(List<Bill> rows) {
        this.rows = rows;
    }
}
