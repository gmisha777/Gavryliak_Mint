package school.softgroup.gavryliak_mint;

/**
 * Created by GMisha on 30.01.2017.
 */

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.ContextMenu;
import android.view.View;
import android.widget.EditText;
import com.google.gson.Gson;
import java.util.ArrayList;

public class AddDialogFragment extends DialogFragment implements
        DialogInterface.OnClickListener {
    private View form=null;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        form= getActivity().getLayoutInflater()
                .inflate(R.layout.additem_layout, null);
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        return(builder.setTitle("Add Fruit").setView(form)
                .setPositiveButton(android.R.string.ok, this)
                .setNegativeButton(android.R.string.cancel, null).create());
    }
    @Override
    public void onClick(DialogInterface dialog, int which) {

        EditText fruit_edit=(EditText)form.findViewById(R.id.fruit_name);
        String fruit_name  = fruit_edit.getText().toString();
        String JSON_OBJ = "RecyclerViewFragment";
        Gson gson =new Gson();
        String temp_str_gson;
        MyApp app=((MyApp) getActivity().getApplicationContext());
        ArrayList<String> mDataset= gson.fromJson(app.getMySPREF().getString(JSON_OBJ,""),ArrayList.class);
        mDataset.add(fruit_name);
        temp_str_gson=gson.toJson(mDataset);
        app.getMySPREF().edit().putString(JSON_OBJ,temp_str_gson).commit();

    }
    @Override
    public void onDismiss(DialogInterface unused) {
        super.onDismiss(unused);
    }
    @Override
    public void onCancel(DialogInterface unused) {
        super.onCancel(unused);
    }
}
