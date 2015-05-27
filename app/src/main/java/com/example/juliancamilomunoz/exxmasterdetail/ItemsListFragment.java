package com.example.juliancamilomunoz.exxmasterdetail;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.util.ArrayList;

/**
 * Created by Xingke on 25/05/2015.
 */

public class ItemsListFragment extends Fragment {

    private ArrayAdapter<Item> adapterItems;
    private ListView lvItems;

    private OnListItemSelectedListener listener;

    public interface OnListItemSelectedListener {
        public void onItemSelected(Item i);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity instanceof OnListItemSelectedListener) {
            listener = (OnListItemSelectedListener) activity;
        } else {
            throw new ClassCastException(
                    activity.toString()
                            + " must implement ItemsListFragment.OnListItemSelectedListener");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create arraylist from item fixtures
        ArrayList<Item> items = new ArrayList<Item>();
        //Crear Items para agregar a la lista
        items.add(new Item(this.getString(R.string.hot_res_),
                this.getString(R.string.brazil) +"\n"+ this.getString(R.string.dir) + this.getString(R.string.brazildir) +"\n"+ this.getString(R.string.tel) + this.getString(R.string.braziltel) +"\n"+ this.getString(R.string.horario) + this.getString(R.string.brazilhor) +"\n"+ this.getString(R.string.email) + this.getString(R.string.brazilemail)
                +"\n\n"+ this.getString(R.string.dosburros) +"\n"+ this.getString(R.string.tipo) + this.getString(R.string.burrostipo) +"\n"+ this.getString(R.string.dir) + this.getString(R.string.burrosdir) +"\n"+ this.getString(R.string.tel) + this.getString(R.string.burrostel) +"\n"+ this.getString(R.string.horario) + this.getString(R.string.burroshor)
                +"\n\n"+ this.getString(R.string.HandM) +"\n"+ this.getString(R.string.tipo) + this.getString(R.string.HandMtipo) +"\n"+ this.getString(R.string.dir) + this.getString(R.string.HandMdir) +"\n"+ this.getString(R.string.tel) + this.getString(R.string.HandMtel) +"\n"+ this.getString(R.string.horario) + this.getString(R.string.HandMhor)));
        items.add(new Item(this.getString(R.string.bares_),
                this.getString(R.string.sala94) +"\n"+ this.getString(R.string.tipo) + this.getString(R.string.res_bar) +"\n"+ this.getString(R.string.dir) + this.getString(R.string.sala94dir) +"\n"+ this.getString(R.string.horario) + this.getString(R.string.sala94hor)
                        +"\n\n"+ this.getString(R.string.jano) +"\n"+ this.getString(R.string.tipo) + this.getString(R.string.bar) +"\n"+ this.getString(R.string.dir) + this.getString(R.string.janodir) +"\n"+ this.getString(R.string.horario) + this.getString(R.string.janohor)
                        +"\n\n"+ this.getString(R.string.konos) +"\n"+ this.getString(R.string.tipo) + this.getString(R.string.res_bar) +"\n"+ this.getString(R.string.dir) + this.getString(R.string.konosdir) +"\n"+ this.getString(R.string.tel) + this.getString(R.string.konostel) +"\n"+ this.getString(R.string.horario) + this.getString(R.string.konoshor)));
        items.add(new Item(this.getString(R.string.turismo_),
                this.getString(R.string.cruz) +"\n"+ this.getString(R.string.cruz_info1) +"\n"+ this.getString(R.string.cruz_info2)
                        +"\n\n"+ this.getString(R.string.asuncion) +"\n"+ this.getString(R.string.asuncion_info1) +"\n"+ this.getString(R.string.asuncion_info2)
                        +"\n\n"+ this.getString(R.string.sanjuan) +"\n"+ this.getString(R.string.sanjuan_info1)
                        +"\n\n"+ this.getString(R.string.comfama) +"\n"+ this.getString(R.string.comfama_info1)
                        +"\n\n"+ this.getString(R.string.cristorey) +"\n"+ this.getString(R.string.cristorey_info1) +"\n"+ this.getString(R.string.cristorey_info2)));
        items.add(new Item(this.getString(R.string.demografia_),
                this.getString(R.string.demografia_info1) +"\n"+ this.getString(R.string.demografia_info2)));
        items.add(new Item(this.getString(R.string.about_),
                this.getString(R.string.about_text)));


        // Create adapter based on items
        adapterItems = new ArrayAdapter<Item>(getActivity(),
                android.R.layout.simple_list_item_activated_1, items);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate view
        View view = inflater.inflate(R.layout.fragment_items_list, container,
                false);
        // Bind adapter to ListView
        lvItems = (ListView) view.findViewById(R.id.lvItems);
        lvItems.setAdapter(adapterItems);
        lvItems.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View item,
                                    int position, long rowId) {
                // Retrieve item based on position
                Item i = adapterItems.getItem(position);
                // Fire selected listener event with item
                listener.onItemSelected(i); // <--------------
            }
        });
        return view;
    }

    /**
     * Turns on activate-on-click mode. When this mode is on, list items will be
     * given the 'activated' state when touched.
     */
    public void setActivateOnItemClick(boolean activateOnItemClick) {
        // When setting CHOICE_MODE_SINGLE, ListView will automatically
        // give items the 'activated' state when touched.
        lvItems.setChoiceMode(
                activateOnItemClick ? ListView.CHOICE_MODE_SINGLE
                        : ListView.CHOICE_MODE_NONE);
    }
}