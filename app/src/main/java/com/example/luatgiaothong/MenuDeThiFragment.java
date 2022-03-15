package com.example.luatgiaothong;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.luatgiaothong.Adapter.DethiAdapter;
import com.example.luatgiaothong.Entity.DeThi;

import java.util.ArrayList;
import static com.example.luatgiaothong.Home.layout;
public class MenuDeThiFragment extends Fragment {
    ArrayList<DeThi>deThis=new ArrayList<>();
    DethiAdapter adapter;
    ListView listView;
    public MenuDeThiFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        listView=view.findViewById(R.id.lv_deThi);
        layout.setVisibility(View.GONE);
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        deThis.add(new DeThi(2,"20p"));
        adapter=new DethiAdapter(deThis,R.layout.item_dethi,getActivity());
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Navigation.findNavController(view).navigate(R.id.action_menuDeThiFragment_to_thiFragment2);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu_de_thi, container, false);
    }
}