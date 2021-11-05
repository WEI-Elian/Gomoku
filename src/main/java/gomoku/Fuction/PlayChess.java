package gomoku.Fuction;

public class PlayChess {
    Drawstaff drawstaff=new Drawstaff();

    private Object[][][] wins = new Object[16][16][672];//赢法的三维数组
    private int count = 0;//赢法的数量
    private int[] blackWin = new int[1000], whiteWin = new int[1000];//赢法的标号实则可以定位成为572
    public boolean me = false;//判断谁先下棋
    private int win = 0;//判断谁赢了
    public int[][] chessBoard = new int[16][16];//棋盘的布局
    private long start,end;


    public PlayChess() {
        // 阳线纵向90°的赢法
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = 0; k < 5; k++) {
                    wins[i][j + k][count] = true;
                }
                count++;
            }
        }
        // 阳线横向0°的赢法
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = 0; k < 5; k++) {
                    wins[j + k][i][count] = true;
                }
                count++;
            }
        }
        // 阴线斜向135°的赢法
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 12; j++) {
                for (int k = 0; k < 5; k++) {
                    wins[i + k][j + k][count] = true;
                }
                count++;
            }
        }
        // 阴线斜向45°的赢法
        for (int i = 0; i < 12; i++) {
            for (int j = 15; j > 3; j--) {
                for (int k = 0; k < 5; k++) {
                    wins[i + k][j - k][count] = true;
                }
                count++;
            }
        }
        //初始化棋盘
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 15; j++) {
                chessBoard[i][j] = 0;
            }
        }
        //初始化win
        for (int i = 0; i < 1000; i++) {
            blackWin[i] = 0;
            whiteWin[i] = 0;
        }
    }

    public int[] getPoint(double x, double y) {
        int[] point = new int[2];
        if (x >= 0 && x <= 825 && y >= 0 && y <= 825) {
            int i;
            int j;
            if (x < 75) {
                i = 0;
            } else if (x <= 775) {
                if (x % 50 >= 25) {
                    i = (int) x / 50;
                } else {
                    i = (int) x / 50 - 1;
                }
            } else {
                i = 15;
            }

            if (y < 75) {
                j = 0;
            } else if (y <= 775) {
                if (y % 50 >= 25) {
                    j = (int) y / 50;
                } else {
                    j = (int) y / 50 - 1;
                }
            } else {
                j = 15;
            }
            point[0] = i;
            point[1] = j;
            return point;
        }
        return null;
    }


    public void blackGo(int i, int j) {
        if (chessBoard[i][j] == 0) {

            // 改变棋盘信息(该位置有棋子)
            chessBoard[i][j] = 1;

            // 遍历赢法统计数组
            for (int k = 0; k < count; k++) {
                if (wins[i][j][k] != null && (boolean) wins[i][j][k]) {
                    // 如果存在赢法,则玩家此赢法胜算+1(赢法为5胜取胜)
                    blackWin[k]++;
                    // 如果存在赢法,则电脑此赢法胜算赋值为6(永远不等于5,永远无法在此处取胜)
                    whiteWin[k] = 6;
                    // 玩家落子后,此处赢法数组凑够5,玩家取胜
                    if (blackWin[k] == 5) {
                        win = 1;
                    }
                }
            }
            me = !me;
        }

    }


    public void whiteGo(int i, int j) {
        if (chessBoard[i][j] == 0) {

            // 改变棋盘信息(该位置有棋子)
            chessBoard[i][j] = 2;

            // 遍历赢法统计数组
            for (int k = 0; k < count; k++) {
                if (wins[i][j][k] != null && (boolean) wins[i][j][k]) {
                    // 如果存在赢法,则玩家此赢法胜算+1(赢法为5胜取胜)
                    whiteWin[k]++;
                    // 如果存在赢法,则电脑此赢法胜算赋值为6(永远不等于5,永远无法在此处取胜)
                    blackWin[k] = 6;
                    // 玩家落子后,此处赢法数组凑够5,玩家取胜
                    if (whiteWin[k] == 5) {
                        win = 2;
                    }
                }
            }
            me = !me;
        }
    }

    public void setStart(long start) {
        this.start = start;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long getTime(){
        return end-start;
    }

    public int getWin() {
        return win;
    }








}
