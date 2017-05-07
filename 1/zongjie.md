char与string的区别

1. 类型不同，char是字符类型， String是字符串类型

2、String字符串是用""来包含串的， char是用''来包含单字符的
   char a='1';//定义一个字符
   String b="dadsa";//定义一个字符串

3、String内部用来存储的结果是一个char字符数组。
    private final char value[];//这是string中用来存储值的结构。
    所以对于string与char的互相转换：
    
    ///////////char转string，用的是valueof/////////
    char c[] = { 'a', 'b' };
    String s = String.valueOf(c);
    
    ////////////string转char，用的是string的自带方法charat///////////
    String str = "qwe";
    for (int i = 0; i < str.length(); i++) {
    char c = str.charAt(i);
