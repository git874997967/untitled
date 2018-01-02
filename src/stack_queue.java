
import java.util.Iterator;
import java.util.Stack;
public class stack_queue {
    /**
     * 例题 1 Design a stack with push(), pop() and max() in
     * O(1) time
     * push operation should record the max value and each push should update the max value  so that is o(1) time
     * and we need another stack to record the all max values keep them in order. duplicate is necessary. So two stacks in total
     */

    public Stack<Integer> valueStack = new Stack<>();

    public Stack<Integer> maxStack = new Stack<>();
    public Stack<String> stringStack = new Stack<>();


    public void pushString(String a) {

        stringStack.push(a);
    }

    public void pushStack(int a) {
        // update the maxStack first
        // to get the top element use peek to return the max value only instead of change the stack
        // get(int index) function will return the bottom; instead of the top element.
        valueStack.push(a);
        maxStack.push(a);
        maxStack.sort((b, c) -> b.compareTo(c));

    }

    public int popStack() {
        //get the top value and check the maxStack should update or not
        int top = valueStack.peek();
        if (top == maxStack.peek()) {
            maxStack.pop();
        }
        return valueStack.pop();
    }

    public int max() {
        return maxStack.peek();

    }

    /**
     * Given a stack structure, use it to implement a
     * queue.
     */
    public void staticToqueue() {
        while (!valueStack.empty()) {
            maxStack.push(valueStack.pop());
            System.out.println(maxStack.pop());
        }
    }

    /**
     * 例题 3 How to sort a stack in ascending order (i.e. pop
     * in ascending order) with another stack?
     */

    public void orderQueue() {
        maxStack.clear();
        valueStack.sort((b, c) -> c.compareTo(b));
        while (!valueStack.empty()) {
            maxStack.push(valueStack.pop());
            System.out.println(maxStack.pop());
        }
    }

    /**
     * 例题 4 Given a string containing just the characters '(',
     * ')', '{', '}', '[' and ']', determine if the input string is
     * a valid parentheses string. For example, “(([]))” is valid,
     * but “()” or “((” is not.
     */
    public boolean validSymbol() {
        int match = 0;
        if (stringStack.size() % 2 != 0) {
            return false;
        }
        for (int i = 0; i < stringStack.size() % 2; i++) {
            StringBuilder sb = new StringBuilder(stringStack.get(i) + stringStack.get(stringStack.size() - i - i));
            if (sb.toString().equals("()") || sb.toString().equals("{}") || sb.toString().equals("[]")) {
                match++;
            }
        }
        if (match == stringStack.size() % 2)
            return true;
        return false;
    }

    /**
     * Given a binary tree, implement the In-Order
     * Traversal using a stack.
     *
     * @param args
     */
  /*  public void inOrderTraversal(Tree root){
        if(root=null) return;
        Stack<Tree> st=new Stack<>();
        while(!st.empty()){

                st.push(root);
                root=root.left;

            else{
                root=st.pop();
                st.pop();
                root=root.right;
            }
        }
    }*/

    /**Solve  the  Hanoi  Tower
     (http://mathworld.wolfram.com/ TowerofHanoi.html) problem
     without recursion
     *
     * @param L the souce stack
     */
    public static  void HanoiWithoutRecursion(Stack<Integer> L){
        if(L.size()==0)return;
        Stack<Integer> M=new Stack<>();
        Stack<Integer>R =new Stack<>();
        M.push(100);
        R.push(100);
        char src='L',aux='M',dest='R';
     //    even number  switch the r and m
        if(L.size()%2==0){
            char tem=aux;
            aux=dest;
            dest=tem;
        }
        int totalTime=(int)Math.pow(2,L.size())-1;
      for(int i=1;i<=totalTime;i++){
          if(i%3==0){
            moveMR(M,R);
          }
          if(i%3==1){
              if(L.size()%2==0){
                  moveLR(L,R);
              }
              else{
                  moveLM(L,M);
              }
          }
          if(i%3==2){
              if(L.size()%2==0){
                  moveLM(L,M);
              }
              else{
                  moveLR(L,R);
              }
          }
      }
 ;

    }
        public  static void  moveMR(Stack<Integer> M,Stack<Integer> R){
        if(M.isEmpty()&&R.isEmpty()) return;

        if(M.isEmpty()||M.peek()>R.peek()){
            int value=R.peek();
            M.push(value);
            System.out.println("move "+ value+ " from M to R");
            R.pop();
        }
        else if(R.isEmpty()||R.peek()>M.peek()){
            int value=M.peek();
            R.push(value);
            System.out.println("move "+ value+ " from R to M");
            M.pop();
        }
        }

    public  static void  moveLM(Stack<Integer> L,Stack<Integer> M  ){
        if(L.isEmpty()&&M.isEmpty()) return;
        if(L.isEmpty()||L.peek()>M.peek()){
            int value=M.peek();
            L.push(value);
            System.out.println("move "+ value+ " from M to L");
           M.pop();
        }
        else if(M.isEmpty()||M.peek()>L.peek()){
            int value=L.peek();
           M.push(value);
            System.out.println("move "+ value+ " from L to M");
            L.pop();
        }
    }
    public  static void  moveLR(Stack<Integer> L ,Stack<Integer> R){
        if(L.isEmpty()&&R.isEmpty()) return;
        if(L.isEmpty()||L.peek()>R.peek()){
            int value=R.peek();
           L.push(value);
            System.out.println("move "+ value+ " from R to L");
            R.pop();
        }
        else if(R.isEmpty()||R.peek()>L.peek()){
            int value=L.peek();
            R.push(value);
            System.out.println("move "+ value+ " from L to R");
            L.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world");
        stack_queue sq = new stack_queue();
        sq.pushString("(");
        sq.pushString("{");
        sq.pushString("[");
        sq.pushString("]");
        sq.pushString("}");
        sq.pushString(")");
       /* System.out.println(sq.popStack());
        System.out.println(sq.max());
        System.out.println(sq.popStack());
        System.out.println(sq.popStack());*/
        // sq.staticToqueue();
    //    System.out.println(sq.validSymbol());
        Stack<Integer> src=new Stack();
        for(int i=3;i>=1;i--){
            src.push(i);
        }
        HanoiWithoutRecursion(src);
    }
}
