/**
 * Created by 15313 on 2020/6/16.
 */
public class SimpleList<T> {
    //尾结点
    private Node<T> tail;
    //头结点
    private Node<T> head;
    public SimpleList(){
        head = tail = null;
    }
    //静态内部节点类
    public static class Node<T>{
        T data;
        Node<T> next;
        //当为中间节点的时候用此构造方法
        Node(T data,Node<T> next){
            this.data=data;
            this.next=next;
        }
        //当为头结点或尾节点的时候 使用此构造方法
        Node(T data){
            this.data=data;
            this.next=null;
        }
    }
    public T get(T point){
        return null;
    }
    public boolean insert(T point){
        Node<T> preNext=head.next;
        Node<T> newNode=new Node(point,preNext);
        if(head.next!=null){
            preNext=head.next;
            head.next=newNode;
            newNode.next=preNext;
        }
        return true;
    }
    //删除某一节点
    public void earse(T data){
        Node<T> curr=head,prev=null;
        boolean b=false;
        while(curr!=null){
            if(curr.data.equals(data)){
                //判断是什么节点
                if(curr==head){
                    //如果删除的是头节点
                    System.out.println('\n'+"delete head node");
                    head=curr.next;
                    b=true;
                    return;
                }
                if(curr==tail){
                    //如果删除的是尾节点
                    System.out.println('\n'+"delete tail node");
                    tail=prev;
                    prev.next=null;

                    b=true;
                    return;
                }
                else{
                    //  如果删除的是中间节点（即非头节点或非尾节点）
                    System.out.println('\n'+"delete center node");
                    prev.next=curr.next;
                    b=true;
                    return;
                }
            }
            prev=curr;
            curr=curr.next;
        }
        if(b==false){
            System.out.println('\n'+"没有这个数据");
        }
    }

}
