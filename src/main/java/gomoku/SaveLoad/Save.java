package gomoku.SaveLoad;

import gomoku.BasicClass.Board;
import gomoku.BasicClass.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Save {

    private List<Board> staff = new ArrayList<>();
  /*  public void add(Board board) {
        File file = new File("./Boards.txt");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Board> boards = (ArrayList<Board>) ois.readObject();
            ois.close();
            boards.add(board);
            ObjectOutputStream oos = null;
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(boards);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }*/

    public void add(Board board, String name) {
        try {
            File dir = new File("saves/");
            if (!dir.exists()) {
                System.out.println("文件夹创建成功");
                dir.mkdir();
            }
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("saves/" + name + ".porn"));
            output.writeObject(board);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        /*try {
            File file = new File("./Boards.txt");
            if (file.exists()) {
                ObjectInputStream ois = null;
                ois = new ObjectInputStream(new FileInputStream(file));
                ArrayList<Board> boards = (ArrayList<Board>) ois.readObject();//从文件里面取出了list放在一个新的list里面了
                ois.close();
                boards.add(board);
                ObjectOutputStream oos = null;
                oos = new ObjectOutputStream(new FileOutputStream(file));
                oos.writeObject(boards);
                System.out.println("存入");
                oos.close();
            } else {
                boolean flag = file.createNewFile();
                if (flag) {
                    ObjectOutputStream oos = null;
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    int [][]c=new int[16][16];
                    staff.add(new Board("1","1",c,"测试文档"));
                    oos.writeObject(staff);
                    oos.close();

                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }*/

    }


}
