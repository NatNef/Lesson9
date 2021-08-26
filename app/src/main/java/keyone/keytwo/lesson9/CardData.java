package keyone.keytwo.lesson9;

// бизнес логика, модель

public class CardData {

    private final String title;
    private final String description;
    private final int picture;
    private final boolean Like;

    public CardData(String title, String description, int picture, boolean like) {
        this.title = title;
        this.description = description;
        this.picture = picture;
        this.Like = like;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPicture() {
        return picture;
    }

    public boolean isLike() {
        return Like;
    }
}
