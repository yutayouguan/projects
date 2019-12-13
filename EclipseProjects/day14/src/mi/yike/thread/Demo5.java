package mi.yike.thread;

/**
 * @author wangmeng
 *集合cellection中常用的方法：
 
 集合：集合是存储对象数据的集合容器。
 
集合比数组的优势：
	1. 集合可以存储任意类型的对象数据，数组只能存储同一种数据类型 的数据。
	2. 集合的长度是会发生变化的，数组的长度是固定的。
	
 
-------| Collection  单例集合的跟接口。 
 ----------| List  如果是实现了List接口的集合类，具备的特点： 有序，可重复。
 ----------| Set   如果是实现了Set接口的集合类，具备特点： 无序，不可重复。

Collection接口中的方法：
	
	增加
		add(E e)  添加成功返回true，添加 失败返回false.
		addAll(Collection c)  把一个集合 的元素添加到另外一个集合中去。
	
	删除
		clear() 
		remove(Object o) 
		
		removeAll(Collection  c) 
		retainAll(Collection  c) 
	
	查看
		size() 

	
	判断
		isEmpty() 
		contains(Object o) 
		containsAll(Collection<?> c) 
	
	迭代
		toArray() 
		iterator() 


 */
public class Demo5 {
public static void main(String[] args) {
	
}
}
