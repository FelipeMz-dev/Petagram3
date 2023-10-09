package com.mz_dev.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mz_dev.petagram.R;
import com.mz_dev.petagram.dataBase.PetsBuilder;
import com.mz_dev.petagram.pojo.Pet;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {
    private final ArrayList<Pet> pets;
    private final ArrayList<Pet> favoritePets = new ArrayList<>();
    private static Activity activity = new Activity();
    private boolean ratingEnabled = false;

    public PetAdapter(ArrayList<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        Pet pet = pets.get(position);
        holder.bindData(pet);
    }

    public ArrayList<Pet> getFavoritePets(){
        return favoritePets;
    }

    public void setRatingEnabled(boolean ratingEnabled){
        this.ratingEnabled = ratingEnabled;
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{

        private final ImageView imgPet;
        private final TextView tvNamePet;
        private final TextView tvRatingPet;
        private final ImageButton btnBone;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPet = itemView.findViewById(R.id.imgPet);
            tvNamePet = itemView.findViewById(R.id.tvNamePet);
            tvRatingPet = itemView.findViewById(R.id.tvRatingPet);
            btnBone = itemView.findViewById(R.id.btnBone);
        }

        void bindData(Pet pet){
            imgPet.setImageResource(pet.getImage());
            tvNamePet.setText(pet.getName());
            tvRatingPet.setText(String.valueOf(pet.getRating()));
            btnBone.setOnClickListener(v -> setRatingBone(pet));
        }

        private void setRatingBone(Pet pet){
            PetsBuilder petsBuilder = new PetsBuilder(activity);
            petsBuilder.insertPetRating(pet);
            Toast.makeText(activity, R.string.pet_rated, Toast.LENGTH_SHORT).show();

            tvRatingPet.setText(String.valueOf(petsBuilder.getPetRating(pet)));

        /*if (ratingEnabled) return;
        Pet pet = pets.get(position);
        //only it can rated if not are in favoritePets list
        int newRating = pet.getRating();
        if (favoritePets.contains(pet)){
            //unrated
            newRating --;
            pet.setRating(newRating);
            favoritePets.remove(pet);
            notifyItemChanged(position);
            Toast.makeText(activity, R.string.pet_unrated, Toast.LENGTH_SHORT).show();
            return;
        }
        //rated pet an add to favoritePets list
        newRating ++;
        favoritePets.add(pet);
        pet.setRating(newRating);
        notifyItemChanged(position);
        Toast.makeText(activity, R.string.pet_rated, Toast.LENGTH_SHORT).show();*/
        }
    }
}
