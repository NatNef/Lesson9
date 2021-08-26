package keyone.keytwo.lesson9;

//реализация интерфейса

import android.content.res.Resources;
import android.content.res.TypedArray;

import java.util.ArrayList;
import java.util.List;

public class CardSourceImpl implements CardSourse {

    private List<CardData> dataSource;

    private Resources resources;


    @Override
    public int size() {
        return 0;
    }

    @Override
    public CardData getCardData(int position) {
        return dataSource.get(position);
    }

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
