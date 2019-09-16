package keepondoing;

public class SynchronizeAlphGo implements Runnable{

    public  static int sharenum=5 ;
    String  threadNum;

    public static Integer count=6;
    static int  soul=0;

    public SynchronizeAlphGo(String threadNum) {
        this.threadNum = threadNum;
    }

    public void synfun1(){
          String threadname = Thread.currentThread().getName();
          System.out.println("线程"+threadname+"运行中");
          int soul=0;
          synchronized (count){
              count.notify();
              boolean lockResult = Thread.holdsLock(count);
              System.out.println(threadname+"获得锁"+lockResult);
              System.out.println(++soul);
              try {
                  System.out.println(10/0);
              } catch (Exception e) {
                  try {
                      count.wait();
                  } catch (InterruptedException e1) {
                      e1.printStackTrace();
                  }

                  //Thread.currentThread().interrupt();  终止线程
                  e.printStackTrace();
              }
              System.out.println("当前线程"+Thread.currentThread().getName()+"执行结束");
          }
      }

    @Override
    public void run()  {
        String threadname = Thread.currentThread().getName();
        System.out.println("线程"+threadname+"运行中");

        synchronized (count) {
           while(sharenum-->0) {
                //count.notify();
               soul++;
                boolean lockResult = Thread.holdsLock(count);
                System.out.println(threadname + "获得锁" + lockResult);
                try {
                    System.out.println(10/0);

                } catch (Exception e) {
                   /* try {

                       // count.wait();//当一个线程执行wait，不需要notify·另一个线程会重新获得锁并继续往下执行
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }*/
                    e.printStackTrace();
                }
                System.out.println("当前值"+soul+","+threadname+"");
                //System.out.println(10 / 0);
               /* try {
                    System.out.println(10 / 0);
                } catch (Exception e) {
                    try {
                        count.wait();
                    } catch (InterruptedException e1) {
                        e1.printStackTrace();
                    }

                    //Thread.currentThread().interrupt();  终止线程
                    e.printStackTrace();
                }*/

                System.out.println("当前线程" + threadname + "执行结束" + soul);

            }
        }
    }
     //static类变量
    public static void main(String[] args) {

         new Thread(new SynchronizeAlphGo("first"),"线程1").start();
        new Thread(new SynchronizeAlphGo("second"),"线程2").start();

    }


























}
