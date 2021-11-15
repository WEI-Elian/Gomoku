package gomoku.Time;

import gomoku.BasicClass.Step;
import gomoku.Fuction.Drawstaff;
import javafx.application.Platform;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class PlayWatcher2Plus extends Thread {
    private Thread thread = null; //线程
    private HTimer2Plus hTimer2Plus; // 观察者要持有一个闹钟，不然他看谁？


    ArrayList<Step> steps = new ArrayList<Step>();
    Drawstaff drawstaff = new Drawstaff();
    AnchorPane anchorPane = new AnchorPane();

    // 构造函数（传入一个要被观察的时钟）
    public PlayWatcher2Plus(HTimer2Plus hTimer2Plus, AnchorPane anchorPane, ArrayList<Step> steps) {
        this.hTimer2Plus = hTimer2Plus;
        this.anchorPane = anchorPane;
        this.steps = steps;
    }

    // 用法说明
    private void test() {
        // 必须：创建一个观察者
        HTimer2Plus hTimer2Plus = new HTimer2Plus(); // 创建一个时钟，这个时钟要传给观察者
//        PlayWatcher2Plus playWatcher2Plus = new PlayWatcher2Plus(hTimer2Plus); // 创建观察者
        // 用法
        // 1.让观察者看着时钟
//        playWatcher2Plus.watch();
//        // 2.观察者别看了
//        playWatcher2Plus.pause();
    }

    // 开始盯着时钟看
    public void watch() {
        // 实例化线程
        System.out.println("开始观察");
        thread = new Thread(this);
        thread.setPriority(Thread.MIN_PRIORITY);
        // 开始盯着看
        thread.start();
    }

    // 不要盯着看
    public void pause() {
        // 如果线程存在，才能停下来。
        if (thread != null) {
            thread.interrupt();
        }
    }

    //    public void setSteps(ArrayList<Step> steps){
//        this.steps=steps;
//    }
    public void speed(int v) {
        this.hTimer2Plus.setDoubleSpeed(v);
    }


    @Override
    public void run() {
        try {

            for (Step i : steps) {
                System.out.println(i.getX());
            }
            // 如果观察者没有被人停下来
            int[] a = new int[1];

            while (!thread.isInterrupted()) {
                if (hTimer2Plus.getTime() <= 0) {
                    // 闹钟已经到零了！
                    // start 把这个棋子（棋子A）放下去
                    // 【注意】这里放置自己的落子逻辑
                    // end
                    // 判断刚刚下的棋子（棋子A），是不是最后一个棋子
                    if (a[0] % 2 == 0) {
                        Platform.runLater(() -> {
                            drawstaff.drawBlackChessUnit(this.anchorPane, this.steps.get(a[0]).getX(), this.steps.get(a[0]).getY(), a[0] + 1);
                        });


                    } else {
                        Platform.runLater(() -> {
                            drawstaff.drawWhiteChessUnit(this.anchorPane, this.steps.get(a[0]).getX(), this.steps.get(a[0]).getY(), a[0] + 1);
                        });

                    }

//                    boolean isLastChess = false; // 【注意】请把这句话改成自己的，isLastChess变量代表当前要下的棋子是不是最后一个棋子
                    if (a[0] == this.steps.size() - 1) {

                        thread.interrupt(); // 观察者不要盯着看了，因为没有棋子要下了
                    } else {
                        // 还有下一个棋子的话，就让闹钟重新开始倒计时（时间为下一个棋子的落子时间）
                        System.out.println(a[0]);
                        long nextChessTime = this.steps.get(a[0]).getTime(); // 【注意】请把这句话改成自己的，nextChessTime变量代表下一个棋子的落子时间
                        hTimer2Plus.startTimer(nextChessTime);
                        a[0]++;
                    }
                }
                // 观察者休息一下，不要老是盯着人家看！休息完了，再看看闹钟到点了吗
                sleep(500);
            }
        } catch (Exception e) {
        }

    }
}
