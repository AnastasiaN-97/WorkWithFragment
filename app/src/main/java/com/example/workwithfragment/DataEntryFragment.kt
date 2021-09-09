package com.example.workwithfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.fragment_example.SomeFragmentClickListener

class DataEntryFragment: Fragment() {
    private var clickListener : SomeFragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.data_entry_fragment, container, false)
        val bookTitle: EditText = view.findViewById(R.id.bookTitle)
        val bookAuthor: EditText = view.findViewById(R.id.bookAuthor)
        val buttonFound: Button = view.findViewById(R.id.buttonSend)

        buttonFound.setOnClickListener{
            val title = bookTitle.text.toString()
            val author = bookAuthor.text.toString()
            clickListener?.onClick(title, author)
        }

        return view
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is SomeFragmentClickListener) {
            clickListener = context
        }
    }

    companion object {
        fun newInstance() : DataEntryFragment {
            return DataEntryFragment()
        }
    }
}