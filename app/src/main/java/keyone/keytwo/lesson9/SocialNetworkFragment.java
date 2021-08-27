package keyone.keytwo.lesson9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

// SocialNetworkFragment должен уметь обрабатывать поведение для MyOnClickListener
public class SocialNetworkFragment extends Fragment implements MyOnClickListener {

    //9 выносим источник данных, адаптер
    private CardSourse data;
    private SocialNetworkAdapter adapter;
    private RecyclerView recyclerView;



    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();

    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //9 указываем явно, что наш фрагмент имеет оптионменю
        //наш фрагмент имеет явное меню
        setHasOptionsMenu(true);



        View view = inflater.inflate(R.layout.fragment_social_network, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);

        //зададим для всех элементов одинаковые размеры
        recyclerView.setHasFixedSize(true);

        //получили данные
      //  String[] data = getResources().getStringArray(R.array.test_title);
        CardSourse data = new CardSourceImpl(getResources()).init();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());  // отвечает за размещение элементов в RecyclerViewБ будут вертикально вниз
        recyclerView.setLayoutManager(layoutManager);

        SocialNetworkAdapter socialNetworkAdapter = new SocialNetworkAdapter(data);
        socialNetworkAdapter.setMyOnClickListener(this);
// или создаем листенер
//        socialNetworkAdapter.setMyOnClickListener(new MyOnClickListener() {
//            @Override
//            public void OnMyClick(View view, int position) {
//                Toast.makeText (getContext(), "тяжелая обработка для" + position, Toast.LENGTH_SHORT).show();
//            }
//        });

        // прикрепим адаптер к списку
        recyclerView.setAdapter(socialNetworkAdapter);

        return view;
    }

    @Override
    public void OnMyClick(View view, int position) {
        Toast.makeText(getContext(), "тяжелая обработка для" + position, Toast.LENGTH_SHORT).show();

    }

    //    //урок 9 добавляем меню
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
    }

    // 9 заходим в меню / удаляем добавляем карточки
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                data.addCardData(new CardData("Новая" + data.size(),
                        "Описание" + data.size(),
                        R.drawable.nature1, false));
                adapter.notifyItemInserted(data.size()-1); //обновить создать новый
               // adapter.notifyDataSetChanged();//обновляет весь список, ресурсно
               // recyclerView.scrollToPosition(data.size()-1); // добавляем позицию снизу/быстро
                recyclerView.smoothScrollToPosition(data.size()-1); // добавляем позицию снизу/медленно пролистывая список
                return true;
            case R.id.action_clear:
                data.clearCardData(); // удаление
                adapter.notifyDataSetChanged(); //адаптер примени все данные /обновляет списки
                    return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
