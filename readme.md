# 题目

## 简单

[7-1 用栈实现队列](./src/easy/t7_1/Main.java)

[7-2 合作圈](./src/easy/t7_2/Main.java)

[7-3 大山的数目](./src/easy/t7_3/Main.java)

[7-4 跳跃](./src/easy/t7_4/Main.java)

[7-5 检测回文字符串](./src/easy/t7_5/Main.java)

[7-6 同构字符串](./src/easy/t7_6/Main.java)

[7-7 数字拆分求和](./src/easy/t7_7/Main.java)

[7-8 最长的美好字符子串](./src/easy/t7_8/Main.java)

[7-9 最小硬币个数](./src/easy/t7_9/Main.java)

[7-10 判断二叉树是不是搜索树](./src/easy/t7_10/Main.java)

[7-11 买票需要的时间](./src/easy/t7_11/Main.java)

[7-12 无法吃午餐的学生数量](./src/easy/t7_12/Main.java)

[7-13 求最后一块石头的重量](./src/easy/t7_13/Main.java)

[7-14 最小栈](./src/easy/t7_14/Main.java)

[7-15 字符串编辑距离](./src/easy/t7_15/Main.java)

[7-16 给定数字组成最大时间](./src/easy/t7_16/Main.java)

[7-17 交换和](./src/easy/t7_17/Main.java)

[7-18 最长回文子串](./src/easy/t7_18/Main.java)

## 中等

[7-1 连续的子数组和](./src/middle/t7_1/Main.java)

[7-2 或运算的最小翻转次数](./src/middle/t7_2/Main.java)

[7-3 删除无效的括号](./src/middle/t7_3/Main.java)

[7-4 钥匙和房间](./src/middle/t7_4/Main.java)

[7-5 三数之和](./src/middle/t7_5/Main.java)

[7-6 最小数](./src/middle/t7_6/Main.java)

[7-7 连通网络的操作次数](./src/middle/t7_7/Main.java)

[7-8 分段反转链表](./src/middle/t7_8/Main.java)

## 困难

[7-1 按格式合并两个链表](./src/hard/t7_1/Main.java)

[7-2 按公因数计算最大组件大小](./src/hard/t7_2/Main.java)

[7-3 拼接最大数](./src/hard/t7_3/Main.java)

[7-4 最长递增子序列](./src/hard/t7_4/Main.java)

[7-5 二叉树的最大路径和](./src/hard/t7_5/Main.java)

[7-6 计算岛屿最大面积](./src/hard/t7_6/Main.java)

[7-7 不相交的线](./src/hard/t7_7/Main.java)

[7-8 解码异或后的排列](./src/hard/t7_8/Main.java)

[7-9 最长超赞子字符串](./src/hard/t7_9/Main.java)

[7-10 统计美丽子字符串 II](./src/hard/t7_10/Main.java)

[7-11 判断二分图](./src/hard/t7_11/Main.java)

[7-12 超级回文数](./src/hard/t7_12/Main.java)

[7-13 最多能完成排序的块](./src/hard/t7_13/Main.java)

[7-14 异次元星人的文字](./src/hard/t7_14/Main.java)

# java编程题常用方法

## Arrays

1. `Arrays.asList(T… data)`

   注意：该方法返回的是 Arrays 内部静态类 ArrayList，而不是我们平常使用的 ArrayList,，该静态类 ArrayList 没有覆盖父类的 add(), remove() 等方法，所以如果直接调用，会报
   UnsupportedOperationException 异常


2. `Arrays.fill(Object[] array, Object obj)` 、 `Arrays.fill(Object[] array, int fromIndex, int toIndex, Object obj)`

   用指定元素填充整个数组 (会替换掉数组中原来的元素)


3. `Arrays.sort(Object[] array)` 、 `Arrays.sort(T[] array, Comparator<? super T> comparator)`
   、 `Arrays.sort(Object[] array, int fromIndex, int toIndex)`
   、 `Arrays.sort(T[] array, int fromIndex, int toIndex, Comparator<? super T> c)`

   排序


4. `Arrays.parallelSort(T[] array)`

   并行排序，有较好的性能


5. `Arrays.binarySearch(Object[] array, Object key)`
   、 `Arrays.binarySearch(Object[] array, int fromIndex, int toIndex, Object obj)`

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

https://juejin.cn/post/6844903497666674702

1. 流初始化

```java
Stream stream = Stream.of(array);
//或者
Stream stream = Arrays.stream(array);

// 集合转化为流
Stream stream = collcetions.stream();
```

2. 操作流

```java
stream.map(it -> {}) //遍历
    .mapToInt(Interger::valueOf) // 转为int
    .filter(it ->{}) //过滤
    .forEach(it ->{}) // 循环
    .skip(2) // 跳过前两个
    .limit(3) // 只要前3个
    .sorted((a, b) -> { a- b;}) //  排序
    .max().getAsInt() // 获取最大元素
    .sum().getAsInt() // 求和
    .reduce(0, (a, b)->{return a+b}).getAsInt() // 聚集     
    .distinct() // 去重
    .allMatch(s -> {}) // 是否全部匹配，返回boolean
    .anyMatch(s -> {}) // 是否有匹配
    .noneMath(s -> {}) // 是否没有匹配
    .toArray() // 转为array    
    .collect(Collectors.toList()) // 返回集合
```

3. collect 操作

```java
//1. supplier结果存放容器, accumulator如何添加到容器, combiner多个容器的聚合策略
<R> R collect(Supplier<R> supplier,
                  BiConsumer<R, ? super T> accumulator,
                  BiConsumer<R, R> combiner);
//2.
<R, A> R collect(Collector<? super T, A, R> collector);
```

第一种使用举例：

```java
String str = Stream.of("a", "b", "c")
        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
        .toString();

// 收集并转换格式
ArrayList<Integer> arr = Stream.of("1", "2", "2").collect(ArrayList::new,
    (a, x) -> {
        a.add(Integer.valueOf(x));
    },
    (a1, a2) -> {
        a1.addAll(a2);
    }
);

```


collector 常用方法：

```java
Collectors.toList()
Collectors.toSet()
Collectors.joining(CharSequence delimiter,CharSequence prefix,CharSequence suffix)

// 收集到指定集合中
Collectors.toCollection(ArrayList::new)
Collectors.toCollection(HashSet::new)


// groupBy
Collectors.groupBy(Person::getType, HashMap:new, Collector.toList());
Collectors.groupBy(Person::getType, HashMap:new, Collector.mapping(Person::name, Collectors.toSet()));

```

3. toArray操作

```java
//1.使用无参,收集到数组,返回值为 Object[](Object类型将不好操作)
Object[] toArray();
//2.使用有参,可以指定将数据收集到指定类型数组,方便后续对数组的操作
<A> A[] toArray(IntFunction<A[]> generator);
```

```java
stream.toArray() // 返回Object[]
stream.toArray(String[]::new) 返回String[]
```





## String

1. substring(start, end) 提取子串


2. charAt(ind) 去读字符


3. compareTo(String anotherString) 、 compareToIgnore(String anotherString) 、
   equals(Object anotherObject)、 equalsIgnoreCase(String anotherString)
   比较大小
   

4. indexOf(int ch/String str)、 indexOf(int ch/String str, int fromIndex)
   lastIndexOf(int ch/String str)、 lastIndexOf(int ch/String str, int fromIndex)
   查找
   

5. toLowerCase() 、 toUpperCase() 转大小写


6.  replace(char oldChar, char newChar)、 replaceFirst(String regex, String replacement) 、
    replaceAll(String regex, String replacement)
    字符串替换
    
7. trim()、 split(String str)

## 进制转换

Long.toString(long l, int p)//p作为任意进制

```java
Long.toString(100L, 16) // 转为16进制字符串
```

## Deque

// 栈、队列都用它来表示
Deque<Integer> deq = new LinkedList<>();

| |抛出异常|特殊值|抛出异常|特殊值|
|---|---|---|---|---|
|插入|    addFirst(e)|offerFirst(e)|    addLast(e)|	offerLast(e)|
|删除|    removeFirst()|    pollFirst()|    removeLast()|	pollLast()|
|获取|    getFirst()|    peekFirst()|    getLast()|	peekLast()|

## 优先级队列

```java

// 大根堆
PriorityQueue<Integer> que = new PriorityQueue<Integer>(Comparator.reverseOrder());

// 大根堆
PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
    return b - a;
});

// 小根堆
PriorityQueue<Integer> que = new PriorityQueue<Integer>();
// 小根堆        
PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> {
    return a - b;
});

```

| |抛异常| 特殊值|
|---|---|---|
|插入|add(e) |offer(e)|
|删除|remove() | poll()|
|获取|element()| peek()|

1. public int size(); //获取队列中元素个数

2. public void clear(); //清空队列

3. public boolean contains(Object o); //判断队列中是否包含指定元素（从队头到队尾遍历）

4. public Iterator<E> iterator(); //迭代器
