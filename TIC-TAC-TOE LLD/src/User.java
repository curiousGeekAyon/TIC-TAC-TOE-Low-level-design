public class User {
    String name;
    Piece piece;
    public User()
    {

    }
    public User(String name,Piece piece)
        {
            this.name=name;
            this.piece=piece;
        }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }
}
