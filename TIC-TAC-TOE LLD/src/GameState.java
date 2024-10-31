public abstract class GameState {
    GameService gameService;

    public abstract void nextMove(int x,int y);
    public abstract void createUser(String name,char symbol);
//    public abstract void changeUserName(User user,String name);
//    public abstract void changeUserPiece(String name,char symbol);
      public abstract void start();
}
