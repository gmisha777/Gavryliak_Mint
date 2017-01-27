package school.softgroup.gavryliak_mint;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by GMisha on 26.01.2017.
 */

public class Fragment_Welcome_1 extends Fragment {
    final String LOG_TAG = "myLogs";
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(LOG_TAG, "Fragment1 onAttach");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onAttach", Toast.LENGTH_SHORT).show();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onCreate");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onCreate", Toast.LENGTH_SHORT).show();
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(LOG_TAG, "Fragment1 onCreateView");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onCreateView", Toast.LENGTH_SHORT).show();
        return inflater.inflate(R.layout.fagment_welcome_1, null);
    }

    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(LOG_TAG, "Fragment1 onActivityCreated");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onActivityCreated", Toast.LENGTH_SHORT).show();
    }

    public void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "Fragment1 onStart");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onStart", Toast.LENGTH_SHORT).show();
    }

    public void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "Fragment1 onResume");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onResume", Toast.LENGTH_SHORT).show();
    }

    public void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "Fragment1 onPause");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onPause", Toast.LENGTH_SHORT).show();
    }

    public void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "Fragment1 onStop");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onStop", Toast.LENGTH_SHORT).show();
    }

    public void onDestroyView() {
        super.onDestroyView();
        Log.d(LOG_TAG, "Fragment1 onDestroyView");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onDestroyView", Toast.LENGTH_SHORT).show();
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "Fragment1 onDestroy");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onDestroy", Toast.LENGTH_SHORT).show();
    }

    public void onDetach() {
        super.onDetach();
        Log.d(LOG_TAG, "Fragment1 onDetach");
        Toast.makeText(getActivity().getApplicationContext(),"Fragment1 onDetach", Toast.LENGTH_SHORT).show();
    }
}
