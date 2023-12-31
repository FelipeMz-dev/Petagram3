package com.mz_dev.petagram.view.fragment;

import com.mz_dev.petagram.adapter.PetAdapter;
import com.mz_dev.petagram.pojo.Pet;

import java.util.ArrayList;

public interface IHomeFragmentView {
    void generateLinearLayoutVertical();
    PetAdapter makePetAdapter(ArrayList<Pet> pets);
    void initPetAdapter(PetAdapter petAdapter);
}
