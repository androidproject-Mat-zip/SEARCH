package org.techtwon.searchactivity;

public class Menu {
    String name;
    String add;
    String num;
    String opentime;
    String endtime;
    String breakT;
    String ima;
    String recomand;
    String holiday;

    public Menu(String name, String add, String num, String opentime, String endtime, String breakT, String ima, String ima2, String recomand, String holiday) {
        this.name = name;
        this.add = add;
        this.num = num;
        this.opentime = opentime;
        this.endtime = endtime;
        this.breakT = breakT;
        this.ima = ima;
        this.ima2 = ima2;
        this.recomand = recomand;
        this.holiday = holiday;
    }

    public String getHoliday() {
        return holiday;
    }

    public void setHoliday(String holiday) {
        this.holiday = holiday;
    }


    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    public String getRecomand() {
        return recomand;
    }

    public void setRecomand(String recomand) {
        this.recomand = recomand;
    }
    public String getIma() {
        return ima;
    }

    public void setIma(String ima) {
        this.ima = ima;
    }

    public String getIma2() {
        return ima2;
    }

    public void setIma2(String ima2) {
        this.ima2 = ima2;
    }

    String ima2;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOpentime() {
        return opentime;
    }

    public void setOpentime(String opentime) {
        this.opentime = opentime;
    }

    public String getBreakT() {
        return breakT;
    }

    public void setBreakT(String breakT) {
        this.breakT = breakT;
    }

}
