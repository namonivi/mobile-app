package com.example.pizza_loop;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
//import com.squareup.picasso.Picasso;
import com.bumptech.glide.Glide;
import java.util.List;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ProductViewHolder>  {
    private Context mtx;
    private List<Pizza> productList;
    private OnItemClickListner mListner;

    public interface OnItemClickListner{
        void  onItemClick(int position);
    }
    public void setOnItemCliclListener(OnItemClickListner listener){
        mListner = listener;
    }

    public PizzaAdapter(Context mtx, List<Pizza> productList) {
        this.mtx = mtx;
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        /*View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem, viewGroup,true);
        ProductViewHolder vh = new ProductViewHolder(v);
       return vh;*/

        LayoutInflater layoutInflater = LayoutInflater.from(mtx);
        View view = layoutInflater.inflate(R.layout.listitem, null);

        return new ProductViewHolder(view);

    }

    public void onBindViewHolder(ProductViewHolder holder, int position) {
        Pizza product = productList.get(position);

        String PizzaName = product.getName();
        Double PizzaPrice = product.getPrice();
        String PizzaDescription = product.getDetails();
        String imgURL = product.getImageURL();

        holder.textViewname.setText(PizzaName);
        holder.textViewprice.setText("Rs." + PizzaPrice);
        holder.textViewdescription.setText(PizzaDescription);

       Glide.with(mtx).load(imgURL).into(holder.imageView);

       // Picasso.get().load(imgURL).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewname, textViewdescription, textViewprice;
        public ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

           imageView = itemView.findViewById(R.id.imageView);
            textViewname = itemView.findViewById(R.id.name);
            textViewdescription = itemView.findViewById(R.id.description);
            textViewprice = itemView.findViewById(R.id.price);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListner != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListner.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
