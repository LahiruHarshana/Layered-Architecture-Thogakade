package lk.ijse.pos.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CustomEntityDTO {
    private String oid;
    private LocalDate date;
    private String customerID;
    private String itemCode;
    private int qty;
    private BigDecimal unitPrice;

    public CustomEntityDTO() {
    }

    public CustomEntityDTO(String oid, LocalDate date, String customerID, String itemCode, int qty, BigDecimal unitPrice) {
        this.oid = oid;
        this.date = date;
        this.customerID = customerID;
        this.itemCode = itemCode;
        this.qty = qty;
        this.unitPrice = unitPrice;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
