package keyone.keytwo.lesson9;

//источник данных
public interface CardSourse {

    int size();

    //метод возврата данных карточки по значиени
    CardData getCardData(int position);
}
