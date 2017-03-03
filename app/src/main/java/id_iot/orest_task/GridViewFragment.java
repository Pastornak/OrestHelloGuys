package id_iot.orest_task;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class GridViewFragment extends Fragment {

    GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.grid_view, container, false);
        getActivity().setTitle("Menu");

        gridView = (GridView) view.findViewById(R.id.gridview);
        final GridViewAdapter gridViewAdapter = new GridViewAdapter(getContext());
        gridView.setAdapter( gridViewAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),  gridViewAdapter.getRecipes().get(i).getRecipeName(), Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}