package ml.yike.collelction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

/*作业2：使用集合实现注册登陆功能，

第一步： 提示用户选择功能， A（注册）  B(登陆) 。 要求： 功能选择 的时候要忽略大小写。


注册：
	1. 提示用户输入注册的账号(数字)与密码，如果输入的id号已经存在集合中，提示用户重新输入。 注册完毕之后，把集合中的所有用户信息打印出来。(使用：toArrry()方法)	

登陆： 
	提示用户输入登陆的账号与密码,如果账号与密码这个用户已经存在集合中，那么登陆成功，否则登陆失败。*/


public class Demo2 {
	//都要用到，共享使用
	static Collection<User> users = new ArrayList<User>(); // 使用该集合保存用户信息

	static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("😀😬😁😂😃😄😅😆😇😉😊😛😡");
			System.out.println("😎请选择功能:A：注册  B：登录 😎");
			System.out.println("☺️😋😌😍😘😗😙😚😜😝😛😠😡");
			String opation = input.next();

			if ("a".equalsIgnoreCase(opation)) {// 注册功能
				reg();

			} else if ("b".equalsIgnoreCase(opation)) { // 登录功能
				login();

			} else {
				System.out.println("输入错误，请重新输入：");
			}

		}

	}

	public static void login() {
		System.out.println("请输入账号：");
		int id = input.nextInt();
		System.out.println("请输入密码：");
		String password = input.next();
//				判断集合中是否存在用户与密码
		boolean isLogin = false;// 默认没有登录成功
		Iterator<User> iterator = users.iterator();

		while (iterator.hasNext()) {
			User user = (User) iterator.next();
			if (user.id == id && user.password.equals(password)) {

				isLogin = true;
			}

		}
		if (isLogin) {
			System.out.println("登录成功！！");
		} else {
			System.out.println("用户名或者密码错误！！");
		}
	}

	public static void reg() {
		User user = null;
		while (true) {
			System.out.println("请输入账号：");
			int id = input.nextInt();
			user = new User(id, null);
			if (users.contains(user)) { // contains 方法底层依赖了equal方法
				System.out.println("该用户已经存在，请重新输入：");
			} else {
				// 如果不存在
				break;
			}

		}

		System.out.println("请输入密码：");
		String password = input.next();
		user.setPassword(password);
		// 把user对象保存在集合中
		users.add(user);
		System.out.println("注册成功！！");
		System.out.println("当前注册的人员：" + users);
	}

}


class User {
	int id; // 账号
	String password; // 密码

	public User(int id, String password) {
		this.id = id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		return this.id == user.id;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{" + "账号" + this.id + "密码：" + this.password + "}";
	}
}
