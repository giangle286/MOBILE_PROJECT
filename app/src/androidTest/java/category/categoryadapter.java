package category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.phamthiminhhoa.myapplication.R;

import org.junit.experimental.categories.Category;

import java.util.List;

import nhatro.nhatroadapter;


public class categoryadapter extends RecyclerView.Adapter<categoryadapter.categoryViewHolder>{
    private Context mContext;
    private List<Category> mListCategory;
    public void CategoryAdapter (Context mContext) {
        this.mContext=mContext;
    }
    public void setData(List<Category> list) {
        this.mListCategory=list;/*gán category bằng tham số truyền vào*/
        notifyDataSetChanged();/*khi nội dung của list bị thay đổi thì phải gọi notify datasetchanged*/
    }
    @NonNull
    @Override
    public categoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category,parent,false);
        return new categoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull categoryViewHolder holder, int position) {
     Category category=mListCategory.get(position);
    if (category==null){
        return;
    }
    holder.tvnamecategory.setText(category.getNameCategory());
    nhatroadapter nhatroadapter = new nhatroadapter();
    nhatroadapter.setData(category.getNhatro());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class categoryViewHolder extends RecyclerView.ViewHolder{
    private TextView tvnamecategory;
    private RecyclerView rcvnhatro;
        public categoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvnamecategory =itemView.findViewById(R.id.tv_namecategory);
        rcvnhatro=itemView.findViewById(R.id.rcv_nhatro);
        }
    }
}
