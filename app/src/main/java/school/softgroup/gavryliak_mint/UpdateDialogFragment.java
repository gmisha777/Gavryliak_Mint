package school.softgroup.gavryliak_mint;

/**
 * Created by GMisha on 06.02.2017.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import java.util.UUID;
import io.realm.Realm;
public class UpdateDialogFragment extends DialogFragment implements
        DialogInterface.OnClickListener {
    private View form=null;
    private Fruits_realM myList;
    EditText fruit_edit;
    public UpdateDialogFragment(Fruits_realM myList) {
        this.myList = myList;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        form= getActivity().getLayoutInflater()
                .inflate(R.layout.additem_layout, null);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return(builder.setTitle("Update Fruit").setView(form)
                .setPositiveButton(android.R.string.ok, this)
                .setNegativeButton(android.R.string.cancel, null).create());
    }

    @Override
    public void onStart() {
        super.onStart();
        fruit_edit=(EditText)form.findViewById(R.id.fruit_name);
        fruit_edit.setText(myList.getFruit_name());

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {

        String fruit_name  = fruit_edit.getText().toString();
        Realm realm = Realm.getInstance(MyApp.getInstance());
        realm.beginTransaction();
        Fruits_realM fruitdel =myList;
        fruitdel.setFruit_name(fruit_name);
        realm.commitTransaction();
        MyApp.getInstance().getmAdapter().notifyDataSetChanged();
    }
    @Override
    public void onDismiss(DialogInterface unused) {
        super.onDismiss(unused);
    }
    @Override
    public void onCancel(DialogInterface unused) {
        super.onCancel(unused);
    }

    @Override
    public void onStop() {
        super.onStop();
        // getActivity().recreate();
    }
}
