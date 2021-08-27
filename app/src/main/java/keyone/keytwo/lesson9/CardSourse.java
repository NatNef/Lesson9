package keyone.keytwo.lesson9;

//источник данных
public interface CardSourse {

    int size(); //возвращает свой размер
    //метод возврата данных карточки по позиции
    CardData getCardData(int position);


    //9 что-бы работало наше меню
    //обновили поведение интерфейса
    void deleteCardData(int position); //удаляет карточку
    void updateCardData(int position,CardData newCardData); //обновляет карточку,
    void addCardData(CardData newCardData); //создать новую
    void clearCardData(); //удалить все карточки


}
