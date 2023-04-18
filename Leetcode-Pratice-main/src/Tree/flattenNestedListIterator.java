package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;


// This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
interface NestedInteger {
  // @return true if this NestedInteger holds a single integer,
  // rather than a nested list.
      public boolean isInteger();

      // @return the single integer that this NestedInteger holds,
      // if it holds a single integer
      // Return null if this NestedInteger holds a nested list
      public Integer getInteger();

      // @return the nested list that this NestedInteger holds,
      // if it holds a nested list
      // Return null if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
  }
public class flattenNestedListIterator implements Iterator<Integer> {
    private Deque<NestedInteger> stack;
    public flattenNestedListIterator(List<NestedInteger> nestedList){
        stack=new ArrayDeque<>();
        for(int i=nestedList.size()-1;i>=0;i--){
            stack.push(nestedList.get(i));
        }
        flat();
    }
    private void flat(){
        while(!stack.isEmpty()&& !stack.peek().isInteger()){
            List<NestedInteger> list=stack.pop().getList();
            for (int i=list.size()-1;i>=0;i--){
                stack.push(list.get(i));
            }
        }
    }
    @Override
    public Integer next(){
        Integer value=stack.pop().getInteger();
        flat();
        return value;
    }
    @Override
    public boolean hasNext(){
        return !stack.isEmpty();
    }
    @Override
    public void remove(){}
}
