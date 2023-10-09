package com.mz_dev.petagram.view.fragment;

import com.mz_dev.petagram.adapter.ProfilePetAdapter;
import com.mz_dev.petagram.pojo.ImagePublication;
import com.mz_dev.petagram.pojo.Pet;

import java.util.ArrayList;

public interface IProfileFragmentView {
    void initPetProfile(Pet pet);
    void generateGridLayout();
    ProfilePetAdapter makeImageAdapter(ArrayList<ImagePublication> images);
    void initImageAdapter(ProfilePetAdapter adapter);
}
