package id_iot.orest_task;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.Toast;

public class GridViewFragment extends Fragment implements SearchView.OnQueryTextListener {

    GridView gridView;
    //FloatingActionButton changeToCard;
    ImageButton changeToCard;
    SearchView findRecipe;
    GridViewAdapter gridViewAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.grid_view, container, false);
        getActivity().setTitle("Menu");

        changeToCard = (ImageButton) view.findViewById(R.id.changeToCard);
        changeToCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentActivity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;
                mainActivity.showFragment(new RecyclerViewFragment());
            }
        });

        gridView = (GridView) view.findViewById(R.id.gridview);

        FragmentActivity activity = getActivity();
        MainActivity mainActivity = (MainActivity) activity;

        gridViewAdapter = new GridViewAdapter(getContext(), mainActivity.getRecipe());
        gridView.setAdapter( gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),  gridViewAdapter.getRecipes().get(i).getRecipeName(), Toast.LENGTH_SHORT).show();
                gridViewAdapter.getRecipes().get(i).toogleFavorite();
                gridViewAdapter.notifyDataSetChanged();
            }
        });

        findRecipe = (SearchView) view.findViewById(R.id.searchRecipe);
        findRecipe.setOnQueryTextListener(this);

        return view;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        gridViewAdapter.filter(text);
        return false;
    }
}
