import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> list = new MyList<>(5);
        //Them phan tu vao danh sach
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        //In ra so luong phan tu
        System.out.println("Size of list: " + list.size()); //5
        //Kiem tra phan tu tai chi muc 2
        System.out.println("Element at index 2: " + list.get(2)); //30
        //Kiem tra danh sach co chua phan tu 30 khong
        System.out.println("Contain 30: " + list.contains(30)); //true
        System.out.println("Contains 100: " + list.contains(100)); //false
        //Tim chi muc cua phan tu 40
        System.out.println("Index of 40: " + list.indexOf(40)); //3
        //Them phan tu tai chi muc 2
        list.add(2, 35);
        System.out.println("Element at index 2 after add: " + list.get(2)); //35
        //Xoa phan tu tai chi muc 1
        System.out.println("Removed element: " + list.remove(1)); //20
        System.out.println("Size of list after removing: " + list.size()); //5
        //Sao chep danh sach
        MyList<Integer> clonedList = list.clone();
        System.out.println("Cloned list size: " + clonedList.size()); //5
        //Xoa tat ca cac phan tu
        list.clear();
        System.out.println("Size of list after clearing: " + list.size()); //0
    }
}