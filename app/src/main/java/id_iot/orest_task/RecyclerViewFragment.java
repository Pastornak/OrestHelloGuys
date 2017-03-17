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
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.Toast;

public class RecyclerViewFragment extends Fragment implements SearchView.OnQueryTextListener{

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    //FloatingActionButton changeToGrid;
    ImageButton changeToGrid;
    SearchView searchRecipe;
    RecyclerAdapter recyclerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        getActivity().setTitle("Menu");

        changeToGrid = (ImageButton) view.findViewById(R.id.changeToGrid);
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

        FragmentActivity activity = getActivity();
        MainActivity mainActivity = (MainActivity) activity;

        recyclerAdapter= new RecyclerAdapter(mainActivity.getRecipe());
        recyclerView.setAdapter(recyclerAdapter);

        searchRecipe = (SearchView) view.findViewById(R.id.searchRecipe);
        searchRecipe.setOnQueryTextListener(this);

        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        recyclerAdapter.filter(text);
        return false;
    }
}
