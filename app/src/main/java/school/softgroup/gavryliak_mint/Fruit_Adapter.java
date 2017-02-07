package school.softgroup.gavryliak_mint;

/**
 * Created by GMisha on 04.02.2017.
 */

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import io.realm.Realm;

/**
 * Created by Belal on 29/09/16.
 */

public class Fruit_Adapter extends RecyclerView.Adapter<Fruit_Adapter.ViewHolder> {

    private List<Fruits_realM> list;
    private Context mCtx;


    public Fruit_Adapter(List<Fruits_realM> list, Context mCtx) {
        this.list = list;
        this.mCtx = mCtx;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Fruits_realM myList = list.get(position);
        holder.textViewHead.setText(myList.getFruit_name());
       // holder.textViewDesc.setText(myList.getDesc());

        holder.buttonViewOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                //creating a popup menu
                PopupMenu popup = new PopupMenu(mCtx, holder.buttonViewOption);
                //inflating menu from xml resource
                popup.inflate(R.menu.options_menu);
                //adding click listener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.menu1:
                                Realm realm = Realm.getInstance(MyApp.getInstance());
                                realm.beginTransaction();
                                Fruits_realM fruitdel =myList;
                                fruitdel.removeFromRealm();
                                realm.commitTransaction();
                                MyApp.getInstance().getmAdapter().notifyDataSetChanged();
                                break;
                            case R.id.menu2:
                                new UpdateDialogFragment(myList).show(MyApp.getInstance().getFm(),
                                        "fruit_add");

                                break;
                            case R.id.menu3:
                                new AddDialogFragment().show(MyApp.getInstance().getFm(),
                                        "fruit_add");
                                break;
                        }
                        return false;
                    }
                });
                //displaying the popup
                popup.show();

            }
        });
    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewHead;
        public ImageView buttonViewOption;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textViewHead);
            buttonViewOption = (ImageView) itemView.findViewById(R.id.item_settings);
        }
    }
}