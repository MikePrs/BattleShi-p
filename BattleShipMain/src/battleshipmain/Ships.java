package battleshipmain;

import java.util.ArrayList;

public class Ships {
    String id;
    int size;
    ArrayList<Integer> pos = new ArrayList<>();

    Ships(){}
    Ships(String id, int size ) {
        this.id = id;
        this.size = size;
    }

    public String getId() {
        return id;
    }

    public int getSize() {
        return size;
    }

    public ArrayList<Integer> getPos() {
        return pos;
    }
    
    public void setPos(int j) {
       this.pos.add(j) ;
    }

    int getPos(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}