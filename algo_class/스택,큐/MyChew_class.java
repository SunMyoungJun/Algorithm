package com.ssafy.subset_statck_queue;
import java.util.LinkedList;
import java.util.Queue;

public class MyChew_class {
    public static void main(String[] args) {
        int N = 20;
        int num=1;
        Queue<Person> queue = new LinkedList<Person>();
        queue.offer(new Person(num, 1));
        Person p;
        int availableCnt=0;
        while(N > 0) {
            if(!queue.isEmpty()) {
                p= queue.poll();
                availableCnt = (N>=p.cnt)? p.cnt: N;
                N -= availableCnt;
                if(N == 0) {
                    System.out.println("마지막 마이쭈를 가져간 사원 "+p.num+" 가져간 개수 : "+availableCnt);
                }else {
                    System.out.println(p.num+"번이 "+availableCnt+"개수만큼 가져갑니다. 남은 수 : "+N);
                    p.cnt++; //  받을 마이쮸 개수 하나 증가
                    queue.offer(p);// 자기 다시 줄 세우기
                    queue.offer(new Person(++num,1)); // 다음번호 사람 줄 세우기
                }
            }
        }
    }
    static class Person{
        int num;
        int cnt;
        public Person(int num, int cnt) {
            this.num = num;
            this.cnt = cnt;
        }

    }
}