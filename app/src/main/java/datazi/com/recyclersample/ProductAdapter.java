package datazi.com.recyclersample;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashish on 2/13/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;

    public ProductAdapter(Context context,List<Product> productList){
        this.context=context;
        this.productList=productList;
    }


    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //bind the layout here
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.recycler_list,null);
        ProductViewHolder productViewHolder=new ProductViewHolder(view);
        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //fetch obj from list and set it to holder
        Product product=productList.get(position);//1st post all object from list fetched by this id

        holder.textViewTitle.setText(product.getTitle());
        holder.imageView.setImageResource(product.getImage());
        holder.textViewDesc.setText(product.getShortdesc());
        holder.textViewPrice.setText(String.valueOf(product.getPrice()));
        holder.textViewRating.setText(String.valueOf(product.getRating()));
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(view.getContext(),"Hello",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,ProductView.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        //size of productList
        return productList.size();
    }
    //pass filtered array
    public  void filterList(ArrayList<Product> filteredList){

        productList=filteredList;
        notifyDataSetChanged();
    }

    //INTERNAL CLASS
    public class ProductViewHolder extends RecyclerView.ViewHolder{

        //create all object which required to add in recycler_list.xml
        //or we want to bind data to xml
        //ui element in order to bind with layout
        ImageView imageView;
        TextView textViewTitle;
        TextView textViewDesc;
        TextView textViewRating;
        TextView textViewPrice;

        //in order to make all item clickable or any parent layout of above xml
        RelativeLayout relativeLayout;

        public ProductViewHolder(View itemView) {
            super(itemView);
            //initalize al object
            imageView=itemView.findViewById(R.id.imageView);
            textViewDesc=itemView.findViewById(R.id.textViewShortDesc);
            textViewPrice=itemView.findViewById(R.id.textViewPrice);
            textViewRating=itemView.findViewById(R.id.textViewRating);
            textViewTitle=itemView.findViewById(R.id.textViewTitle);
            relativeLayout=itemView.findViewById(R.id.relative_layout);
        }
    }

}
