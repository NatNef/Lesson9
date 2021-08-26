package keyone.keytwo.lesson9;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
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

    public static SocialNetworkFragment newInstance() {
        return new SocialNetworkFragment();

    }

    @Nullable
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_social_network, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

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

    //урок 9 добавляем меню
    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.fragment_menu, menu);
    }
}
