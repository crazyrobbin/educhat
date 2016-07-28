package android.educhat.com.educhat.Adapter;

import android.app.Activity;
import android.educhat.com.educhat.R;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Robbin Singh on 27/07/2016.
 */
public class AnnouncementsAdapter extends RecyclerView.Adapter<AnnouncementsAdapter.MyViewHolder>{

    Activity activity;

    public AnnouncementsAdapter( Activity activity) {
        this.activity = activity;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_holder, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.menu.setTag(position);

        holder.menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopupMenu(view);
            }
        });
    }



    @Override
    public int getItemCount() {
        return 10;
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageButton menu;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            menu = (ImageButton) view.findViewById(R.id.menu_btton);
        }

    }

    private void showPopupMenu(View view) {
        // inflate menu
        PopupMenu popup = new PopupMenu(activity, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.popup_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    /**
     * Click listener for popup menu items
     */
    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.install:
                    Toast.makeText(activity, "Open it", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.addtowishlist:
                    Toast.makeText(activity, "Signature it", Toast.LENGTH_SHORT).show();
                    return true;
                default:
            }
            return false;
        }
    }

}