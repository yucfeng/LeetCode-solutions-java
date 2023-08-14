package com.yucfeng;

public class CustomQueue<T>
{
    private T[] queue;//队列数组
    private int head=0;//头下标
    private int tail=0;//尾下标
    private int count=0;//元素个数
    public CustomQueue()
    {
        queue=(T[])new Object[10];
        this.head=0;//头下标为零
        this.tail=0;
        this.count=0;
    }
    public CustomQueue(int size)
    {
        queue=(T[])new Object[size];
        this.head=0;
        this.tail=0;
        this.count=0;
    }
    //入队
    public boolean add(T t)
    {
        if(count==queue.length)
            return false;
        queue[tail++%(queue.length)]=t;// % 复用数组
        count++;
        return true;
    }
    //出队
    public T poll()
    {
        if(count==0)
            return null;
        count--;
        return queue[head++%(queue.length)];
    }
    //查队头
    public T peek()
    {
        if(count==0) return null;
        return queue[head];
    }
    //判满
    public boolean isFull()
    {
        return count==queue.length;
    }
    //判空
    public boolean isEmpty()
    {
        return count==0;
    }
}
