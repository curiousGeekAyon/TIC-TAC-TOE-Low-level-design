import java.util.ArrayList;
import java.util.List;

public class GameService {
    int currentPlayer;
    List<User> userList;
    Grid grid;
    IdleState idleState;
    PlayState playState;
    GameState currentState;
    int totalMoves;

    public GameService(int size)
        {
            grid=new Grid(size);
            userList=new ArrayList<>();
            idleState=new IdleState(this);
            playState=new PlayState(this);
            currentState=idleState;
            System.out.println("Add users to start");
        }

    public IdleState getIdleState() {
        return idleState;
    }

    public PlayState getPlayState() {
        return playState;
    }

    public void nextMove(int x, int y) {
            currentState.nextMove(x,y);
    }
    public void createUser(String name, char symbol) {
            currentState.createUser(name, symbol);
    }
//    public void changeUserName(User user, String name) {
//            currentState.changeUserName(user, name);
//    }
//    public void changeUserPiece(String name, char symbol) {
//
//    }
//
    public void changePlayer()
        {
            currentPlayer++;
            int size=userList.size();
            currentPlayer=currentPlayer%size;
        }
    public boolean isValidMove(int x, int y) {
        int size=grid.getSize();
        char [][]arr=grid.getArr();
        if(x<0||y<0||x>=size||y>=size||arr[x][y]!='_')
            {
                return false;
            }
        return true;
    }
    public boolean checkifGameEnded(int x,int y)
    {
        char [][]arr=grid.getArr();
        char ch=arr[x-1][y-1];
        int row=x-1;
        int col=y-1;
        int size=arr.length;
        //look for left right
        boolean flag=false;
        for(int i=0;i<size;i++)
        {
            if(arr[row][i]!=ch)
                {
                    flag=true;
                    break;
                }
        }
        if(!flag)
        {
            return true;
        }
        flag=false;
        //look for up and down
        for(int i=0;i<size;i++)
        {
            if(arr[i][col]!=ch)
            {
                flag=true;
                break;
            }
        }
        if(!flag)
        {
            return true;
        }
        flag=false;
        //look for first diagonal
        int count=0;
        for(int i=row,j=col;i>=0&&j>=0;i--,j--)
        {
            if(arr[i][j]!=ch)
              {
                  flag=true;
                  break;
              }
            count++;
        }
        if(flag)
        {
            return false;
        }

        for(int i=row,j=col;i<size&&j<size;i++,j++)
        {
            if(arr[i][j]!=ch)
            {
                flag=true;
                break;
            }
            count++;
        }
        if(!flag&&count==size+1)
        {
            return true;
        }
        flag=false;

        //look for second diagonal
       count=0;

        for(int i=row,j=col;i>=0&&j<size;i--,j++)
            {
                if(arr[i][j]!=ch)
                    {
                        flag=true;
                        break;
                    }
                count++;
            }
        if(flag)
        {
            return false;
        }

        for(int i=row,j=col;i<size&&j>0;i++,j--)
        {
            if(arr[i][j]!=ch)
                {
                    flag=true;
                    break;
                }
            count++;
        }
        if(!flag&&count==size+1)
        {
            return true;
        }
        return false;
    }

    public void setIndexValue(int x, int y, char shape) {
        char [][]arr=grid.getArr();
        arr[x-1][y-1]=shape;
        int size=arr.length;
        for (char[] chars : arr) {
            for (int j = 0; j < size; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println();
        }
        System.out.println("/////////////////////////////////");
    }

    public void reset() {
        userList=new ArrayList<>();
        grid=new Grid(grid.getSize());
        totalMoves=0;
        currentState=getIdleState();
        System.out.println("Add user to start");
    }
    public void start()
    {
        currentState.start();
    }

    public boolean checkifNoMoreMoveLeft() {
        totalMoves++;
        int size= grid.getSize();
        if(totalMoves<size*size)
        {
            return true;
        }
        return false;
    }
    public void exit()
    {
        reset();
        System.out.println("exiting from current game");
    }
}
