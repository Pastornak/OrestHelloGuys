package id_iot.orest_task;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class RecyclerViewFragment extends Fragment{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    Button changeToGrid;
    SearchView searchRecipe;
    RecyclerAdapter recyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        getActivity().setTitle("Menu");

        changeToGrid = (Button) view.findViewById(R.id.changeToGrid);
        changeToGrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new GridViewFragment());
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.rv);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        recyclerAdapter= new RecyclerAdapter();
        recyclerView.setAdapter(recyclerAdapter);

        searchRecipe = (SearchView) view.findViewById(R.id.searchRecipe);

        return view;
    }
}