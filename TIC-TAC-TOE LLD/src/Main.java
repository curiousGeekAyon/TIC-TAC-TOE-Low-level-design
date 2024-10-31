//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GameService game=new GameService(3);
        game.createUser("Atul",'X');
        game.createUser("Ayon",'O');
        game.start();
        game.nextMove(2,2);
        game.nextMove(1,3);
        game.nextMove(1,1);
        game.nextMove(1,2);
        game.nextMove(2,2);
        game.nextMove(3,3);
        game.nextMove(3,2);
        game.nextMove(3,1);
        game.nextMove(1,3);


    }
}