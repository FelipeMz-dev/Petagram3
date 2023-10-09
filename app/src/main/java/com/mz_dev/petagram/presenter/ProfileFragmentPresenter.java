package com.mz_dev.petagram.presenter;

import android.content.Context;

import com.mz_dev.petagram.dataBase.PetsBuilder;
import com.mz_dev.petagram.pojo.ImagePublication;
import com.mz_dev.petagram.pojo.Pet;
import com.mz_dev.petagram.view.fragment.IProfileFragmentView;

import java.util.ArrayList;

public class ProfileFragmentPresenter implements IProfileFragmentPresenter {

    private IProfileFragmentView view;
    private Context context;
    private PetsBuilder petsBuilder;
    private ArrayList<ImagePublication> images;
    private Pet profilePet;

    public ProfileFragmentPresenter(IProfileFragmentView view, Context context) {
        this.view = view;
        this.context = context;
        getProfilePetDataBase();
        getImagesDataBase();
    }

    @Override
    public void getProfilePetDataBase() {
        petsBuilder = new PetsBuilder(context);
        profilePet = petsBuilder.getFirstPet();
        applyProfilePet();
    }

    @Override
    public void applyProfilePet() {
        if (profilePet != null) {
            view.initPetProfile(profilePet);
        }else {
            view.initPetProfile(new Pet());
        }
    }

    @Override
    public void getImagesDataBase() {
        images = petsBuilder.getImagesPublication();
        showImagesRecyclerView();
    }

    @Override
    public void showImagesRecyclerView() {
        view.initImageAdapter(view.makeImageAdapter(images));
        view.generateGridLayout();
    }
}
