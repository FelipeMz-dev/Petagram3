package com.mz_dev.petagram.presenter;

import android.content.Context;

import com.mz_dev.petagram.dataBase.PetsBuilder;
import com.mz_dev.petagram.pojo.Pet;
import com.mz_dev.petagram.view.fragment.IHomeFragmentView;

import java.util.ArrayList;

public class HomeFragmentPresenter implements IHomeFragmentPresenter {

    private IHomeFragmentView view;
    private Context context;
    private PetsBuilder petsBuilder;
    private ArrayList<Pet> pets;

    public HomeFragmentPresenter(IHomeFragmentView view, Context context){
        this.view = view;
        this.context = context;
        getPetsDataBase();
    }

    @Override
    public void getPetsDataBase() {
        petsBuilder = new PetsBuilder(context);
        pets = petsBuilder.getPetData();
        showPetsRecyclerView();
    }

    @Override
    public void showPetsRecyclerView() {
        view.initPetAdapter(view.makePetAdapter(pets));
        view.generateLinearLayoutVertical();
    }
}
