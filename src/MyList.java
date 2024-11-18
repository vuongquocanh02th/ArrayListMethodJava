import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public MyList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be a positive integer");
        }
        elements = new Object[capacity];
        size = 0;
    }

    //Them phan tu tai chi muc nhat dinh
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        ensureCapacity(size + 1);//Dam bao dung luong de them phan tu
        //Dich cac phan tu de chua cho cho phan tu moi
        System.arraycopy(elements, index, elements, index + 1, size - index);
        //Them phan tu vao vi tri chi muc
        elements[index] = element;
        size++;
    }

    //Xoa phan tu tai chi muc
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removedElement;
    }

    //Tra ve so luong phan tu trong danh sach
    public int size() {
        return size;
    }

    //Sao chep danh sach
    public MyList<E> clone() {
        MyList<E> clone = new MyList<>(size);
        System.arraycopy(elements, 0, clone.elements, 0, size);
        clone.size = size;
        return clone;
    }

    //Kiem tra xem phan tu co ton tai trong danh sach hay khong
    public boolean contains(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return true;
            }
        }
        return false;
    }

    //Tim kiem chi muc cua phan tu trong danh sach
    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(o)) {
                return i;
            }
        }
        return -1;//Khong tim thay phan tu
    }

    //Them phan tu vao cuoi danh sach
    public boolean add(E e) {
        ensureCapacity(size + 1); //Dam bao du dung luong
        elements[size++] = e;
        return true;
    }

    //Dam bao kich thuoc mang du lon
    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(elements.length * 2, minCapacity);
            elements = Arrays.copyOf(elements, newCapacity);
        }
    }

    //Lay phan tu tai chi muc
    public E get(int i) {
        if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (E) elements[i];
    }

    //Xoa tat ca cac phan tu
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

}
