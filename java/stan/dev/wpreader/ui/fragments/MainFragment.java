package stan.dev.wpreader.ui.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import stan.dev.wpreader.R;
import stan.dev.wpreader.ui.adapters.PostsAdapter;

public class MainFragment
        extends Fragment
{
    //___________________VIEWS
    private RecyclerView list_posts;

    //___________________FIELDS
    private PostsAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.main_fragment, container, false);
        initViews(v);
        init();
        return v;
    }

    private void initViews(View v)
    {
        list_posts = (RecyclerView) v.findViewById(R.id.list_posts);
    }

    private void init()
    {
        adapter = new PostsAdapter(getActivity());
        list_posts.setLayoutManager(new LinearLayoutManager(getActivity()));
        list_posts.setAdapter(adapter);
        ArrayList<String> data = new ArrayList<>();
        data.add("text" + data.size());
        data.add("text" + data.size());
        data.add("text" + data.size());
        data.add("text" + data.size());
        data.add("text" + data.size());
        data.add("text" + data.size());
        data.add("text" + data.size());
        data.add("text" + data.size());
        adapter.swapData(data);
    }
}