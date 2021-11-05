package gomoku.BasicClass;

import java.io.Serializable;
import java.util.ArrayList;

public class Player implements Serializable {
    private String name;
    private String passnum;


    public Player(String name, String passnum) {
        this.passnum = passnum;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getPassnum() {
        return passnum;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setPassnum(String passnum) {
        this.passnum = passnum;
    }




}
