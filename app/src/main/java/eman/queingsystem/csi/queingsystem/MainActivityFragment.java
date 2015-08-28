package eman.queingsystem.csi.queingsystem;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner spinner;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        List<String> transactions = new ArrayList<String>(Arrays.asList(days));

        spinner = (Spinner) rootView.findViewById(R.id.spinner);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(
                getActivity(),
                R.array.days,
                R.layout.support_simple_spinner_dropdown_item);



        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(this);

        return rootView;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView textView = (TextView) view;
        Toast.makeText(getActivity(), "You selected " + textView.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
