package com.o7solutions.kotlinjunebatch

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment(), ActivityInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var initView: View
    lateinit var tvName: TextView
    lateinit var fragmentActivity: FragmentActivity
    lateinit var btnChangeActivityMethod : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentActivity = activity as FragmentActivity
        fragmentActivity.activityInterface = this
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        initView = inflater.inflate(R.layout.fragment_first, container, false)
        tvName = initView.findViewById(R.id.tvName)
        btnChangeActivityMethod = initView.findViewById(R.id.btnChangeActivityMethod)
        return initView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvName = view.findViewById(R.id.tvName)
        tvName.setText("Test")

        btnChangeActivityMethod.setOnClickListener {
            fragmentActivity.changeText()
        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        fragmentActivity = activity as FragmentActivity
        Toast.makeText(fragmentActivity, "In attach", Toast.LENGTH_LONG).show()
    }

    fun InvokedFromActivity(){
        btnChangeActivityMethod.setText("Changed from activity")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun CalledFromFragment() {
        tvName.setText("Changed from activity")
    }

}