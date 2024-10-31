import java.util.Arrays;

public class Grid {
    int size;
    private char [][]arr;
    public Grid(int size)
    {
        this.size=size;
        this.arr=new char[size][size];
        for(char []arr1:arr)
        {
            Arrays.fill(arr1,'_');
        }
    }

    public int getSize() {
        return size;
    }

    public char[][] getArr() {
        return arr;
    }
}
