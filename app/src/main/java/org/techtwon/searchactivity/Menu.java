package org.techtwon.searchactivity;

public class Menu {
    String name;
    String add;
    String num;
    String time;
    String breakT;



    public Menu(String name, String add, String num, String time, String breakT) {
        this.name = name;
        this.add = add;
        this.num = num;
        this.time = time;
        this.breakT = breakT;
    }

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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBreakT() {
        return breakT;
    }

    public void setBreakT(String breakT) {
        this.breakT = breakT;
    }

}
