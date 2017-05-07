ArrayList是一个比数组要强大的类，在Java中推荐使用。
ArrayList是一个现成的类，有自己的插入，删除，索引等等方法可以直接调用，而且如果要打印其中的内容，不用加循环，直接System.out.println(a);
即可因为ArrayList是一个整体
除此之外，ArrayList在创建的时候推荐加上后缀，比如ArrayList<String>,着说明这个ArrayList是专门存放string的，不过不说也可以，会有警告。
当不添加后缀时，ArrayList里面可以放不同类型的成员，int，string，Boolean可以混搭。
说白了ArrayList里面存放的是对象object类型
