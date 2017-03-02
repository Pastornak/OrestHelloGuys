package id_iot.orest_task;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecycleView extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    EditText findRecipe;
    Button buttonFind;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.recycler_view, container, false);
        getActivity().setTitle("Menu");
        recyclerView = (RecyclerView) view.findViewById(R.id.rv);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        final RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        findRecipe = (EditText) view.findViewById(R.id.editText2);
        buttonFind = (Button) view.findViewById(R.id.button);
        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = findRecipe.getText().toString();
                boolean found = false;
                for (Recipe recipe: adapter.ITEM.getRecipies()){
                    if (recipe.getRecipeName().equalsIgnoreCase(name)) {
                        Toast.makeText(getContext(), "Found", Toast.LENGTH_SHORT).show();
                        found = true;
                    }
                }

                if (found == false)
                    Toast.makeText(getContext(), "Didn`t found", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}
