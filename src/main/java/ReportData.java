/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SEISANI GUNDO JR
 */
public class ReportData {

    private String productCode;
    private String productName;
    private double warranty;
    private int category;
    private double price;
    private int stockLevels;
    private String supplier;

    public ReportData(String productCode,
                      String productName,
                      double warranty,
                      int category,
                      double price,
                      int stockLevels,
                      String supplier) {

        this.productCode = productCode;
        this.productName = productName;
        this.warranty = warranty;
        this.category = category;
        this.price = price;
        this.stockLevels = stockLevels;
        this.supplier = supplier;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getProductName() {
        return productName;
    }

    public double getWarranty() {
        return warranty;
    }

    public int getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public int getStockLevels() {
        return stockLevels;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setProductCode(String code) {
        this.productCode = code;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setWarranty(double warranty) {
        this.warranty = warranty;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setStockLevels(int stockLevels) {
        this.stockLevels = stockLevels;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}