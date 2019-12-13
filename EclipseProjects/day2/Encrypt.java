import java.io.*;
import java.util.*;
public class Encrypt{
public static void main(String[] args) throws Exception{
//读取图片

System.out.println("请输入图片的完整路径：");
Scanner input = new Scanner(System.in);
String path = input.nextLine();
File inFile = new File(path);
//
System.out.println("加密后的图片在桌面");
File outFile = new File("/Users/wangmeng/Desktop/加密的图片.jpg");
//建立数据通道，让（文件）图片二进制数流入
FileInputStream inPut = new FileInputStream(inFile);
FileOutputStream outPut = new FileOutputStream(outFile);
//边读边把读到的数据异或一个数据，把数据写出
int content = 0; //声明一个数据用于存储读取的数据
while((content = inPut.read())!=-1){//如果没有读到文件尾；继续读取数据；
outPut.write(content^12);
}
//关闭资源
outPut.close();
inPut.close();


}

}
