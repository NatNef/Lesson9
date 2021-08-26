package keyone.keytwo.lesson9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

// класс для обслуживания RecyclerView
public class SocialNetworkAdapter extends RecyclerView.Adapter<SocialNetworkAdapter.MyViewHolder> {

    //xml файл -inflate- теперь он java - разбиваем этот объект на
    // оболочку MyViewHolder что-бы обращаться к его элементам  textView и imageView
    // достаем элементы public MyViewHolder и далее задаются значения onBindViewHolder


    private MyOnClickListener Listener;

    public void setMyOnClickListener(MyOnClickListener Listener){
        this.Listener = Listener;
    }

    // задаем данные
    private CardSourse dadaSource;


  //  private MyOnClickListener Listener;

    public SocialNetworkAdapter(CardSourse dadaSource) {
        this.dadaSource = dadaSource;
    }
//// можем на ходу передавать новые данные в String[] dadaSource
   public void setData(CardSourse dadaSource) {
       this.dadaSource = dadaSource;
//    }
   }





    // создаются элементы мы создаем для него оболочку MyViewHolder
    // делаем доступ к его полям TextView
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_view, parent,false);

//        // вешаем клики
//        (view.findViewById(R.id.textView)).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
//
////        MyViewHolder holder = new MyViewHolder(view);
////        holder.imageView
//

        return new MyViewHolder(view);
    }


    //связивает данные View со значением
    // прокрутился список и создается след элемент который уехал за экран
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
          holder.title.setText(dadaSource.getCardData(position).getTitle());
          holder.description.setText(dadaSource.getCardData(position).getDescription());
          holder.imageView.setImageResource(dadaSource.getCardData(position).getPicture());
          holder.Like.setChecked(dadaSource.getCardData(position).isLike());
//        holder.imageView.setText(dadaSource[position]);

    }

    //вернуть размер. сколько прокручивается
    @Override
    public int getItemCount() {
        return dadaSource.size();
    }

    // внутри адаптера класс, будет предатсавлением в
    public class MyViewHolder extends RecyclerView.ViewHolder {
        // элементы
        TextView title;
        TextView description;
        ImageView imageView;
        CheckBox Like;

//        public TextView getTextView() {
//            return textView;
//        }

//        public void setTextView(TextView textView) {
//            this.textView = textView;
//        }

 //приходят элементы и мы достаем
        public MyViewHolder(View itemView) {
            super(itemView);
            description = itemView.findViewById(R.id.description);
            title = itemView.findViewById(R.id.title);
            imageView = itemView.findViewById(R.id.imageView);
            Like = itemView.findViewById(R.id.Like);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Listener.OnMyClick(v, getAdapterPosition()); // getAdapterPosition()) возвращает текущую позицию

                }
            });

        }
    }

}
