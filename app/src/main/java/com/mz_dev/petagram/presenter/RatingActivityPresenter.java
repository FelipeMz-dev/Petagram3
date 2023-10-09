package com.mz_dev.petagram.presenter;

import android.content.Context;

import com.mz_dev.petagram.dataBase.PetsBuilder;
import com.mz_dev.petagram.pojo.Pet;
import com.mz_dev.petagram.view.IRatingActivityView;

import java.util.ArrayList;

public class RatingActivityPresenter implements IRatingActivityPresenter {

    private IRatingActivityView view;
    private Context context;
    private PetsBuilder petsBuilder;
    private ArrayList<Pet> pets;

    public RatingActivityPresenter(IRatingActivityView view, Context context) {
        this.view = view;
        this.context = context;
        getPetsDataBase();
    }

    @Override
    public void getPetsDataBase() {
        petsBuilder = new PetsBuilder(context);
        pets = petsBuilder.getLastRatedPets();
        showPetsRecyclerView();
    }

    @Override
    public void showPetsRecyclerView() {
        view.initPetAdapter(view.makePetAdapter(pets));
        view.generateLinearLayoutVertical();
    }
}
