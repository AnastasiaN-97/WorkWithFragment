package com.example.workwithfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragment_example.SomeFragmentClickListener

class ResultFragment: Fragment() {
    private var clickListener : SomeFragmentClickListener? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.result_fragment, container, false)
        val mainText = view.findViewById<TextView>(R.id.mainText)
        val title = arguments?.getString("putTitle")
        val author = arguments?.getString("putAuthor")

        if (title?.length == 0 || author?.length == 0) {
            mainText.text = "Вы ввели не все значения"
        } else {
            mainText.text = "Название произведения: \"$title\".\nАвтор: $author."
        }

        view.findViewById<Button>(R.id.button).apply {
            setOnClickListener { clickListener?.onClickResult() }
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
        fun newInstance(title: String, author: String) : ResultFragment {
            val args = Bundle()
            args.putString("putTitle", title)
            args.putString("putAuthor", author)
            val fragment = ResultFragment()
            fragment.arguments = args
            return fragment
        }
    }

}