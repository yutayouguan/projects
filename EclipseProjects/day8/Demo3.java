//球员
class Player{
int num;
String name;
public Player(int num,String name){
this.name = name;
this.num = num;
}
public void run(){
System.out.println("球员跑起来了！");

}
}
//球队
class Team{
String name;

Player p1;
Player p2;
Player p3;

public  Team(String name,Player p1,Player p2,Player p3){
this.name =name;
this.p1=p1;
this.p2=p2;
this.p3=p3;
}
public void play(){
System.out.println(name+"开始比赛！！！");

}

}
class Demo3{
public static void main(String[] args){
Player p1 = new Player(12,"梅西");
Player p2= new Player(7,"C罗");
Player p3= new Player(11,"内马尔");
Team t = new Team("恒大",p1,p2,p3);
t.play();
System.out.println("名字:"+t.p1.name);
}


}
