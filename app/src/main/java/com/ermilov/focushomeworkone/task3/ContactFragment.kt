package com.ermilov.focushomeworkone.task3


import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.loader.app.LoaderManager
import androidx.loader.content.Loader
import com.ermilov.focushomeworkone.R
import kotlinx.android.synthetic.main.list_contact_activity.*
import kotlinx.android.synthetic.main.list_item.*


val from = arrayOf(ContactsContract.Contacts.DISPLAY_NAME)

class ContactFragment: Fragment(), LoaderManager.LoaderCallbacks<Cursor>,
    AdapterView.OnItemClickListener {

    companion object {
        fun newInstanse() = ContactFragment()

    }

    private var cursorAdapter: SimpleCursorAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.list_contact_activity, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val resolver = requireActivity().contentResolver
        val cursor: Cursor? = resolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null,
            null)
        val TO_IDS: IntArray = intArrayOf(android.R.id.text1)


        cursorAdapter = SimpleCursorAdapter(context, android.R.layout.simple_list_item_2, cursor, from, TO_IDS)
        contact_list_view.adapter = cursorAdapter

        if (cursor != null) {
            if (cursor.count > 0) {
                while (cursor.moveToNext()) {
                    val name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                    Toast.makeText(context, name, Toast.LENGTH_SHORT).show()

                }


            }
        }


    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        TODO("Not yet implemented")
    }

    override fun onLoadFinished(loader: Loader<Cursor>, data: Cursor?) {
        TODO("Not yet implemented")
    }

    override fun onLoaderReset(loader: Loader<Cursor>) {
        TODO("Not yet implemented")
    }
    
    override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        TODO("Not yet implemented")
    }
}