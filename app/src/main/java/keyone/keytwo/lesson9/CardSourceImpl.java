package keyone.keytwo.lesson9;

//реализация интерфейса

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class CardSourceImpl implements CardSourse {

    private List<CardData> dataSource;

    private Resources resources;


    // добавили по 9му карточки
    //обновили имплементацию. реализацию CardSourse
    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }

    public int size() {
        return dataSource.size();
    }

    @Override
    public void deleteCardData(int position) {
        dataSource.remove(position);
    }

    @Override
    public void updateCardData(int position, CardData newCardData) {
        dataSource.set(position,newCardData);
    }

    @Override
    public void addCardData(CardData newCardData) {
        dataSource.add(newCardData);
    }

    @Override
    public void clearCardData() {
        dataSource.clear();
    }



    //8
    //инициализируем объект из ресурсов
    public CardSourceImpl(Resources resources) {
        dataSource = new ArrayList<>();
        this.resources = resources;
    }

    public CardSourceImpl init(){
        String[] titles = resources.getStringArray(R.array.title);
        String[] descriptions = resources.getStringArray(R.array.descriptions);
        TypedArray typedArray = resources.obtainTypedArray(R.array.pictures);
        int[] pictures = new int [typedArray.length()];
        for (int i=0;i<typedArray.length();i++) {
            pictures[i] = typedArray.getResourceId(i, -1 );
        }
        for (int i=0;i<titles.length;i++){
            dataSource.add(new CardData(titles[i], descriptions[i], pictures[i], false));

        }
        return this;

    }
}
