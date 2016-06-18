package yasheth.sportsandculturalhub1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.MyViewHolder> {

    private List<Details> detailsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView subj, desc;

        public MyViewHolder(View view) {
            super(view);
            subj = (TextView) view.findViewById(R.id.subject);
            desc = (TextView) view.findViewById(R.id.desc);
        }
    }


    public DetailsAdapter(List<Details> detailsList) {
        this.detailsList = detailsList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Details details = detailsList.get(position);
        holder.subj.setText(details.getSubject());
        holder.desc.setText(details.getDescription());
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }
}
