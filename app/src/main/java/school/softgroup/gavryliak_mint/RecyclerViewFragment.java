package school.softgroup.gavryliak_mint;

/**
 * Created by GMisha on 29.01.2017.
 */

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class RecyclerViewFragment extends Fragment {

    private static final String TAG = "RecyclerViewFragment";
    protected RecyclerView mRecyclerView;
   // protected Fruit_Adapter mAdapter;

    String[] default_list_fruits = {"Apple", "Apricot", "Avocado", "Banana", "Bilberry", "Blackberry", "Blackcurrant", "Blueberry", "Boysenberry"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_frag, container, false);
        rootView.setTag(TAG);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        MyApp.getInstance().setmAdapter(new Fruit_Adapter(loadAllDatafromRealM(), getContext()));

        mRecyclerView.setAdapter( MyApp.getInstance().getmAdapter());
        return rootView;
    }

    private RealmResults loadAllDatafromRealM() {
        Realm realm = Realm.getInstance(MyApp.getInstance());
        RealmQuery query = realm.where(Fruits_realM.class);
        return query.findAll();
    }
}