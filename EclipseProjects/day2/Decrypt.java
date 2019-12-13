import java.util.*;
import java.io.*;
public class Decrypt{
public static void main(String[] args) throws Exception{
System.out.println("请输入图片的完整路径：");
Scanner input = new Scanner(System.in);
String path = input.nextLine();
//获取图片路径
File inFile = new File(path);
System.out.println("解密后的图片在桌面");
File outFile = new File("/Users/wangmeng/Desktop/解密的图片.jpg");

//建立数据通道，让图片的二进制数据流流入、流出
FileInputStream inPut = new FileInputStream(inFile);
FileOutputStream outPut = new FileOutputStream(outFile);
//边读，边解密（异或一个加密时相同的数）
int content = 0;

while((content = inPut.read())!=-1){//没有读取到文件尾，继续读取
outPut.write(content^12);
}
//关闭资源
outPut.close();
inPut.close();
}}
