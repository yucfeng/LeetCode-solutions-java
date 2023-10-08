import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.cn/problems/flatten-nested-list-iterator/
public class NestedIterator implements Iterator<Integer> {

    //    List<NestedInteger> nestedList;
    List<Integer> integerList = new LinkedList<>();
    int size;
    int cursor;

    public NestedIterator(List<NestedInteger> nestedList) {
//        this.nestedList = nestedList;
        add(nestedList);
        size = nestedList.size();
        System.out.println(size);
    }

    void add(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                integerList.add(nestedInteger.getInteger());
                System.out.println(nestedInteger.getInteger());
            } else {
                add(nestedInteger.getList());
            }
        }
    }

    @Override
    public Integer next() {
        int i = cursor;
        cursor = i + 1;
        return integerList.get(i);
    }

    @Override
    public boolean hasNext() {
        return cursor != size;
    }

    // 存储列表的当前遍历位置
    private Deque<Iterator<NestedInteger>> stack;
/*
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new LinkedList<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
        // 由于保证调用 next 之前会调用 hasNext，直接返回栈顶列表的当前元素
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            Iterator<NestedInteger> it = stack.peek();
            if (!it.hasNext()) { // 遍历到当前列表末尾，出栈
                stack.pop();
                continue;
            }
            // 若取出的元素是整数，则通过创建一个额外的列表将其重新放入栈中
            NestedInteger nest = it.next();
            if (nest.isInteger()) {
                List<NestedInteger> list = new ArrayList<NestedInteger>();
                list.add(nest);
                stack.push(list.iterator());
                return true;
            }
            stack.push(nest.getList().iterator());
        }
        return false;
    }*/
}
