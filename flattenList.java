/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

public class NestedIterator implements Iterator<Integer> {
  // tc:O(1) sc:O(1) 
    List<NestedInteger> nestedList;
    NestedInteger nextElement;
    Stack<Iterator<NestedInteger>> s;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList=nestedList;
        s=new Stack<>();
    s.push(nestedList.iterator());
    
       
    }

    @Override
    public Integer next() {
        return nextElement.getInteger();
    }

    @Override
    // this returns true if stack top has something
    public boolean hasNext() {
        while(!s.isEmpty()){
            if(!s.peek().hasNext()){
                s.pop();
                
            }//storing next element so that we dont skip the previous
            else if((nextElement=s.peek().next()).isInteger()){
               return true;
                
            }
            else{
                s.push(nextElement.getList().iterator());
                
            }
        }
        return false;
        
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
