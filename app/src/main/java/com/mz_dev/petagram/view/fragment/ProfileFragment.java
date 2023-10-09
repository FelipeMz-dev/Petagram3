package com.mz_dev.petagram.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mz_dev.petagram.R;
import com.mz_dev.petagram.adapter.ProfilePetAdapter;
import com.mz_dev.petagram.pojo.ImagePublication;
import com.mz_dev.petagram.pojo.Pet;
import com.mz_dev.petagram.presenter.IProfileFragmentPresenter;
import com.mz_dev.petagram.presenter.ProfileFragmentPresenter;

import java.util.ArrayList;

/**
 * Created by FelipeMz on 25/09/2023
 */
public class ProfileFragment extends Fragment implements IProfileFragmentView {

    private IProfileFragmentPresenter presenter;
    private ImageView ivPetProfile;
    private TextView tvPetNameProfile;
    private RecyclerView rvProfileImages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        initUI(view);
        presenter = new ProfileFragmentPresenter(this, getContext());
        return view;
    }

    private void initUI(View view){
        ivPetProfile = (ImageView) view.findViewById(R.id.ivPetProfile);
        tvPetNameProfile = view.findViewById(R.id.tvPetNameProfile);
        rvProfileImages = view.findViewById(R.id.rvProfileImages);
    }

    @Override
    public void initPetProfile(Pet pet) {
        ivPetProfile.setImageResource(pet.getImage());
        tvPetNameProfile.setText(pet.getName());
    }

    @Override
    public void generateGridLayout() {
        GridLayoutManager linearLayoutManager = new GridLayoutManager(getContext(), 3);;
        rvProfileImages.setLayoutManager(linearLayoutManager);
    }

    @Override
    public ProfilePetAdapter makeImageAdapter(ArrayList<ImagePublication> images) {
        ProfilePetAdapter adapter = new ProfilePetAdapter(images);
        return adapter;
    }

    @Override
    public void initImageAdapter(ProfilePetAdapter adapter) {
        rvProfileImages.setAdapter(adapter);
    }
}