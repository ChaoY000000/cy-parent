package com.chao.note.util;

/**
 * Created by 15313 on 2020/11/13.
 */
public class ExcelDTO {
    private String firstCode;
    private String firstAddress;
    private String secondCode;
    private String secondAddress;
    private String thirdCode;
    private String thirdAddress;
    private String fourthCode;
    private String fourthAddress;


    public ExcelDTO() {
    }

    public ExcelDTO(String firstCode, String firstAddress, String secondCode, String secondAddress, String thirdCode, String thirdAddress, String fourthCode, String fourthAddress) {
        this.firstCode = firstCode;
        this.firstAddress = firstAddress;
        this.secondCode = secondCode;
        this.secondAddress = secondAddress;
        this.thirdCode = thirdCode;
        this.thirdAddress = thirdAddress;
        this.fourthCode = fourthCode;
        this.fourthAddress = fourthAddress;
    }

    public String getFirstCode() {
        return firstCode;
    }

    public void setFirstCode(String firstCode) {
        this.firstCode = firstCode;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondCode() {
        return secondCode;
    }

    public void setSecondCode(String secondCode) {
        this.secondCode = secondCode;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public String getThirdCode() {
        return thirdCode;
    }

    public void setThirdCode(String thirdCode) {
        this.thirdCode = thirdCode;
    }

    public String getThirdAddress() {
        return thirdAddress;
    }

    public void setThirdAddress(String thirdAddress) {
        this.thirdAddress = thirdAddress;
    }

    public String getFourthCode() {
        return fourthCode;
    }

    public void setFourthCode(String fourthCode) {
        this.fourthCode = fourthCode;
    }

    public String getFourthAddress() {
        return fourthAddress;
    }

    public void setFourthAddress(String fourthAddress) {
        this.fourthAddress = fourthAddress;
    }

    @Override
    public String toString() {
        return "ExcelDTO{" +
                "firstCode='" + firstCode + '\'' +
                ", firstAddress='" + firstAddress + '\'' +
                ", secondCode='" + secondCode + '\'' +
                ", secondAddress='" + secondAddress + '\'' +
                ", thirdCode='" + thirdCode + '\'' +
                ", thirdAddress='" + thirdAddress + '\'' +
                ", fourthCode='" + fourthCode + '\'' +
                ", fourthAddress='" + fourthAddress + '\'' +
                '}';
    }
}
