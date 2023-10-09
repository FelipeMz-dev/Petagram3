package com.mz_dev.petagram.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import static com.mz_dev.petagram.view.MainActivity.PETS_OBJ;

import com.mz_dev.petagram.OptionsMenuHandler;
import com.mz_dev.petagram.adapter.PetAdapter;
import com.mz_dev.petagram.R;
import com.mz_dev.petagram.pojo.Pet;
import com.mz_dev.petagram.presenter.IRatingActivityPresenter;
import com.mz_dev.petagram.presenter.RatingActivityPresenter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class RatingActivity extends AppCompatActivity implements IRatingActivityView {

    private RecyclerView rvRatingPetsList;
    private IRatingActivityPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);
        initTollBar();
        initUI();
        presenter = new RatingActivityPresenter(this, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (OptionsMenuHandler.handleOptionsItemSelected(item, this)) return true;
        return super.onOptionsItemSelected(item);
    }

    private void initTollBar(){
        Toolbar myToolBar = findViewById(R.id.myToolBar);
        setSupportActionBar(myToolBar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void initUI(){
        rvRatingPetsList = findViewById(R.id.rvRatingPetsList);
    }

    @Override
    public void generateLinearLayoutVertical(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRatingPetsList.setLayoutManager(linearLayoutManager);
    }

    @Override
    public PetAdapter makePetAdapter(ArrayList<Pet> pets) {
        PetAdapter petAdapter = new PetAdapter(pets, this);
        return petAdapter;
    }

    @Override
    public void initPetAdapter(PetAdapter petAdapter) {
        rvRatingPetsList.setAdapter(petAdapter);
        petAdapter.setRatingEnabled(true);
    }
}