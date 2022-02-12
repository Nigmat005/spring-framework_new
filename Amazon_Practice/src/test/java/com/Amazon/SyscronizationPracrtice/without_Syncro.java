package com.Amazon.SyscronizationPracrtice;

import java.io.IOException;

public class without_Syncro {
    public void print_Result(int n){
        for (int i = 1; i < 5; i++) {
            System.out.println(n*i);
            try{
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

class MyThread1 extends Thread{
    static without_Syncro withoutSyscro;
    static String st1;
//    MyThread1( without_Syncro withoutSyscro){
//        MyThread1.withoutSyscro =withoutSyscro;
//        st1="haha";
//    }
    public void replaceCons( without_Syncro withoutSyscro){
        this.withoutSyscro=withoutSyscro;
    }

    public void run(){
//        System.out.println("Thread1 is running");
        withoutSyscro.print_Result(5);
    }
}

class MyThread2 extends Thread{
    without_Syncro withoutSyscro;

    MyThread2(without_Syncro withoutSyscro){
        this.withoutSyscro=withoutSyscro;
    }
    public void run(){
//        System.out.println("Thread2 is running");
        withoutSyscro.print_Result(100);
    }
}

class Test{
    public static void main(String[] args) {
        without_Syncro withoutSyscro=new without_Syncro();
        MyThread1 myThread1=new MyThread1();
        myThread1.replaceCons(withoutSyscro);
        MyThread1.st1 ="hehe";
        System.out.println(MyThread1.st1);
        MyThread2 myThread2=new MyThread2(withoutSyscro);
        myThread1.start();
        myThread2.start();
    }
}