package stefan.jovanovic.chatapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class ContactsActivity extends Activity implements View.OnClickListener {

    private ListView lvContacts;
    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        lvContacts = findViewById(R.id.contacts_list);
        btnLogout = findViewById(R.id.btn_logout);

        // Adds logout button listener
        btnLogout.setOnClickListener(this);

        ContactsListAdapter contactslistadapter = new ContactsListAdapter(this);
        contactslistadapter.addContactClass(new ContactClass((String) getText(R.string.contact1)));
        contactslistadapter.addContactClass(new ContactClass((String) getText(R.string.contact2)));

        lvContacts.setAdapter(contactslistadapter);

        //lvContacts.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view) {
        // Starts main activity if logout button is pressed
        if (view.getId() == R.id.btn_logout){
            Intent intMainactivity = new Intent(ContactsActivity.this, MainActivity.class);
            startActivity(intMainactivity);
        }

    }

    /*@Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (view.getId() == R.id.imgbtn_send){
            Intent intMessageactivity = new Intent(ContactsActivity.this, MessageActivity.class);
            startActivity(intMessageactivity);
        }

    }*/
}
