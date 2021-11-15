package gomoku.SaveLoad;

import gomoku.BasicClass.Board;
import gomoku.BasicClass.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Save {

    private List<Board> staff = new ArrayList<>();
    Load load=new Load();


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





    }



    public void savepassword(Player player,String newpassword){
        File file = new File("./Player.txt");
        ObjectOutputStream oos = null;
        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Player> staff = (ArrayList<Player>) ois.readObject();
            for(Player i:staff){
                if(i.getName().equals(player.getName())){
                    i.setPassnum(newpassword);
                    break;
                }
            }


            clearInfoForFile(file);
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(staff);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }



    public void addPlayer(String playername){

        File file = new File("./Player.txt");
        ObjectOutputStream oos = null;
        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Player> staff = (ArrayList<Player>) ois.readObject();
            staff.add(new Player(playername,"00000"));


            clearInfoForFile(file);
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(staff);
            oos.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



    public static void clearInfoForFile(File file) {

        try {
            if(!file.exists()) {
                file.createNewFile();
            }
            FileWriter fileWriter =new FileWriter(file);
            fileWriter.write("");
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}
