# 题目

## 简单

## 中等

## 困难

[7-1 按格式合并两个链表](./src/hard/t7_1/Main.java)

7-2
按公因数计算最大组件大小
7-3
拼接最大数
7-4
最长递增子序列
7-5
二叉树的最大路径和
7-6
计算岛屿最大面积
7-7
不相交的线
7-8
解码异或后的排列
7-9
最长超赞子字符串
7-10
统计美丽子字符串 II
7-11
判断二分图
7-12
超级回文数
7-13
最多能完成排序的块
7-14
异次元星人的文字





# java编程题常用方法

## Arrays

1. `Arrays.asList(T… data)`
   
   注意：该方法返回的是 Arrays 内部静态类 ArrayList，而不是我们平常使用的 ArrayList,，该静态类 ArrayList 没有覆盖父类的 add(), remove() 等方法，所以如果直接调用，会报 UnsupportedOperationException 异常
   

2. `Arrays.fill(Object[] array, Object obj)` 、 `Arrays.fill(Object[] array, int fromIndex, int toIndex, Object obj)`

   用指定元素填充整个数组 (会替换掉数组中原来的元素)


3. `Arrays.sort(Object[] array)` 、 `Arrays.sort(T[] array, Comparator<? super T> comparator)` 、 `Arrays.sort(Object[] array, int fromIndex, int toIndex)` 、 `Arrays.sort(T[] array, int fromIndex, int toIndex, Comparator<? super T> c)`
    
    排序

   
4. `Arrays.parallelSort(T[] array)`

    并行排序，有较好的性能
   

5. `Arrays.binarySearch(Object[] array, Object key)` 、 `Arrays.binarySearch(Object[] array, int fromIndex, int toIndex, Object obj)`

   注意：在调用该方法之前，必须先调用 Arrays.sort() 方法进行排序，如果数组没有排序，那么结果是不确定的，此外如果数组中包含多个指定元素，则无法保证将找到哪个元素


6. `Arrays.copyOf(T[] original, int newLength)` 、 `Arrays.copyOfRange(T[] original, int from, int to)`

    复制固定长度
   

7. `Arrays.equals(Object[] array1, Object[] array2)` 、 `Arrays.deepEquals(Object[] array1, Object[] array2)`

    数组是否相等 、 多维数组是否相等
   

8. `Arrays.hashCode(Object[] array)` 、 `Arrays.deepHashCode(Object[] array)`
    
    返回数组的hash值 、 返回多维数组的hash值
   
9. `Arrays.toString(Object[] array)` 、 `Arrays.deepToString(Object[] array)`

    数组转字符串、多维数据转字符串


10. `Arrays.stream(T[] array)`

    创建流


## Collections

1. `sort(Collection)`


2. `revrese(Collection)`


3. `shuffle(Collection)`

    集合随机排序


4. `fill(List list, Object o)`

    替换集合中所有元素


5. `copy(List m , List n)`

    n 复制到 m中


6. `min(Collection)`、`min(Collection, Comparator)` 、 `max(Collection)` 、`max(Collection, Comparator)`
    
    去集合中的最大值、最小值


7. `indexOfSubList(List list, List subList)` 、 `lastIndexOfSubList(List source,List target)`

    查找subList在list中首次/末次出现的位置


8. `rotate(List list,int m)`

    循环移动， 负数向左移动，正数向右移动


9. `swap(List list,int i,int j)`

   交换集合中指定元素索引的位置


10. `binarySearch(Collection,Object)`


11. `replaceAll(List list,Object old,Object new)`


12. `frequency(Collection coll, Object o)`
    
    集合中指定元素出现次数


## Stream


## String

## Deque


抛出异常	特殊值	抛出异常	特殊值
插入	addFirst(e)	offerFirst(e)	addLast(e)	offerLast(e)
删除	removeFirst()	pollFirst()	removeLast()	pollLast()
检查	getFirst()	peekFirst()	getLast()	peekLast()


PriorityQueue<Integer> que = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
priorityQueue<Integer> que = new PriorityQueue<Integer>(Comparator.reverseOrder());

Arrays.copyOfRange