package stefan.jovanovic.chatapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class ContactsListAdapter extends BaseAdapter implements View.OnClickListener{

    private Context cContext;
    private ArrayList<ContactClass> arlstContacts;

    public ContactsListAdapter(Context context){
        cContext = context;
        arlstContacts = new ArrayList<ContactClass>();
    }

    public void addContactClass(ContactClass contacts){
        arlstContacts.add(contacts);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return arlstContacts.size();
    }

    @Override
    public Object getItem(int position) {
        Object contact = null;
        try{
            contact = arlstContacts.get(position);
        } catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        return contact;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) cContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.layout_contact, null);

            ContactHolder holder = new ContactHolder();
            holder.tvFirstletter = (TextView) view.findViewById(R.id.tv_name_first_letter);
            holder.tvName = (TextView) view.findViewById(R.id.tv_contact_name);
            holder.imgbtnSend = (ImageView) view.findViewById(R.id.imgbtn_send);
            holder.imgbtnSend.setOnClickListener(this);

            view.setTag(holder);
        }

        ContactClass contactclass = (ContactClass) getItem(position);
        ContactHolder holder = (ContactHolder) view.getTag();

        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));

        holder.tvFirstletter.setText(contactclass.getTvName().substring(0,1).toUpperCase());
        holder.tvFirstletter.setBackgroundColor(color);
        holder.tvName.setText(contactclass.getTvName());

        return view;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(cContext, "print", Toast.LENGTH_SHORT).show();
    }

    private class ContactHolder{
        public TextView tvFirstletter = null;
        public TextView tvName = null;
        public ImageView imgbtnSend = null;
    }
}
