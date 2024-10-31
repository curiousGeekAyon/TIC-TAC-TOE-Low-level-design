public class IdleState extends GameState{

    GameService gameService;

    public IdleState(GameService gameService) {
        this.gameService=gameService;
    }

    public void nextMove(int x, int y) {
        System.out.println("Create users first");
    }

    @Override
    public void createUser(String name, char symbol) {
            Piece piece=new Piece(symbol);
            User user=new User(name,piece);
            gameService.userList.add(user);
    }
    public void start()
    {
        if(gameService.userList.size()<2)
        {
            System.out.println("To Start the game minimum 2 players needed ");
        }
        else{
            System.out.println("Let's goooooooooooooooo!!");
            char [][]arr=gameService.grid.getArr();
            int size=arr.length;
            for (char[] chars : arr) {
                for (int j = 0; j < size; j++) {
                    System.out.print(chars[j] + " ");
                }
                System.out.println();
            }
            System.out.println("////////////////////////////////////");
            gameService.currentState= gameService.getPlayState();
        }
    }

//    @Override
//    public void changeUserName(User user, String name) {
//
//    }
//
//    @Override
//    public void changeUserPiece(String name, char symbol) {
//
//    }

}
