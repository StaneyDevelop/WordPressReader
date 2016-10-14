package stan.dev.wpreader.ui.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import stan.dev.wpreader.R;

public class PostsAdapter
        extends RecyclerView.Adapter<PostsAdapter.PostHolder>
{
    private Context context;
    private List<String> data;

    public PostsAdapter(Context c)
    {
        this.context = c;
    }

    @Override
    public PostHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.post, parent, false);
        return new PostHolder(v);
    }

    @Override
    public void onBindViewHolder(PostHolder holder, int position)
    {
        holder.text.setText(data.get(position));
    }

    @Override
    public int getItemCount()
    {
        if (data == null)
        {
            return 0;
        }
        return data.size();
    }

    public void swapData(List<String> d)
    {
        this.data = d;
    }

    public class PostHolder
            extends RecyclerView.ViewHolder
    {
        public TextView text;

        public PostHolder(View v)
        {
            super(v);
            text = (TextView) v.findViewById(R.id.text);
        }
    }
}