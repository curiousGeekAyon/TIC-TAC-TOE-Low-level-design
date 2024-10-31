public class PlayState extends GameState{
    GameService gameService;
    public PlayState(GameService gameService) {
        this.gameService=gameService;
    }

    @Override
    public void nextMove(int x, int y) {
        boolean isValid=gameService.isValidMove(x-1,y-1);
        if(isValid) {
            gameService.setIndexValue(x,y,gameService.userList.get(gameService.currentPlayer).getPiece().getShape());
            boolean gameEnded=gameService.checkifGameEnded(x,y);
            if(!gameEnded) {
                boolean moveLeft=gameService.checkifNoMoreMoveLeft();
                if(!moveLeft)
                {
                    System.out.println("Game is over,no one won");
                    gameService.reset();
                    return;
                }
                gameService.changePlayer();
            }
            else{
                System.out.println(gameService.userList.get(gameService.currentPlayer).name+" has won the match");
                gameService.reset();
            }
        }
        else{
            System.out.println(gameService.userList.get(gameService.currentPlayer).getName()+" your current movie is not a valid move");
        }
    }

    @Override
    public void createUser(String name, char symbol) {
            System.out.println("In the middle of the game users cannot be created");
    }

    @Override
    public void start() {
        System.out.println("Game is already been started ,if u want restrart it or else complete the game");
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
