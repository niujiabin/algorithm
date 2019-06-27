package wanghui.栈;

import java.util.EmptyStackException;

public class 数组实现队列和栈 {

    public static class ArrayStack {
        private Integer[] arr;
        private Integer size;

        public ArrayStack(Integer initsize) {
            if(size<0) {
                throw new IllegalArgumentException();
            }
            arr = new Integer[initsize];
            size = 0;
        }

        public void push (int obj) {
            if(size == arr.length) {
                throw  new ArrayIndexOutOfBoundsException();
            }
            arr[size++] = obj;
        }

        public Integer pop() {
            if(size==0) {
                throw new EmptyStackException();
            }
            return arr[--size];
        }

        public Integer peek() {
            if(size==0) {
                return null;
            }
            return arr[size-1];
        }
    }

    public static class ArrayQueue {
        private Integer[] arr;
        private Integer size;
        private Integer first;
        private Integer last;

        public ArrayQueue(int initSize) {
            if(initSize<0) {
                throw new IllegalArgumentException();
            }
            arr = new Integer[initSize];
            size = 0;
            first = 0;
            last = 0;
        }

        public Integer peek() {
            if(size == 0) {
                return null;
            }
            return arr[first];
        }

        public void push(int obj) {
            if(size==arr.length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            size++;
            arr[last] = obj;
            last = last==arr.length-1?0:last+1;
        }

        public Integer poll() {
            if(size==0) {
                throw new ArrayIndexOutOfBoundsException();
            }
            size--;
            int tmp = first;
            first = first==arr.length-1?0:first+1;
            return arr[tmp];
        }

    }
}
