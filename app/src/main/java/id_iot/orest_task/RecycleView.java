package id_iot.orest_task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecycleView extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    //RecyclerView.Adapter adapter;
    EditText findRecipe;
    Button buttonFind;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        recyclerView = (RecyclerView) findViewById(R.id.rv);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        final RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);

        findRecipe = (EditText) findViewById(R.id.editText2);
        buttonFind = (Button) findViewById(R.id.button);
        buttonFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = findRecipe.getText().toString();
                boolean found = false;
                for (Recipe recipe: adapter.ITEM.getRecipies()){
                    if (recipe.getRecipeName().equalsIgnoreCase(name)) {
                        Toast.makeText(getBaseContext(), "Found", Toast.LENGTH_SHORT).show();
                        found = true;
                    }
                }

                if (found == false)
                    Toast.makeText(getBaseContext(), "Didn`t found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
