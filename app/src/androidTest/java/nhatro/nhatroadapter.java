package nhatro;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phamthiminhhoa.myapplication.R;

import java.util.List;


public class nhatroadapter extends RecyclerView.Adapter<nhatro.nhatroadapter.nhatroViewHolder>{
    private List<nhatro> mnhatro;
    private void setData (List<nhatro> list) {
        this.mnhatro = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public nhatroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_nhatro, parent, false);
        return new nhatroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull nhatroViewHolder holder, int position) {
        nhatro Nhatro=mnhatro.get(position);
        if (Nhatro==null){
        return;
        }
        holder.imgnhatro.setImageResource(Nhatro.getResourceId());
        holder.tvtitle.setText(Nhatro.getTitle());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class nhatroViewHolder extends RecyclerView.ViewHolder {
    private ImageView imgnhatro;
    private TextView tvtitle;

        public nhatroViewHolder(@NonNull View itemView) {
            super(itemView);

            imgnhatro=itemView.findViewById(R.id.img_nhatro);
            imgnhatro=itemView.findViewById(R.id.tv_title);
        }
    }
}
