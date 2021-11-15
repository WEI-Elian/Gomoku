package gomoku.SaveLoad;

import gomoku.BasicClass.Board;
import gomoku.BasicClass.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Load {

    private List<Player> staff = new ArrayList<>();

    public Player loadPlayer(String Name, String password) {
        try {
            File file = new File("./Player.txt");
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                List<Player> players = (List<Player>) ois.readObject();
                ois.close();
                for (Player i : players) {
                    System.out.println(i.getName());
                    System.out.println(i.getPassnum());
                    if (i.getName().equals(Name) && i.getPassnum().equals(password)) {
                        return i;
                    }
                }

            } else {
                boolean flag = file.createNewFile();
                if (flag) {
                    ObjectOutputStream oos = null;
                    oos = new ObjectOutputStream(new FileOutputStream(file));
                    staff.add(new Player("wei", "123"));
                    staff.add(new Player("wang", "124"));
                    staff.add(new Player("li", "125"));
                    oos.writeObject(staff);
                    oos.close();

                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;

    }



    public boolean findPlayer(String name) throws IOException {
        try {
            File file = new File("./Player.txt");
            if (file.exists()) {
                ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                List<Player> players = (List<Player>) ois.readObject();
                ois.close();
                for (Player i : players) {
                    System.out.println(i.getName());
                    System.out.println(i.getPassnum());
                    if (i.getName().equals(name)) {
                        return true;
                    }
                }

            }
        } catch (FileNotFoundException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;


    }


    public ArrayList<String> loadallBoard(Player player) {
      /*  File file = new File("./Boards.txt");
        ObjectOutputStream oos = null;
        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Board> staff = (ArrayList<Board>) ois.readObject();
            System.out.println("去除");
            return  staff;


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return  null;*/
        ArrayList<String> staff = new ArrayList<>();
        try {
            File work = new File("saves/");
            File[] files = work.listFiles();
            if (files != null && files.length != 0) {
                for (int i = 0; i < files.length; i++) {
                    ObjectInputStream input = new ObjectInputStream(new FileInputStream(files[i]));
                    Board board=(Board) (input.readObject());
                    if(player.getName().equals(board.getPlayer1())||player.getName().equals(board.getPlayer2())){
                        staff.add(board.getBoardname());
                    }
                   /* staff.add((Board) (input.readObject()));*/
                }
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return staff;
    }


    public Board loadBoard(String boardname) {

        ArrayList<String> staff = new ArrayList<>();
        try {
            File work = new File("saves/");
            File[] files = work.listFiles();
            if (files != null && files.length != 0) {
                for (int i = 0; i < files.length; i++) {
                    ObjectInputStream input = new ObjectInputStream(new FileInputStream(files[i]));
                    Board board=(Board) (input.readObject());
                    if(boardname.equals(board.getBoardname())){
                     return board;
                    }
                    /* staff.add((Board) (input.readObject()));*/
                }
            }


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

      return null;
    }


    public ArrayList<Board> Boardall(Player player) {

        ArrayList<Board> staff = new ArrayList<>();
        try {
            File work = new File("saves/");
            File[] files = work.listFiles();
            if (files != null && files.length != 0) {
                for (int i = 0; i < files.length; i++) {
                    ObjectInputStream input = new ObjectInputStream(new FileInputStream(files[i]));
                    Board board=(Board) (input.readObject());
                    if(player.getName().equals(board.getPlayer1())||player.getName().equals(board.getPlayer2())){
                        staff.add(board);
                    }
                    /* staff.add((Board) (input.readObject()));*/
                }
            }
            return staff;


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }

        return null;
    }


    public ArrayList<String> getallplayername(Player player) {
        File file = new File("./Player.txt");
        ObjectOutputStream oos = null;
        try {
            ObjectInputStream ois = null;
            ois = new ObjectInputStream(new FileInputStream(file));
            ArrayList<Player> staff = (ArrayList<Player>) ois.readObject();
            ArrayList<String> names = new ArrayList<>();
            for (Player i : staff) {
                if (i.getName().equals(loadPlayer(player.getName(), player.getPassnum()).getName())) {

                } else {
                    names.add(i.getName());
                }
            }
            return names;


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


}
