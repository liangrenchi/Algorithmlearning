package com.renchi.linkedlist;

import java.util.Objects;

public class SingleLinkedListDemo {

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(new HeroNode(1,"宋江","及时雨"));
        singleLinkedList.add(new HeroNode(2,"卢俊义","b"));
        singleLinkedList.del(1);
        singleLinkedList.printList();
    }
}

class SingleLinkedList{
    //先初始化一个头节点
    private HeroNode head = new HeroNode(0,"","");

    /**
     * 新增节点
     * @param heroNode
     */
    public void add(HeroNode heroNode){
        if (Objects.isNull(heroNode)){
            return;
        }

        //因为head节点不能移动，因此我们需要一个辅助节点帮助我们找到最后一个节点
        HeroNode temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }

        temp.next = heroNode;
    }

    /**
     * 根据节点的no来修改
     * @param heroNode
     */
    public void update(HeroNode heroNode){

        if (head.next == null){
            System.out.println("链表为空，无法修改");
            return;
        }

        HeroNode temp = head.next;
        while (true){
            if (temp.next == null || Objects.equals(temp.no,heroNode.no)){
                break;
            }
            temp = temp.next;
        }

        //存在该节点，进行修改
        if (Objects.equals(temp.no,heroNode.no)){
            temp.name=heroNode.name;
            temp.nickName=heroNode.nickName;
        }else {
            System.out.println("不存在该节点，无法修改");
        }
    }

    /**
     * 删除节点
     * @param no
     */
    public void del(int no){
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }

        HeroNode temp = head;
        while (true){
            if (temp.next == null || Objects.equals(temp.next.no,no)){
                break;
            }
            temp = temp.next;
        }

        if (Objects.equals(temp.next.no,no)){
            temp.next=temp.next.next;
        }else {
            System.out.println("不存在该节点，无法删除");
        }
    }

    public void printList(){
        if (head.next == null){
            System.out.println("链表为空，无法遍历");
            return;
        }

        HeroNode temp = head.next;
        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

}


class HeroNode{
    public Integer no; //编号
    public String name; //姓名
    public String nickName; //妮称
    public HeroNode next; //指向下一个节点

    public HeroNode(Integer no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName+
                '}';
    }
}