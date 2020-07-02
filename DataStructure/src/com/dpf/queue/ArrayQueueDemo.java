package com.dpf.queue;


import java.util.Scanner;

//数组模拟单向队列
public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key=' ';//接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean flag=true;
        while(flag){
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出队列");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):获取队列数据");
            System.out.println("h(head):查看队列头的数据");
            key=scanner.next().charAt(0);
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int cs = arrayQueue.Queue();
                        System.out.println("取出来的数据为" + cs);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.headQueue();
                        System.out.println("队列头的数据为:" + head);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出！");
    }
}
//使用数组模拟队列-编写一个ArrayQueue类
class ArrayQueue {
    private int maxsize;//表示数组的最大容量
    private int front=-1;  //队列头;指向队列头部,分析出front是指向队列头的前一个位置
    private int rear=-1;   //队列尾;指向队列尾部,指向队列尾的数量（即就是队列最后一个数据）
    private int[] arr; //该数据用于存放数据,模拟队列a

    //创建队列构造器
    public ArrayQueue(int arrmaxsize) {
        maxsize = arrmaxsize;
        arr = new int[maxsize];
    }

    //判断队列是否满
    public boolean isFull() {
        return rear == maxsize-1;
    }

    //判断队列是否为空
    public boolean isEmpty(){
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        //判断队列是否为满
        if(isFull()){
            System.out.println("队列满,不能加入数据");
            return;
        }
        rear++; //让rear后移
        arr[rear] = n;
    }

    //获取队列的数据
    public int Queue(){
        if(isEmpty()){
            throw new RuntimeException("队列空,不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列的所有数据
    public  void showQueue(){
        if(isEmpty()){
            System.out.println("队列空的,没有数据");
            return;
        }
        for (int i=0;i<arr.length;i++){
            System.out.println("arr["+i+"]:"+arr[i]);
        }
    }

    //显示队列的头数据,注意不是取出数据
    public int headQueue(){
        if(isEmpty()){
            throw new RuntimeException("队列空的,没有数据");
        }
        return arr[front+1];
    }
}