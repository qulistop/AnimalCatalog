package ord.aplas.animalcatalog;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>
       implements ItemMoveCallback.ItemTouchHelperContract {

    //All methods in this adapter are required for a bare minimum recyclerview adapter
    private int listItemLayout;
    private ArrayList<DataItem> itemList;
    private Context mContext;

    // Constructor of the class
    public DataAdapter(Context context, ArrayList<DataItem> itemList) {
        mContext = context;
        this.itemList = itemList;
    }

    // specify the row layout file and click for each row
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.layout_data, parent, false));
    }

    // load data in each row element
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DataItem currData = itemList.get(position);
        holder.bindTo(currData);

        //holder.time.setText(itemList.get(listPosition).getTime());
        //holder.player.setText(itemList.get(listPosition).getPlayer());
        //String name = itemList.get(listPosition).getName();
        //holder.name.setText(name);
        //holder.img.setImageResource(R.drawable.mammals);
    }

    @Override
    public void onRowMoved(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(itemList, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(itemList, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    @Override
    public void onRowSelected(ViewHolder myViewHolder) {
        myViewHolder.rowView.setBackgroundColor(Color.GRAY);

    }

    @Override
    public void onRowClear(ViewHolder myViewHolder) {
        myViewHolder.rowView.setBackgroundColor(Color.WHITE);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    // Static inner class to initialize the views of rows
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView info;
        public TextView youtube;
        public ImageView icon;
        public ImageView video;
        public View rowView;

        public ViewHolder(View itemView) {
            super(itemView);
            //itemView.setOnClickListener(this);
            title = (TextView) itemView.findViewById(R.id.txtName);
            info = (TextView) itemView.findViewById(R.id.txtTime);
            youtube = (TextView) itemView.findViewById(R.id.txtPlayer);
            icon = (ImageView) itemView.findViewById(R.id.eventIcon);
            rowView = itemView;
        }

        public void bindTo(DataItem currData){
            //Populate the textviews with data
            title.setText(currData.getTitle());
            info.setText(currData.getInfo());
            youtube.setText(currData.getYoutube());
            icon.setImageResource(currData.getIcon());
        }
    }


}